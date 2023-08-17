SELECT `t`.`employee_id`, `t`.`department_id`
FROM `Employee` `t`
WHERE `t`.`primary_flag` = 'Y'
   -- 非主部门数据记录数只有1条记录的 存在用例有两个非主部门的记录
   OR (SELECT COUNT(1) FROM `Employee` WHERE `employee_id` = `t`.`employee_id`) = 1
