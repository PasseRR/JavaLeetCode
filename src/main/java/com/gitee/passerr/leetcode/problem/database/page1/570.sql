-- 直接下级 按照上级id分组 大于等于5及为结果
SELECT `e`.`name`
FROM (SELECT `managerId`
      FROM `Employee`
      GROUP BY `managerId`
      HAVING COUNT(1) >= 5) `t`
         INNER JOIN `Employee` `e` ON `t`.`managerId` = `e`.`id`
