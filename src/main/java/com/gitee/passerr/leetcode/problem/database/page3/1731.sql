SELECT `e`.`employee_id`, `e`.`name`, `t`.`reports_count`, `t`.`average_age`
FROM (SELECT `reports_to` AS `employee_id`, COUNT(1) AS `reports_count`, ROUND(AVG(`age`), 0) AS `average_age`
      FROM `Employees`
      WHERE `reports_to` IS NOT NULL
      GROUP BY `reports_to`) `t`
         INNER JOIN `Employees` `e` ON `t`.`employee_id` = `e`.`employee_id`
ORDER BY `e`.employee_id
