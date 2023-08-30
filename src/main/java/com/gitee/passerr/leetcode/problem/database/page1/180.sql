-- 解法1
/*#region solution1*/
-- 记录连续即可
SELECT DISTINCT `t`.`Num` AS `ConsecutiveNums`
FROM (
         SELECT CASE
                    WHEN @`preValue` = `l`.`Num`
                        THEN @`cnt` := @`cnt` + 1
                    WHEN `l`.`Num` IS NOT NULL AND @`preValue` := `l`.`Num`
                        THEN @`cnt` := 1
                END AS `cnt`,
                `l`.`Num`
         FROM `Logs` `l`,
              (SELECT @`preValue` := NULL, @`cnt` := 0) `r`
     ) `t`
WHERE `t`.`cnt` >= 3;
/*#endregion solution1*/

-- 解法2
/*#region solution2*/
-- 必须满足id连续
SELECT DISTINCT `l1`.`Num` AS `ConsecutiveNums`
FROM `Logs` `l1`
         INNER JOIN `Logs` `l2` ON `l1`.`Id` = `l2`.`id` - 1 AND `l1`.`Num` = `l2`.`Num`
         INNER JOIN `Logs` `l3` ON `l1`.`Id` = `l3`.`Id` - 2 AND `l1`.`Num` = `l3`.`Num`
/*#endregion solution2*/
