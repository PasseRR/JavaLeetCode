-- 考查having用法
SELECT `Email`
FROM `Person`
GROUP BY `Email`
HAVING COUNT(1) > 1
