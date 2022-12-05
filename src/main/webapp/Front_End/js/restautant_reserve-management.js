$("#set_store").on("click", function () {
    $.ajax({
        url: "http://localhost:8080/GoodEatTime/restaurant/setReservation",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify([
            { reserveTime: "12:00", allowReserveNum: $("#allowReserveNum_12").val() },
            { reserveTime: "13:00", allowReserveNum: $("#allowReserveNum_13").val() },
            { reserveTime: "18:00", allowReserveNum: $("#allowReserveNum_18").val() },
            { reserveTime: "19:00", allowReserveNum: $("#allowReserveNum_19").val() },
        ]),
        dataType: "JSON",
        success: function (data) {
            console.log(data);
        },
    });
});


// 搜尋功能
function searchFunction() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("reserve_search");
    filter = input.value.toUpperCase();
    console.log(filter);
    table = document.getElementById("reservation_status");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[0];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}
