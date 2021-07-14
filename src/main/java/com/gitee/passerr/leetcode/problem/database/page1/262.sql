# 表：Trips
# +-------------+----------+
# | Column Name | Type     |
# +-------------+----------+
# | Id          | int      |
# | Client_Id   | int      |
# | Driver_Id   | int      |
# | City_Id     | int      |
# | Status      | enum     |
# | Request_at  | date     |     
# +-------------+----------+
# Id 是这张表的主键。
# 这张表中存所有出租车的行程信息。每段行程有唯一 Id ，其中 Client_Id 和 Driver_Id 是 Users 表中 Users_Id 的外键。
# Status 是一个表示行程状态的枚举类型，枚举成员为(‘completed’, ‘cancelled_by_driver’, ‘cancelled_by_client’) 。
#
# 表：Users
# +-------------+----------+
# | Column Name | Type     |
# +-------------+----------+
# | Users_Id    | int      |
# | Banned      | enum     |
# | Role        | enum     |
# +-------------+----------+
# Users_Id 是这张表的主键。
# 这张表中存所有用户，每个用户都有一个唯一的 Users_Id ，Role 是一个表示用户身份的枚举类型，枚举成员为 (‘client’, ‘driver’, ‘partner’) 。
# Banned 是一个表示用户是否被禁止的枚举类型，枚举成员为 (‘Yes’, ‘No’) 。
# 
# 写一段 SQL 语句查出"2013-10-01"至"2013-10-03"期间非禁止用户（乘客和司机都必须未被禁止）的取消率。
# 非禁止用户即 Banned 为 No 的用户，禁止用户即 Banned 为 Yes 的用户。
# 取消率 的计算方式如下：(被司机或乘客取消的非禁止用户生成的订单数量) / (非禁止用户生成的订单总数)。
# 返回结果表中的数据可以按任意顺序组织。其中取消率 Cancellation Rate 需要四舍五入保留 两位小数 。
# 
# 查询结果格式如下例所示：
# Trips 表：
# +----+-----------+-----------+---------+---------------------+------------+
# | Id | Client_Id | Driver_Id | City_Id | Status              | Request_at |
# +----+-----------+-----------+---------+---------------------+------------+
# | 1  | 1         | 10        | 1       | completed           | 2013-10-01 |
# | 2  | 2         | 11        | 1       | cancelled_by_driver | 2013-10-01 |
# | 3  | 3         | 12        | 6       | completed           | 2013-10-01 |
# | 4  | 4         | 13        | 6       | cancelled_by_client | 2013-10-01 |
# | 5  | 1         | 10        | 1       | completed           | 2013-10-02 |
# | 6  | 2         | 11        | 6       | completed           | 2013-10-02 |
# | 7  | 3         | 12        | 6       | completed           | 2013-10-02 |
# | 8  | 2         | 12        | 12      | completed           | 2013-10-03 |
# | 9  | 3         | 10        | 12      | completed           | 2013-10-03 |
# | 10 | 4         | 13        | 12      | cancelled_by_driver | 2013-10-03 |
# +----+-----------+-----------+---------+---------------------+------------+
# 
# Users 表：
# +----------+--------+--------+
# | Users_Id | Banned | Role   |
# +----------+--------+--------+
# | 1        | No     | client |
# | 2        | Yes    | client |
# | 3        | No     | client |
# | 4        | No     | client |
# | 10       | No     | driver |
# | 11       | No     | driver |
# | 12       | No     | driver |
# | 13       | No     | driver |
# +----------+--------+--------+
# 
# Result 表：
# +------------+-------------------+
# | Day        | Cancellation Rate |
# +------------+-------------------+
# | 2013-10-01 | 0.33              |
# | 2013-10-02 | 0.00              |
# | 2013-10-03 | 0.50              |
# +------------+-------------------+
# 
# 2013-10-01：
#   - 共有 4 条请求，其中 2 条取消。
#   - 然而，Id=2 的请求是由禁止用户（User_Id=2）发出的，所以计算时应当忽略它。
#   - 因此，总共有 3 条非禁止请求参与计算，其中 1 条取消。
#   - 取消率为 (1 / 3) = 0.33
# 2013-10-02：
#   - 共有 3 条请求，其中 0 条取消。
#   - 然而，Id=6 的请求是由禁止用户发出的，所以计算时应当忽略它。
#   - 因此，总共有 2 条非禁止请求参与计算，其中 0 条取消。
#   - 取消率为 (0 / 2) = 0.00
# 2013-10-03：
#   - 共有 3 条请求，其中 1 条取消。
#   - 然而，Id=8 的请求是由禁止用户发出的，所以计算时应当忽略它。
#   - 因此，总共有 2 条非禁止请求参与计算，其中 1 条取消。
#   - 取消率为 (1 / 2) = 0.50

SELECT `t`.`Request_at`                                                 AS `Day`,
       ROUND(IFNULL(SUM(`t`.`Status` != 'completed'), 0) / COUNT(1), 2) AS `Cancellation Rate`
FROM `Trips` `t`
         INNER JOIN `Users` `u1` ON `t`.`Client_Id` = `u1`.`Users_Id` AND `u1`.`Banned` = 'No'
         INNER JOIN `Users` `u2` ON `t`.`Driver_Id` = `u2`.`Users_Id` AND `u2`.`Banned` = 'No'
WHERE `t`.`Request_at` BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY `t`.`Request_at`
ORDER BY `t`.`Request_at`
