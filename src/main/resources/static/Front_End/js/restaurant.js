// ======================執行Google Map API 同時抓出餐廳的資料=======================

var restaurantNumber; //本餐廳編號
// google map
function initMap() {
  var restaurantAddress; //本餐廳地址
  fetch("http://localhost:8080/restaurant-read/3") //餐廳編號先寫死測試。因為fetch默認GET請求，所以不用特別輸入method:GET
    .then((res) => res.json())
    .then((data) => {
      //輸入需要的屬性取出資料庫中的值
      const { restaurantNo } = data;
      const { restaurantName } = data;
      const { restaurantTel } = data;
      const { restaurantAddr } = data;
      const { restaurantBusinessHour } = data;

      restaurantNumber = restaurantNo;
      restaurantAddress = restaurantAddr;
      document.getElementById("restaurantName").innerHTML = restaurantName;
      document.getElementById("restaurantTel").innerHTML += restaurantTel;
      document.getElementById("restaurantAddr").innerHTML += restaurantAddr;
      document.getElementById("restaurantBusinessHour").innerHTML +=
        restaurantBusinessHour;
      document.getElementById("comment_restaurantName").innerHTML =
        restaurantName;

      geocoder = new google.maps.Geocoder();
      var myLatLng = new google.maps.LatLng(25.04, 121.512);
      var mapOptions = {
        center: myLatLng,
        zoom: 16,
      };
      map = new google.maps.Map(document.getElementById("map"), mapOptions);
      codeAddress(restaurantAddress);
    });
}
function codeAddress(address) {
  geocoder.geocode({ address: address }, function (results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      map.setCenter(results[0].geometry.location); //center the map over the result
      //place a marker at the location
      var marker = new google.maps.Marker({
        map: map,
        position: results[0].geometry.location,
      });
    } else {
      alert("Geocode was not successful for the following reason: " + status);
    }
  });
}

// =======================抓出餐廳已上傳的輪播圖片======================

fetch("http://localhost:8080/restaurant-readInfo/CarouselPic/3") //餐廳編號先寫死測試。因為fetch默認GET請求，所以不用特別輸入method:GET
  .then((res) => res.json())
  .then((list) => {
    const picStr = []; //取得輪播圖list裡的每個base64字串，裝進陣列裡
    for (const base64 of list) {
      const { carouselPicStr } = base64;
      picStr.push("data:image/*;base64," + carouselPicStr);
    }

    const items = document.querySelectorAll("div.item"); //抓到所有顯示圖片的div標籤
    for (var i = 0; i < items.length; i++) {
      //如果圖片不夠裝所有div標籤，就隨機取圖裝滿div標籤
      if (i >= picStr.length) {
        const random_pic = Math.floor(Math.random() * picStr.length); //隨機取得一個圖(base64)的索引值
        items[i].querySelector("img").src = picStr[random_pic];
      }
      //不然就正常裝滿
      else {
        items[i].querySelector("img").src = picStr[i];
      }
    }

    $(".owl-carousel").owlCarousel({
      autoplay: true,
      loop: true,
      margin: 5,
      nav: true,

      responsive: {
        0: {
          items: 1,
        },
        600: {
          items: 2,
        },
        1000: {
          items: 3,
        },
      },
    });
  });

// ======================抓出餐廳已上傳的貼文======================

fetch("http://localhost:8080/restaurant-readInfo/Post/3")
  .then((res) => res.json())
  .then((list) => {
    var post_uploaded = document.querySelector(".col-lg-8"); //準備裝已上傳貼文的div
    var post_array = []; //準備裝多個貼文物件的陣列
    for (const item of list) {
      //多個貼文的陣列,一個個取出資料
      const { postType } = item;
      const { postPicStr } = item;
      const { postTitle } = item;
      const { postContent } = item;

      const firstTwoLines = postContent.split("<br>", 2).join("<br>");
      const fullPost = postContent.split("<br>").slice(2).join("<br>");

      const base64 = "data:image/*;base64," + postPicStr;

      const newDiv = document.createElement("div");
      newDiv.innerHTML = `<div class="blog__item">
      <div class="blog__item__pic set-bg" style="margin-bottom:100px">
      <img src="${base64}"/>
        <div class="blog__pic__inner"  style="position: relative">
          <div class="label">${postType}</div>
        </div>
      </div>
      <div class="blog__item__text" style="position: relative ; padding-top:50px">
        <h2>${postTitle}</h2>
        <p style="margin:0 0 5px 0">
          ${firstTwoLines}
        </p>
        <div class="inner_block">
        ${fullPost}
        </div>
        <br>
        <a class="readmore" type="button">READ MORE</a>
      </div>
    </div>`;
      post_uploaded.appendChild(newDiv);
    }
  });

//=========================點選收藏餐廳=================================

//找到該會員的所有收藏餐廳
fetch("http://localhost:8080/LikedRestaurant-list/1") //會員編號先寫死
  .then((res) => res.json())
  .then((list) => {
    for (const item of list) {
      const { restaurantNo } = item;
      //如果有符合本餐廳編號的，就顯示已收藏
      if (restaurantNo == restaurantNumber) {
        $("#liked").html("已收藏");
        $("#liked").addClass("liked");
      }
    }
  });

$("#liked").on("click", function () {
  if ($(this).hasClass("liked")) {
    fetch("http://localhost:8080/LikedRestaurant-delete", {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        memberNo: 1, //先寫死測試
        restaurantNo: restaurantNumber, //本餐廳編號
      }),
    }).then(function () {
      $("#liked").removeClass("liked");
      $("#liked").trigger("classChange");
      alert("已取消收藏!");
    });
  } else {
    fetch("http://localhost:8080/LikedRestaurant-add", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        memberNo: 1, //先寫死測試
        restaurantNo: restaurantNumber, //本餐廳編號
      }),
    }).then(function () {
      $("#liked").addClass("liked");
      $("#liked").trigger("classChange");
      alert("收藏成功!");
    });
  }
});

$("#liked").on("classChange", function (e) {
  if ($(this).hasClass("liked")) {
    $(this).html("已收藏");
  } else {
    $(this).html("收藏餐廳");
  }
});

//=============================================================

$(".breadcrumb__links a").bind("click", function () {
  var id = $(this).attr("data-id");

  var target_top = $("#area" + id).offset().top;

  var $body = window.opera
    ? document.compatMode == "CSS1Compat"
      ? $("html")
      : $("body")
    : $("html,body");

  $body.animate(
    {
      scrollTop: target_top,
    },
    800
  );
});

$(document).on("click", ".readmore", function (e) {
  e.preventDefault();
  if ($(this).hasClass("-on")) {
    $(this).removeClass("-on");
    $(this).text("READ MORE");
    $(this).siblings().removeClass("-on");
  } else {
    $(this).toggleClass("-on");
    $(this).text("CLOSE");
    $(this).siblings().toggleClass("-on");
  }
});

$("div.coupon").on("mouseenter", function (e) {
  $(this).toggleClass("-on");
});
$("div.coupon").on("mouseleave", function (e) {
  $(this).removeClass("-on");
});
