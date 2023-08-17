SELECT `r`.`contest_id`, ROUND(COUNT(1) * 100 / `t`.`total`, 2) AS `percentage`
FROM `Register` `r`,
     -- 陷阱 只能子查询统计所有人数 关联查询做不到
     (SELECT COUNT(1) AS `total` FROM `Users`) `t`
GROUP BY `r`.`contest_id`
ORDER BY 2 DESC, 1
