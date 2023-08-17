-- 正则匹配
SELECT *
FROM `Users`
WHERE `mail` REGEXP '^[a-zA-Z][a-zA-Z0-9._-]*@leetcode\\.com$'
