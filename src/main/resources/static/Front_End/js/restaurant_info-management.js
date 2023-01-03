// ======================抓出餐廳原本的資料顯示在表單=======================
let restaurantNo = 3; //先死預防打不開
if (sessionStorage.getItem("restaurantMemberVO") != null) {
  restaurantNo = JSON.parse(
    sessionStorage.getItem("restaurantMemberVO")
  ).restaurantNo;
}

fetch(`http://localhost:8080/restaurant-read/${restaurantNo}`, {
  method: "GET",
  redirect: "follow",
}).then((resp) => {
  if (resp.redirected) {
    Swal.fire({
      position: "center",
      icon: "warning",
      title: "請先登入",
      showConfirmButton: false,
      timer: 1000,
    }).then(() => {
      sessionStorage.setItem("URL_before_login", window.location.href);
      window.location.href = resp.url;
    });
  } else {
    resp.json().then((data) => {
      //輸入需要的屬性取出資料庫中的值
      const { restaurantNo } = data;
      const { restaurantName } = data;
      const { restaurantTel } = data;
      const { restaurantAddr } = data;
      const { restaurantBusinessHour } = data;
      const { restaurantTaxIDNo } = data;
      const { restaurantAccountInfo } = data;
      const { restaurantAccount } = data;
      const { restaurantPassword } = data;
      //把取出的值塞進表單的input標籤

      document.getElementById("restaurantName").value = restaurantName;
      document.getElementById("restaurantTel").value = restaurantTel;
      document.getElementById("restaurantAddr").value = restaurantAddr;
      document.getElementById("restaurantBusinessHour").value =
        restaurantBusinessHour;
      document.getElementById("restaurantTaxIDNo").value = restaurantTaxIDNo;
      document.getElementById("restaurantAccountInfo").value =
        restaurantAccountInfo;
      document.getElementById("restaurantAccount").value = restaurantAccount;
      document.getElementById("restaurantPassword").value = restaurantPassword;
    });
  }
});

// ========================看見密碼用的把啾=============================

$("#passwordEye").on("click", function () {
  if ($(this).hasClass("fa-eye-slash")) {
    $(this).attr("class", "fas fa-eye");
    $("#restaurantPassword").attr("type", "text");
    $("#restaurantPasswordCheck").attr("type", "text");
  } else {
    $(this).attr("class", "fas fa-eye-slash");
    $("#restaurantPassword").attr("type", "password");
    $("#restaurantPasswordCheck").attr("type", "password");
  }
});

// ==================餐廳資料變更驗證 使用jQuery Validation Plugin================

$(function () {
  $("#restaurant_info").validate({
    /* 常用檢測屬性
 required:必填
 minlength:最小長度
 maxlength:最大長度
 email:信箱格式
 number:數字格式
 equalTo:比對內容是否一致
 */
    onkeyup: function (element, event) {
      //去除左側空白
      var value = this.elementValue(element).replace(/^\s+/g, "");
      $(element).val(value);
    },
    rules: {
      restaurantName: {
        required: true,
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
        minlength: 6,
        maxlength: 15,
        required: true,
      },
      restaurantPasswordCheck: {
        required: true,
        equalTo: "#restaurantPassword",
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
        minlength: "密碼長度須介於6~15字元",
        maxlength: "密碼長度須介於6~15字元",
      },
      restaurantPasswordCheck: {
        required: "必填",
        equalTo: "密碼不一致",
      },
    },
    submitHandler: function (form) {
      //通過驗證後處理餐廳資料變更
      Swal.fire({
        position: "center",
        icon: "success",
        title: "儲存成功",
        showConfirmButton: false,
        timer: 1500,
      });
      setTimeout(function () {
        form.submit();
      }, 1500);
      const restaurantName = $("#restaurantName").val();
      const restaurantTel = $("#restaurantTel").val();
      const restaurantAddr = $("#restaurantAddr").val();
      const restaurantBusinessHour = $("#restaurantBusinessHour").val();
      const restaurantTaxIDNo = $("#restaurantTaxIDNo").val();
      const restaurantAccountInfo = $("#restaurantAccountInfo").val();
      const restaurantAccount = $("#restaurantAccount").val();
      const restaurantPassword = $("#restaurantPassword").val();

      fetch(`http://localhost:8080/restaurant-update/${restaurantNo}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          restaurantName: restaurantName,
          restaurantTel: restaurantTel,
          restaurantAddr: restaurantAddr,
          restaurantBusinessHour: restaurantBusinessHour,
          restaurantTaxIDNo: restaurantTaxIDNo,
          restaurantAccountInfo: restaurantAccountInfo,
          restaurantAccount: restaurantAccount,
          restaurantPassword: restaurantPassword,
        }),
      });
    },
  });
});

// =======================抓出餐廳已上傳的輪播圖片======================
var quota; //還可上傳的圖片額度
fetch(`http://localhost:8080/restaurant-readInfo/CarouselPic/${restaurantNo}`)
  .then((res) => res.json())
  .then((list) => {
    const carousel_uploaded = document.querySelector("#carousel_uploaded"); //準備裝已上傳圖片的div
    const carousel_quota = document.querySelector("#carousel_quota"); //放圖片額度文字的span
    quota = 6 - list.length;
    carousel_quota.innerHTML = `可再上傳${quota}張輪播圖片`;
    for (const item of list) {
      //多張輪播圖的陣列,一張一張取出圖片PK跟base64Str
      const { carouselPicNo } = item;
      const { carouselPicStr } = item;
      const newDiv = document.createElement("div");
      newDiv.innerHTML = `<div  id="cPic_${carouselPicNo}" class="uploaded_pic"><span class="delete_btn">✖</span><img src="data:image/*;base64,${carouselPicStr}"></div>`;
      carousel_uploaded.appendChild(newDiv);
    }
  });

// ===========================輪播圖點擊刪除=========================

let carouselPicNo;
$(document).on("click", ".uploaded_pic", function () {
  carouselPicNo = $(this).attr("id").substring(5); //id字串索引5開始就是圖片PK
  $(this).fadeOut(800, function () {
    $(this).remove();
    quota++;
    carousel_quota.innerHTML = `可再上傳${quota}張輪播圖片`;
  });
  fetch(
    `http://localhost:8080/restaurant-deleteInfo/CarouselPic/${carouselPicNo}`,
    {
      method: "DELETE",
    }
  );
});

// =========================輪播圖上傳限制六張==========================

var carousel_file_el = document.getElementById("carousel_file");

carousel_file_el.addEventListener("click", function (e) {
  if (quota == 0) {
    e.preventDefault();
    Swal.fire("輪播圖片最多共6張<br>請先刪除不要的圖片再重新選擇!");
    // alert("輪播圖片最多共6張，請先刪除不要的圖片再重新選擇!");
  }
});

// 當file變化時
carousel_file_el.addEventListener("change", function (e) {
  // 判
  if (this.files.length <= quota) {
    preview_img(this.files[0]);
  } else {
    alert("輪播圖片最多共6張，請先刪除不要的圖片再重新選擇!");
    $("#carousel")[0].reset();
  }
});

// ============================多張輪播圖片上傳===============================

let base64arr = []; //裝多張圖用的base64陣列

function readFiles(files) {
  //檔案陣列傳進來
  for (let file of files) {
    //一個一個檔案處理
    const read = new FileReader();
    read.readAsDataURL(file); //讀取檔案轉成base64
    read.onloadend = function (e) {
      base64arr.push(e.target.result.split(",")[1]); //要截掉前面的data:image/png;base64, 才是圖像編碼
      if (files.length === base64arr.length) {
        //等陣列裝好所有選的圖檔後進來執行
        fetch(
          `http://localhost:8080/restaurant-uploadMultiplePics/${restaurantNo}`,
          {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(base64arr),
          }
        );
      }
    };
  }
}

$("#carousel").on("submit", function (e) {
  let files = document.querySelectorAll("#carousel_file")[0].files; //抓到要上傳的所有檔案，會是陣列
  readFiles(files);
});

// ===========================拖曳區+預覽圖處理=========================

var drop_zone = document.getElementById("drop_zone");

carousel.addEventListener("reset", function () {
  carousel_quota.innerHTML = `可再上傳${quota}張輪播圖片`;
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

// ======================抓出餐廳已上傳的菜單======================

var menu_array = []; //準備裝多個菜單物件的陣列
fetch(`http://localhost:8080/restaurant-readInfo/Menu/${restaurantNo}`)
  .then((res) => res.json())
  .then((list) => {
    const menu_uploaded = document.querySelector("#menu_uploaded"); //準備裝已上傳菜單的div
    for (const item of list) {
      const { menuNo } = item;
      const { menuPicstr } = item;
      const { menuPicRemark } = item;

      menu_array.push({
        menuNo: menuNo,
        menuPicstr: menuPicstr,
        menuPicRemark: menuPicRemark,
      });

      const newDiv = document.createElement("div");
      newDiv.innerHTML = `<div id="mPic_${menuNo}" class="uploaded_menu">
      <img src="data:image/*;base64,${menuPicstr}" />
      <a class="delete_menu">刪除</a>
      <a class="edit_menu">編輯</a>
      </div>`;

      menu_uploaded.appendChild(newDiv);
    }
  });
// ===============================菜單編輯==========================

$(document).on("click", ".edit_menu", function () {
  $("#editing_menu").addClass("-on"); //顯示目前為編輯狀態
  document.getElementById("menu_file").removeAttribute("required"); //因為是在編輯狀態，圖片不一定會重選，故移除required屬性
  let id = $(this).closest("div").attr("id").substring(5); //抓到點擊的菜單的id，id字串索引5開始就是菜單PK
  let toBeEdited = menu_array.find((menu) => menu.menuNo == id); //用PK從菜單物件陣列中找到所點擊的菜單物件

  //將要編輯的菜單資料塞回表單中
  document.querySelector('input[name="menuNo"]').value = id; //將菜單PK先存在隱藏標籤中
  document.getElementById("pic_remark").value =
    toBeEdited.menuPicRemark.replace(/<br>/g, "\n");
  drop_zone2.innerHTML = `<img src="data:image/*;base64,${toBeEdited.menuPicstr}" id="uploaded_menuPic" class="preview_img2"> `;
});

//=====================更新菜單的函式==================

function editMenu(picStr, pic_remark) {
  //從隱藏標籤拿回此貼文的PK
  const menuNo = document.querySelector('input[name="menuNo"]').value;
  fetch("http://localhost:8080/restaurant-updateMenu", {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      menuNo: menuNo,
      menuPicstr: picStr,
      menuPicRemark: pic_remark,
    }),
  });
}

// =====================上傳新菜單(單張圖)的函式=============================

//把要存進物件的參數帶進來
function readFile(pic, pic_remark) {
  const read = new FileReader();
  read.readAsDataURL(pic); //讀取檔案轉成base64
  read.onloadend = function (e) {
    var base64 = e.target.result.split(",")[1]; //要截掉前面的data:image/png;base64, 才是圖像編碼

    fetch("http://localhost:8080/restaurant-uploadMenu", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        restaurantNo: restaurantNo,
        menuPicstr: base64, //VO那邊要先建一個String的屬性來裝base64的編碼，過去controller再轉byte陣列
        menuPicRemark: pic_remark,
      }),
    });
  };
}

// =========================菜單上傳 按下送出資料============================

$("#menu").on("submit", function (e) {
  var pic = document.querySelector("#menu_file").files[0]; //抓到input標籤上傳的檔案
  var picStr = document
    .querySelector("#uploaded_menuPic")
    .getAttribute("src")
    .split(",")[1]; //如果是編輯菜單，可能沒重選圖片，故從原圖的預覽圖拿出base64編碼
  var pic_remark = document
    .querySelector("#pic_remark")
    .value.replace(/\n/g, "<br>"); //抓到textarea輸入的文字

  //判斷是不是在編輯狀態，決定走哪個函式
  if ($("#editing_menu").hasClass("-on")) {
    editMenu(picStr, pic_remark); //帶進上方的editMenu函式
  } else {
    readFile(pic, pic_remark); //帶進上方的readFile函式
  }
});

// =========================刪除菜單============================

$(document).on("click", ".delete_menu", function () {
  const MenuNo = $(this).closest("div").attr("id").substring(5);

  $(this)
    .closest("div")
    .fadeOut(800, function () {
      $(this).remove();
    });
  fetch(`http://localhost:8080/restaurant-deleteInfo/Menu/${MenuNo}`, {
    method: "DELETE",
  });
});

// ============================拖曳區+預覽圖處理===========================

var drop_zone2 = document.getElementById("drop_zone2");
var menu_file_el = document.getElementById("menu_file");

menu.addEventListener("reset", function () {
  drop_zone2.innerHTML = '<span class = "text">菜單圖片</span>';
  $("#editing_menu").removeClass("-on");
  document.getElementById("menu_file").setAttribute("required", true);
  sessionStorage.clear();
});

var preview_img2 = function (file) {
  var reader = new FileReader();
  reader.readAsDataURL(file);
  reader.addEventListener("load", function () {
    let img_str =
      '<img src="' +
      reader.result +
      '" id="uploaded_menuPic" class="preview_img2">';
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

// ======================抓出餐廳已上傳的貼文======================

var post_array = []; //準備裝多個貼文物件的陣列
fetch(`http://localhost:8080/restaurant-readInfo/Post/${restaurantNo}`)
  .then((res) => res.json())
  .then((list) => {
    const post_uploaded = document.querySelector("#post_uploaded"); //準備裝已上傳貼文的div
    for (const item of list) {
      //多個貼文的陣列,一個個取出資料
      const { restaurantPostNo } = item;
      const { postType } = item;
      const { postPicStr } = item;
      const { postTitle } = item;
      const { postContent } = item;
      //存成貼文物件，push進準備好的陣列
      post_array.push({
        restaurantPostNo: restaurantPostNo,
        postType: postType,
        postPicStr: postPicStr,
        postTitle: postTitle,
        postContent: postContent,
      });

      const newDiv = document.createElement("div");
      newDiv.innerHTML = `<div id="pPic_${restaurantPostNo}" class="uploaded_restaurantPost">
      <span class="uploaded_postType">${postType}</span> | <span class="uploaded_postTitle">${postTitle.substring(
        0,
        9
      )}...</span>
      <a class="delete_post">刪除</a>
      <a class="edit_post">編輯</a>
    </div>`;
      post_uploaded.appendChild(newDiv);
    }
  });

// ===============================貼文編輯==========================

$(document).on("click", ".edit_post", function () {
  $("#editing").addClass("-on"); //顯示目前為編輯狀態
  document.getElementById("news_file").removeAttribute("required"); //因為是在編輯狀態，圖片不一定會重選，故移除required屬性
  let id = $(this).closest("div").attr("id").substring(5); //抓到點擊的貼文的id，id字串索引5開始就是貼文PK
  let toBeEdited = post_array.find((post) => post.restaurantPostNo == id); //用PK從貼文物件陣列中找到所點擊的貼文物件

  //將要編輯的貼文資料塞回表單中
  var select = document.getElementById("post_type");
  for (let i = 0; i < select.options.length; i++) {
    if (select.options[i].text == toBeEdited.postType) {
      select.options[i].selected = true;
    } else {
      select.options[i].selected = false;
    }
  }

  document.querySelector('input[name="restaurantPostNo"]').value = id; //將貼文PK先存在隱藏標籤中
  document.getElementById("title").value = toBeEdited.postTitle;
  document.getElementById("content").value = toBeEdited.postContent.replace(
    /<br>/g,
    "\n"
  );
  drop_zone3.innerHTML = `<img src="data:image/*;base64,${toBeEdited.postPicStr}" id="uploaded_pic" class="preview_img3"> `;
});

//=====================更新貼文的函式==================

function editPost(picStr, post_type, post_title, post_content) {
  //從隱藏標籤拿回此貼文的PK
  const restaurantPostNo = document.querySelector(
    'input[name="restaurantPostNo"]'
  ).value;
  fetch("http://localhost:8080/restaurant-updatePost", {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      restaurantPostNo: restaurantPostNo,
      postType: post_type,
      postPicStr: picStr,
      postTitle: post_title,
      postContent: post_content,
    }),
  });
}

//=====================上傳新貼文的函式==================

function readPostFile(pic, post_type, post_title, post_content) {
  const read = new FileReader();
  read.readAsDataURL(pic); //讀取檔案轉成base64
  read.onloadend = function (e) {
    var base64 = e.target.result.split(",")[1]; //要截掉前面的data:image/png;base64, 才是圖像編碼

    fetch("http://localhost:8080/restaurant-uploadPost", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        restaurantNo: restaurantNo,
        postType: post_type,
        postPicStr: base64, //VO那邊要先建一個String的屬性來裝base64的編碼，過去controller再轉byte陣列
        postTitle: post_title,
        postContent: post_content,
      }),
    });
  };
}

// =========================貼文上傳 按下送出資料============================

$("#news").on("submit", function (e) {
  var pic = document.querySelector("#news_file").files[0]; //抓到input標籤上傳的檔案
  var picStr = document
    .querySelector("#uploaded_pic")
    .getAttribute("src")
    .split(",")[1]; //如果是編輯貼文，可能沒重選圖片，故從原圖的預覽圖拿出base64編碼
  var select = document.getElementById("post_type");
  var post_type = select.options[select.selectedIndex].text; //抓到下拉選單被選的選項內容
  var post_title = document.querySelector("#title").value;
  var post_content = document
    .querySelector("#content")
    .value.replace(/\n/g, "<br>");

  //判斷是不是在編輯狀態，決定走哪個函式
  if ($("#editing").hasClass("-on")) {
    editPost(picStr, post_type, post_title, post_content); //帶進上方的editPost函式
  } else {
    readPostFile(pic, post_type, post_title, post_content); //帶進上方的readPostFile函式
  }
});

// =========================刪除貼文============================

$(document).on("click", ".delete_post", function () {
  const restaurantPostNo = $(this).closest("div").attr("id").substring(5);

  $(this)
    .closest("div")
    .fadeOut(800, function () {
      $(this).remove();
    });
  fetch(
    `http://localhost:8080/restaurant-deleteInfo/Post/${restaurantPostNo}`,
    {
      method: "DELETE",
    }
  );
});

// ============================拖曳區+預覽圖處理============================

var drop_zone3 = document.getElementById("drop_zone3");
var news_file_el = document.getElementById("news_file");

news.addEventListener("reset", function () {
  drop_zone3.innerHTML = '<span class = "text">貼文圖片</span>';
  $("#editing").removeClass("-on");
  document.getElementById("news_file").setAttribute("required", true);
  sessionStorage.clear();
});

var preview_img3 = function (file) {
  var reader = new FileReader();
  reader.readAsDataURL(file);
  reader.addEventListener("load", function () {
    let img_str =
      '<img src="' +
      reader.result +
      '" class="preview_img3" id="uploaded_pic">';
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
