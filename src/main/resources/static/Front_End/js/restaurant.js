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

$(".readmore").on("click", function (e) {
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
