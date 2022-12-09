/*-------------------
    訂位功能
    --------------------- */
// dateTimePicker
$(function () {
  const weekdays = [0, 1, 2, 3, 6] // 想要營業的時間放這邊
  $("#reserveDate").datepicker({ 
    dateFormat: 'yy/mm/dd',
    beforeShowDay: function (dt){
    return [(weekdays.includes(dt.getDay())), ''];
  } }).val();

});



// submit訂位資訊
$("#btn_reserve").on("click", function (e) {
    e.preventDefault();
    var send_data = {};
    let people = $("#reserveNum").val();
    let date = $("#reserveDate").val();
    let time = $("#reserveTime").val();

    if(people > 0){
      send_data.people = people;  
    }else{
      alert("請輸入人數")
    };

    

    

    
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
      const reservation_inf = JSON.parse(sessionStorage.getItem("reservation_inf"));
      console.log(reservation_inf);
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

