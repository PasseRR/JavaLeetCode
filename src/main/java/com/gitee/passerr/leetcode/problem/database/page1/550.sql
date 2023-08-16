-- 先找到玩家的首次登录日期，然后左关联是否存在第二天也登录，首次登录即为玩家总人数，第二天也登录则为连续登录人数
SELECT ROUND(COUNT(`a2`.`player_id`) / COUNT(`a1`.`player_id`), 2) AS `fraction`
FROM (SELECT `player_id`, MIN(`event_date`) AS `event_date`
      FROM `Activity`
      GROUP BY `player_id`) `a1`
         LEFT JOIN `Activity` `a2` ON `a1`.`player_id` = `a2`.`player_id` AND
                                      `a1`.`event_date` =
                                      DATE_ADD(`a2`.`event_date`, INTERVAL -1 DAY)
