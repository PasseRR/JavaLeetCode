SELECT `Customers`.`Name` AS `Customers`
FROM `Customers`
WHERE NOT EXISTS(SELECT 1 FROM `Orders` WHERE `Orders`.`CustomerId` = `Customers`.`Id`)
