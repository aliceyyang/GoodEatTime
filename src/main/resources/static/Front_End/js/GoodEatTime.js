const showcouponPic = document.querySelectorAll("div.coupon__item__icon");
$.ajax({
  url: "../coupon/Manage",
  type: "POST",
  dataType: "json",
  success: function (list) {
    for (let index = 0; index < showcouponPic.length; index++) {
      const coupon = list[index % 6];
      const base64toUrl = getPicUrl(coupon.couponPicStr);
      const img = showcouponPic[index].querySelector("img");
      img.src = base64toUrl;
      img.dataset.couponNo = coupon.couponNo;
    }
  }
});

// function showPic(list) {
//   for(let obj of list) {
//     const picUrl = getPicUrl(obj.couponPicStr);
//     for (i = 1; i < 7; i++) {
//       if (i < picUrl.length) {
//         showcouponPic[i].querySelector("img").src = picUrl;
//       }
//     }
//   }
// }

// function showPic(list) {
//   let result = '';
//   for (let obj of list) {
//     const picUrl = getPicUrl(obj.couponPicStr);
//     result += showcouponPic.src="${picUrl}"
//   }
//   return result;
// };


function getPicUrl(base64Str) {
    const binaryStr = atob(base64Str);
    let len = binaryStr.length;
    const uint8Array = new Uint8Array(len);
    while (len--) {
      uint8Array[len] = binaryStr.charCodeAt(len);
    }
    const blob = new Blob([uint8Array]);
    return URL.createObjectURL(blob);
  };
 