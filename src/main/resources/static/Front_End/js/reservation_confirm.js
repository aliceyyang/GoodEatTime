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
    var r_remark_el = document.getElementById("r_remark");

    r_name_el.innerHTML = reservation_inf.name;
    r_tel_el.innerHTML = reservation_inf.tel;
    r_people_el.innerHTML = reservation_inf.reserveNum;
    r_date_el.innerHTML = reservation_inf.reserveDate;
    r_time_el.innerHTML = reservation_inf.reserveTime;
    r_remark_el.innerHTML = reservation_inf.remark;
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
      }).then(() => {
        location.href = "./GoodEatTime.html";
      });
    },
  });
});

document.querySelector("#btn_cancel").addEventListener("click", () => {
  Swal.fire({
    title: "您確定要取消訂位?",
    text: "如果取消，內容將會完全清除!",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    cancelButtonText: "放棄取消!",
    confirmButtonText: "是的，我要取消",
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire("訂位已取消", "", "success");
      sessionStorage.clear();
      location.href = "./GoodEatTime.html";
    }
  });
});
