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
