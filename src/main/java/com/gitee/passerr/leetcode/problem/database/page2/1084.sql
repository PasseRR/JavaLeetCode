SELECT `p`.`product_id`, `p`.`product_name`
FROM `Product` `p`
         INNER JOIN `Sales` `s` ON `p`.`product_id` = `s`.`product_id`
GROUP BY `p`.`product_id`, `p`.`product_name`
HAVING COUNT(1) = SUM(`s`.`sale_date` >= '2019-01-01' AND `s`.`sale_date` <= '2019-03-31')
