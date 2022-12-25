    SELECT 
        t.*, (allowReserveNum - totalReserveNum) AS availableSeats
    FROM
        (SELECT 
            rt.restaurantNo,
                rt.weekDay,
                rt.reserveTime,
                rt.allowReserveNum,
                rv.reserveDate,
                SUM(IFNULL(rv.reserveNum, 0)) AS totalReserveNum
        FROM
            reserveTime rt
        LEFT JOIN reservation rv ON rt.restaurantNo = rv.restaurantNo
            AND rt.reserveTime = rv.reserveTime
            AND rt.weekDay = DAYOFWEEK(rv.reserveDate)
        GROUP BY rt.restaurantNo , rt.reserveTime , rt.weekDay , rt.allowReserveNum, rv.reserveDate
        ORDER BY rt.restaurantNo , rt.weekDay , rt.reserveTime) t