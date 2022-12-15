// console.log("read success");

// 商品星等調整
$("div.product__details__rating .fill-ratings").attr("style", "width: 70%");

/**
 * 使用者傳入的商品編號->controller->把prodInfoVO傳回此頁面
 * 部分資料需轉換restaurantNo -> restaurantName, prodCategoryNo -> prodCategory
 *
 * 考慮新增商品簡單描述資料
 *
 * 類似商品->隨機找同類別的產品顯示
 * 資料格式同商城
 *
 * 加入購物車->跳轉至購物車頁面，修改資料庫中購物車的內容
 *
 * 商品評論
 * 評論部分尚未呈現，可以參考首頁的評論部分
 * 先用prodOrderDetail表格的資料抓出來放到網頁中
 * 後續可以考慮再增加memberName, memberPic等資料呈現
 *
 * 商品詳細改用longtext???
 *
 */

const params = new Proxy(new URLSearchParams(window.location.search), {
  get: (searchParams, prop) => searchParams.get(prop),
});
let prodNo = params.prodNo;
// console.log(prodNo);
var prodData;

if (prodNo != null && prodNo > 0) {
  fetch(`../product/detail?prodNo=${prodNo}`)
    .then((r) => r.json())
    .then((data) => {
      // console.log(data);
      let mainPicURL = `../product/mainPic?prodNo=${prodNo}`;
      $("div.product__details__big__img > img").attr("src", mainPicURL);
      let mainPic = `<div class="pt__item active">
        <img
          data-imgbigurl="${mainPicURL}"
          src="${mainPicURL}"
          alt=""
        />
      </div>`;
      $("div.product__details__thumb").children().remove();
      $("div.product__details__thumb").append(mainPic);
      $.each(data.prodPicList, (index, item) => {
        // console.log("索引值：" + index + "; 值：" + item);
        let smallPicURL = `../product/ProdPic?prodPicNo=${item}`;
        let smallPic = `<div class="pt__item">
          <img
            data-imgbigurl="${smallPicURL}"
            src="${smallPicURL}"
            alt=""
          />
        </div>`;
        $("div.product__details__thumb").append(smallPic);
      });
      $("div.product__details__text > div.product__label").text(data.restaurantName);
      $("div.product__details__text > h4").text(data.prodName);
      $("div.product__details__text > h5").text(`NTD ${data.prodPrice}`);
      $("div.product__details__text > p").html(data.prodDescription);
      $("div.product__details__text span.product_category").text(
        data.prodCategory
      );
      $("div.product__details__text span.product_stock").text(data.prodStock);
      let averageRating =
        data.prodCommentQty == 0
          ? 0
          : (data.totalCommentRating / data.prodCommentQty) * 20;
      $("div.product__details__text div.fill-ratings").attr(
        "style",
        `width: ${averageRating}%`
      );
      $("#tabs-2 p").html(data.prodContent);
      prodData = data;
    });
}
// 這裡還抓不到，因為執行時，伺服器尚未回傳資料
// console.log(prodData);
$(function () {});
