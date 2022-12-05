
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

  $("a#readmore").on("click",function(e){
    e.preventDefault();
    if($("a#readmore").hasClass('-on')){
      $(this).removeClass("-on");
      $(this).text("READ MORE");
      $(".inner_block").removeClass("-on");
    }
    else{
      $(this).toggleClass("-on");
    $(this).text("CLOSE");
    $(".inner_block").toggleClass("-on");
    }
  });

  $('div.coupon').on("mouseenter",function(e){
    $(this).toggleClass("-on");
  });
  $('div.coupon').on("mouseleave",function(e){
    $(this).removeClass("-on");
  });
    
  
