// 選擇營業星期，顯示時段開放預約人數 (select)
$("#weekDay").on("change", function () {
  let weekDay = $("#weekDay").val();
  fetch(`../reservation/restaurant/inf?weekDay=${weekDay}`)
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
    .then(function (arr) {
      $("#allowReserveNum_12").val(arr[0]?.allowReserveNum ?? 0);
      $("#allowReserveNum_13").val(arr[1]?.allowReserveNum ?? 0);
      $("#allowReserveNum_18").val(arr[2]?.allowReserveNum ?? 0);
      $("#allowReserveNum_19").val(arr[3]?.allowReserveNum ?? 0);
    });
});

// 設定營業時間及人數
$("#set_store").on("click", function () {
  fetch("../reservation/restaurant", {
    method: "post",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify([
      {
        weekDay: $("#weekDay").val(),
        reserveTime: "12:00",
        allowReserveNum: $("#allowReserveNum_12").val(),
      },
      {
        weekDay: $("#weekDay").val(),
        reserveTime: "13:00",
        allowReserveNum: $("#allowReserveNum_13").val(),
      },
      {
        weekDay: $("#weekDay").val(),
        reserveTime: "18:00",
        allowReserveNum: $("#allowReserveNum_18").val(),
      },
      {
        weekDay: $("#weekDay").val(),
        reserveTime: "19:00",
        allowReserveNum: $("#allowReserveNum_19").val(),
      },
    ]),
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
    .then((data) => {
      console.log(data);
      Swal.fire({
        position: "center",
        icon: "success",
        title: "儲存成功",
        showConfirmButton: false,
        timer: 1000,
      });
    });
});

// default today
function getDate() {
  var today = new Date();
  var dd = today.getDate();
  var mm = today.getMonth() + 1; //January is 0!
  var yyyy = today.getFullYear();

  if (dd < 10) {
    dd = "0" + dd;
  }

  if (mm < 10) {
    mm = "0" + mm;
  }
  today = yyyy + "-" + mm + "-" + dd;
  // console.log(today);
  $("#reserve_search").val(today);
}
getDate();

// 顯示訂位狀況
$("#reserve_search").on("change", status);
status();
function status() {
  var reserveDate = $("#reserve_search").val();
  const tbReserve_status = $("#tbReserve_status");
  fetch(`../reservation/restaurant/reserveStatus?date=${reserveDate}`)
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
      console.log(tbReserve_status);
      tbReserve_status.html(
        a
          .map((e) =>
            Template(
              e.reserveDate,
              e.reserveTime,
              e.totalReserveNum,
              e.availableSeats
            )
          )
          .join("")
      );
    });
}

function Template(reserveDate, reserveTime, totalReserveNum, availableSeats) {
  return `<tr>
  <td>${reserveDate}</td>
  <td>${reserveTime}</td>
  <td>${totalReserveNum}</td>
  <td>${availableSeats}</td>
  </tr> `;
}

document.querySelector("#search_detail").addEventListener("click", function () {
  // console.log("aa");
  var reserveDate = $("#reserve_search").val();
  sessionStorage.setItem("reserveDate", reserveDate);
  fetch("../reservation/restaurant/statusChange", {
    method: "POST",
    headers: { "content-Type": "application/json" },
    body: JSON.stringify({ reserveDate: reserveDate }),
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
    .then((b) => {
      location.href = "./restaurant_reservation.html";
    });
});
