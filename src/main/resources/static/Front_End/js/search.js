// 載入頁面時先去跟後端拿資料
var restaurantName = sessionStorage.getItem("searchText");
$.ajax({
  url: "/search_restaurant/search",
  type: "POST",
  data: {restaurantName : restaurantName},
  dataType: "json",
  success: function (data) {
    console.log(data);
    restaurantNo = data.restaurantNo;
    restaurantName = data.restaurantName;
    restaurantTel = data.restaurantTel;
    restaurantBusinessHour = data.restaurantBusinessHour;
    restaurantAddr = data.restaurantAddr;
    restaurantCommentQuantity = data.restaurantCommentQuantity;
    totalCommentRating = data.totalCommentRating;
    console.log(restaurantNo);
    // prodQty = data.prodList.length;
    // prodList = data.prodList;
    // prodCategoryList = data.prodCategoryList;
    // shoppingCart = data.shoppingCart;
    // changePage(1, data.prodList);
    // console.log(prodCategoryList);
    // $("div.shop__option__search select").children().remove();
    // $("div.shop__option__search select").append(
    //   '<option value="0">商品類別</option>'
    // );
    // $.each(prodCategoryList, (index, item) => {
    //   $("div.shop__option__search select").append(
    //     `<option value="${item.prodCategoryNo}">${item.prodCategory}</option>`
    //   );
    // });
    // $("select").niceSelect('update');
  },
  error: function (xhr) {
    console.log(xhr);
  },
  complete: function (data) {
    $("div.shop__last__text > p").text(`查詢結果共 ${restaurantNo} 筆`);

    // console.log(prodList)
  },
});

function goToShopDeatil(prodNo) {
  window.location.href = `./shop_details.html?prodNo=${prodNo}`;
}

$(function () {
  // 更換頁面事件註冊
  $("div.shop__pagination").on("click", "a", function (e) {
    e.preventDefault();
    // console.log($(this).attr("data-page"));
    let page = $(this).attr("data-page");
    if (page != "last") {
      changePage(page, prodList);
    } else {
      // (35/12)|0 = 2; 無條件捨去取整數
      changePage((prodQty / 12) | 0, prodList);
    }
  });

  // 點圖片進入商品明細頁面
  $("#product_area").on("click", "div.product__item__pic", function (e) {
    e.preventDefault();
    // console.log($(this).attr("data-prodNo"));
    goToShopDeatil($(this).attr("data-prodNo"));
  });

  // 點商品名稱進入商品明細頁面
  $("#product_area").on(
    "click",
    "div.product__item__text > h6 > a",
    function (e) {
      e.preventDefault();
      goToShopDeatil($(this).attr("data-prodNo"));
      // console.log($(this).attr("data-prodNo"));
    }
  );
});
