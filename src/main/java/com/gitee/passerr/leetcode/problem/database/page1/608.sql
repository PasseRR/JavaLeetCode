-- 解1
SELECT `t`.`id`,
       CASE
           WHEN `t`.`p_id` IS NULL
               THEN 'Root'
           WHEN EXISTS(SELECT 1 FROM `tree` WHERE `p_id` = `t`.`id`)
               THEN 'Inner'
           ELSE 'Leaf'
       END AS `Type`
FROM `tree` `t`;

-- 解2
SELECT `t`.`id`,
       CASE
           WHEN `t`.`p_id` IS NULL
               THEN 'Root'
           WHEN `s`.`cnt` > 0
               THEN 'Inner'
           ELSE 'Leaf'
       END AS `Type`
FROM `tree` `t`
         LEFT JOIN(SELECT `p_id` AS `id`, COUNT(1) AS `cnt`
                   FROM `tree`
                   GROUP BY `p_id`) `s` ON `t`.`id` = `s`.`id`
