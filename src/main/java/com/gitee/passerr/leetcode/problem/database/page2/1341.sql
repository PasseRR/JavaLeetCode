-- 两个结果集无关 考虑使用union
(SELECT `t`.`results`
 FROM (SELECT `u`.`name` AS `results`, COUNT(1) AS `cnt`
       FROM `MovieRating` `mr`
                INNER JOIN `Users` `u` ON `mr`.`user_id` = `u`.`user_id`
       GROUP BY `u`.`user_id`, `u`.`name`) `t`
 ORDER BY `t`.`cnt` DESC, `t`.`results`
 LIMIT 1)
-- 电影名和人名可能一样
UNION ALL
(SELECT `t`.`results`
 FROM (SELECT `m`.`title` AS `results`, AVG(`mr`.`rating`) AS `cnt`
       FROM `MovieRating` `mr`
                INNER JOIN `Movies` `m`
                           ON `mr`.`movie_id` = `m`.`movie_id` AND DATE_FORMAT(`mr`.`created_at`, '%Y-%m') = '2020-02'
       GROUP BY `m`.`movie_id`, `m`.`title`) `t`
 ORDER BY `t`.`cnt` DESC, `t`.`results`
 LIMIT 1)
