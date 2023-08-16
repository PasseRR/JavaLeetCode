-- 分别按照requester_id、accepter_id分组计数 union按照人数倒叙排序取一条记录
SELECT *
FROM (SELECT `t`.`id`, SUM(`t`.`cnt`) AS `num`
      FROM (SELECT `requester_id` AS `id`, COUNT(1) AS `cnt`
            FROM `RequestAccepted`
            GROUP BY `requester_id`
            UNION ALL
            SELECT `accepter_id` AS `id`, COUNT(1) AS `cnt`
            FROM `RequestAccepted`
            GROUP BY `accepter_id`) `t`
      GROUP BY `t`.`id`) `tmp`
ORDER BY `tmp`.`num` DESC
LIMIT 1
