-- 按照月份、国家分组 按照state统计计算
SELECT DATE_FORMAT(`trans_date`, '%Y-%m')                    AS `month`,
       `country`,
       COUNT(1)                                              AS `trans_count`,
       COUNT(IF(`state` = 'approved', 1, NULL))              AS `approved_count`,
       SUM(`amount`)                                         AS `trans_total_amount`,
       IFNULL(SUM(IF(`state` = 'approved', `amount`, 0)), 0) AS `approved_total_amount`
FROM `Transactions`
GROUP BY DATE_FORMAT(`trans_date`, '%Y-%m'), `country`
