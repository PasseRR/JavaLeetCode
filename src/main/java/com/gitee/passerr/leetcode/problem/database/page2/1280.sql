SELECT `s`.`student_id`,
       `s`.`student_name`,
       `su`.`subject_name`,
       -- 考虑有的学生未参加考试
       IFNULL(`e`.`attended_exams`, 0) AS `attended_exams`
FROM `Students` `s`
         -- 学生和科目笛卡尔乘积
         INNER JOIN `Subjects` `su` ON TRUE
         -- 按照学生、科目分组统计
         LEFT JOIN (SELECT `student_id`, `subject_name`, COUNT(1) AS `attended_exams`
                    FROM `Examinations`
                    GROUP BY `student_id`, `subject_name`) `e`
                   ON `e`.`student_id` = `s`.`student_id` AND `e`.`subject_name` = `su`.`subject_name`
ORDER BY `s`.`student_id`, `su`.`subject_name`
