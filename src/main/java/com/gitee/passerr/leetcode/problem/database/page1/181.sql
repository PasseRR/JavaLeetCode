SELECT `e1`.`Name` AS `Employee`
FROM `Employee` `e1`
         INNER JOIN `Employee` `e2` ON `e1`.`ManagerId` = `e2`.`Id` AND `e1`.`Salary` > `e2`.`Salary`
