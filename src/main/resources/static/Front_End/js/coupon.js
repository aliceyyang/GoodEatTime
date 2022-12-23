var tbcoupon_detail = document.querySelector("#tbcoupon_detail");
var tbcoupon_update = document.querySelector("#tbcoupon_update");
var tbcoupon_insert = document.querySelector("#tbcoupon_insert");
$.ajax({
  url: "../coupon/Manage",
  type: "GET",
  dataType: "json",
  success: function (arr) {
    console.log(arr);
    // 如果餐廳沒有優惠券的話會抓不到餐廳編號
    sessionStorage.setItem("restaurantNo", arr[0].restaurantNo)
    tbcoupon_detail.innerHTML = arr.map((e) => Template(e.couponNo, e.couponApplyDate, e.couponStartTime, e.couponEndTime, e.couponContent, e.usageLimitation, e.amountOrFold ,e.couponType ,e.couponName, e.maxIssueQty, e.issuedQty, e.couponPicStr)).join('')
  },
  error: function (arr) {
    console.log(arr);
    tbcoupon_detail.innerHTML = arr.map((e) => Template(e.couponNo, e.couponApplyDate, e.couponStartTime, e.couponEndTime, e.couponContent, e.usageLimitation, e.amountOrFold ,e.couponType ,e.couponName, e.maxIssueQty, e.issuedQty, e.couponPicStr)).join('')
  }
});


function Template(couponNo, couponApplyDate, couponStartTime, couponEndTime, couponContent,usageLimitation, amountOrFold,couponType,couponName,maxIssueQty, issuedQty, couponPicStr) {
  return `<tr>
  <td>${couponNo}</td>
  <td>${couponName}</td>
  <td>${couponApplyDate}</td>
  <td>${couponStartTime}</td>
  <td>${couponEndTime}</td>
  <td>${couponContent}</td>
  <td>${usageLimitation}</td>
  <td>${amountOrFold}</td>
  <td>${couponType ? '折價' : '打折'}</td>
  <td>${maxIssueQty}</td>
  <td>${issuedQty}</td>
  <td>
  	<img src="${couponPicStr ? getPicUrl(couponPicStr) : ''}">
  </td>
  <td><button type="button" id="updatebtn" onclick="update(${couponNo})">修改</button></td>  
  </tr> `
}

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
 
function update(couponNo) {
  sessionStorage.setItem("couponNo",couponNo);
  location.href ="coupon_RESupdate.html";
}

function insert() {
  location.href="coupon_RESinsert.html";
}

