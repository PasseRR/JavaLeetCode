# 小美是一所中学的信息科技老师，她有一张seat座位表，平时用来储存学生名字和与他们相对应的座位id。
# 其中纵列的id是连续递增的
# 小美想改变相邻俩学生的座位。
# 你能不能帮她写一个 SQL query来输出小美想要的结果呢？
#
# 示例：
# +---------+---------+
# |    id   | student |
# +---------+---------+
# |    1    | Abbot   |
# |    2    | Doris   |
# |    3    | Emerson |
# |    4    | Green   |
# |    5    | Jeames  |
# +---------+---------+
#
# 假如数据输入的是上表，则输出结果如下：
# +---------+---------+
# |    id   | student |
# +---------+---------+
# |    1    | Doris   |
# |    2    | Abbot   |
# |    3    | Green   |
# |    4    | Emerson |
# |    5    | Jeames  |
# +---------+---------+
#
# 注意：
# 如果学生人数是奇数，则不需要改变最后一个同学的座位。

SELECT `s1`.`id`,
       IFNULL(`s2`.`student`, `s1`.`student`) AS `student`
FROM `seat` `s1`
         LEFT JOIN `seat` `s2`
    # 若主表id为奇数 则使用副表student 否则使用主表student 若为null 直接使用主表student
                   ON (`s1`.`id` MOD 2 AND `s1`.`id` = `s2`.`id` - 1) OR
                      (NOT `s1`.`id` MOD 2 AND `s1`.`id` = `s2`.`id` + 1)
