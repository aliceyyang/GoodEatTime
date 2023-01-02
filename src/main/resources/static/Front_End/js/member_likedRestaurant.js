//找到該會員的所有收藏餐廳
fetch("http://localhost:8080/LikedRestaurant-list/0", {
  method: "GET",
  redirect: "follow",
}).then((res) => {
  var redirect_URL = res.url;
  if (res.redirected) {
    // alert("請先登入");
    Swal.fire({
      position: "center",
      icon: "warning",
      title: "請先登入",
      showConfirmButton: false,
      timer: 1000,
    }).then(() => {
      sessionStorage.setItem(
        "URL_before_login",
        "http://localhost:8080/Front_End/member_likedRestaurant.html"
      );
      sessionStorage.setItem(
        "resp_login",
        window.location.assign(redirect_URL)
      );
    });
  } else {
    res.json().then((list) => {
      if (list.length == 0) {
        $(".wishlist__cart__table").append(
          '<h4 style="text-align: center;padding:30px">尚無收藏的餐廳</h4>'
        );
      }
      //將所有收藏的餐廳編號存進陣列
      for (const item of list) {
        const { restaurantNo } = item;
        //   let restaurant_Name;
        //   let carouselPic_Str;
        fetch(`http://localhost:8080/restaurant-page/${restaurantNo}`)
          .then((res) => res.json())
          .then((data) => {
            const { restaurantName } = data;
            //   restaurant_Name = restaurantName;

            fetch(
              `http://localhost:8080/restaurant-readInfo/CarouselPic/${restaurantNo}`
            )
              .then((res) => res.json())
              .then((list) => {
                const { carouselPicStr } = list[0];
                //   carouselPic_Str = carouselPicStr;

                let html = `<tr id="liked_${restaurantNo}">
                                <td class="product__cart__item">
                                    <div class="product__cart__item__pic">
                                        <img class="rPic" src="data:image/*;base64,${carouselPicStr}" alt="">
                                    </div>
                                    <div class="product__cart__item__text">
                                        <h5 class="rName" style="color:black">${restaurantName}</h5>
                                    </div>
                                </td>
                                <td class="cart__btn"><a class="primary-btn">取消收藏</a></td>
                            </tr>`;

                $("#likedRestaurant tbody").append(html);
              });
          });
      }
    });
  }
});

$(document).on("click", ".rName", function () {
  var Num = $(this).closest("tr").attr("id").substring(6);
  sessionStorage.setItem("restaurantNo", Num);
  window.open("http://localhost:8080/Front_End/restaurant.html", "_blank");
});

$(document).on("click", ".rPic", function () {
  var Num = $(this).closest("tr").attr("id").substring(6);
  sessionStorage.setItem("restaurantNo", Num);
  window.open("http://localhost:8080/Front_End/restaurant.html", "_blank");
});

$(document).on("click", ".primary-btn", function () {
  let restaurantNo = $(this).closest("tr").attr("id").substring(6);
  $(this)
    .closest("tr")
    .fadeOut(800, function () {
      $(this).remove();
    });
  fetch("http://localhost:8080/LikedRestaurant-delete", {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      memberNo: 0,
      restaurantNo: restaurantNo,
    }),
  });
});
