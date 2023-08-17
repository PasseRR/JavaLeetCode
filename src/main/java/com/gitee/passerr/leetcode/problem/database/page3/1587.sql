SELECT *
FROM (SELECT `u`.`name`, IFNULL(SUM(`t`.`amount`), 0) AS `balance`
      FROM `Users` `u`
               LEFT JOIN `Transactions` `t` ON `u`.`account` = `t`.`account`
      GROUP BY `u`.`account`, `u`.`name`) `t`
WHERE `t`.`balance` > 10000
