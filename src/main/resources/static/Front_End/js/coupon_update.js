var tbcoupon_update = document.querySelector("#tbcoupon_update");
var couponNo = parseInt(sessionStorage.getItem("couponNo"));

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
//==========================返回=================================
function onbackClick() {
  location.href ="coupon_restaurant.html";
}
//==========================上傳資料=================================
function onConfirmClick() {
  const couponStartTime = document.querySelector('#couponStartTime').value;
  const couponEndTime = document.querySelector('#couponEndTime').value;
  const couponContent = document.querySelector('#couponContent').value;
  const usageLimitation = parseInt(document.querySelector('#usageLimitation').value);
  const amountOrFold = parseFloat(document.querySelector('#amountOrFold').value);
  const couponType = JSON.parse(document.querySelector('input[name="couponType"]:checked').value);
  const couponName = document.querySelector('#couponName').value;
  const maxIssueQty = parseInt(document.querySelector('#maxIssueQty').value);
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
            if (confirm("確定更新優惠券資料嗎?") == true) {
              alert("更新成功");
              location.href ="coupon_restaurant.html";
            } else {
              alert("取消更新");
            }
        }
      })
    };
  fileReader.readAsBinaryString(news_file.files[0]);
}

function Template({couponNo, couponStartTime, couponEndTime, couponContent, usageLimitation, amountOrFold,couponType,couponName,maxIssueQty, issuedQty, couponPicStr}) {
  const picUrl = getPicUrl(couponPicStr);
  return `
  <h3>優惠券更新</h3>
  <div class="class__sidebar col-lg-6" style="width: 50%; height: 755px; margin: 0px auto; float: left">
    <form>
        <h3 class="couponNo">優惠券編號 : ${couponNo}</h3>
        <span>優惠券名稱 :<input type="text"  placeholder="${couponName}" id="couponName"></span>
        <span>活動開始時間 :<input type="date"  placeholder="${couponStartTime}" id="couponStartTime"></span>
        <span>活動結束時間 :<input type="date"  placeholder="${couponEndTime}" id="couponEndTime"></span>
        <span>訂單金額滿多少可以使用 :<input type="text"  placeholder="${usageLimitation}" id="usageLimitation"></span>
        <span>金額 / 折數 :<input type="text"  placeholder="${amountOrFold}" id="amountOrFold"></span>
        <label>折價<input type="radio" value="true" name="couponType" id="amount" checked></label>
        <label>打折<input type="radio" value="false"  id="Fold" name="couponType"></label>  
      </form>
    </div>
    <div class="class__sidebar col-lg-6" style="width: 50%; height: 755px; margin: 0px auto; float: right">
      <form>
        <span>發行張數上限 :<input type="text"  placeholder="${maxIssueQty}" id="maxIssueQty"></span>
        <span>已發行張數 :<input type="text" disabled="disabled" placeholder="${issuedQty}"</span>
        <span>優惠券說明內容 :<textarea id="couponContent" style="resize: none; width:450px ; height:121px" placeholder="${couponContent}"></textarea></span>
        <div class="wrapper">
          <div id="first">
              <p>現有圖片 :</p>
              <img class="updatePic" src="${picUrl}" onload="nullPic()">
          </div>
            <div id="second">
              <p>上傳圖片 :</p>
              <img id="news_file_preview" style="width: 150px; height: 150px; border:1px dashed;">
              <label id="updatePicdata" for="news_file">上傳圖片</label>
              <input type="file" id="news_file" accept="image/*" onchange="showPreview(event);">
            </div>
          </div>
      </form>
      <label id="backpage" for="backpagebtn"></label>
      <button type="button" id="backpagebtn" onclick="onbackClick()">返回</button>
      <label id="updata" for="confirmbtn"></label>
      <button type="button" id="confirmbtn" onclick="onConfirmClick()">確認</button>
    </div>`
}
//==========================顯示圖片=================================

function getPicUrl(base64Str) {
  if (base64Str) {
    const binaryStr = atob(base64Str);
    let len = binaryStr.length;
    const uint8Array = new Uint8Array(len);
    while (len--) {
      uint8Array[len] = binaryStr.charCodeAt(len);
    }
    const blob = new Blob([uint8Array]);
    return URL.createObjectURL(blob);
  }  else {
    $(document).ready(function () {
       $('img[src="undefined"]').parent().remove();
    })
  }
};


//==========================顯示上傳圖片=================================
function showPreview(event){
  if(event.target.files.length > 0){
    var src = URL.createObjectURL(event.target.files[0]);
    var preview = document.getElementById("news_file_preview");
    preview.src = src;
    preview.style.display = "block";
  }
}