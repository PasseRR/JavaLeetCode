# 编写一个 SQL 查询，获取 Employee 表中第n高的薪水（Salary）。
#
# +----+--------+
# | Id | Salary |
# +----+--------+
# | 1  | 100    |
# | 2  | 200    |
# | 3  | 300    |
# +----+--------+
# 例如上述Employee表，n = 2时，应返回第二高的薪水200。如果不存在第n高的薪水，那么查询应返回null。
#
# +------------------------+
# | getNthHighestSalary(2) |
# +------------------------+
# | 200                    |
# +------------------------+
CREATE FUNCTION `getNthHighestSalary`(`N` INT) RETURNS INT
BEGIN
    SET `N` := `N` - 1;
    RETURN (
        SELECT DISTINCT `Salary` AS `getNthHighestSalary`
        FROM `Employee`
        ORDER BY `Salary` DESC
        LIMIT `N`, 1
    );
END
