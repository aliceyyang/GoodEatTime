create view V_userAccount as
    select 
        mail as user_account,
        name as member_name,
        memberLevel as member_level,
        verificationAccount as verified
    from
        member m
    union
    select 
        restaurantAccount as user_account,
        restaurantName as member_name,
        null as member_level,
        restaurantStatus as verified
    FROM
        restaurant r ;