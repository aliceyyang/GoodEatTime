// 選擇營業星期，顯示時段開放預約人數 (select)
$("#weekDay").on("change", function () {
  let weekDay = $("#weekDay").val();
  $.ajax({
    url: "../reservation/restaurant/inf",
    type: "GET",
    dataType: "json",
    data: { weekDay: weekDay },
    success: function (arr) {
      $("#allowReserveNum_12").val(arr[0]?.allowReserveNum ?? 0);
      $("#allowReserveNum_13").val(arr[1]?.allowReserveNum ?? 0);
      $("#allowReserveNum_18").val(arr[2]?.allowReserveNum ?? 0);
      $("#allowReserveNum_19").val(arr[3]?.allowReserveNum ?? 0);
    },
  });
});

// 設定營業時間及人數
$("#set_store").on("click", function () {
  $.ajax({
    url: "../reservation/restaurant",
    type: "POST",
    contentType: "application/json",
    data: JSON.stringify([
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
    dataType: "JSON",
    success: function (data) {
      console.log(data);
    },

    complete: function () {
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
function status() {
  $("#reserve_search").on("change", function () {
    var reserveDate = $("#reserve_search").val();
    const tbReserve_status = $("#tbReserve_status");
    $.ajax({
      url: "../reservation/restaurant/reserveStatus",
      type: "GET",
      dataType: "json",
      data: { date: reserveDate },
      success: function (a) {
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
      },
    });
  });
}
status();

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
  location.href = "./restaurant_reservation.html";
});
