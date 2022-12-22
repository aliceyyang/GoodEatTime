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
  console.log(tempOrder);
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
  // 金額加上運費
  tempOrder.prodOrderVO.amountAfterCoupon+=tempOrder.prodOrderVO.deliverFee;
  tempOrder.prodOrderVO.amountBeforeCoupon+=tempOrder.prodOrderVO.deliverFee;
  $("ul.checkout__total__all span").text(`NTD ${tempOrder.prodOrderVO.amountAfterCoupon}`);
  //   $("#price_confirm").click();
  
  // 收件人姓名不可為空白
  $("#receiver_name").on("blur", function(){
    $(this).siblings().children(".error_message").remove();
    if ($(this).val().trim()=="") {
      let error_message = "<span class='error_message'>&emsp;不可為空白</span>";
      $(this).siblings().append(error_message);
    }
  });

  // 收件地址不可為空白
  $("#receiver_address").on("blur", function(){
    $(this).siblings().children(".error_message").remove();
    if ($(this).val().trim()=="") {
      let error_message = "<span class='error_message'>&emsp;不可為空白</span>";
      $(this).siblings().append(error_message);
      return;
    }
  });

  // 驗證電話格式
  $("#receiver_tel").on("blur", function(){
    $(this).siblings().children(".error_message").remove();
    if ($(this).val().trim()=="") {
      let error_message = "<span class='error_message'>&emsp;不可為空白</span>";
      $(this).siblings().append(error_message);
      return;
    }
    let pattern =  /^09\d{2}\d{6}$/;
    if(!pattern.test($(this).val())){
      let error_message = "<span class='error_message'>&emsp;電話號碼格式錯誤</span>";
      $(this).siblings().append(error_message);
      return;
    }
  });

  // 驗證信箱格式
  $("#receiver_mail").on("blur", function(){
    $(this).siblings().children(".error_message").remove();
    if ($(this).val().trim()=="") {
      let error_message = "<span class='error_message'>&emsp;不可為空白</span>";
      $(this).siblings().append(error_message);
      return;
    }
    let pattern = /^([\w]+)(.[\w]+)*@([\w]+)(.[\w]{2,3}){1,2}$/;
    if (!pattern.test($(this).val())){
      let error_message = "<span class='error_message'>&emsp;信箱地址格式錯誤</span>";
      $(this).siblings().append(error_message);
      return;
    }
  });

  // 驗證統一編號格式
  $("#receiver_taxId").on("blur",function(){
    $(this).siblings().children(".error_message").remove();
    if ($(this).val().trim()=="") {
      $(this).val("");
      return;
    }
    let pattern = /^\d{8}$/;
    if (!pattern.test($(this).val())){
      let error_message = "<span class='error_message'>&emsp;統一編號格式錯誤</span>";
      $(this).siblings().append(error_message);
      return;
    }
  });

  $("#price_check").on("click", function(e){
    if ($("#receiver_name").val().trim() == "") {
      console.log("aaa");
      e.stopPropagation();
      return;
    }
    $(this).toggleClass("-on");
    // $(this).find("label").trigger("click");
  });
  console.log(tempOrder);
});
