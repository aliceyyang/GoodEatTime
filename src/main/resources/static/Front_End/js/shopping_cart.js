/**
 * 提供memberNo資料
 * 進入資料庫抓shoppingCart的資料，轉換成下方的格式
 * ->已完成
 *
 * 進入資料庫抓memberCoupon的資料，轉換成下方的格式
 * ->尚未開始抓折價券資料，須更新價格計算、存入資料...
 * 
 * 修改資料庫中購物車的內容
 * ->已完成
 *
 * 結帳->儲存prodOrderDetail資料至session storage->跳轉至checkout頁面
 *
 */
/*購物車需要的資料格式
[
    {
       "restaurantName":"餐廳名稱",
       "cart":[
          {
             "prodNo":"商品編號",
             "prodName":"商品名稱",
             "prodQty":"商品數量",
             "prodPrice":"商品價格"
          },
          {
             "prodNo":"商品編號",
             "prodName":"商品名稱",
             "prodQty":"商品數量",
             "prodPrice":"商品價格"
          },
          {
             "prodNo":"商品編號",
             "prodName":"商品名稱",
             "prodQty":"商品數量",
             "prodPrice":"商品價格"
          }
       ]
    },
    {
       "restaurantName":"餐廳名稱",
       "cart":[
          {
             "prodNo":"商品編號",
             "prodName":"商品名稱",
             "prodQty":"商品數量",
             "prodPrice":"商品價格"
          },
          {
             "prodNo":"商品編號",
             "prodName":"商品名稱",
             "prodQty":"商品數量",
             "prodPrice":"商品價格"
          },
          {
             "prodNo":"商品編號",
             "prodName":"商品名稱",
             "prodQty":"商品數量",
             "prodPrice":"商品價格"
          }
       ]
    }
 ]
*/
/* 折價券需要使用的資料
最簡單應該List<CouponVO>直接傳也可以，但會多傳很多不必要的資訊
[
   {
      "rsetaurantName":"餐廳名稱",
      "coupons":[
         {
            "couponNo":"折價券編號",
            "couponName":"折價券名稱",
            "couponContent":"折價券內容",
            "amountOrFold":"金額或折價",
            "couponType":"折價類型"
         },
         {
            "couponNo":"折價券編號",
            "couponName":"折價券名稱",
            "couponContent":"折價券內容",
            "amountOrFold":"金額或折價",
            "couponType":"折價類型"
         }
      ]
   },
   {
      "rsetaurantName":"餐廳名稱",
      "coupons":[
         {
            "couponNo":"折價券編號",
            "couponName":"折價券名稱",
            "couponContent":"折價券內容",
            "amountOrFold":"金額或折價",
            "couponType":"折價類型"
         },
         {
            "couponNo":"折價券編號",
            "couponName":"折價券名稱",
            "couponContent":"折價券內容",
            "amountOrFold":"金額或折價",
            "couponType":"折價類型"
         }
      ]
   }
]

*/
var cartList;
fetch("../cart/allDetail")
  .then((r) => r.json())
  .then((data) => {
    cartList = data;
    // console.log(data);
    $("div.shopping__cart__table").children().remove();
    $.each(cartList, (index, restaurant) => {
      let table_html = `<table>
        <thead class="prod__cart__heads" data-restaurantNo="${restaurant.restaurantNo}">
          <tr>
            <th class="prod__cart__head1" data-restaurantName="${restaurant.restaurantName}">
                <span class="-plus">+</span><span class="-minus">-</span>
                ${restaurant.restaurantName}
            </th>
            <th class="prod__cart__head2">數量</th>
            <th class="prod__cart__head3">金額</th>
            <th></th>
          </tr>
        </thead>
        <tbody class="prod__cart__items" id="restaurantNo${restaurant.restaurantNo}">
        </tbody>
      </table>
      <div class="table__divider"></div>`;
      $("div.shopping__cart__table").append(table_html);
      $.each(restaurant.cart, (index, product) => {
        let row_html = `<tr data-prodNo="${product.prodNo}">
          <td class="product__cart__item">
            <div class="product__cart__item__pic">
              <img src="../product/mainPic?prodNo=${product.prodNo}" alt="">
            </div>
            <div class="product__cart__item__text">
              <h6>${product.prodName}</h6>
              <h5 price="${product.prodPrice}">NTD ${product.prodPrice}</h5>
            </div>
          </td>
          <td class="quantity__item">
            <div class="quantity">
              <div class="pro-qty">
                <span class="dec qtybtn">-</span>
                <input type="text" value="${product.prodQty}">
                <span class="inc qtybtn">+</span>
              </div>
            </div>
          </td>
        <td class="cart__price"></td>
        <td class="cart__close"><span class="icon_close"></span></td>
        </tr>`;
        // console.log(product);
        $(`#restaurantNo${restaurant.restaurantNo}`).append(row_html);
      });
    });
    $("div.shopping__cart__table").find("thead").first().trigger("click");
  });

$(function () {
  function calculateCart() {
    // console.log($("thead.-on").next("tbody").find("td.cart__price"));
    // 僅針對打開的表個計算
    $("div.cart__total li.cart__subtotal").remove();

    let totalAmount = 0;
    let totalQty = 0;
    $("table.-on")
      .children("tbody")
      .find("td.cart__price")
      .each(function (index, item) {
        let price = parseInt(
          $(item).siblings("td.product__cart__item").find("h5").attr("price")
        );
        let quantity = parseInt(
          $(item).siblings("td.quantity__item").find("input").val()
        );
        let subtotal = price * quantity;

        $(item).html(`NTD ${subtotal}`);
        $(item).attr("subtotal", subtotal);
        // console.log("777");
        totalAmount += subtotal;
        totalQty += quantity;

        let itemName = $(this)
          .siblings("td.product__cart__item")
          .find("h6")
          .text();
        // console.log(itemName);
        let li_subtotal = `<li class="cart__subtotal">${itemName} <span>${subtotal}</span></li>`;
        if (subtotal != 0) {
          $("li.cart__total__divider").before(li_subtotal);
        }
      });

    $("li.cart__final__amount > span").text(`NTD ${totalAmount}`);
    $("li.cart__final__amount").attr("data-amount", totalAmount);
    $("div.header__top__right__cart div.cart__price span").text(
      `${totalQty}筆`
    );

    if ($("li.cart__final__amount").is(":nth-child(2)")) {
      $("li.cart__final__amount").removeClass("-on");
    } else {
      $("li.cart__final__amount").addClass("-on");
    }
  }

  calculateCart();

  // +-變更購物車內容數量
  $("div.shopping__cart__table").on("click", ".qtybtn", function () {
    var $button = $(this);
    var oldValue = $button.parent().find("input").val();
    if ($button.hasClass("inc")) {
      var newVal = parseFloat(oldValue) + 1;
    } else {
      // Don't allow decrementing below zero
      if (oldValue > 0) {
        var newVal = parseFloat(oldValue) - 1;
      } else {
        newVal = 0;
      }
    }
    $button.parent().find("input").val(newVal);
    calculateCart();
    let update = {
      prodNo: parseInt($(this).closest("tr").attr("data-prodNo")),
      prodQty: parseInt($(this).siblings("input").val()),
    };
    // console.log(update);
    fetch("../cart/update", {
      method: "PATCH",
      body: JSON.stringify(update),
      headers: { "content-type": "application/json" },
    })
      .then((r) => r.json())
      .then((data) => {
        //   console.log(data);
      });
  });

  // 輸入變更購物車內容數量
  $("div.shopping__cart__table").on("change", "input", function () {
    if ($(this).val() < 0 || isNaN($(this).val()) || $(this).val() == "") {
      $(this).val("0");
    } else {
      $(this).val(parseInt($(this).val()));
    }
    // console.log($(this).val());
    calculateCart();
    let update = {
      prodNo: parseInt($(this).closest("tr").attr("data-prodNo")),
      prodQty: parseInt($(this).val()),
    };
    // console.log(update);
    fetch("../cart/update", {
      method: "PATCH",
      body: JSON.stringify(update),
      headers: { "content-type": "application/json" },
    })
      .then((r) => r.json())
      .then((data) => {
        //   console.log(data);
      });
  });

  // 縮合不同餐廳內的購物車內容
  $("div.shopping__cart__table").on(
    "click",
    "thead.prod__cart__heads",
    function () {
      // console.log($(this).closest("table"));
      // console.log($(this).next("tbody.prod__cart__items"));
      // console.log("aaa");
      // 關閉其他已打開的表格關閉
      let otherOpenTable = $(this).closest("table").siblings(".-on");
      otherOpenTable
        .children("tbody.prod__cart__items")
        .find("tr")
        .slideToggle(1);
      otherOpenTable.toggleClass("-on");

      // 縮核備點擊餐廳的購物車內容
      let targetTable = $(this).next("tbody.prod__cart__items");
      $(this).closest("table").toggleClass("-on");
      targetTable.find("tr").slideToggle(1);

      // 金額重新計算
      calculateCart();
      if ($("#use__coupon").hasClass("coupon__using")) {
        $("#use__coupon").html("使用");
        $("#use__coupon").removeClass("coupon__using");
        $("div.cart__discount__alert span").removeClass("-on");
        $("div.cart__total li.coupon__using").remove();
        $("div.nice-select li.selected").removeClass("selected");
        $("div.nice-select li").first().addClass("selected");
        $("div.nice-select span.current").text(
          $("div.nice-select li.selected").text()
        );
      }
    }
  );

  // 刪除購物車內容
  $("div.shopping__cart__table").on("click", "span.icon_close", function () {
    // console.log(this);
    let delete_item = {
      prodNo: parseInt($(this).closest("tr").attr("data-prodNo")),
    };
    fetch("../cart/delete", {
      method: "DELETE",
      body: JSON.stringify(delete_item),
      headers: { "content-type": "application/json" }
    })
      .then((r) => r.json())
      .then((data) => {
        //   console.log(data);
      });

    let target = $(this).closest("tr");

    if (target.is(":first-child") && target.is(":last-child")) {
      // console.log("aaa");
      target.closest("table").fadeOut(500, function () {
        $(this).remove();
        calculateCart();
      });
    } else {
      target.fadeOut(500, function () {
        // console.log(this);
        // console.log($(this).is(":last-child"));

        // if($(this).is(":first-child") && $(this).is(":last-child")) {
        //     $(this).closest("table").remove();
        // }
        $(this).remove();
        calculateCart();
      });
    }
  });

  // 使用折價券按鈕功能
  $("#use__coupon").on("click", function () {
    // console.log(this);
    let selected__coupon = $(this)
      .closest("form")
      .find("div.nice-select li.selected")
      .attr("data-value");
    // console.log(selected__coupon);
    // 若未選擇折價券，直接回傳，不執行後方程式碼
    if (selected__coupon == "") {
      return;
    }

    let coupon__discount = -50;
    let li__coupon__discount = `<li class="coupon__using">
            折價券優惠 
            <span>${coupon__discount}</span>
        </li>`;
    let li__amount__before = `<li class="amount__before ">
            折扣前金額
            <span>尚未更新</span>
        </li>`;

    if ($(this).hasClass("coupon__using")) {
      /**
       * 若目前已有折價券使用中，則取消使用折價券
       * 取消顯示警告訊息
       * */
      // console.log("using");
      $("div.cart__total li.coupon__using").fadeOut(500, function () {
        $(this).remove();
      });
      $(this).html("使用");
      // $("div.cart__discount__alert span").removeClass("-on");
      $("div.nice-select li.selected").removeClass("selected");
      $("div.nice-select li").first().addClass("selected");
      $("div.nice-select span.current").text(
        $("div.nice-select li.selected").text()
      );
    } else {
      /**
       * 若目前尚未有折價券使用中，則使用折價券
       * */
      // console.log("not using");
      // console.log($("div.cart__total li.cart__orginal__amount"));
      $("div.cart__total li.cart__final__amount").before(li__coupon__discount);
      $("div.cart__total li.coupon__using").fadeIn(500);
      $(this).html("取消");
    }

    $(this).toggleClass("coupon__using");
  });

  // 配合折價券按鈕功能遮蔽折價券選擇
  $("div.selected__coupon__mask").on("click", function (e) {
    if ($("button#use__coupon").hasClass("coupon__using")) {
      // console.log("using");
      // 若已有折價券使用中，則停止冒泡事件，不讓使用者再次選擇折價券
      // 需先取消折價券後再使用
      e.stopPropagation();
      $("div.cart__discount__alert span").addClass("-on");
      $("div.cart__discount__alert span").css({
        visibility: "visible",
      });
      $("div.cart__discount__alert span").fadeOut(3500, function () {
        $(this).css({
          display: "block",
          visibility: "hidden",
        });
        $(this).removeClass("-on");
      });
    } else {
      // console.log("not using");
    }
  });

  // 數量變動重新計算金額
  /*-------------------
		Quantity change
	--------------------- */
  // var proQty = $(".pro-qty");
  // proQty.prepend('<span class="dec qtybtn">-</span>');
  // proQty.append('<span class="inc qtybtn">+</span>');
  //   proQty.on("click", ".qtybtn", function () {
  //     calculateCart();
  //     console.log(123);
  //   });

  //   $("div.shopping__cart__table").find("thead").first().trigger("click");

  // 繼續購物 -> 用a標籤直接跳轉，沒有另外寫js

  // 前往結帳功能
  $("a.primary-btn").on("click", function (e) {
    e.preventDefault();
    // console.log($("table.-on"));
    if (!$("table.-on").length) {
      //   console.log("aa");
      //   let error_message = '<li class="error_message">請選擇欲結帳之餐廳商品</li>'
      $("li.error_message").css({
        visibility: "visible",
      });
      $("li.error_message").fadeOut(3500, function () {
        $(this).css({
          display: "block",
          visibility: "hidden",
        });
      });
      return;
    }
    let order_list = new Array();
    $.each($("table.-on tbody tr"), (index, item) => {
      let prod_qty = parseInt($(item).find("input").val());
      if (prod_qty) {
        let order_detail = {
        prodNo: parseInt($(item).attr("data-prodNo")),
        prodName: $(item).find("h6").text(),
        prodQty: prod_qty,
        prodPrice: parseInt($(item).find("td.cart__price").attr("subtotal"))
        };
        order_list[index] = order_detail;
      }
    });
    let data = {
      prodOrderVO: {
        restaurantNo: parseInt(
          $("table.-on > .prod__cart__heads").attr("data-restaurantNo")
        ),
        restaurantName: $("table.-on .prod__cart__head1").attr("data-restaurantName"),
        couponNo: null,
        deliverFee: null,
        amountBeforeCoupon: parseInt($("li.cart__final__amount").attr("data-amount")),
        amountAfterCoupon: parseInt($("li.cart__final__amount").attr("data-amount")),
        prodOrderPoint: parseInt($("li.cart__final__amount").attr("data-amount")),
        prodOrderReceiverName: null,
        prodOrderReceiverTel: null,
        prodOrderReceiverMail: null,
        prodOrderReceiverAddress: null,
        taxIDNumber: null
      },
      orderDetailList: order_list,
    };
    console.log(data);
    sessionStorage.setItem("tempOrder", JSON.stringify(data));
    window.location.href = "./checkout.html";
  });
});
