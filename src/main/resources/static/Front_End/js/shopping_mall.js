// console.log($("div.product__rating .fill-ratings"));

// 修改商品星等
// $("div.product__rating .fill-ratings").attr("style", "width: 30%");

/**
 * 抓全部產品、計算星等後放入
 * 資料格式如下
 * -> 已完成
 *
 * 12筆一頁分頁
 * -> 已完成
 * -> lazy loading???
 *
 * 跳轉至商品明細頁面，呈現商品明細
 * -> 已完成
 *
 * 依商品類別篩選
 *
 * 修改資料庫中購物車的內容
 * ->已完成
 * 
 * 分頁
 * ->完成一半，重整會回到第一頁
 *
 * 價格排序
 *
 * 優惠券優先排序???
 *
 * 關鍵字搜尋???
 *
 * 漢堡&清單列表拿掉
 *
 */
/* 資料格式
[
    {
       "prodNo":"商品編號",
       "prodName":"商品名稱",
       "restaurantName":"餐廳名稱",
       "prodCategory":"商品類別",
       "prodPrice":"商品價格",
       "averageRating":"平均評分"
    },
    {
       "prodNo":"商品編號",
       "prodName":"商品名稱",
       "restaurantName":"餐廳名稱",
       "prodCategory":"商品類別",
       "prodPrice":"商品價格",
       "averageRating":"平均評分"
    }
 ]
 */

//更換頁面的功能
function changePage(page, data) {
  // 先刪除原本頁面上的元素
  $("section.shop > div.container > div.row").children().remove();
  $("div.shop__pagination").children().remove();
  // 根據頁面編號放入相對應的產品
  for (var i = (page - 1) * 12; i < page * 12; i++) {
    let averageRating =
      data[i].prodCommentQty == 0
        ? 0
        : (data[i].totalCommentRating / data[i].prodCommentQty) * 20;
    let addCart = data[i].prodNo in shoppingCart ? "已在購物車" : "加入購物車";
    let addCartClass = data[i].prodNo in shoppingCart ? "cart_add added" : "cart_add";
    let product_html = `<div class="col-lg-3 col-md-6 col-sm-6">
         <div class="product__item">
           <div
             class="product__item__pic set-bg"
             style="background-image: url('../product/mainPic?prodNo=${data[i].prodNo}');" data-prodNo="${data[i].prodNo}"
           >
           <div class="product__rating">
             <div class="fill-ratings" style="width: ${averageRating}%">
               <span>★★★★★</span>
             </div>
             <div class="empty-ratings">
               <span>★★★★★</span>
             </div>
           </div>
             <div class="product__label">
               <span>${data[i].restaurantName}</span>
             </div>
           </div>
           <div class="product__item__text">
             <h6><a href="#" data-prodNo="${data[i].prodNo}">${data[i].prodName}</a></h6>
             <div class="product__item__price">NTD &nbsp; ${data[i].prodPrice}</div>
             <div class="${addCartClass}" data-prodNo="${data[i].prodNo}">
               <a href="#" data-prodNo="${data[i].prodNo}">${addCart}</a>
             </div>
           </div>
         </div>
       </div>`;
    $("section.shop > div.container > div.row").append(product_html);
    if (data.length == i + 1) {
      break;
    }
  }

  // 更新頁面按鈕
  if (page > 1) {
    // 第一頁
    let first_page = `<a href="#" data-page="1"><span class="arrow_carrot-left"></span></a>`;
    $("div.shop__pagination").append(first_page);
  }
  for (var i = 1; i <= data.length / 12; i++) {
    // 每一頁
    let page_html = `<a href="#" data-page="${i}">${i}</a>`;
    $("div.shop__pagination").append(page_html);
  }
  if (data.length - page > 1) {
    // 最後一頁
    let last_page = `<a href="#" data-page="last"><span class="arrow_carrot-right"></span></a>`;
    $("div.shop__pagination").append(last_page);
  }
}

let prodQty = -1;
var prodList;
var prodCategoryList;
var shoppingCart;

// 載入頁面時先去跟後端拿資料
$.ajax({
  url: "../product/all",
  type: "GET",
  data: "",
  dataType: "json",
  success: function (data) {
    prodQty = data.prodList.length;
    prodList = data.prodList;
    prodCategoryList = data.prodCategoryList;
    shoppingCart = data.shoppingCart;
    changePage(1, data.prodList);
    // console.log(prodCategoryList);
    $("div.shop__option__search select").children().remove();
    $("div.shop__option__search select").append(
      '<option value="0">商品類別</option>'
    );
    $.each(prodCategoryList, (index, item) => {
      $("div.shop__option__search select").append(
        `<option value="${item.prodCategoryNo}">${item.prodCategory}</option>`
      );
    });
    $("select").niceSelect('update');
  },
  error: function (xhr) {
    console.log(xhr);
  },
  complete: function (data) {
    $("div.shop__last__text > p").text(`查詢結果共 ${prodQty} 筆`);

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

  // 加入購物車功能
  $("#product_area").on("click", "div.cart_add > a", function(e) {
    e.preventDefault();
    if ($(this).closest("div").hasClass("added")) {
      return;
    }
    var data = {prodNo: parseInt($(this).attr("data-prodNo"))};
    // console.log(data.prodNo);
    // console.log(data);
    // let form_data = new FormData();
    // form_data.append("prodNo", parseInt($(this).attr("data-prodNo")));
    fetch("../cart/insert", {
      method: "POST",
      body: JSON.stringify(data),
      headers: {'content-type': 'application/json'}
    }).then((r) => r.json())
    .then((data) => {
      // console.log(data);
      $(this).closest("div").addClass("added");
      $(this).text("已在購物車");
    });
  });
});
