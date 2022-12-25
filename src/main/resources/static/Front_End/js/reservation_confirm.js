$(window).on("load", function () {
  var check_func = function () {
    const reservation_inf = JSON.parse(
      sessionStorage.getItem("reservation_inf")
    );
    console.log(reservation_inf);
    var r_name_el = document.getElementById("r_name");
    var r_tel_el = document.getElementById("r_tel");
    var r_people_el = document.getElementById("r_people");
    var r_date_el = document.getElementById("r_date");
    var r_time_el = document.getElementById("r_time");

    r_name_el.innerHTML = reservation_inf.name;
    r_tel_el.innerHTML = reservation_inf.tel;
    r_people_el.innerHTML = reservation_inf.reserveNum;
    r_date_el.innerHTML = reservation_inf.reserveDate;
    r_time_el.innerHTML = reservation_inf.reserveTime;
  };
  check_func();
});

document.querySelector("#btn_confirm").addEventListener("click", () => {
  const reservation_inf = JSON.parse(sessionStorage.getItem("reservation_inf"));
  console.log(reservation_inf);
  $.ajax({
    url: "../reservation/member",
    type: "POST",
    contentType: "application/json",
    data: sessionStorage.getItem("reservation_inf"),
    dataType: "json",
    success: function (a) {
      console.log(a);
    },
    complete: () => {
      Swal.fire({
        position: "center",
        icon: "success",
        title: "儲存成功",
        showConfirmButton: false,
        timer: 1000,
      });
    },
  });
});
