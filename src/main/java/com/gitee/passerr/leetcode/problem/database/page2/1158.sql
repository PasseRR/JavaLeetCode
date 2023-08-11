SELECT `u`.`user_id` AS `buyer_id`, `u`.`join_date`, IFNULL(`t`.`cnt`, 0) AS `orders_in_2019`
FROM `Users` `u`
         LEFT JOIN (SELECT `o`.`buyer_id`, COUNT(1) AS `cnt`
                    FROM `Orders` `o`
                    WHERE `o`.`order_date` >= '2019-01-01'
                      AND `o`.`order_date` <= '2019-12-31'
                    GROUP BY `o`.`buyer_id`) `t` ON `u`.`user_id` = `t`.`buyer_id`
