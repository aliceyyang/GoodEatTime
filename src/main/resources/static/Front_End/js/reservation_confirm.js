$(window).on("load", function () {
    var check_func = function () {
        var reservation_inf = JSON.parse(sessionStorage.getItem("reservation_inf"));
        console.log(reservation_inf);
        var r_name_el = document.getElementById("r_name");
        var r_tel_el = document.getElementById("r_tel");
        var r_people_el = document.getElementById("r_people");
        var r_date_el = document.getElementById("r_date");
        var r_time_el = document.getElementById("r_time");

        r_name_el.innerHTML = reservation_inf.name;
        r_tel_el.innerHTML = reservation_inf.tel;
        r_people_el.innerHTML = reservation_inf.people;
        r_date_el.innerHTML = reservation_inf.date;
        r_time_el.innerHTML = reservation_inf.time;
    }
    check_func();
})
