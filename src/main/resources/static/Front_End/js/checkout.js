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
var memberVO;
fetch("../order/receiver").then((r) => r.json())
  .then((data) => {
    memberVO = data;
    console.log(memberVO);
  });

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
  // console.log(tempOrder);
  // 金額加上運費
  tempOrder.prodOrderVO.amountAfterCoupon+=tempOrder.prodOrderVO.deliverFee;
  tempOrder.prodOrderVO.amountBeforeCoupon+=tempOrder.prodOrderVO.deliverFee;
  $("ul.checkout__total__all span").text(`NTD ${tempOrder.prodOrderVO.amountAfterCoupon}`);
  
  // 加入會員資料
  $("#member").on("click", function(e){
    e.stopPropagation();
    
    if ($(this).hasClass("memeber_confirm")) {
      $(this).find("input").removeAttr("disabled");
      $(this).find("input").trigger("click");
      $(this).find("input").attr("disabled", "disabled");
      $(this).removeClass("memeber_confirm");
      // console.log("a")
    } else {
      // console.log("b");
      $(this).find("input").removeAttr("disabled");
      $(this).find("input").trigger("click");
      $(this).find("input").attr("disabled", "disabled");
      $("#receiver_name").val(memberVO.name);
      $("#receiver_name").trigger("blur");
      $("#receiver_mail").val(memberVO.mail);
      $("#receiver_mail").trigger("blur");
      if(memberVO.tel) {
        $("#receiver_tel").val(memberVO.tel);
        $("#receiver_tel").trigger("blur");
      }
      $(this).addClass("memeber_confirm");
    }

  });

  // 收件人姓名不可為空白
  $("#receiver_name").on("blur", function(){
    $(this).siblings().children(".error_message").remove();
    if ($(this).val().trim()=="") {
      $(this).removeClass("check_ok");
      let error_message = "<span class='error_message'>&emsp;不可為空白</span>";
      $(this).siblings().append(error_message);
      return;
    }
    tempOrder.prodOrderVO.prodOrderReceiverName = $(this).val().trim();
    $(this).addClass("check_ok");
  });

  // 收件地址不可為空白
  $("#receiver_address").on("blur", function(){
    $(this).siblings().children(".error_message").remove();
    if ($(this).val().trim()=="") {
      $(this).removeClass("check_ok");
      let error_message = "<span class='error_message'>&emsp;不可為空白</span>";
      $(this).siblings().append(error_message);
      return;
    }
    tempOrder.prodOrderVO.prodOrderReceiverAddress = $(this).val().trim();
    $(this).addClass("check_ok");
  });

  // 驗證電話格式
  $("#receiver_tel").on("blur", function(){
    $(this).siblings().children(".error_message").remove();
    if ($(this).val().trim()=="") {
      $(this).removeClass("check_ok");
      let error_message = "<span class='error_message'>&emsp;不可為空白</span>";
      $(this).siblings().append(error_message);
      return;
    }
    let pattern =  /^09\d{2}\d{6}$/;
    if(!pattern.test($(this).val())){
      $(this).removeClass("check_ok");
      let error_message = "<span class='error_message'>&emsp;電話號碼格式錯誤</span>";
      $(this).siblings().append(error_message);
      return;
    }
    tempOrder.prodOrderVO.prodOrderReceiverTel = $(this).val();
    $(this).addClass("check_ok");
  });

  // 驗證信箱格式
  $("#receiver_mail").on("blur", function(){
    $(this).siblings().children(".error_message").remove();
    if ($(this).val().trim()=="") {
      $(this).removeClass("check_ok");
      let error_message = "<span class='error_message'>&emsp;不可為空白</span>";
      $(this).siblings().append(error_message);
      return;
    }
    let pattern = /^([\w]+)(.[\w]+)*@([\w]+)(.[\w]{2,3}){1,2}$/;
    if (!pattern.test($(this).val())){
      $(this).removeClass("check_ok");
      let error_message = "<span class='error_message'>&emsp;信箱地址格式錯誤</span>";
      $(this).siblings().append(error_message);
      return;
    }
    tempOrder.prodOrderVO.prodOrderReceiverMail = $(this).val();
    $(this).addClass("check_ok");
  });

  // 驗證統一編號格式
  $("#receiver_taxId").on("blur",function(){
    $(this).siblings().children(".error_message").remove();
    if ($(this).val().trim()=="") {
      $(this).addClass("check_ok");
      $(this).val("");
      return;
    }
    let pattern = /^\d{8}$/;
    if (!pattern.test($(this).val())){
      $(this).removeClass("check_ok");
      let error_message = "<span class='error_message'>&emsp;統一編號格式錯誤</span>";
      $(this).siblings().append(error_message);
      return;
    }
    tempOrder.prodOrderVO.taxIDNumber = $(this).val();
    $(this).addClass("check_ok");
  });

  // StackOverflow的cc_formatter
  function cc_format(value) {
    var v = value.replace(/\s+/g, '').replace(/[^0-9]/gi, '')
    var matches = v.match(/\d{4,16}/g);
    var match = matches && matches[0] || ''
    var parts = []

    for (i=0, len=match.length; i<len; i+=4) {
        parts.push(match.substring(i, i+4))
    }

    if (parts.length) {
        return parts.join('   ')
    } else {
        return value
    }
  }

  // 不讓使用者輸入數字以外的東西
  $("#credit_card").keypress(function (e) {
    if ((e.which < 48 || e.which > 57) && (e.which !== 8) && (e.which !== 0)) {
        return false;
    }
    return true;
  });

  $("#credit_card").on("keyup", function(){
    $(this).val(cc_format($(this).val()));
    // console.log($(this).val());
    // console.log($(this).val().replace(/ +/g, ""));
  });

  // 信用卡卡號格式確認
  $("#credit_card").on("blur", function() {
    $(this).siblings().children(".error_message").remove();
    if ($(this).val().trim()=="") {
      $(this).removeClass("check_ok");
      let error_message = "<span class='error_message'>&emsp;不可空白</span>";
      $(this).siblings().append(error_message);
      return;
    }
    let pattern =  /^\d{16}$/;
    if(!pattern.test($(this).val().replace(/ +/g, ""))){
      // console.log($(this).val().replace(/ +/g, ""));
      // console.log(!pattern.test($(this).val().replace(/ +/g, "")))
      $(this).removeClass("check_ok");
      let error_message = "<span class='error_message'>&emsp;信用卡卡號格式錯誤</span>";
      $(this).siblings().append(error_message);
      return;
    }
    $(this).addClass("check_ok");
  });

  // cc_formatter用上面的cc_formatter去改的
  function expire_date_format(value) {
    var v = value.replace(/\s+/g, '').replace(/[^0-9]/gi, '')
    var matches = v.match(/\d{2,4}/g);
    var match = matches && matches[0] || ''
    var parts = []

    for (i=0, len=match.length; i<len; i+=2) {
        parts.push(match.substring(i, i+2))
    }

    if (parts.length) {
        return parts.join(' / ')
    } else {
        return value
    }
  }

  // 不讓使用者輸入數字以外的東西
  $("#expire_date").keypress(function (e) {
    if ((e.which < 48 || e.which > 57) && (e.which !== 8) && (e.which !== 0)) {
        return false;
    }
    return true;
  });

  $("#expire_date").on("keyup", function(){
    $(this).val(expire_date_format($(this).val()));
    // console.log($(this).val());
    // console.log($(this).val().split(" / ").join(""));
  });

  // 確認有效期限格式
  $("#expire_date").on("blur", function() {
    $(this).siblings().children(".error_message").remove();
    if ($(this).val().trim()=="") {
      $(this).removeClass("check_ok");
      let error_message = "<span class='error_message'>&emsp;不可空白</span>";
      $(this).siblings().append(error_message);
      return;
    }
    let pattern =  /^0|^11|^12/;
    if(!pattern.test($(this).val().split(" / ").join(""))){
      $(this).removeClass("check_ok");
      let error_message = "<span class='error_message'>&emsp;格式錯誤</span>";
      $(this).siblings().append(error_message);
      return;
    }
    $(this).addClass("check_ok");
  });

  // 不讓使用者輸入數字以外的東西
  $("#security_code").keypress(function (e) {
    if ((e.which < 48 || e.which > 57) && (e.which !== 8) && (e.which !== 0)) {
        return false;
    }
    return true;
    console.log()
  });


  // $("#security_code").on("keyup", function(){
  //   console.log($(this).val());
  // });

  // 確認安全碼格式
  $("#security_code").on("blur", function() {
    $(this).siblings().children(".error_message").remove();
    if ($(this).val().trim()=="") {
      $(this).removeClass("check_ok");
      let error_message = "<span class='error_message'>&emsp;不可空白</span>";
      $(this).siblings().append(error_message);
      return;
    }
    let pattern =  /^\d{3}$/;
    if(!pattern.test($(this).val())){
      $(this).removeClass("check_ok");
      let error_message = "<span class='error_message'>&emsp;格式錯誤</span>";
      $(this).siblings().append(error_message);
      return;
    }
    $(this).addClass("check_ok");
  });

  //確認金額
  $("#price_check").on("click", function(e){
    e.stopPropagation();
    if ($(this).hasClass("price_confirm")) {
      $(this).find("input").removeAttr("disabled");
      $(this).find("input").trigger("click");
      $(this).find("input").attr("disabled", "disabled");
      $(this).removeClass("price_confirm");
    } else {
      $(this).find("input").removeAttr("disabled");
      $(this).find("input").trigger("click");
      $(this).find("input").attr("disabled", "disabled");
      $(this).addClass("price_confirm");
      $(this).find("span.error_message").remove();
    }
    // $(this).toggleClass("price_confirm");
    // console.log($(this).hasClass("price_confirm"));
    // console.log("test");
  });

  // 再次確認收貨人資訊checkbox
  $("#receiver_check").on("click", function(e){
    e.stopPropagation();
    // console.log(!$(".receiver_check").hasClass("check_ok") + "123");
    if ($(this).hasClass("receiver_confirm")) {
      $(".receiver_check").removeAttr("disabled");
      $(this).find("input").removeAttr("disabled");
      $(this).find("input").trigger("click");
      $(this).find("input").attr("disabled", "disabled");
      $(this).removeClass("receiver_confirm");
      return;
    }

    if ($("#receiver_name").hasClass("check_ok") &&
    $("#receiver_address").hasClass("check_ok") &&
    $("#receiver_tel").hasClass("check_ok") &&
    $("#receiver_mail").hasClass("check_ok") &&
    $("#receiver_taxId").hasClass("check_ok")) {
      $(this).find("input").removeAttr("disabled");
      $(this).find("input").trigger("click");
      $(this).find("input").attr("disabled", "disabled");
      $(".receiver_check").attr("disabled", "disabled");
      $(this).addClass("receiver_confirm");
      $(this).find("span.error_message").remove();
      // $("#receiver_name").attr("disabled", "disabled");
      // $("#receiver_address").attr("disabled", "disabled");
      // $("#receiver_tel").attr("disabled", "disabled");
      // $("#receiver_mail").attr("disabled", "disabled");
      // $("#receiver_taxId").attr("disabled", "disabled");
      // console.log("aaa");
      return;
    }
    $(".receiver_check").trigger("blur");
    // console.log("123");
    // $(this).toggleClass("-on");
    // console.log($(this).hasClass("-on"));
  });

  // 信用卡資訊確認
  $("#payment_check").on("click", function(e){
    e.stopPropagation();
    // console.log("aaa");
    if ($(this).hasClass("payment_confirm")) {
      $(".payment_check").removeAttr("disabled");
      $(this).find("input").removeAttr("disabled");
      $(this).find("input").trigger("click");
      $(this).find("input").attr("disabled", "disabled");
      $(this).removeClass("payment_confirm");
      return;
    }

    if ($("#credit_card").hasClass("check_ok") &&
      $("#expire_date").hasClass("check_ok") &&
      $("#security_code").hasClass("check_ok")) {
        $(this).find("input").removeAttr("disabled");
        $(this).find("input").trigger("click");
        $(this).find("input").attr("disabled", "disabled");
        $(".payment_check").attr("disabled", "disabled");
        $(this).addClass("payment_confirm");
        $(this).find("span.error_message").remove();
        return;
    }
    $(".payment_check").trigger("blur");

  });

  // 確認送出訂單
  $(".site-btn").on("click", function(){
    $("#price_check span.error_message").remove();
    $("#receiver_check span.error_message").remove();
    $("#payment_check span.error_message").remove();
    if (!$("#price_check").hasClass("price_confirm")) {
      let error_message = "<span class='error_message'>&emsp;請確認價格資訊</span>";
      $("#price_check label").append(error_message);
      return;
    }
    if (!$("#receiver_check").hasClass("receiver_confirm")) {
      let error_message = "<span class='error_message'>&emsp;請確認收貨人資訊</span>";
      $("#receiver_check label").append(error_message);
      return;
    }
    if (!$("#payment_check").hasClass("payment_confirm")) {
      let error_message = "<span class='error_message'>&emsp;請確認信用卡資訊</span>";
      $("#payment_check label").append(error_message);
      return;
    }
    
    // console.log("資訊驗證ok");
    console.log(tempOrder);

    fetch("../order/insert", {
      method: "POST",
      body: JSON.stringify(tempOrder),
      headers: { "content-type": "application/json" }
    }).then((r) => r.json())
    .then((data) => {
      if(data.message == "Insert Success") {
        Swal.fire({
          position: "center",
          icon: "success",
          title: "訂單新增成功",
          showConfirmButton: false,
          timer: 1000,
        }).then(()=>{
          window.location.href = "./shopping_mall.html";
        });
      } else {
        Swal.fire({
          position: "center",
          icon: "error",
          title: "訂單新增失敗",
          showConfirmButton: false,
          timer: 1000,
        }).then(()=>{
          window.location.href = "./shopping_cart.html";
        });
      }
      
    });

  });

});
