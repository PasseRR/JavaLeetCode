-- 三边构成三角形前提 任意两边和大于第三边
SELECT `x`,
       `y`,
       `z`,
       IF(`x` + `y` > `z` AND `y` + `z` > `x` AND `x` + `z` > `y`, 'Yes', 'No') AS `triangle`
FROM `Triangle` `t`