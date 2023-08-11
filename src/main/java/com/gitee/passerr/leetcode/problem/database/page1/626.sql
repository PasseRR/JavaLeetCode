SELECT `s1`.`id`,
       IFNULL(`s2`.`student`, `s1`.`student`) AS `student`
FROM `seat` `s1`
         LEFT JOIN `seat` `s2`
    -- 若主表id为奇数 则使用副表student 否则使用主表student 若为null 直接使用主表student
                   ON (`s1`.`id` MOD 2 AND `s1`.`id` = `s2`.`id` - 1) OR
                      (NOT `s1`.`id` MOD 2 AND `s1`.`id` = `s2`.`id` + 1)
