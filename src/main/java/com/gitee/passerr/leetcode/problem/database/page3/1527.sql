SELECT *
FROM `Patients`
     -- 前缀
WHERE `conditions` LIKE 'DIAB1%'
   -- 或者在空格后的前缀
   OR `conditions` LIKE '% DIAB1%'
