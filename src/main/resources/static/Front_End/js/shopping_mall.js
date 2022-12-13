// console.log($("div.product__rating .fill-ratings"));

// 修改商品星等
// $("div.product__rating .fill-ratings").attr("style", "width: 30%");

/**
 * 抓全部產品、計算星等後放入
 * 資料格式如下
 *
 * 12筆一頁分頁???
 *
 * 依商品類別篩選
 *
 * 加入購物車->跳轉至購物車頁面，修改資料庫中購物車的內容
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
function changePage(page, data) {
  $("section.shop > div.container > div.row").children().remove();
  for (var i = 0; i < page * 12; i++) {
    let averageRating =
      data[i].prodCommentQty == 0
        ? 0
        : (data[i].totalCommentRating / data[i].prodCommentQty) * 20;
    let product_html = `<div class="col-lg-3 col-md-6 col-sm-6">
         <div class="product__item">
           <div
             class="product__item__pic set-bg"
             style="background-image: url('../product/mainPic?prodNo=${data[i].prodNo}');"
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
             <h6><a href="#">${data[i].prodName}</a></h6>
             <div class="product__item__price">NTD &nbsp; ${data[i].prodPrice}</div>
             <div class="cart_add" data-prodNo="${data[i].prodNo}">
               <a href="#">加入購物車</a>
             </div>
           </div>
         </div>
       </div>`;
    $("section.shop > div.container > div.row").append(product_html);
  }
}

let prodQty = -1;
var prodList;
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


