# 表：Logs
# +-------------+---------+
# | Column Name | Type    |
# +-------------+---------+
# | id          | int     |
# | num         | varchar |
# +-------------+---------+
# id 是这个表的主键。
#
# 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
# 返回的结果表中的数据可以按 任意顺序 排列。
#
# 查询结果格式如下面的例子所示：
# Logs 表：
# +----+-----+
# | Id | Num |
# +----+-----+
# | 1  | 1   |
# | 2  | 1   |
# | 3  | 1   |
# | 4  | 2   |
# | 5  | 1   |
# | 6  | 2   |
# | 7  | 2   |
# +----+-----+
#
# Result 表：
# +-----------------+
# | ConsecutiveNums |
# +-----------------+
# | 1               |
# +-----------------+
# 1 是唯一连续出现至少三次的数字。

# 1 记录连续即可
SELECT DISTINCT `t`.`Num` AS `ConsecutiveNums`
FROM (
         SELECT CASE
                    WHEN @`preValue` = `l`.`Num`
                        THEN @`cnt` := @`cnt` + 1
                    WHEN `l`.`Num` IS NOT NULL AND @`preValue` := `l`.`Num`
                        THEN @`cnt` := 1
                END AS `cnt`,
                `l`.`Num`
         FROM `Logs` `l`,
              (SELECT @`preValue` := NULL, @`cnt` := 0) `r`
     ) `t`
WHERE `t`.`cnt` >= 3;

# 2 必须满足id连续
SELECT DISTINCT `l1`.`Num` AS `ConsecutiveNums`
FROM `Logs` `l1`
         INNER JOIN `Logs` `l2` ON `l1`.`Id` = `l2`.`id` - 1 AND `l1`.`Num` = `l2`.`Num`
         INNER JOIN `Logs` `l3` ON `l1`.`Id` = `l3`.`Id` - 2 AND `l1`.`Num` = `l3`.`Num`