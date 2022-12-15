// ==========餐廳資料變更審核===========

$(function () {
  $("#restaurant_info").validate({
    /* 常用檢測屬性
 required:必填
 noSpace:空白
 minlength:最小長度
 maxlength:最大長度
 email:信箱格式
 number:數字格式
 url:網址格式https://www.minwt.com
 */
    onkeyup: function (element, event) {
      //去除左側空白
      var value = this.elementValue(element).replace(/^\s+/g, "");
      $(element).val(value);
    },
    rules: {
      restaurantName: {
        required: true,
        noSpace: true,
      },
      restaurantTel: {
        required: true,
        minlength: 8,
        maxlength: 10,
        number: true,
      },
      restaurantAddr: {
        required: true,
      },
      restaurantBusinessHour: {
        required: true,
      },
      restaurantAccount: {
        required: true,
        email: true,
      },
      restaurantPassword: {
        required: true,
      },
      restaurantPasswordCheck: {
        required: true,
      },
    },
    messages: {
      restaurantName: {
        required: "必填",
      },
      restaurantTel: {
        required: "必填",
        minlength: "電話格式不正確",
        maxlength: "電話格式不正確",
        number: "電話號碼需為數字",
      },
      restaurantAddr: {
        required: "必填",
      },
      restaurantBusinessHour: {
        required: "必填",
      },
      restaurantAccount: {
        required: "必填",
        email: "Email格式不正確",
      },
      restaurantPassword: {
        required: "必填",
      },
      restaurantPasswordCheck: {
        required: "必填",
      },
    },
    submitHandler: function (form) {
      form.submit();
    },
  });
});

// ==========輪播圖設定===========

var drop_zone = document.getElementById("drop_zone");
var carousel_file_el = document.getElementById("carousel_file");

carousel.addEventListener("reset", function () {
  drop_zone.innerHTML = '<span class = "text">輪播圖片6張</span>';
  sessionStorage.clear();
});

var preview_img = function (file) {
  var reader = new FileReader();
  reader.readAsDataURL(file);
  reader.addEventListener("load", function () {
    let img_str = '<img src="' + reader.result + '" class="preview_img">';
    drop_zone.innerHTML = img_str;
  });
};

// 當file變化時
carousel_file_el.addEventListener("change", function (e) {
  // 判
  if (this.files.length <= 6) {
    preview_img(this.files[0]);
  } else {
    alert("最多選擇6張圖片，請重新選擇!");
    $("#carousel")[0].reset();
  }
});

drop_zone.addEventListener("dragover", function (e) {
  e.preventDefault();
  e.target.classList.add("-on");
});

drop_zone.addEventListener("dragleave", function (e) {
  e.target.classList.remove("-on");
});

drop_zone.addEventListener("drop", function (e) {
  e.preventDefault();
  e.target.classList.remove("-on");
  preview_img(e.dataTransfer.files[0]);
  carousel_file_el.value = "";
});

// ==========菜單圖設定===========

var drop_zone2 = document.getElementById("drop_zone2");
var menu_file_el = document.getElementById("menu_file");

menu.addEventListener("reset", function () {
  drop_zone2.innerHTML = '<span class = "text">菜單圖片</span>';
  sessionStorage.clear();
});

var preview_img2 = function (file) {
  var reader = new FileReader();
  reader.readAsDataURL(file);
  reader.addEventListener("load", function () {
    let img_str = '<img src="' + reader.result + '" class="preview_img2">';
    drop_zone2.innerHTML = img_str;
  });
};

menu_file_el.addEventListener("change", function (e) {
  if (this.files.length > 0) {
    preview_img2(this.files[0]);
  } else {
    drop_zone2.innerHTML = '<span class = "text">菜單圖</span>';
  }
});

drop_zone2.addEventListener("dragover", function (e) {
  e.preventDefault();
  e.target.classList.add("-on");
});

drop_zone2.addEventListener("dragleave", function (e) {
  e.target.classList.remove("-on");
});

drop_zone2.addEventListener("drop", function (e) {
  e.preventDefault();
  e.target.classList.remove("-on");
  preview_img2(e.dataTransfer.files[0]);
  menu_file_el.value = "";
});

// ==========貼文圖設定===========

var drop_zone3 = document.getElementById("drop_zone3");
var news_file_el = document.getElementById("news_file");

news.addEventListener("reset", function () {
  drop_zone3.innerHTML = '<span class = "text">貼文圖片</span>';
  sessionStorage.clear();
});

var preview_img3 = function (file) {
  var reader = new FileReader();
  reader.readAsDataURL(file);
  reader.addEventListener("load", function () {
    let img_str = '<img src="' + reader.result + '" class="preview_img3">';
    drop_zone3.innerHTML = img_str;
  });
};

news_file_el.addEventListener("change", function (e) {
  if (this.files.length > 0) {
    preview_img3(this.files[0]);
  } else {
    drop_zone3.innerHTML = '<span class = "text">菜單圖</span>';
  }
});

drop_zone3.addEventListener("dragover", function (e) {
  e.preventDefault();
  e.target.classList.add("-on");
});

drop_zone3.addEventListener("dragleave", function (e) {
  e.target.classList.remove("-on");
});

drop_zone3.addEventListener("drop", function (e) {
  e.preventDefault();
  e.target.classList.remove("-on");
  preview_img3(e.dataTransfer.files[0]);
  news_file_el.value = "";
});

// ===================餐廳資料頁籤=================

$(document).ready(function () {
  tabCutover();
});

function tabCutover() {
  $(".tab_title li.active").each(function () {
    var tablink = $(this).find("a").data("tablink");

    $("#" + tablink)
      .show()
      .siblings(".tab_inner")
      .hide();
  });

  $(".tab_title li").click(function () {
    $("#" + $(this).find("a").data("tablink"))
      .show()
      .siblings(".tab_inner")
      .hide();
    $(this).addClass("active").siblings(".active").removeClass("active");
  });
}

// ===================輪播圖片上傳=================

// ===================尚未成功 還在研究中T_T=================

let base64arr = [];
let pic_remark = document.querySelector("pic_remark");

function readFiles(files) {
  console.log("testtttttt");
  for (let file of files) {
    const read = new FileReader();
    read.readAsDataURL(file);
    read.onloadend = function (e) {
      base64arr.push(e.target.result.slice(23));
      if (files.length === base64arr.length) {
        const data = JSON.stringify(base64arr);
        fetch("http://localhost:8080/restaurant-uploadMultiplePics", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: data,
        });
        // .then((r) => r.json())
        // .then((data) => {
        //   console.log(data);
        // });
      }
    };
  }
}

$("#carousel").on("submit", function (e) {
  e.preventDefault();
  let files = document.querySelectorAll("#carousel_file")[0].files;
  readFiles(files);
});
