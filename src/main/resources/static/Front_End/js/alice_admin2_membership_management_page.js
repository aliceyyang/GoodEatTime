(function (document) {
  "use strict";

  var LightTableFilter = (function (Arr) {
    var _input;

    // 輸入搜尋關鍵字
    function _onInputEvent(e) {
      // console.log(e);
      _input = e.target;
      var tables = document.getElementsByClassName(
        _input.getAttribute("data-table")
      );
      Arr.forEach.call(tables, function (table) {
        Arr.forEach.call(table.tBodies, function (tbody) {
          Arr.forEach.call(tbody.rows, _filter);
        });
      });
    }

    function _filter(row) {
      var text = row.textContent.toLowerCase(),
        val = _input.value.toLowerCase();
      row.style.display = text.indexOf(val) === -1 ? "none" : "table-row";
    }

    return {
      init: function () {
        var inputs = document.getElementsByClassName("membership_search");
        Arr.forEach.call(inputs, function (input) {
          input.oninput = _onInputEvent;
        });
      },
    };
  })(Array.prototype);

  document.addEventListener("readystatechange", function () {
    if (document.readyState === "complete") {
      LightTableFilter.init();
    }
  });
})(document);

// 點選會員種類按鈕
var choose_customer_btn = document.getElementById("choose_customer_btn");
var choose_restaurant_btn = document.getElementById("choose_restaurant_btn");
var inputs = document.getElementById("membership_search");

// 點選checkbox修改、刪除資料
var update_box = document.querySelector(".update_box");

// update_box.addEventListener("click", function () {
//   console.log(this);
// });
