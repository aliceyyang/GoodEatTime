    /*-----------------------------
        news Slider
    -------------------------------*/
    $(".news__slider").owlCarousel({
      loop: true,
      margin: 0,
      items: 2,
      dots: true,
      smartSpeed: 1200,
      autoHeight: false,
      autoplay: true,
      responsive: {
          0: {
              items: 1
          },
          768: {
              items: 2
          }
      }
  });
