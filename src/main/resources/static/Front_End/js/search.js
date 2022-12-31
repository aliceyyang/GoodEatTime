// 載入頁面時先去跟後端拿資料
var searchText = sessionStorage.getItem("searchText");
var restaurantNo, carouselPicStr, restaurantTel, restaurantBusinessHour, restaurantAddr, 
    restaurantCommentQuantity, totalCommentRating, Allrestauant, carouselUrl;
$.ajax({
  url: "/search_restaurant/search",
  type: "GET",
  data: {restaurantName : searchText},
  dataType: "json",
  success: function (data) {
//==============一個一個的取的餐廳資訊==========
for(i = 0; i < data.length; i++) {
  carouselUrl = getPicUrl(carouselPicStr); 
  Allrestauant = data.length;
  restaurantNo = data[i].restaurantNo;
  carouselPicStr = data[i].carouselPicStr;
  console.log(carouselPicStr);
  restaurantName = data[i].restaurantName;
  restaurantTel = data[i].restaurantTel;
  restaurantBusinessHour = data[i].restaurantBusinessHour;
  restaurantAddr = data[i].restaurantAddr;
  restaurantCommentQuantity = data[i].restaurantCommentQuantity;
  totalCommentRating = data[i].totalCommentRating;
      
//================有幾筆餐廳資料就顯示幾筆=================
let restaurant_html = `<div class="col-lg-3 col-md-6 col-sm-2">
                          <div class="SearchRestaurant__item">
                            <div class="SearchRestaurant__author">
                              <img src="${carouselUrl + 1}" alt="">
                              <div class="rating">
                                <span>評分 :</span>
                                  <span class="icon_star"></span>
                                  <span class="icon_star"></span>
                                  <span class="icon_star"></span>
                                  <span class="icon_star"></span>
                                  <span class="icon_star-half_alt"></span>
                                </div>
                            <div class="SearchRestaurant__author__pic">
                            </div>
                            <div class="SearchRestaurant__author__text">
                              <h5>${restaurantName}</h5>
                              <span>${restaurantAddr}</span>
                              <p>${restaurantBusinessHour}</p>
                            </div>
                            </div>
                              </div>
                            </div>
                          </div>`
$("section.restaurant > div.container > #restaurant_area.row").append(restaurant_html);
  if (data.length == i + 1) {
    break;
  };
};
    // console.log(carouselUrl);
    console.log(data);
  },
  complete: function (data) {
    $("div.shop__last__text > p").text(`查詢結果共 ${Allrestauant} 筆`);

    // console.log(prodList)
  },
});
//================顯圖片===================
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