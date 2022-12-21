var tbcoupon_update = document.querySelector("#tbcoupon_update");
var couponNo = sessionStorage.getItem("couponNo")
$.ajax({
  url: "../coupon/update",
  type: "GET",
  data: {"couponNo" : couponNo},
  dataType: "json",
  success: function (coupon) {
    console.log(coupon);
    tbcoupon_update.innerHTML = Template(coupon);
  },
});



function onConfirmClick() {
  const couponStartTime = document.querySelector('#couponStartTime').value;
  const couponEndTime = document.querySelector('#couponEndTime').value;
  const couponContent = document.querySelector('#couponContent').value;
  const usageLimitation = document.querySelector('#usageLimitation').value;
  const amountOrFold = document.querySelector('#amountOrFold').value;
  const couponType = Boolean(document.querySelector('input[name="couponType"]:checked').value);
  const couponName = document.querySelector('#couponName').value;
  const maxIssueQty = document.querySelector('#maxIssueQty').value;
  const news_file = document.querySelector('#news_file');

  const fileReader = new FileReader();
  fileReader.onload = event => {
      const couponPicStr = btoa(event.target.result);

      $.ajax({
        url: "../coupon/update",
        type: "POST",
        contentType: 'application/json',
        data:JSON.stringify({
          "couponNo": couponNo,
          "couponStartTime": couponStartTime,
          "couponEndTime": couponEndTime,
          "couponContent": couponContent,
          "usageLimitation": usageLimitation,
          "amountOrFold": amountOrFold,
          "couponType": couponType,
          "couponName": couponName,
          "maxIssueQty": maxIssueQty,
          "couponPicStr": couponPicStr
        }),
        dataType: "json",
        success: function () {
          alert("xxxxxxxxxx");
        }
      })
    };
  fileReader.readAsBinaryString(news_file.files[0]);
}

function Template({couponNo, couponApplyDate, couponStartTime, couponEndTime, couponContent,usageLimitation, amountOrFold,couponType,couponName,maxIssueQty, issuedQty, couponPicStr}) {
  const picUrl = getPicUrl(couponPicStr);
  return `
  <h3>資料設定</h3>
  <div class="class__sidebar col-lg-6" style="width:50% ; margin: 0px auto ;float: left;">
    <form>
        <h4>優惠券編號 : ${couponNo}</h4>
        <span>優惠券名稱 :<input type="text" value="${couponName}" placeholder="${couponName}" id="couponName" required></span>
        <span>活動開始時間 :<input type="date" value="${couponStartTime}" placeholder="${couponStartTime}" id="couponStartTime" required></span>
        <span>活動結束時間 :<input type="date" value="${couponEndTime}" placeholder="${couponEndTime}" id="couponEndTime" required></span>
        <span>訂單金額滿多少可以使用 :<input type="text" value="${usageLimitation}" placeholder="${usageLimitation}" id="usageLimitation" required></span>
        <span>金額 / 折數 :<input type="text" value="${amountOrFold}" placeholder="${amountOrFold}" id="amountOrFold" required></span>
        <label>折價<input type="radio" value="true" name="couponType" id="amount" checked ></label>
        <label>打折<input type="radio" value="false"  id="Fold" name="couponType"></label>
        <p>發行張數上限 :<input type="text" value="${maxIssueQty}" placeholder="${maxIssueQty}" id="maxIssueQty" required></p>
        <span>已發行張數 :${issuedQty}</span>  
      </form>
    </div>
    <div class="class__sidebar col-lg-6" style="width:50% ; margin: 0px auto; float: right;">
      <form>
        <span>優惠券說明內容 :<textarea id="couponContent" style="width:450px ; height:300px" placeholder="${couponContent}" required></textarea></span>
        <p>現有圖片 :</p>
        <img class="updatePic" src="${picUrl}">
        <div class="preview">
          <img id="news_file_preview">
          <label id="updatePicdata" for="news_file">上傳圖片</label>
          <input type="file" id="news_file" accept="image/*" onchange="showPreview(event);/>
        </div>
      </form>
      <label id="updata" for="confirmbtn"></label>
      <button type="button" id="confirmbtn" onclick="onConfirmClick()">確認</button>
    </div>`
}
//==========================顯示圖片=================================

function getPicUrl(base64Str) {
  const binaryStr = atob(base64Str);
  let len = binaryStr.length;
  const uint8Array = new Uint8Array(len);
  while (len--) {
    uint8Array[len] = binaryStr.charCodeAt(len);
  }
  const blob = new Blob([uint8Array]);
  return URL.createObjectURL(blob);
}

//==========================顯示上傳圖片=================================
function showPreview(event){
  if(event.target.files.length > 0){
    var src = URL.createObjectURL(event.target.files[0]);
    var preview = document.getElementById("news_file_preview");
    preview.src = src;
    preview.style.display = "block";
  }
}