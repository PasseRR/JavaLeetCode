SELECT COUNT(1) AS `rich_count`
FROM (SELECT DISTINCT `customer_id`
      FROM `Store`
      WHERE `amount` > 500) `t`
