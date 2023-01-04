$(window).on("load", function () {
  var check_func = function () {
    // 餐廳資訊
    $("#restaurantName").html(sessionStorage.getItem("restaurantName"));
    $("#phone").html(sessionStorage.getItem("restaurantTel"));
    $("#address").html(sessionStorage.getItem("restaurantAddr"));
    // 星等
    const rate = sessionStorage.getItem("restaurantRating");
    // let rate = 4.8;
    let star = Math.trunc(rate);
    for (var i = 1; i <= rate; i++) {
      $("#star_" + i).addClass("checked");
    }
    if (rate - star >= 0.5) {
      $("#star_" + (star + 1)).attr(
        "class",
        "fa-solid fa-star-half-stroke checked"
      );
    }
    $("#rating").html(rate);

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
    r_remark_el.innerHTML =
      `<i class="fa-solid fa-clipboard fa-xl"></i> 備註：` +
      reservation_inf.remark;
  };
  check_func();
});

document.querySelector("#btn_confirm").addEventListener("click", () => {
  // const reservation_inf = JSON.parse(sessionStorage.getItem("reservation_inf"));
  // console.log(reservation_inf);
  fetch("../reservation/member", {
    method: "POST",
    headers: { "content-Type": "application/json" },
    body: sessionStorage.getItem("reservation_inf"),
  })
    .then((resp) => {
      if (resp.redirected) {
        Swal.fire({
          // sweet alert CDN
          position: "center",
          icon: "warning",
          title: "請先登入",
          showConfirmButton: false,
          timer: 1000,
        }).then(() => {
          // 動畫跑完後跳轉
          sessionStorage.setItem("URL_before_login", window.location.href);
          window.location.href = resp.url;
        });
      } else {
        return resp.json();
      }
    })
    .then((a) => {
      console.log(a);
      Swal.fire({
        position: "center",
        icon: "success",
        title: "儲存成功",
        showConfirmButton: false,
        timer: 1000,
      }).then(() => {
        location.href = "./GoodEatTime.html";
      });
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
