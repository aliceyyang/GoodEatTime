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
 * 跳轉至購物車頁面，修改資料庫中購物車的內容
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
    let product_html = 
      `<div class="col-lg-3 col-md-6 col-sm-6">
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
             <div class="cart_add" data-prodNo="${data[i].prodNo}">
               <a href="#">加入購物車</a>
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

// 載入頁面時先去跟後端拿資料
$.ajax({
  url: "http://localhost:8080/product/all",
  type: "GET",
  data: "",
  dataType: "json",
  success: function (data) {
    prodQty = data.length;
    prodList = data;
    changePage(1, data);
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
  window.location.href = `http://localhost:8080/Front_End/shop_details.html?prodNo=${prodNo}`;
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
