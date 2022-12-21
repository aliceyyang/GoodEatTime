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
      }
  });

      /*-----------------------------
        newsrst Slider
    -------------------------------*/
    $(".newsrst__slider").owlCarousel({
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
        }
    });

    /*--------------------------
        coupon Slider
    ----------------------------*/
    $(".coupon__slider").owlCarousel({
        loop: true,
        margin: 22,
        items: 5,
        dots: false,
        nav: true,
        navText: ["<span class='arrow_carrot-left'><span/>", "<span class='arrow_carrot-right'><span/>"],
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: false,
        responsive: {
            0: {
                items: 1,
                margin: 0
            },
            480: {
                items: 2
            },
            768: {
                items: 3
            },
            992: {
                items: 4
            },
            1200: {
                items: 5
            }
        }
    });
