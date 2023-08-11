SELECT `Department`.`Name` AS `Department`, `Employee`.`Name` AS `Employee`, `Employee`.`Salary` AS `Salary`
FROM `Employee`
         INNER JOIN (
    SELECT MAX(`Salary`) AS `Salary`, `DepartmentId` FROM `Employee` GROUP BY `DepartmentId`
) `t` ON `t`.`DepartmentId` = `Employee`.`DepartmentId` AND `Employee`.`Salary` = `t`.`Salary`
         INNER JOIN `Department` ON `t`.`DepartmentId` = `Department`.`Id`
