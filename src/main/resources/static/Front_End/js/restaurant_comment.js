// =====================五種星等百分比=========================
let restaurantNo = 3; //避免網址直接輸入restaurant_comment.html打不開，這邊先寫死
//照理來說應從餐廳頁面連過來，所以會有sessionStorage存的餐廳編號
if (sessionStorage.getItem("restaurantNo") != null) {
  restaurantNo = sessionStorage.getItem("restaurantNo");
}
let restaurantName = "餐廳名稱";
//照理來說應從餐廳頁面連過來，所以會有sessionStorage存的餐廳名稱
if (sessionStorage.getItem("restaurantName") != null) {
  restaurantName = sessionStorage.getItem("restaurantName");
}
document.getElementById("restaurantName").innerHTML = restaurantName;

fetch(`../restaurant-rating/${restaurantNo}`)
  .then((resp) => resp.json())
  .then((list) => {
    var sum = 0;
    var percentage = [];
    for (let value of list) {
      sum += value;
    }
    for (let value of list) {
      percentage.push(Math.round((100 / sum) * value));
    }

    var fill = document.querySelectorAll(".fill");
    for (let i = 0; i < fill.length; i++) {
      fill[i].setAttribute("data-percentage", percentage[i]);
    }

    // =====================此時才引入jquery.barfiller.js=========================

    (function ($) {
      $.fn.barfiller = function (options) {
        var defaults = $.extend(
          {
            barColor: "#16b597",
            tooltip: true,
            duration: 1000,
            animateOnResize: true,
            symbol: "%",
          },
          options
        );

        /******************************
          Private Variables
          *******************************/

        var object = $(this);
        var settings = $.extend(defaults, options);
        var barWidth = object.width();
        var fill = object.find(".fill");
        var toolTip = object.find(".tip");
        var fillPercentage = fill.attr("data-percentage");
        var resizeTimeout;
        var transitionSupport = false;
        var transitionPrefix;

        /******************************
          Public Methods
          *******************************/

        var methods = {
          init: function () {
            return this.each(function () {
              if (methods.getTransitionSupport()) {
                transitionSupport = true;
                transitionPrefix = methods.getTransitionPrefix();
              }

              methods.appendHTML();
              methods.setEventHandlers();
              methods.initializeItems();
            });
          },

          /******************************
              Append HTML
              *******************************/

          appendHTML: function () {
            fill.css("background", settings.barColor);

            if (!settings.tooltip) {
              toolTip.css("display", "none");
            }
            toolTip.text(fillPercentage + settings.symbol);
          },

          /******************************
              Set Event Handlers
              *******************************/
          setEventHandlers: function () {
            if (settings.animateOnResize) {
              $(window).on("resize", function (event) {
                clearTimeout(resizeTimeout);
                resizeTimeout = setTimeout(function () {
                  methods.refill();
                }, 300);
              });
            }
          },

          /******************************
              Initialize
              *******************************/

          initializeItems: function () {
            var pctWidth = methods.calculateFill(fillPercentage);
            object.find(".tipWrap").css({ display: "inline" });

            if (transitionSupport) methods.transitionFill(pctWidth);
            else methods.animateFill(pctWidth);
          },

          getTransitionSupport: function () {
            var thisBody = document.body || document.documentElement,
              thisStyle = thisBody.style;
            var support =
              thisStyle.transition !== undefined ||
              thisStyle.WebkitTransition !== undefined ||
              thisStyle.MozTransition !== undefined ||
              thisStyle.MsTransition !== undefined ||
              thisStyle.OTransition !== undefined;
            return support;
          },

          getTransitionPrefix: function () {
            if (
              /mozilla/.test(navigator.userAgent.toLowerCase()) &&
              !/webkit/.test(navigator.userAgent.toLowerCase())
            ) {
              return "-moz-transition";
            }
            if (/webkit/.test(navigator.userAgent.toLowerCase())) {
              return "-webkit-transition";
            }
            if (/opera/.test(navigator.userAgent.toLowerCase())) {
              return "-o-transition";
            }
            if (/msie/.test(navigator.userAgent.toLowerCase())) {
              return "-ms-transition";
            } else {
              return "transition";
            }
          },

          getTransition: function (val, time, type) {
            var CSSObj;
            if (type === "width") {
              CSSObj = { width: val };
            } else if (type === "left") {
              CSSObj = { left: val };
            }

            time = time / 1000;
            CSSObj[transitionPrefix] = type + " " + time + "s ease-in-out";
            return CSSObj;
          },

          refill: function () {
            fill.css("width", 0);
            toolTip.css("left", 0);
            barWidth = object.width();
            methods.initializeItems();
          },

          calculateFill: function (percentage) {
            percentage = percentage * 0.01;
            var finalWidth = barWidth * percentage;
            return finalWidth;
          },

          transitionFill: function (barWidth) {
            var toolTipOffset = barWidth - toolTip.width();
            fill.css(
              methods.getTransition(barWidth, settings.duration, "width")
            );
            toolTip.css(
              methods.getTransition(toolTipOffset, settings.duration, "left")
            );
          },

          animateFill: function (barWidth) {
            var toolTipOffset = barWidth - toolTip.width();
            fill.stop().animate({ width: "+=" + barWidth }, settings.duration);
            toolTip
              .stop()
              .animate({ left: "+=" + toolTipOffset }, settings.duration);
          },
        };

        if (methods[options]) {
          // $("#element").pluginName('methodName', 'arg1', 'arg2');
          return methods[options].apply(
            this,
            Array.prototype.slice.call(arguments, 1)
          );
        } else if (typeof options === "object" || !options) {
          // $("#element").pluginName({ option: 1, option:2 });
          return methods.init.apply(this);
        } else {
          $.error(
            'Method "' + method + '" does not exist in barfiller plugin!'
          );
        }
      };
    })(jQuery);

    $("#bar4").barfiller({
      barColor: "#111111",
      duration: 2000,
    });
    $("#bar5").barfiller({
      barColor: "#111111",
      duration: 2000,
    });

    // =====================此時才引入main.js=========================

    const script2 = document.createElement("script");
    script2.src = "js/main.js";
    document.body.appendChild(script2);
  });

// =====================取得所有評論=========================

fetch(`../restaurant-comment/${restaurantNo}`)
  .then((resp) => resp.json())
  .then((list) => {
    $("#comment_sum").html(`共${list.length}則評論`);
    var comment_avg = 0;
    for (let obj of list) {
      const { name } = obj;
      const { memberPicStr } = obj;
      const { commentRating } = obj;
      const { commentContent } = obj;
      const { commentPicStr } = obj;
      const { restaurantCommentTime } = obj;
      const { restaurantRe } = obj;
      const { restaurantReTime } = obj;

      comment_avg += commentRating; //加總所有評分

      let stars = "";
      //根據分數來新增等量的黃色星星
      for (var i = 1; i <= commentRating; i++) {
        stars += '<span class="icon_star"></span>';
      }
      //根據差多少星星來新增等量的灰色星星
      for (var i = 1; i <= 5 - commentRating; i++) {
        stars += '<span class="icon_star -off"></span>';
      }

      let respHtml = ` <div class="restaurant_resp">
      <h5>業主回應</h5>
      <span class="restaurantReTime">${restaurantReTime}</span>
      <p class="restaurantRe">
        ${restaurantRe}
      </p>
      </div>`;

      let picHtml = `<div class="comment_pic">
      <a data-fancybox="gallery" href="data:image/*;base64,${commentPicStr}"
        ><img src="data:image/*;base64,${commentPicStr}"
      /></a>
      </div>`;

      //如果業主沒有回覆，則清空字串
      if (restaurantRe == null) {
        respHtml = "";
      }

      //如果消費者沒上傳圖片，則清空字串
      if (commentPicStr == null) {
        picHtml = "";
      }
      const all_comment = document.querySelector("#all_comment"); //準備裝所有評論的div
      const newDiv = document.createElement("div");
      newDiv.innerHTML = `<div class="col-lg-6 comment">
      <div class="testimonial__item">
        <div class="testimonial__author">
          <div class="testimonial__author__pic">
            <img class="member_pic" src="data:image/*;base64,${memberPicStr}" alt="" style="object-fit: cover" />
          </div>
          <div class="testimonial__author__text">
            <h5 class="member_name">${name}</h5>
            <span class="restaurantCommentTime">${restaurantCommentTime}</span>
          </div>
        </div>
        <div class="rating">
          <h3 class="commentRating">${commentRating}</h3>
          ${stars}
        </div>
        ${picHtml}
        <p class="comment_content">
          ${commentContent}
        </p>
        <hr />
        ${respHtml}
      </div>
    </div>`;

      all_comment.appendChild(newDiv);
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
  });
