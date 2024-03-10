SELECT t3.user_id, 
       round(ifnull(t3.confirmed / IFNULL(t4.total, 0),0),2) AS confirmation_rate
FROM 
    (
        (SELECT t1.user_id, IFNULL(t2.confirmed, t1.confirmed) AS confirmed
         FROM 
             (SELECT user_id, 0 AS confirmed
              FROM Signups) AS t1
         LEFT OUTER JOIN 
             (SELECT user_id, COUNT(*) AS confirmed
              FROM Confirmations
              WHERE action = "confirmed"
              GROUP BY user_id) AS t2 ON t1.user_id = t2.user_id
        ) AS t3
    LEFT OUTER JOIN 
        (
            SELECT user_id, COUNT(*) AS total
            FROM Confirmations
            GROUP BY user_id
        ) AS t4 ON t3.user_id = t4.user_id
    );
