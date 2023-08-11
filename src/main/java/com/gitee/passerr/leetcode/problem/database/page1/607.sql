SELECT `s`.`name` AS `name`
FROM `SalesPerson` `s`
WHERE NOT EXISTS(SELECT 1
                 FROM `Orders` `o`
                          INNER JOIN `Company` `c` ON `o`.`com_id` = `c`.`com_id`
                     AND `c`.`name` = 'RED' AND `o`.`sales_id` = `s`.`sales_id`
    )
