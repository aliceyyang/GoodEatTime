// console.log("read success");

// 取得query string
const params = new Proxy(new URLSearchParams(window.location.search), {
  get: (searchParams, prop) => searchParams.get(prop),
});
let prodOrderNo = parseInt(params.prodOrderNo);
fetch(`../order/detail?prodOrderNo=${prodOrderNo}`)
  .then((r) => {
    if (r.redirected) {
      Swal.fire({
        // sweet alert CDN
        position: "center",
        icon: "warning",
        title: "請先登入",
        showConfirmButton: false,
        timer: 1000,
      }).then(() => {
        // 動畫跑完後跳轉
        sessionStorage.setItem("URL_before_login", window.location.href);
        window.location.href = r.url;
      });
    } else {
      return r.json();
    }
  })
  ?.then((data) => {
    document.getElementById("prodOrderNo").value = prodOrderNo;
    document.getElementById("orderStatus").value = data[0].orderStatus;
    document.getElementById("prodOrderDate").value = data[0].prodOrderDate;
    document.getElementById("prodOderDeliverTime").value = data[0]
      .prodOderDeliverTime
      ? data[0].prodOderDeliverTime
      : "尚未出貨";
    document.getElementById("restaurantName").value = data[0].restaurantName;
    document.getElementById("name").value = data[0].name;
    document.getElementById("tel").value = data[0].tel;
    document.getElementById("prodOrderReceiverName").value =
      data[0].prodOrderReceiverName;
    document.getElementById("prodOrderReceiverTel").value =
      data[0].prodOrderReceiverTel;
    document.getElementById("prodOrderReceiverMail").value =
      data[0].prodOrderReceiverMail;
    document.getElementById("prodOrderReceiverAddress").value =
      data[0].prodOrderReceiverAddress;
    document.getElementById("amountAfterCoupon").value =
      data[0].amountAfterCoupon;
    document.getElementById("invoiceNumber").value = data[0].invoiceNumber;
    document.getElementById("taxIDNumber").value = data[0].taxIDNumber
      ? data[0].taxIDNumber
      : "未輸入統一編號";

    document.querySelector(".orderdateil tbody").innerHTML = "";
    data.forEach((element, index) => {
      let tr_html = `<tr>
      <td>${element.prodName}</td>
      <td>${element.prodQty}</td>
      <td>NTD ${element.prodPrice}</td>
      <td>NTD ${element.prodQty * element.prodPrice}</td>
      <td><button data-index="${index}">前往評論</button></td>
    </tr>`;
      document.querySelector(".orderdateil tbody").insertAdjacentHTML("beforeend", tr_html);
    });
    $("td > button").on("click", function () {
      let index = $(this).attr("data-index");
      // console.log(orderSearchVOList);
      // console.log(orderSearchVOList[index]);
      // sessionStorage.setItem("orderSearchVOList", orderSearchVOList[index]);
      window.location.href = "./member_commentprod.html";
      });
    console.log(data);
  });
