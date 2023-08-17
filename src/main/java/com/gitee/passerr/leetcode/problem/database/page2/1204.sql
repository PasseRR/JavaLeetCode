-- 解法1 使用变量
SELECT `t`.`person_name`
FROM (SELECT `q`.*,
             (@`total` := @`total` + `q`.`weight`) AS `total`
             -- 先按照轮次排序
      FROM (SELECT *
            FROM `Queue`
            ORDER BY `turn`) `q`,
           -- 定总重量变量并初始化总重量为0
           (SELECT @`total` := 0) `t`) `t`
WHERE `t`.`total` <= 1000
ORDER BY `t`.`total` DESC
LIMIT 1

-- 解法2 使用窗口函数
SELECT `t`.`person_name`
       -- 按照轮次累加计重
FROM (SELECT `person_name`, SUM(`weight`) OVER (ORDER BY `turn`) AS `total` FROM `Queue`) `t`
WHERE `t`.`total` <= 1000
ORDER BY `t`.`total` DESC
LIMIT 1
