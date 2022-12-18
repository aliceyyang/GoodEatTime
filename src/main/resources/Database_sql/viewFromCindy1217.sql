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
            
CREATE VIEW v_restaurant_reservation AS
    SELECT 
        r.restaurantNo,
        r.reserveNo,
        m.name,
        r.reserveDate,
        r.reserveTime,
        r.reserveNum,
        m.tel,
        m.mail,
        r.remark,
        r.reserveStatus
    FROM
        reservation r
            JOIN
        member m ON r.memberNo = m.memberNo;