SELECT `d`.`Name` AS `Department`,
       `t`.`Name` AS `Employee`,
       `t`.`Salary`
FROM (
         SELECT `t`.*,
                CAST(
                  (
                      CASE
                          WHEN `t`.`DepartmentId` = @`preDeptId`
                              THEN (
                              -- 工资是否一样
                              IF(
                                    @`preSalary` <> `t`.`Salary` AND (@`preSalary` := `t`.`Salary`) IS NOT NULL,
                                    @`curRank` := @`curRank` + 1,
                                    @`curRank`
                                  )
                              )
                          WHEN (@`preDeptId` := `t`.`DepartmentId`) IS NOT NULL
                              AND (@`preSalary` := `t`.`Salary`) IS NOT NULL
                              THEN @`curRank` := 1
                      END
                      ) AS SIGNED
                    ) AS `Rank`
         FROM (SELECT *
               FROM `Employee`
               ORDER BY `DepartmentId`, `Salary` DESC) `t`,
              (SELECT @`preDeptId` := NULL, @`preSalary` := NULL, @`curRank` := 0) `r`
     ) `t`
         INNER JOIN `Department` `d` ON `t`.`DepartmentId` = `d`.`Id`
WHERE `t`.`Rank` <= 3
