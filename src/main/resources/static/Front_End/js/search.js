// 載入頁面時先去跟後端拿資料
var searchText = sessionStorage.getItem("searchText");
var restaurantNo,
  carouselPicStr,
  restaurantTel,
  restaurantBusinessHour,
  restaurantAddr,
  restaurantCommentQuantity,
  totalCommentRating,
  Allrestauant,
  carouselUrl,
  restaurant;
$.ajax({
  url: "/search_restaurant/search",
  type: "GET",
  data: { restaurantName: searchText },
  dataType: "json",
  success: function (data) {
    let timerInterval
Swal.fire({
  title: '搜尋中.....',
  html: '剩餘搜尋時間 <b></b> 秒.',
  timer: 1000,
  timerProgressBar: true,
  didOpen: () => {
    Swal.showLoading()
    const b = Swal.getHtmlContainer().querySelector('b')
    timerInterval = setInterval(() => {
      b.textContent = Swal.getTimerLeft()
    }, 100)
  },
  willClose: () => {
    clearInterval(timerInterval)
  }
}).then((result) => {
  /* Read more about handling dismissals below */
  if (result.dismiss === Swal.DismissReason.timer) {
    for (i = 0; i < data.length; i++) {
      restaurant = data[i];
      // console.log(restaurant);
      carouselPicStr = data[i].carouselPicStr;
      carouselUrl = getPicUrl(carouselPicStr);
      Allrestauant = data.length;
      restaurantNo = data[i].restaurantNo;
      // console.log(restaurantNo);
      restaurantName = data[i].restaurantName;
      restaurantTel = data[i].restaurantTel;
      restaurantBusinessHour = data[i].restaurantBusinessHour;
      restaurantAddr = data[i].restaurantAddr;
      restaurantCommentQuantity = data[i].restaurantCommentQuantity;
      totalCommentRating = data[i].totalCommentRating;

      //================有幾筆餐廳資料就顯示幾筆=================
      showResInfo();
      let restaurantPic = document.querySelectorAll("div.SearchRestaurant__author");
      let img = restaurantPic[i].querySelector("img");
      img.dataset.restaurantNo = restaurant.restaurantNo;
      console.log(img);
      if (data.length == i + 1) {
        break;
        }
    }
  }
})
    //==============一個一個的取的餐廳資訊==========
    
    // console.log(carouselUrl);
    // console.log(data);
  },
  error: function(a){
    console.log(a)
    Swal.fire({
      icon: 'error',
      title: '抱歉...',
      text: '找不到相關餐廳!',
    });
  },
  complete: function (data) {
    $("div.shop__last__text > p").text(`查詢結果共 ${Allrestauant ?? "0"} 筆`);
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
  } else {
    $(document).ready(function () {
      $('img[src="undefined"]').parent().remove();
    });
  }
}

function showResInfo() {
  let restaurant_html = `<div class="ResInfo col-lg-3 col-md-6 col-sm-2">
  <div class="SearchRestaurant__item" >
    <div class="SearchRestaurant__author">
      <img src="${carouselUrl}" onclick="restaurantPage(event)" >
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
  </div>`;
$("section.restaurant > div.container > #restaurant_area.row").append(
restaurant_html
);
}


$(".searchbtn").on("click",()=>{
  let timerInterval
Swal.fire({
  title: '搜尋中......',
  html: '剩餘搜尋時間 <b></b> 秒.',
  timer: 1000,
  timerProgressBar: true,
  didOpen: () => {
    Swal.showLoading()
    const b = Swal.getHtmlContainer().querySelector('b')
    timerInterval = setInterval(() => {
      b.textContent = Swal.getTimerLeft()
    }, 100)
  },
  willClose: () => {
    clearInterval(timerInterval)
  }
}).then((result) => {
  /* Read more about handling dismissals below */
  if (result.dismiss === Swal.DismissReason.timer) {
    console.log('I was closed by the timer')
    var searchText =  document.querySelector(".restaurantSearch").value;
    console.log(searchText);
  sessionStorage.setItem("searchText",searchText);
  $.ajax({
    url: "/search_restaurant/search",
    type: "GET", 
    dataType: "json",
    data: {restaurantName : searchText},
    success: function(data) {
      
      
       
      $("div#restaurant_area.row").remove();
      $("div.container").append('<div id="restaurant_area" class="row"></div>');
      for (i = 0; i < data.length; i++) {
        carouselPicStr = data[i].carouselPicStr;
        carouselUrl = getPicUrl(carouselPicStr);
        Allrestauant = data.length;
        restaurantNo = data[i].restaurantNo;
        console.log(restaurantNo);
        restaurantName = data[i].restaurantName;
        restaurantTel = data[i].restaurantTel;
        restaurantBusinessHour = data[i].restaurantBusinessHour;
        restaurantAddr = data[i].restaurantAddr;
        restaurantCommentQuantity = data[i].restaurantCommentQuantity;
        totalCommentRating = data[i].totalCommentRating;
  
        //================有幾筆餐廳資料就顯示幾筆=================
        showResInfo();
        let restaurantPic = document.querySelectorAll("div.SearchRestaurant__author");
      let img = restaurantPic[i].querySelector("img");
      img.dataset.restaurantNo = restaurantNo;
      console.log(img);
        if (data.length == i + 1) {
          break;
          }
      }
    },
    error: function () {
      Swal.fire({
        icon: 'error',
        title: '抱歉...',
        text: '抱歉找不到相關餐廳!',
        footer: '<a href="">Why do I have this issue?</a>'
      })
    },
    complete: function (data) {
      $("div.shop__last__text > p").text(`查詢結果共 ${Allrestauant} 筆`);
    },
  })
  }
})
})
//==================顯示所有餐廳按鈕==================
$(".allRES").on("click", ()=>{
  let timerInterval
Swal.fire({
  title: '搜尋中.....',
  html: '剩餘搜尋時間 <b></b> 秒.',
  timer: 1000,
  timerProgressBar: true,
  didOpen: () => {
    Swal.showLoading()
    const b = Swal.getHtmlContainer().querySelector('b')
    timerInterval = setInterval(() => {
      b.textContent = Swal.getTimerLeft()
    }, 100)
  },
  willClose: () => {
    clearInterval(timerInterval)
  }
}).then((result) => {
  /* Read more about handling dismissals below */
  if (result.dismiss === Swal.DismissReason.timer) {
    console.log('I was closed by the timer')
    var allRES = document.querySelector(".allRES").value;
  // console.log(allRES);
  sessionStorage.setItem("searchText",allRES);
  $.ajax({
    url: "/search_restaurant/getAll",
    type: "GET", 
    data: {restaurantName : allRES},
    dataType: "json",
    success: function(data) {
      console.log(data);
      document.querySelector("input.restaurantSearch").value ='';
      $("div#restaurant_area.row").remove();
      $("div.container").append('<div id="restaurant_area" class="row"></div>');
      for (i = 0; i < data.length; i++) {
        carouselPicStr = data[i].carouselPicStr;
        carouselUrl = getPicUrl(carouselPicStr);
        Allrestauant = data.length;
        restaurantNo = data[i].restaurantNo;
        console.log(restaurantNo);
        restaurantName = data[i].restaurantName;
        restaurantTel = data[i].restaurantTel;
        restaurantBusinessHour = data[i].restaurantBusinessHour;
        restaurantAddr = data[i].restaurantAddr;
        restaurantCommentQuantity = data[i].restaurantCommentQuantity;
        totalCommentRating = data[i].totalCommentRating;
  
        //================有幾筆餐廳資料就顯示幾筆=================
        showResInfo();
        let restaurantPic = document.querySelectorAll("div.SearchRestaurant__author");
      let img = restaurantPic[i].querySelector("img");
      img.dataset.restaurantNo = restaurantNo;
      console.log(img);
        if (data.length == i + 1) {
          break;
          }
      }
    },
    complete: function (data) {
      $("div.shop__last__text > p").text(`查詢結果共 ${Allrestauant} 筆`);
    },
  })
  }
})
});

function restaurantPage(e) {
  var restaurantNo = parseInt(e.target.dataset.restaurantNo);
  // console.log(e.target);
  // alert(restaurantNo);
  sessionStorage.setItem("restaurantNo",restaurantNo);
  location.href ="restaurant.html"
}

  
