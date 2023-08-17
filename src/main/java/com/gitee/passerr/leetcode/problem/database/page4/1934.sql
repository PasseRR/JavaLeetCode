SELECT `s`.`user_id`,
       -- 需要保证用户存在确认消息且为确认状态
       ROUND(SUM(IF((`c`.`user_id` IS NOT NULL AND `c`.`action` = 'confirmed'), 1, 0)) / COUNT(1), 2) AS `confirmation_rate`
FROM `Signups` `s`
         LEFT JOIN `Confirmations` `c` ON `s`.`user_id` = `c`.`user_id`
GROUP BY `s`.`user_id`
