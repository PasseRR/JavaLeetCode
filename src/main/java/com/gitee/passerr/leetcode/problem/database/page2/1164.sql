SELECT `t`.`product_id`,
       -- 若产品2019-08-16未更新价格 则为固定价格10
       IFNULL(`p`.`new_price`, 10) AS `price`
       -- 通过子查询按照product_id分组 找到日期在2019-08-16或之前的最大日期 没有则为NULl
FROM (SELECT `product_id`, MAX(IF(`change_date` > '2019-08-16', NULL, `change_date`)) AS `max_date`
      FROM `Products`
      GROUP BY `product_id`) `t`
         -- 再跟产品关联 找到当时的最新价格
         LEFT JOIN `Products` `p` ON `t`.`product_id` = `p`.`product_id` AND `p`.`change_date` = `t`.`max_date`
