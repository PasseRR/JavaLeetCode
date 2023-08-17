SELECT `v`.`customer_id`, COUNT(1) AS `count_no_trans`
FROM `Visits` `v`
         LEFT JOIN `Transactions` `t` ON `v`.`visit_id` = `t`.`visit_id`
     -- 排除消费过的记录
WHERE `t`.`visit_id` IS NULL
GROUP BY `v`.`customer_id`
