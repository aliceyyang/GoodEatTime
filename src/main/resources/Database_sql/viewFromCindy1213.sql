CREATE VIEW V_memeber_reservation AS
    SELECT 
        memberNo,
        reserveNo,
        r.restaurantName,
        reserveNum,
        reserveDate,
        reserveTime,
        remark
    FROM
        reservation rs
            JOIN
        restaurant r ON rs.restaurantNo = r.restaurantNo;

    
CREATE VIEW V_reservation AS
    SELECT 
        rt.restaurantNo,
        r.reserveDate,
        rt.reserveTime,
        rt.allowReserveNum,
        r.totalReserveNum,
        (rt.allowReserveNum - r.totalReserveNum) AS availableSeats
    FROM
        reserveTime rt
            JOIN
        (SELECT 
            restaurantNo,
                reserveTime,
                reserveDate,
                SUM(reserveNum) AS totalReserveNum
        FROM
            reservation
        GROUP BY reserveTime , reserveDate , restaurantNo) AS r ON rt.restaurantNo = r.restaurantNo
            AND rt.weekDay = DAYOFWEEK(r.reserveDate)
            AND rt.reserveTime = r.reserveTime;