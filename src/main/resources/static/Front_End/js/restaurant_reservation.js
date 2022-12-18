$(document).ready(function () {
  $("#reserveinf").DataTable({
    ajax: `../reservation/restaurant/reserveInf?date=${sessionStorage.getItem(
      "reserveDate"
    )}`,
    columns: [
      {
        data: "reserveNo",
      },
      {
        data: "name",
      },
      {
        data: "reserveDate",
      },
      {
        data: "reserveTime",
      },
      {
        data: "reserveNum",
      },
      {
        data: "tel",
      },
      {
        data: "mail",
      },
      {
        data: "remark",
      },
      {
        data: "reserveStatus",
        render: function () {
          return `
            <div class="onoffswitch">
              <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch" tabindex="0">
              <label class="onoffswitch-label" for="myonoffswitch">
                <span class="onoffswitch-inner"></span>
                <span class="onoffswitch-switch"></span>
              </label>
            </div>`;
        },
      },
    ],
  });
});

// const date = sessionStorage.getItem("reserveDate");
// // console.log(date);
// const reserve_restaurant = document.querySelector("#reserve_restaurant");
// function detail() {
//   $.ajax({
//     url: "../reservation/restaurant/reserveInf",
//     type: "GET",
//     dataType: "json",
//     data: { date: date },
//     success: function (a) {
//       // console.log(a);
//       reserve_restaurant.innerHTML = a
//         .map((e) =>
//           Template(
//             e.reserveNo,
//             e.name,
//             e.reserveDate,
//             e.reserveTime,
//             e.reserveNum,
//             e.tel,
//             e.mail,
//             e.remark,
//             e.reserveStatus
//           )
//         )
//         .join("");
//     },
//   });
// }

// detail();
// function Template(
//   reserveNo,
//   name,
//   reserveDate,
//   reserveTime,
//   reserveNum,
//   tel,
//   mail,
//   remark,
//   reserveStatus
// ) {
//   return `<tr>
//   <td>${reserveNo}</td>
//   <td>${name}</td>
//   <td>${reserveDate}</td>
//   <td>${reserveTime}</td>
//   <td>${reserveNum}</td>
//   <td>${tel}</td>
//   <td>${mail}</td>
//   <td>${remark}</td>
//   <td>${reserveStatus}</td>
//   </tr> `;
// }

// {
//   /* <tr>
//               <th>12</th>
//               <th>Jusd</th>
//               <th>2022-12-03</th>
//               <th>12:00</th>
//               <th>3</th>
//               <th>0920300912</th>
//               <th>xxx</th>
//               <th>備註</th>
//               <th>
//                 <div class="onoffswitch">
//                   <input type="checkbox" name="onoffswitch" class="onoffswitch-checkbox" id="myonoffswitch"
//                     tabindex="0">
//                   <label class="onoffswitch-label" for="myonoffswitch">
//                     <span class="onoffswitch-inner"></span>
//                     <span class="onoffswitch-switch"></span>
//                   </label>
//                 </div>
//               </th>
//             </tr> */
// }

// 開關取值
// (function() {
//   $(document).ready(function() {
//     $('.switch-input').on('change', function() {
//       var isChecked = $(this).is(':checked');
//       var selectedData;
//       var $switchLabel = $('.switch-label');
//       console.log('isChecked: ' + isChecked);

//       if(isChecked) {
//         selectedData = $switchLabel.attr('data-on');
//       } else {
//         selectedData = $switchLabel.attr('data-off');
//       }

//       console.log('Selected data: ' + selectedData);

//     });

//     // Params ($selector, boolean)
//     function setSwitchState(el, flag) {
//       el.attr('checked', flag);
//     }

//     // Usage
//     setSwitchState($('.switch-input'), true);
//   });
