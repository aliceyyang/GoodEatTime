      var drop_el = document.getElementById("drop_zone");
      var preview_el = document.getElementById("preview");
      var carousel_file_el = document.getElementById("carousel_file");
      
// ==========輪播圖設定===========
      carousel.addEventListener("reset", function () {
       
        preview_el.innerHTML = '<span class = "text">預覽圖</span>';
        
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

      carousel_file_el.addEventListener("change", function (e) {
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
        carousel_file_el.value = "";
      });

      $("input#carousel_file").change(function(){
        if($(this)[0].files.length > 6){
          alert("最多選擇6張圖片，請重新選擇!");
        }
      })

      // ==========菜單圖設定===========

      var drop_el2 = document.getElementById("drop_zone2");
      var preview_el2 = document.getElementById("preview2");
      var menu_file_el = document.getElementById("menu_file");

      menu.addEventListener("reset", function () {
       
        preview_el2.innerHTML = '<span class = "text">預覽圖</span>';
        
        sessionStorage.clear();
      });

      var preview_img2 = function (file) {
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.addEventListener("load", function () {
          let img_str = '<img src="' + reader.result + '" class="preview_img2">';
          preview_el2.innerHTML = img_str;
        });
      };

      menu_file_el.addEventListener("change", function (e) {
        if (this.files.length > 0) {
          preview_img2(this.files[0]);
        } else {
          preview_el2.innerHTML = '<span class = "text">預覽圖</span>';
        }
      });

      drop_el2.addEventListener("dragover", function (e) {
        e.preventDefault();
        e.target.classList.add("-on");
      });

      drop_el2.addEventListener("dragleave", function (e) {
        e.target.classList.remove("-on");
      });

      drop_el2.addEventListener("drop", function (e) {
        e.preventDefault();
        e.target.classList.remove("-on");
        preview_img2(e.dataTransfer.files[0]);
        menu_file_el.value = "";
      });

      
      