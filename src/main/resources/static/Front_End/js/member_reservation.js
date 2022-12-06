/*-------------------
    會員訂位資訊
  --------------------- */
// 搜尋功能
function searchFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("reserve_search");
  filter = input.value.toUpperCase();
  table = document.getElementById("reserver_detail");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

// 日期排序
function init() {
  const reserve = document.querySelector("#reserve");

  // fetch
  fetch("/js/test.json")
    // body to json
    .then((res) => res.json())
    // get data
    .then((data) => {
      data = data.sort((a, b) => {
        if (a.reserveDate > b.reserveDate) return 1
        if (a.reserveDate < b.reserveDate) return -1
        return 0

      })
      reserve.innerHTML =
        data.map((e) => Template(e.reserveNo, e.restaurantName, e.memberNo, e.reserveDate, e.reserveTime, e.reserveNum, e.remark)).join('')

    });
}
window.onload = init;

function Template(reserveNo, restaurantName, memberNo, reserveDate, reserveTime, reserveNum, remark) {
  return `<tr>
  <td>${reserveNo}</td>
  <td>${restaurantName}</td>
  <td>${reserveDate}</td>
  <td>${reserveTime}</td>
  <td>${reserveNum}</td>
  <td>${remark}</td>
  </tr> `
}