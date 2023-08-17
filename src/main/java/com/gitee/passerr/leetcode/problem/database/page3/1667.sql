-- 将首字母变大写 后续字母变小写即可
SELECT `user_id`, CONCAT(UPPER(SUBSTRING(`name`, 1, 1)), LOWER(SUBSTR(`name`, 2))) AS `name`
FROM `Users`
ORDER BY `user_id`
