-- 题目里面给的null是类型 不是null字符串
SELECT MAX(`t`.`num`) AS `num`
FROM (SELECT `num`
      FROM `MyNumbers`
      GROUP BY `num`
      HAVING COUNT(1) = 1) `t`
