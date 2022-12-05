$(function(){
    $('#BackTop').click(function(){ 
      $('html,body').animate({scrollTop:0}, 400);
    });
    $(window).scroll(function() {
      if ( $(this).scrollTop() > 300 ){
        $('#BackTop').fadeIn(200);
      } else {
        $('#BackTop').stop().fadeOut(200);
      }
    }).scroll();
  });