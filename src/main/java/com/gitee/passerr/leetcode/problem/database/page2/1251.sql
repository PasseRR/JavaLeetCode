SELECT `us`.`product_id`, ROUND(SUM(`us`.`units` * `p`.`price`) / SUM(`us`.`units`), 2) AS `average_price`
FROM `UnitsSold` `us`
         -- 销售日期与价格日期区间关联
         INNER JOIN `Prices` `p` ON `us`.`product_id` = `p`.`product_id` AND
                                    `us`.`purchase_date` BETWEEN `p`.`start_date` AND `end_date`
GROUP BY `us`.`product_id`
