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

var carousel_file_el = document.getElementById("carousel_file");

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

// ===================多張輪播圖片上傳=================

let base64arr = []; //裝多張圖用的base64陣列

function readFiles(files) {
  //檔案陣列傳進來
  for (let file of files) {
    //一個一個檔案處理
    const read = new FileReader();
    read.readAsDataURL(file); //讀取檔案轉成base64
    read.onloadend = function (e) {
      base64arr.push(e.target.result.slice(23)); //要截掉前面的data:image/png;base64, 才是圖像編碼
      if (files.length === base64arr.length) {
        //等陣列裝好所有選的圖檔後進來執行
        fetch("http://localhost:8080/restaurant-uploadMultiplePics/1", {
          //最後面是餐廳編號，我先寫死測試QAQ
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(base64arr),
        });
      }
    };
  }
}

$("#carousel").on("submit", function (e) {
  let files = document.querySelectorAll("#carousel_file")[0].files; //抓到要上傳的所有檔案，會是陣列
  readFiles(files);
});

// ===================拖曳區+預覽圖處理=================

var drop_zone = document.getElementById("drop_zone");

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

// ==========菜單 單張圖上傳設定===========

//把要存進物件的參數帶進來
function readFile(pic, pic_remark) {
  const read = new FileReader();
  read.readAsDataURL(pic); //讀取檔案轉成base64
  read.onloadend = function (e) {
    var base64 = e.target.result.slice(23); //要截掉前面的data:image/png;base64, 才是圖像編碼

    fetch("http://localhost:8080/restaurant-uploadMenu", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        restaurantNo: 3, //餐廳編號我先寫死測試T_T
        menuPicstr: base64, //VO那邊要先建一個String的屬性來裝base64的編碼，過去controller再轉byte陣列
        menuPicRemark: pic_remark,
      }),
    });
  };
}

//表單按下送出時
$("#menu").on("submit", function (e) {
  var pic = document.querySelector("#menu_file").files[0]; //抓到input標籤上傳的檔案
  var pic_remark = document.querySelector("#pic_remark").value; //抓到textarea輸入的文字
  readFile(pic, pic_remark); //帶進上方的readFile函式
});

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
