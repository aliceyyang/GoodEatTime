<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="order.service.*"%>
<%@ page import="order.vo.*"%>

<%
ProdOrderVO prodOrderVO = (ProdOrderVO) request.getAttribute("prodOrderVO");
%>
--<%=prodOrderVO == null%>--${prodOrderVO.restaurantNo}--
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>訂單資料新增 - addProdOrder.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>訂單資料新增 - addProdOrder.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="selectProdOrder.jsp"><img src="images/tomcat.png"
						width="100" height="100" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="ProdOrderServlet" name="form1">
		<table>
			<tr>
				<td>會員編號：</td>
				<td><input type="TEXT" name="memberNo" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getMemberNo()%>" /></td>
			</tr>
			<tr>
				<td>餐廳編號：</td>
				<td><input type="TEXT" name="restaurantNo" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getRestaurantNo()%>" /></td>
			</tr>
			<tr>
				<td>優惠券編號：</td>
				<td><input type="TEXT" name="couponNo" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getCouponNo()%>" /></td>
			</tr>
			<tr>
				<td>訂單狀態：</td>
				<td><input type="TEXT" name="orderStatus" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getOrderStatus()%>" /></td>
			</tr>
			<tr>
				<td>訂單時間：</td>
				<td><input name="prodOrderDate" id="f_date1" type="text"></td>
			</tr>
			<tr>
				<td>收貨時間：</td>
				<td><input type="TEXT" name="prodOrderReveiveTime" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getProdOrderReveiveTime()%>" /></td>
			</tr>
			<tr>
				<td>出貨時間：</td>
				<td><input type="TEXT" name="prodOderDeliverTime" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getProdOderDeliverTime()%>" /></td>
			</tr>
			<tr>
				<td>運費：</td>
				<td><input type="TEXT" name="deliverFee" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getDeliverFee()%>" /></td>
			</tr>
			<tr>
				<td>訂單原始金額：</td>
				<td><input type="TEXT" name="amountBeforeCoupon" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getAmountBeforeCoupon()%>" /></td>
			</tr>
			<tr>
				<td>訂單折扣後金額：</td>
				<td><input type="TEXT" name="amountAfterCoupon" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getAmountAfterCoupon()%>" /></td>
			</tr>
			<tr>
				<td>紅利點數：</td>
				<td><input type="TEXT" name="prodOrderPoint" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getProdOrderPoint()%>" /></td>
			</tr>
			<tr>
				<td>收貨人姓名：</td>
				<td><input type="TEXT" name="prodOrderReceiverName" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getProdOrderReceiverName()%>" /></td>
			</tr>
			<tr>
				<td>收貨人電話：</td>
				<td><input type="TEXT" name="prodOrderReceiverTel" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getProdOrderReceiverTel()%>" /></td>
			</tr>
			<tr>
				<td>收貨人MAIL：</td>
				<td><input type="TEXT" name="prodOrderReceiverMail" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getProdOrderReceiverMail()%>" /></td>
			</tr>
			<tr>
				<td>收貨地址：</td>
				<td><input type="TEXT" name="prodOrderReceiverAddress"
					size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getProdOrderReceiverAddress()%>" /></td>
			</tr>
			<tr>
				<td>發票號碼：</td>
				<td><input type="TEXT" name="invoiceNumber" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getInvoiceNumber()%>" /></td>
			</tr>
			<tr>
				<td>統一編號：</td>
				<td><input type="TEXT" name="taxIDNumber" size="45"
					value="<%=(prodOrderVO == null) ? " " : prodOrderVO.getTaxIDNumber()%>" /></td>
			</tr>
			<tr>
				<td>雇用日期:</td>
				<td><input name="hiredate" id="f_date1" type="text"></td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<%
java.sql.Timestamp prodOrderDate = null;
try {
	prodOrderDate = prodOrderVO.getProdOrderDate();
} catch (Exception e) {
	prodOrderDate = new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis());
}
%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
		   value: '<%=prodOrderDate%>
	', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	});

	// ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

	//      1.以下為某一天之前的日期無法選擇
	//      var somedate1 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      2.以下為某一天之後的日期無法選擇
	//      var somedate2 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
	//      var somedate1 = new Date('2017-06-15');
	//      var somedate2 = new Date('2017-06-25');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//		             ||
	//		            date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});
</script>
</html>