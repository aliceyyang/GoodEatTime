let authenticatedMember = JSON.parse(
  sessionStorage.getItem("restaurantMemberVO")
);
if (authenticatedMember != null) {
  $(".login_icon")
    .parent()
    .empty()
    .append(
      `<div class="testimonial__author__pic" style=" position : relative; top:-15px;right:-20px"><img class="member_pic" src="img/restaurant-login.png" alt="" style="object-fit: cover" /></div><a class="login_text" href="#" style="margin-top: 11px; display: inline-block">歡迎!${authenticatedMember.restaurantName}</a>`
    );
}
