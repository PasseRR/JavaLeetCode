-- 解法1 
/*#region solution1*/
-- 按照正常思维
SELECT `t1`.`visited_on`,
       SUM(`t3`.`amount`)               AS `amount`,
       ROUND(SUM(`t3`.`amount`) / 7, 2) AS `average_amount`
       -- 销售日列表
FROM (SELECT DISTINCT `visited_on` FROM `Customer` ORDER BY `visited_on`) `t1`
         -- 最早销售日
         INNER JOIN (SELECT MIN(`visited_on`) AS `min` FROM `Customer`) `t2` ON TRUE
         -- 每日销售额 关联时 日期差不能超过7天 避免出现负数用了日期比较
         INNER JOIN (SELECT `visited_on`, SUM(`amount`) AS `amount` FROM `Customer` GROUP BY `visited_on`) `t3`
                    ON `t1`.`visited_on` >= `t3`.`visited_on` AND DATEDIFF(`t1`.`visited_on`, `t3`.`visited_on`) <= 6
     -- 还需要排除和最早销售日间隔低于7天的
WHERE DATEDIFF(`t1`.`visited_on`, `t2`.`min`) >= 6
GROUP BY `t1`.`visited_on`
ORDER BY `t1`.`visited_on`
/*#endregion solution1*/


-- 解法2 
/*#region solution2*/
-- 使用滑动窗口
SELECT `t`.`visited_on`, `t`.`amount`, ROUND(`t`.`amount` / 7, 2) AS `average_amount`
FROM (SELECT `t`.`visited_on`,
             DATEDIFF(`t`.`visited_on`, `t2`.`min`)                                            AS `cnt`,
             -- 按照日期滑动窗口当日加上前6天的累计值
             SUM(`t`.`amount`) OVER (ORDER BY `t`.`visited_on` RANGE INTERVAL 6 DAY PRECEDING) AS `amount`
             -- 按照每日汇总销售额
      FROM (SELECT `visited_on`, SUM(`amount`) AS `amount` FROM `Customer` GROUP BY `visited_on`) `t`
               -- 最早销售日 用于判断窗口是否足够7天
               INNER JOIN (SELECT MIN(`visited_on`) AS `min` FROM `Customer`) `t2` ON TRUE
      ORDER BY `t`.`visited_on`) `t`
     -- 和最早销售日间隔不能低于6天
WHERE `t`.`cnt` >= 6
/*#endregion solution2*/
