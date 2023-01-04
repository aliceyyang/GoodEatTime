var tbcoupon_insert = document.querySelector("#tbcoupon_insert");
const couponNo = sessionStorage.getItem("couponNo");
let restaurantMemberVO = JSON.parse(sessionStorage.getItem("restaurantMemberVO"));
  var restaurantNo = restaurantMemberVO.restaurantNo
tbcoupon_insert.innerHTML = Template({restaurantNo : restaurantNo});
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
  const picinput = document.querySelector('input#news_file').value

  const string = String;
  
  console.log(!picinput)
  if (!couponName) {
    document.querySelector("#error_Name").style.display = "";
    document.querySelector("#couponName").style.border=
    "2px solid #ff0000";
  } else {
    document.querySelector("#error_Name").style.display = "none";
    document.querySelector("#couponName").style.border= "";
  }
  if (!couponStartTime) {
    document.querySelector("#error_StartTime").style.display = "";
    document.querySelector("#couponStartTime").style.border=
    "2px solid #ff0000";
  } else {
    document.querySelector("#error_StartTime").style.display = "none";
    document.querySelector("#couponStartTime").style.border= "";
  }
  if (!couponEndTime) {
    document.querySelector("#error_EndTime").style.display = "";
    document.querySelector("#couponEndTime").style.border=
    "2px solid #ff0000";
  } else{
    document.querySelector("#error_EndTime").style.display = "none";
    document.querySelector("#couponEndTime").style.border = "";
  }
  if (!usageLimitation || usageLimitation !== usageLimitation ) {
    document.querySelector("#error_use").style.display = "";
    document.querySelector("#usageLimitation").style.border = 
    "2px solid #ff0000"
  } else {
    document.querySelector("#error_use").style.display = "none";
    document.querySelector("#usageLimitation").style.border = "";
  }
  if (!maxIssueQty) {
    document.querySelector("#error_max").style.display = "";
    document.querySelector("#maxIssueQty").style.border = 
    "2px solid #ff0000"
  } else {
    document.querySelector("#error_max").style.display = "none";
    document.querySelector("#maxIssueQty").style.border = "";
  }
  if (!couponContent) {
    document.querySelector("#error_content").style.display = "";
    document.querySelector("#couponContent").style.border = 
    "2px solid #ff0000"
  } else {
    document.querySelector("#error_content").style.display = "none";
    document.querySelector("#couponContent").style.border = "";
  }
  if (!amountOrFold) {
    document.querySelector("#error_type").style.display = "";
    document.querySelector("#amountOrFold").style.border = 
    "2px solid #ff0000"
  } else {
    document.querySelector("#error_type").style.display = "none";
    document.querySelector("#amountOrFold").style.border = "";
  }
//===============================沒有上傳優惠券圖片========================
  if (!picinput) {
    Swal.fire({
      title: '確認不上傳優惠券圖片嗎?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: '確認',
      cancelButtonText: '取消'
    }).then((result) => {
      $.ajax({
        url: "/coupon/insert",
        type: "POST",
        contentType: 'application/json',
        dataType: "json",
        data:JSON.stringify({
          "restaurantNo": restaurantNo,
          "couponStartTime": couponStartTime,
          "couponEndTime": couponEndTime,
          "couponContent": couponContent,
          "usageLimitation": usageLimitation,
          "amountOrFold": amountOrFold,
          "couponType": couponType,
          "couponName": couponName,
          "maxIssueQty": maxIssueQty,
        }),
        success: function () {
            // if (confirm("確定更新優惠券資料嗎?") == true) {
            //   alert("更新成功");
            //   // location.href ="coupon_restaurant.html";
            // } else {
            //   alert("取消更新");
            // }

            Swal.fire({
              title: '確定新增此優惠卻嗎?',
              icon: 'warning',
              showCancelButton: true,
              confirmButtonColor: '#3085d6',
              cancelButtonColor: '#d33',
              confirmButtonText: '確認',
              cancelButtonText: '取消'
            }).then((result) => {
              if (result.isConfirmed) {
                Swal.fire(
                  '新增成功',
                  '優惠券以新增!',
                  'success',
                  location.href ="coupon_restaurant.html"
                )
              }
            })
        }
      })
    })
  } else {
//====================有上傳優惠券圖片========================
    const fileReader = new FileReader();
  fileReader.onload = event => {
      const couponPicStr = btoa(event.target.result);
      $.ajax({
        url: "/coupon/insert",
        type: "POST",
        contentType: 'application/json',
        dataType: "json",
        data:JSON.stringify({
          "restaurantNo": restaurantNo,
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
        success: function () {
            // if (confirm("確定更新優惠券資料嗎?") == true) {
            //   alert("更新成功");
            //   location.href ="coupon_restaurant.html";
            // } else {
            //   alert("取消更新");
            // }

            Swal.fire({
              title: '確定新增此優惠卻嗎?',
              icon: 'warning',
              showCancelButton: true,
              confirmButtonColor: '#3085d6',
              cancelButtonColor: '#d33',
              confirmButtonText: '確認',
              cancelButtonText: '取消'
            }).then((result) => {
              if (result.isConfirmed) {
                Swal.fire(
                  '新增成功',
                  '優惠券以新增!',
                  'success',
                  location.href ="coupon_restaurant.html"
                )
              }
            })
        }
      })
    };
  fileReader.readAsBinaryString(news_file.files[0]);
  }
}

function Template({couponStartTime, couponEndTime, couponContent,restaurantNo, usageLimitation, amountOrFold,couponType,couponName,maxIssueQty, issuedQty, couponPicStr}) {
  const picUrl = getPicUrl(couponPicStr);
  return `
  <h3>新增優惠券</h3>
  <div class="class__sidebar col-lg-6" style="width: 50%; height: 755px; margin: 0px auto; float: left">
    <form>
        <h3 class="restaurantNo">餐廳編號 : ${restaurantNo}</h3>
        <span>優惠券名稱 :<span id="error_Name" style="display:none; color: red; font-size: 15px;">請輸入優惠券名稱</span><input type="text"  placeholder="請輸入優惠券名稱" id="couponName"></span>
        <span>活動開始時間 : <span id="error_StartTime" style="display:none; color: red; font-size: 15px;">請選擇開始時間</span><input type="date"  placeholder="請輸入開始時間" id="couponStartTime"></span>
        <span>活動結束時間 : <span id="error_EndTime" style="display:none; color: red; font-size: 15px;">請選擇結束名稱</span><input type="date"  placeholder="請輸入結束時間" id="couponEndTime"></span>
        <span>訂單金額滿多少可以使用 : <span id="error_use" style="display:none; color: red; font-size: 15px;">請輸入金額</span><input type="text"  placeholder="請輸入金額" id="usageLimitation"></span>
        <span style="color: red">*</span><span>金額 / 折數 : <span id="error_type" style="display:none; color: red; font-size: 15px;">請輸入金額 or 折數</span><input type="text"  placeholder="請輸入 金額 or 折數" id="amountOrFold"></span>
        <label>折價<input type="radio" value="true" name="couponType" id="couponType" checked></label>
        <label>打折<input type="radio" value="false"  id="couponType" name="couponType"></label>  
      </form>
    </div>
    <div class="class__sidebar col-lg-6" style="width: 50%; height: 755px; margin: 0px auto; float: right">
      <form>
        <span>發行張數上限 : <span id="error_max" style="display:none; color: red; font-size: 15px;">請輸入上限張數</span><input type="text"  placeholder="請輸入上限數量" id="maxIssueQty"></span>
        <span>優惠券說明內容 : <span id="error_content" style="display:none; color: red; font-size: 15px;">請輸入優惠券說明</span><textarea id="couponContent" style="resize: none; width:450px ; height:121px" placeholder="請輸入優惠券內容說明"></textarea></span>
        <div class="wrapper">
          <div id="first">
              <p>現有圖片 :</p>
              <img class="updatePic" src="${picUrl}" onload="nullPic()">
          </div>
            <div id="second">
              <p>上傳優惠券圖片 :</p>
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

