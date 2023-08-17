-- 解法1 先按照机器、进程分组计算运行时间 再按照机器分组计算平均时间
SELECT `t`.`machine_id`, ROUND(AVG(`t`.`processing_time`), 3) AS `processing_time`
FROM (SELECT `machine_id`,
             `process_id`,
             SUM(IF(`activity_type` = 'start', -`timestamp`, `timestamp`)) AS `processing_time`
      FROM `Activity`
      GROUP BY `machine_id`, `process_id`) `t`
GROUP BY `t`.`machine_id`

-- 解法2 直接按照机器分组 求平均值是做个加倍(分组会包含开始、结束两条数据)
SELECT `machine_id`,
       ROUND(AVG(IF(`activity_type` = 'start', -`timestamp`, `timestamp`)) * 2, 3) AS `processing_time`
FROM `Activity`
GROUP BY `machine_id`
