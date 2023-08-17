-- 先利用MIN找出每个产品最早出现的年份 再关联查询
SELECT `t`.`product_id`, `t`.`year` AS `first_year`, `s`.`quantity`, `s`.`price`
FROM (SELECT `product_id`, MIN(`year`) AS `year`
      FROM `Sales`
      GROUP BY `product_id`) `t`
         INNER JOIN `Sales` `s` ON `t`.`product_id` = `s`.`product_id` AND `t`.`year` = `s`.`year`
