var tbcoupon_detail = document.querySelector("#tbcoupon_detail");
var tbcoupon_update = document.querySelector("#tbcoupon_update");
var tbcoupon_insert = document.querySelector("#tbcoupon_insert");
// $.ajax({
//   url: "../coupon/Manage",
//   type: "GET",
//   dataType: "json",
//   success: function (arr) {
//     const couponarr = arr;
//     // console.log(couponarr);
//     // 如果餐廳沒有優惠券的話會抓不到餐廳編號
//     sessionStorage.setItem("restaurantNo", arr[0].restaurantNo);
//     tbcoupon_detail.innerHTML = arr
//       .map((e) =>
//         Template(
//           e.couponNo,
//           e.couponApplyDate,
//           e.couponStartTime,
//           e.couponEndTime,
//           e.couponContent,
//           e.usageLimitation,
//           e.amountOrFold,
//           e.couponType,
//           e.couponName,
//           e.maxIssueQty,
//           e.issuedQty,
//           e.couponPicStr
//         )
//       )
//       .join("");
//   },
//   error: function (arr) {
//     console.log(arr);
//     tbcoupon_detail.innerHTML = arr
//       .map((e) =>
//         Template(
//           e.couponNo,
//           e.couponApplyDate,
//           e.couponStartTime,
//           e.couponEndTime,
//           e.couponContent,
//           e.usageLimitation,
//           e.amountOrFold,
//           e.couponType,
//           e.couponName,
//           e.maxIssueQty,
//           e.issuedQty,
//           e.couponPicStr
//         )
//       )
//       .join("");
//   },
// });

// function Template(
//   couponNo,
//   couponApplyDate,
//   couponStartTime,
//   couponEndTime,
//   couponContent,
//   usageLimitation,
//   amountOrFold,
//   couponType,
//   couponName,
//   maxIssueQty,
//   issuedQty,
//   couponPicStr
// ) {
//   return `<tr id="couponNo${couponNo}">
//   <td class="couponNo">${couponNo}</td>
//   <td class="couponName">${couponName}</td>
//   <td>${couponApplyDate}</td>
//   <td>${couponStartTime}</td>
//   <td>${couponEndTime}</td>
//   <td class="couponContent">${couponContent}</td>
//   <td>${usageLimitation}</td>
//   <td>${amountOrFold}</td>
//   <td>${couponType ? "折價" : "打折"}</td>
//   <td>${maxIssueQty}</td>
//   <td>${issuedQty}</td>
//   <td>
//   	<img src="${couponPicStr ? getPicUrl(couponPicStr) : ""}">
//   </td>
//   <td><button type="button" id="updatebtn" onclick="update(${couponNo})">修改</button></td>  
//   </tr> `;
// }


function update(couponNo) {
  sessionStorage.setItem("couponNo", couponNo);
  location.href = "coupon_RESupdate.html";
}
function insert() {
  location.href = "coupon_RESinsert.html";
}
//===========================搜尋功能================================

$(document).ready(function() {
  $("#coupon_detail").DataTable({
    ajax:"../coupon/Manage",
    type: "GET",
    dataType: "json",
    success: function (arr) {
          const couponarr = arr;
          console.log(couponarr);
          // 如果餐廳沒有優惠券的話會抓不到餐廳編號
          sessionStorage.setItem("restaurantNo", arr[0].restaurantNo);
          tbcoupon_detail.innerHTML = arr
                .map((e) =>
                  Template(
                    e.couponNo,
                    e.couponApplyDate,
                    e.couponStartTime,
                    e.couponEndTime,
                    e.couponContent,
                    e.usageLimitation,
                    e.amountOrFold,
                    e.couponType,
                    e.couponName,
                    e.maxIssueQty,
                    e.issuedQty,
                    e.couponPicStr
                  )
                )
                .join("");    
    },
    error: function (arr) {
          console.log(arr);
          tbcoupon_detail.innerHTML = arr
            .map((e) =>
              Template(
                e.couponNo,
                e.couponApplyDate,
                e.couponStartTime,
                e.couponEndTime,
                e.couponContent,
                e.usageLimitation,
                e.amountOrFold,
                e.couponType,
                e.couponName,
                e.maxIssueQty,
                e.issuedQty,
                e.couponPicStr
              )
            )
            .join("");
        },
    columns: [
      {
        data: "couponNo",
      },
      {
        data: "couponName"
      },
      {
        data: "couponApplyDate"
      },
      {
        data: "couponStartTime"
      },
      {
        data: "couponEndTime"
      },
      {
        data: "couponContent"
      },
      {
        data: "usageLimitation"
      },
      {
        data: "amountOrFold"
      },
      {
        data: "couponType"
      },
      {
        data: "maxIssueQty"
      },
      {
        data: "issuedQty"
      },
      {
        data: "couponPicStr",
        render: function(data, type, row) {
          var couponPicStr = data;
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
          return`<img src="${couponPicStr ? getPicUrl(couponPicStr) : ""}">`
        }
      },
      {
        targets:-1,
        data: "couponNo",
        render: function(data, type, row) {
          var couponNo = data;
          return`<button type="button" id="updatebtn" onclick="update(${couponNo})">修改</button>`
        },
      },
    ],
  });
});






















  /*=====================================]*/ 
  /** 先抓input
   *  if (input trim() == "") {
   *    all tr diplay = ""
   *    -> 先抓到tr -> for each迴圈-> 再去改dispaly
   *    return;
   *  } 
   */
  // inputtxt = document.getElementById("coupon_search").value;
  
  //   if (inputtxt.trim() == "") {
      
  //     tr = document.getElementsByTagName("tr");
      
  //     for (i = 0;  i < tr.length; i++) {
  //       tr[i].style.display = "";
  //     }
  //     return;
  //   }

  // var filter, result, input, filter, table, tr, td, txtValue;
  // input = document.getElementById("coupon_search");

  // filter = {
  //   couponNo: input.value.toUpperCase(),
  //   couponName: input.value.toUpperCase(),
  //   couponContent: input.value.toUpperCase(),
  // };
  
  // table = document.getElementById("coupon_detail");
  // tr = table.getElementsByTagName("tr");
  // var couponList = new Array();
  // for (i = 1; i < tr.length; i++) {

  //   console.log(tr[i].querySelector(".couponName").value);
  //   let coupon = {
  //     couponNo: tr[i].querySelector(".couponNo").innerText,
  //     couponName: tr[i].querySelector(".couponName").innerText,
  //     couponContent: tr[i].querySelector(".couponContent").innerText,
  //   };
  //   couponList[i] = coupon;
  // }
  // couponList.filter(function (item) {
  //   for (var key in filter) {
  //     if (item[key] == filter[key]) {
  //       console.log(item);
  //       document.querySelector(`#couponNo${item.couponNo}`).style.display = "";
  //       return true;
  //     }
  //   }
  //   document.querySelector(`#couponNo${item.couponNo}`).style.display = "none";
  //   return false;
  // });

  // const result = array.filter((data)=> {
  //   data.couponNo == value || data.couponName || data.couponContent
  // })

