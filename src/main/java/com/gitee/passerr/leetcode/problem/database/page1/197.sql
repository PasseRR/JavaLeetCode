SELECT `w1`.`id`
FROM `Weather` `w1`
         INNER JOIN `Weather` `w2`
                    ON `w1`.`recordDate` = DATE_ADD(`w2`.`recordDate`, INTERVAL 1 DAY)
                        AND `w1`.`Temperature` > `w2`.`Temperature`
