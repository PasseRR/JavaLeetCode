-- 按照正常思维比较去重后的产品和客户购买产品数量 关联产品数量 product_key为外键保证数量一致即可
SELECT `t`.`customer_id`
FROM (SELECT DISTINCT `customer_id`, `product_key`
      FROM `Customer`) `t`
         INNER JOIN `Product` `p` ON `t`.`product_key` = `p`.`product_key`
GROUP BY `customer_id`
HAVING COUNT(1) = (SELECT COUNT(1) FROM `Product`);
