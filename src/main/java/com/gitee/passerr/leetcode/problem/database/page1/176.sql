SELECT MAX(`Salary`) AS `SecondHighestSalary`
FROM `Employee`
WHERE `Salary` < (SELECT MAX(`t`.`SALARY`) FROM `Employee` `t`)
