// console.log("read success");

// 商品星等調整
// $("div.product__details__rating .fill-ratings").attr("style", "width: 70%");

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

// 取得query string
const params = new Proxy(new URLSearchParams(window.location.search), {
  get: (searchParams, prop) => searchParams.get(prop),
});
let prodNo = params.prodNo;
// console.log(prodNo);
var prodData;
var shoppingCart;
var similarProdList;

if (prodNo != null && prodNo > 0) {
  fetch(`../product/detail?prodNo=${prodNo}`)
    .then((r) => r.json())
    .then((data) => {
      // console.log(data);
      prodData = data.showProdDetailVO;
      shoppingCart = data.shoppingCart;
      similarProdList = data.similarProdList;
      console.log(similarProdList);
      // 跟後端要主圖片
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
      // 跟後端要附圖片
      $.each(data.prodPicList, (index, item) => {
        // console.log("索引值：" + index + "; 值：" + item);
        let smallPicURL = `../product/prodPic?prodPicNo=${item}`;
        let smallPic = `<div class="pt__item">
          <img
            data-imgbigurl="${smallPicURL}"
            src="${smallPicURL}"
            alt=""
          />
        </div>`;
        $("div.product__details__thumb").append(smallPic);
      });
      // 把商品資料依序放進頁面中
      $("div.product__details__text > div.product__label").text(
        data.showProdDetailVO.restaurantName
      );
      $("div.product__details__text > h4").text(data.showProdDetailVO.prodName);
      $("div.product__details__text > h5").text(
        `NTD ${data.showProdDetailVO.prodPrice}`
      );
      $("div.product__details__text > p").html(
        data.showProdDetailVO.prodDescription
      );
      $("div.product__details__text span.product_category").text(
        data.showProdDetailVO.prodCategory
      );
      $("div.product__details__text span.product_stock").text(
        data.showProdDetailVO.prodStock
      );
      // 計算平均星等
      let averageRating =
        data.showProdDetailVO.prodCommentQty == 0
          ? 0
          : (data.showProdDetailVO.totalCommentRating /
              data.showProdDetailVO.prodCommentQty) *
            20;
      $("div.product__details__text div.fill-ratings").attr(
        "style",
        `width: ${averageRating}%`
      );
      $("#tabs-2 p").html(data.showProdDetailVO.prodContent);
      $("a.primary-btn").text(
        prodNo in data.shoppingCart ? "已在購物車" : "加入購物車"
      );
      // 類似產品放入頁面中
      $.each(similarProdList, (index, item) => {
        // let product_div = $(`#product_item_${index}`);
        // console.log(product_div);
        let avgRating =
          item.prodCommentQty == 0
            ? 0
            : (item.totalCommentRating / item.prodCommentQty) * 20;
        let addCart = item.prodNo in shoppingCart ? "已在購物車" : "加入購物車";
        let addCartClass =
          item.prodNo in shoppingCart ? "added" : "";
        
        // 修改相關產品的圖片
        let prodPic_div = $(`#product_item_${index} .product__item__pic`);
        prodPic_div.removeClass("set-bg");
        prodPic_div.removeAttr("data-setbg");
        prodPic_div.attr(
          "style",
          `background-image: url('../product/mainPic?prodNo=${item.prodNo}');`
        );
        prodPic_div.attr("data-prodNo", `${item.prodNo}`);
        // 把商品資料依序放進頁面中
        $(`#product_item_${index} .fill-ratings`).attr("style", `width: ${avgRating}%`);
        $(`#product_item_${index} .product__label span`).text(`${item.restaurantName}`);
        let prodName_a = $(`#product_item_${index} .product__item__text a`);
        prodName_a.attr("data-prodNo", `${item.prodNo}`);
        prodName_a.text(`${item.prodName}`);
        $(`#product_item_${index} .product__item__price`).text(`NTD \u00A0 ${item.prodPrice}`);
        $(`#product_item_${index} .cart_add a`).text(`${addCart}`);
        $(`#product_item_${index} .cart_add`).attr("data-prodNo", `${item.prodNo}`);
        $(`#product_item_${index} .cart_add`).addClass(`${addCartClass}`);
      });

      // $("div.related__products__slider").children().remove();
      // $.each(similarProdList, (index, item) => {
      //   let avgRating =
      //     item.prodCommentQty == 0
      //       ? 0
      //       : (item.totalCommentRating / item.prodCommentQty) * 20;
      //   let addCart = item.prodNo in shoppingCart ? "已在購物車" : "加入購物車";
      //   let addCartClass =
      //     item.prodNo in shoppingCart ? "cart_add added" : "cart_add";
      //   let similarProd = `<div class="col-lg-3">
      //     <div class="product__item">
      //       <div
      //         class="product__item__pic set-bg"
      //         style="background-image: url('../product/mainPic?prodNo=${item.prodNo}');" data-prodNo="${item.prodNo}"
      //       >
      //         <div class="product__rating">
      //           <div class="fill-ratings" style="width: ${avgRating}%">
      //             <span>★★★★★</span>
      //           </div>
      //           <div class="empty-ratings">
      //             <span>★★★★★</span>
      //           </div>
      //         </div>
      //         <div class="product__label">
      //           <span>${item.restaurantName}</span>
      //         </div>
      //       </div>
      //       <div class="product__item__text">
      //         <h6><a href="#" data-prodNo="${item.prodNo}">${item.prodName}</a></h6>
      //         <div class="product__item__price">NTD &nbsp; ${item.prodPrice}</div>
      //         <div class="${addCartClass}" data-prodNo="${item.prodNo}">
      //         <a href="#">${addCart}</a>
      //       </div>
      //       </div>
      //     </div>
      //   </div>`;
      //   $("div.related__products__slider").append(similarProd);
      // });
    });
}
// 這裡還抓不到，因為執行時，伺服器尚未回傳資料
// console.log(prodData);
$(function () {});
