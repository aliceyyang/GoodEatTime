/*-------------------
    訂位功能
    --------------------- */
// submit訂位資訊
$("#btn_reserve").on("click", function (e) {
    e.preventDefault();
    var send_data = {};
    send_data.name = $("#name").val();
    send_data.tel = $("#tel").val();
    send_data.people = $("#reserveNum").val();
    send_data.date = $("#reserveDate").val();
    send_data.time = $("#reserveTime").val();
    if ($('#remark').val() != "") {
      send_data.remark = $("#remark").val();
    }
    // console.log(send_data);
    sessionStorage.setItem("reservation_inf", JSON.stringify(send_data));
    location.href = "./reservation_confirm.html";
  })
  
  // Session資料 
  var reserve_data = function () {
    if (sessionStorage.getItem("reservation_inf") != null) {
      var reservation_inf = JSON.parse(sessionStorage.getItem("reservation_inf"));
      console.log(reservation_inf);
      reservation_inf.name = $("#name").val();
      reservation_inf.tel = $("#tel").val();
      reservation_inf.people = $("#reserveNum").val();
      reservation_inf.date = $("#reserveDate").val();
      reservation_inf.time = $("#reserveTime").val();
      reservation_inf.remark = $("#remark").val();
  
    }
  }
  reserve_data();
  


// // Session資料 
// const data = {};
// data.name = $("#name").val();
// data.tel = $("#tel").val();
// data.people = $("#reserveNum").val();
// data.date = $("#reserveDate").val();
// data.time = $("#reserveTime").val();
// data.remark = $("#remark").val();
// sessionStorage.setItem("reservation_inf", JSON.stringify(data));
// const sendButton = document.querySelector("#btn_reserve");
// sendButton.addEventListener('click', () => history.replaceState(data, null, "reservation_confirm.html"));

// let pass = false;
// if(data.name.length === 0) {
//     alert()
    
// } else 


// submit -> preventDefault(); window.location.href="xxx";

