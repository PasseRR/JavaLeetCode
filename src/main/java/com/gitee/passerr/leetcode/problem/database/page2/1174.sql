SELECT ROUND(COUNT(IF(`d`.`order_date` = `d`.`customer_pref_delivery_date`, 1, NULL)) * 100 / COUNT(1), 2) AS `immediate_percentage`
-- 按照customer_id分组 找到最早的下单日期(即首单) 题目保证了首单不会重复
FROM (SELECT `customer_id`, MIN(`order_date`) AS `order_date`
      FROM `Delivery`
      GROUP BY `customer_id`) `t`
         INNER JOIN `Delivery` `d` ON `d`.`customer_id` = `t`.`customer_id` AND `d`.`order_date` = `t`.`order_date`
