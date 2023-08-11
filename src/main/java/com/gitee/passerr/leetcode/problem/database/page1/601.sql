SELECT `s`.*
FROM `Stadium` `s`
         INNER JOIN (
    -- 大于100人连续出现的次数
    SELECT CAST(
             (
                 CASE
                     WHEN @`preId` = `id` - 1 AND @`preId` := `id`
                         THEN
                         @`startId`
                     WHEN @`preId` := `id`
                         THEN @`startId` := `id`
                 END
                 )
               AS SIGNED
               )    AS `startId`,
           COUNT(1) AS `cnt`
    FROM `Stadium`,
         -- 记录前一个id和开始id
         (SELECT @`preId` := NULL, @`startId` := NULL) `t`
    WHERE `people` >= 100
    GROUP BY 1
    HAVING COUNT(1) >= 3
) `t` ON `s`.`id` >= `t`.`startId` && `s`.`id` <= (`t`.`startId` + `t`.`cnt` - 1)
