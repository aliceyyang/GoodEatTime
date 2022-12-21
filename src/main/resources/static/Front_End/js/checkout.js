console.log("read success");

/**
 * 抓出購物車傳來的prodOrderDetail資訊呈現在頁面上
 *
 * 抓出memberVO的資料暫存在js中
 * 若會員本人即是收貨人則抓出資料呈現在對應的欄位
 * 會員本人即是收貨人的話，仍可以修改地址&統編，其餘欄位則無法修改
 *
 * 確認收貨人資訊->檢查收貨人資訊是否符合格式
 * 確認付款資訊->檢查付款資訊是否符合格式
 * 確認後又再修改的話->需重新確認
 *
 *
 * 新增訂單
 * 新增訂單明細
 *
 *
 * 串接綠界api
 *
 */

$(function () {
  var tempOrder = JSON.parse(sessionStorage.getItem("tempOrder"));
  $("div.checkout__order__products").html(
    `${tempOrder.prodOrderVO.restaurantName} 的產品  <span>金額</span>`
  );
  // 從sessionStorage取出商品放入右側訂單欄位
  $("#checkout__total__products").children().remove();
  $.each(tempOrder.orderDetailList, (index, item) => {
    let order_item_html = `<li><samp>${index + 1}.</samp> ${item.prodName}(${
      item.prodQty
    }) <span>${item.prodPrice}</span></li>`;
    $("#checkout__total__products").append(order_item_html);
  });
  // 刪除優惠券扣除額，若有使用優惠券再加上去
  $("#couponFee").remove();
  if (tempOrder.prodOrderVO.couponNo) {
    let coupon_html = `<li id="couponFee" data-fee="-50"> 折價券優惠 <span>-50</span></li>`;
    $("#other_fee").prepend(coupon_html);
  }
  // 運費暫時先寫死
  tempOrder.prodOrderVO.deliverFee = parseInt(
    $("#deliverFee").attr("data-fee")
  );
  console.log(tempOrder);
  // 金額加上運費
  tempOrder.prodOrderVO.amountAfterCoupon+=tempOrder.prodOrderVO.deliverFee;
  tempOrder.prodOrderVO.amountBeforeCoupon+=tempOrder.prodOrderVO.deliverFee;
  $("ul.checkout__total__all span").text(`NTD ${tempOrder.prodOrderVO.amountAfterCoupon}`);
  
  
//   $("#price_confirm").click();
});
