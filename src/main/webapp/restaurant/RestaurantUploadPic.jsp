<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>餐廳圖片上傳</title>

<style>
      #drop_zone {
        border: 1px dashed #ccc;
        height: 50px;
        position: relative;
      }
      #drop_zone span.text {
        position: absolute;
        display: inline-block;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        z-index: -1;
        color: lightgray;
      }
      #drop_zone.-on {
        border: 1px dashed lightblue;
        box-shadow: 3px 3px 5px lightblue inset, -3px -3px 5px lightblue inset;
      }

      input[disabled] {
        background-color: #eee;
        cursor: not-allowed;
      }

      #preview {
        border: 1px solid lightgray;
        display: inline-block;
        width: 100px;
        min-height: 150px;
        position: relative;
      }
      #preview span.text {
        position: absolute;
        display: inline-block;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        z-index: -1;
        color: lightgray;
      }
      #preview img.preview_img {
        width: 100%;
      }
    </style>
</head>
<body>
	<form action="restaurant/UploadPic" method="post" enctype="multipart/form-data" items="pic" id="the_form">
      <div>
        <label>商品圖片:</label>
        <input type="file" id="p_file" accept="image/*" />
      </div>
      <div id="drop_zone"><span class="text">圖片拖曳至此處</span></div>
      <br />
      <div id="preview"><span class="text">預覽圖</span></div>
      <br />
      <label>圖片說明:</label>
      <input type="text" />
      <br />
      <button type="reset">清空資料</button>
      <button type="submit" id="btn_submit">送出資料</button>
      <br />
      <br />
    </form>
    
        <script>
      var p_count_el = document.getElementById("p_count");
      var p_name_el = document.getElementById("p_name");
      var show_count = document.getElementById("show_count");
      var my_form = document.getElementById("the_form");
      var drop_el = document.getElementById("drop_zone");
      var preview_el = document.getElementById("preview");
      var p_file_el = document.getElementById("p_file");
      var btn_submit_el = document.getElementById("btn_submit");

      function reset_p_count_value() {
        show_count.innerHTML = p_count_el.value;
      }

      p_count_el.addEventListener("mousemove", function () {
        reset_p_count_value();
      });

      my_form.addEventListener("reset", function () {
        show_count.innerHTML = 1;
        preview_el.innerHTML = '<span class = "text">預覽圖</span>';
        getLocation();
        sessionStorage.clear();
      });

      var preview_img = function (file) {
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.addEventListener("load", function () {
          let img_str = '<img src="' + reader.result + '" class="preview_img">';
          preview_el.innerHTML = img_str;
        });
      };

      p_file_el.addEventListener("change", function (e) {
        if (this.files.length > 0) {
          preview_img(this.files[0]);
        } else {
          preview_el.innerHTML = '<span class = "text">預覽圖</span>';
        }
      });

      drop_el.addEventListener("dragover", function (e) {
        e.preventDefault();
        e.target.classList.add("-on");
      });

      drop_el.addEventListener("dragleave", function (e) {
        e.target.classList.remove("-on");
      });

      drop_el.addEventListener("drop", function (e) {
        e.preventDefault();
        e.target.classList.remove("-on");

        preview_img(e.dataTransfer.files[0]);
        p_file_el.value = "";
      });

      btn_submit_el.addEventListener("click", function (e) {
        e.preventDefault();

        var send_data = {};
        send_data.p_name = p_name_el.value;
        send_data.p_count = p_count_el.value;

        var img_base64_el = document.querySelector(".preview_img");
        if (img_base64_el) {
          send_data.img_base64 = img_base64_el.src;
        }

        sessionStorage.setItem("form_data", JSON.stringify(send_data));
      });

      function recovery_data() {
        if (sessionStorage.getItem("form_data") != null) {
          var form_data = JSON.parse(sessionStorage.getItem("form_data"));
          p_name_el.value = form_data.p_name;
          p_count_el.value = form_data.p_count;
          show_count.innerHTML = form_data.p_count;
          lng_el.value = form_data.position.lng;
          lat_el.value = form_data.position.lat;
          preview_el.innerHTML =
            "<img class='preview_img' src='" + form_data.img_base64 + "'>";
        }
      }

      recovery_data();
    </script>

</body>
</html>