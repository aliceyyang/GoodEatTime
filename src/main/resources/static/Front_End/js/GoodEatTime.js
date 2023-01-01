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

$(".btn").on("click", ()=>{
  const searchText = document.querySelector(".main_serch").value;
  // console.log(searchText)
  sessionStorage.setItem("searchText", searchText);
  location.href="/Front_End/Search.html";
})  


function getcoupon(e) {
  let couponNo = parseInt(e.target.dataset.couponNo);
  // alert(couponNo);
  $.ajax({
    url: "../coupon_member/getCoupon",
    type: "POST",
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify({
      "couponNo" : couponNo
    }),
    success: function (resp) {
      alert(resp.successful ? '成功' : '已使用');
    },
   })
}

$.ajax ({
  url: "../search_restaurant/newrestaurant",
  type: "GET",
  dataType: "json",
  success : function(data) {
    console.log(data);
  var restaurantName,
  restaurantAddr,
  restaurantBusinessHour,
  restauranPicStr,
  restaurantPic

$("div.testimonial__slider").remove();
$("#owl").append('<div class="testimonial__slider owl-carousel">');


for(i = 0; i < data.length; i++) {
  carouselPicStr = data[i].carouselPicStr;
  carouselPicUrl = getPicUrl(carouselPicStr);
  restaurantAddr = data[i].restaurantAddr;
  restaurantBusinessHour = data[i].restaurantBusinessHour;
  restaurantName = data[i].restaurantName;

  let newrestaurant_html = `<div class="col-lg-6">
  <div class="NewRestaurant__item">
      <div class="NewRestaurant__author">
          <div class="NewRestaurant__author__pic">
              <img src="${carouselPicUrl}" alt="">
          </div>
          <div class="NewRestaurant__author__text">
              <h5>${restaurantName}</h5>
              <span>${restaurantBusinessHour}</span>
          </div>
      </div>
      <div class="rating">
          <span class="icon_star"></span>
          <span class="icon_star"></span>
          <span class="icon_star"></span>
          <span class="icon_star"></span>
          <span class="icon_star-half_alt"></span>
      </div>
      <p>${restaurantAddr}</p>
  </div>
</div>`;

$("section.testimonial > div.container > div.row > div.testimonial__slider").append(newrestaurant_html);
}
showNewRestaurant();

  }
})
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
 
  function showNewRestaurant() {
    $(".testimonial__slider").owlCarousel({
      loop: true,
      margin: 0,
      items: 2,
      dots: true,
      smartSpeed: 1200,
      autoHeight: false,
      autoplay: true,
      responsive: {
          0: {
              items: 1
          },
          768: {
              items: 2
          }
          
      }
    });
  }