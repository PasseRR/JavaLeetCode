-- 结果保留两位小数
SELECT ROUND(IFNULL(SUM(`t1`.`tiv_2016`), 0), 2) AS `tiv_2016`
FROM `Insurance` `t1`
     -- 必须存在一个2015年投保金额相同但投保编号不能相同
WHERE EXISTS(SELECT 1
             FROM `Insurance` `t2`
             WHERE `t2`.`tiv_2015` = `t1`.`tiv_2015`
               AND `t2`.`pid` != `t1`.`pid`)
  -- 必须不能存在任意不和当前投保编号相同当城市相同
  AND NOT EXISTS(SELECT 1
                 FROM `Insurance` `t3`
                 WHERE `t3`.`lat` = `t1`.`lat`
                   AND `t3`.`lon` = `t1`.`lon`
                   AND `t3`.`pid` != `t1`.`pid`)
