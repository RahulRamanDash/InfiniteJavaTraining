-- Display all friday's of current Month
SELECT Fridays
FROM (
    SELECT DATE_ADD(LAST_DAY(CURDATE() - INTERVAL 1 MONTH), INTERVAL 1 DAY) AS FirstDay
) AS MonthStart
JOIN (
    SELECT DATE_ADD(FirstDay, INTERVAL (n - 1) WEEK) AS Fridays
    FROM (
        SELECT 1 AS n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 -- Adjust the number of weeks as needed
    ) AS Numbers
    CROSS JOIN (
        SELECT DATE_ADD(LAST_DAY(CURDATE() - INTERVAL 1 MONTH), INTERVAL 1 DAY) AS FirstDay
    ) AS FirstFriday
    WHERE DAYNAME(DATE_ADD(FirstDay, INTERVAL (n - 1) WEEK)) = 'Friday'
) AS FridayDates;