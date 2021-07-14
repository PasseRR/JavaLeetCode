# 编写一个 SQL 查询，来删除Person表中所有重复的电子邮箱，重复的邮箱里只保留Id最小的那个。
# 
# +----+------------------+
# | Id | Email            |
# +----+------------------+
# | 1  | john@example.com |
# | 2  | bob@example.com  |
# | 3  | john@example.com |
# +----+------------------+
# Id 是这个表的主键。
# 例如，在运行你的查询语句之后，上面的 Person 表应返回以下几行:
# 
# +----+------------------+
# | Id | Email            |
# +----+------------------+
# | 1  | john@example.com |
# | 2  | bob@example.com  |
# +----+------------------+
# 
# 提示：
# 
# 执行 SQL 之后，输出是整个 Person表。
# 使用 delete 语句。

DELETE
    `P1`
FROM `Person` `p1`
         INNER JOIN `Person` `p2` ON `p1`.`Email` = `p2`.`Email` AND `p1`.`Id` > `p2`.`Id`

