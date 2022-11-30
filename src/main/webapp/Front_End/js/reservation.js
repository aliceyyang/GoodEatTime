/*-------------------
    訂位功能
    --------------------- */
// Session資料 
const data = {};
data.name = $("#name").val();
data.tel = $("#tel").val();
data.people = $("#reserveNum").val();
data.date = $("#reserveDate").val();
data.time = $("#reserveTime").val();
data.remark = $("#remark").val();
sessionStorage.setItem("reservation_inf", JSON.stringify(data));
const sendButton = document.querySelector("#btn_reserve");
sendButton.addEventListener('click', () => history.replaceState(data, null, "reservation_confirm.html"));

// let pass = false;
// if(data.name.length === 0) {
//     alert()
    
// } else 


// submit -> preventDefault(); window.location.href="xxx";

