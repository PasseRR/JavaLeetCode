SELECT `sell_date`,
       -- 计数不重复的产品名称
       COUNT(DISTINCT `product`)                           AS `num_sold`,
       -- 默认,拼接 按照产品名称字典排序
       GROUP_CONCAT(DISTINCT `product` ORDER BY `product`) AS `products`
FROM `Activities`
GROUP BY `sell_date`
ORDER BY `sell_date`
