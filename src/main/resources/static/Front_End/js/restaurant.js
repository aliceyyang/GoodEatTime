// ======================執行Google Map API 同時抓出餐廳的資料=======================

// google map
function initMap() {
  var restaurantNumber; //本餐廳編號
  fetch("http://localhost:8080/restaurant-page/3") //餐廳編號先寫死測試。因為fetch默認GET請求，所以不用特別輸入method:GET
    .then((res) => res.json())
    .then((data) => {
      //輸入需要的屬性取出資料庫中的值
      const { restaurantNo } = data;
      const { restaurantName } = data;
      const { restaurantTel } = data;
      const { restaurantAddr } = data;
      const { restaurantBusinessHour } = data;
      sessionStorage.setItem("restaurantNo", restaurantNo);
      sessionStorage.setItem("restaurantName", restaurantName);

      restaurantNumber = restaurantNo;
      document.getElementById("restaurantName").innerHTML = restaurantName;
      document.getElementById("restaurantTel").innerHTML += restaurantTel;
      document.getElementById("restaurantAddr").innerHTML += restaurantAddr;
      document.getElementById("restaurantBusinessHour").innerHTML +=
        restaurantBusinessHour;
      document.getElementById("comment_restaurantName").innerHTML =
        restaurantName;

      //================Google Map API==============
      geocoder = new google.maps.Geocoder();
      var myLatLng = new google.maps.LatLng(25.04, 121.512);
      var mapOptions = {
        center: myLatLng,
        zoom: 16,
      };
      map = new google.maps.Map(document.getElementById("map"), mapOptions);
      codeAddress(restaurantAddr);
    });

  //=========================點選收藏餐廳=================================
  //找到該會員的所有收藏餐廳
  fetch("http://localhost:8080/LikedRestaurant-list/0") //會員編號先寫死
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
          memberNo: 0,
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
        redirect: "follow",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          memberNo: 0,
          restaurantNo: restaurantNumber, //本餐廳編號
        }),
      }).then((res) => {
        console.log("是否重導向" + res.redirected);
        var redirect_URL = res.url;
        if (res.redirected) {
          alert("請先登入會員");
          // swal({
          //   title: "",
          //   text: "請先登入",
          //   icon: "warning",
          //   button: "OK",
          //   timer: 1000,
          // })
          setTimeout(function () {
            sessionStorage.setItem(
              "res_login",
              window.location.assign(redirect_URL)
            );
          }, 1000);
        } else {
          $("#liked").addClass("liked");
          $("#liked").trigger("classChange");
          alert("收藏成功!");
        }
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
}
//================Google Map API==============
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

// ======================抓出餐廳已上傳的菜單======================

fetch("/restaurant-readInfo/Menu/3")
  .then((res) => res.json())
  .then((list) => {
    const menu_list = document.querySelector("#menu_list"); //準備裝已上傳菜單的div
    for (const item of list) {
      const { menuPicstr } = item;
      const { menuPicRemark } = item;

      const newDiv = document.createElement("div");
      newDiv.innerHTML = `<div class="menu">
      <img class="menu_pic" src="data:image/*;base64,${menuPicstr}" />
      <h4 class="menu_remark">${menuPicRemark}</h4>
      </div>`;

      menu_list.appendChild(newDiv);
    }
  });

//===============================餐廳評價===================================

fetch("/restaurant-comment/3")
  .then((resp) => resp.json())
  .then((list) => {
    $("#comment_sum").html(`共${list.length}則評論`);
    var comment_avg = 0;
    for (let obj of list) {
      const { commentRating } = obj;
      comment_avg += commentRating; //加總所有評分
    }

    comment_avg = Math.round((comment_avg / list.length) * 10) / 10;
    $("#comment_avg").html(comment_avg); //平均分數

    let restaurantStars = "";

    //餐廳平均分數 算出整數部分要有幾顆星星
    for (var i = 1; i <= Math.trunc(comment_avg); i++) {
      restaurantStars += '<i class="fa-solid fa-star" color="orange"></i>';
    }

    //餐廳平均分數 算出小數點大於0.5 就顯示半顆星星
    if (comment_avg - Math.trunc(comment_avg) >= 0.5) {
      restaurantStars += '<i class="fa-solid fa-star-half" color="orange"></i>';
    }

    $("#restaurant_stars").html(restaurantStars);

    const { name } = list[0];
    const { commentRating } = list[0];
    const { commentContent } = list[0];

    $("#member_name").html(name);
    $("#comment_rating").html(commentRating);
    $("#comment_content").html(commentContent);

    let stars = "";
    //根據分數來新增等量的黃色星星
    for (var i = 1; i <= commentRating; i++) {
      stars += '<i class="fa-solid fa-star" color="orange"></i>';
    }
    //根據差多少星星來新增等量的灰色星星
    for (var i = 1; i <= 5 - commentRating; i++) {
      stars += '<i class="fa-solid fa-star" color="gray"></i>';
    }

    $("#rating_stars").html(stars);
  });

// ========================================================

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
