-- 使用变量控制前一个分数，再比较分数获得排名
SELECT `Score`,
       CAST(
         (
             CASE
                 WHEN @`preScore` = `Score`
                     THEN @`curRank`
                 WHEN (@`preScore` := `Score`) IS NOT NULL
                     THEN @`curRank` := @`curRank` + 1
             END
             ) AS SIGNED
           ) AS `Rank`
FROM `Scores`,
     (SELECT @`curRank` := 0, @`preScore` := NULL) `t`
ORDER BY `Score` DESC
