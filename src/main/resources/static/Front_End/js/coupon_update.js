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
  const couponType = document.querySelector('#couponType').value;
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
    <tr>
      <td>${couponNo}</td>
      <td><input type="text" value="${couponName}" id="couponName"></td>
      <td>${couponApplyDate}</td>
      <td><input type="text" value="${couponStartTime}" id="couponStartTime"></td>
      <td><input type="text" value="${couponEndTime}" id="couponEndTime"></td>
      <td><input type="textarea" value="${couponContent}" id="couponContent"></td>
      <td><input type="text" value="${usageLimitation}" id="usageLimitation"></td>
      <td><input type="text" value="${amountOrFold}" id="amountOrFold"></td>
      <td><input type="text" value="${couponType}" id="couponType"></td>
      <td><input type="text" value="${maxIssueQty}" id="maxIssueQty"></td>
      <td>${issuedQty}</td>
      <td>
        <input type="file" id="news_file" accept="image/*"/>
        <img src="${picUrl}">
      </td>
      <td><button type="button" id="confirmbtn" onclick="onConfirmClick()">確認</button></td>  
    </tr> `
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

