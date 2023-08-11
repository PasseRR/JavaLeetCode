SELECT `t`.`Request_at`                                                 AS `Day`,
       ROUND(IFNULL(SUM(`t`.`Status` != 'completed'), 0) / COUNT(1), 2) AS `Cancellation Rate`
FROM `Trips` `t`
         INNER JOIN `Users` `u1` ON `t`.`Client_Id` = `u1`.`Users_Id` AND `u1`.`Banned` = 'No'
         INNER JOIN `Users` `u2` ON `t`.`Driver_Id` = `u2`.`Users_Id` AND `u2`.`Banned` = 'No'
WHERE `t`.`Request_at` BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY `t`.`Request_at`
ORDER BY `t`.`Request_at`
