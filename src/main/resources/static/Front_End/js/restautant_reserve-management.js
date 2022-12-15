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

$("#set_store").on("click", function () {
  $.ajax({
    url: "http://localhost:8080/reservation/restaurant",
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
        timer: 1500,
      });
    },
  });
});

// 搜尋功能;
// function searchFunction() {
//   let input, filter, table, tr, td, i, txtValue;
//   input = document.getElementById("reserve_search");
//   // filter = input.value.toUpperCase();
//   filter = input.value;
//   console.log(filter);
//   table = document.querySelector("#reserve_status");
//   tr = table.getElementsByTagName("tr");
//   for (i = 0; i < tr.length; i++) {
//     td = tr[i].getElementsByTagName("td")[0];
//     console.log(td);
//     if (td == filter) {
//       // if (indexOf(filter) > -1) {
//       //   tr[i].style.display = "";
//       // } else {
//       //   tr[i].style.display = "none";
//       // }
//     }
//   }
// }
