SELECT `t`.`customer_number`
FROM (
         SELECT `customer_number`, COUNT(1) AS `cnt` FROM `orders` GROUP BY `customer_number`
     ) `t`
ORDER BY `t`.`cnt` DESC
LIMIT 1
