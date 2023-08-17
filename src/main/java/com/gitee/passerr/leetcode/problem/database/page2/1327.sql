SELECT `p`.`product_name`, SUM(`o`.`unit`) AS `unit`
FROM `Products` `p`
         -- 过滤2020-02的订单
         LEFT JOIN (SELECT * FROM `Orders` WHERE DATE_FORMAT(`order_date`, '%Y-%m') = '2020-02') `o`
                   ON `p`.`product_id` = `o`.`product_id`
GROUP BY `p`.`product_id`, `p`.`product_name`
         -- 销售数量至少100
HAVING SUM(`o`.`unit`) >= 100
