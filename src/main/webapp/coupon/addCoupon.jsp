<%@page import="java.util.GregorianCalendar"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tibame.tga104.coupon.vo.*"%>
<%@ page import="com.tibame.tga104.coupon.service.*"%>


<%
CouponVO couponVO = (CouponVO) request.getAttribute("couponVO");
%>
--<%=couponVO == null%>--${couponVO.couponNo}--
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>優惠券資料新增 - addCoupon.jsp</title>

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
				<h3>優惠券資料新增 - addCoupon.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="select_page.jsp"><img src="images/tomcat.png"
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

	<FORM METHOD="post" ACTION="AddCoupon" name="form1">
		<table>
			<tr>
				<td>優惠券編號：</td>
				<td><input type="TEXT" name="couponNo" size="45"
					value="<%=(couponVO == null) ? " " : couponVO.getCouponNo()%>" /></td>
			</tr>
			<tr>
				<td>餐廳編號：</td>
				<td><input type="TEXT" name="restaurantNo" size="45"
					value="<%=(couponVO == null) ? " " : couponVO.getRestaurantNo()%>" /></td>
			</tr>
			<tr>
				<td>管理員編號：</td>
				<td><input type="TEXT" name="adminNo" size="45"
					value="<%=(couponVO == null) ? " " : couponVO.getAdminNo()%>" /></td>
			</tr>
			<tr>
				<td>申請日期：</td>
				<td><input name="CouoponApplyDate" id="f_date1" type="text"></td>
			</tr>
			<tr>
				<td>優惠券名稱：</td>
				<td><input type="TEXT" name="CouponName" size="45"
					value="<%=(couponVO == null) ? " " : couponVO.getCouponName()%>" /></td>
			</tr>
			<tr>
				<td>優惠券開始時間：</td>
				<td><input name="CouponStartTime" id="f_date1" type="text"></td>
			</tr>
			<tr>
				<td>優惠券結束時間：</td>
				<td><input name="CouponEndTime" id="f_date1" type="text"></td>
			</tr>
			<tr>
				<td>審核狀態：</td>
				<td><input name="verified" type="text"
					value="<%=(couponVO == null) ? " " : couponVO.getVerified()%>" /></td>
			</tr>
			<tr>
				<td>優惠券內容：</td>
				<td><input type="TEXT" name="couponContent" size="45"
					value="<%=(couponVO == null) ? " " : couponVO.getCouponContent()%>" /></td>
			</tr>
			<tr>
				<td>訂單金額滿多少可以使用：</td>
				<td><input type="TEXT" name="usageLimitation" size="45"
					value="<%=(couponVO == null) ? " " : couponVO.getUsageLimitation()%>" /></td>
			</tr>
			<tr>
				<td>金額 / 折數：</td>
				<td><input type="TEXT" name="amountOrFold" size="45"
					value="<%=(couponVO == null) ? " " : couponVO.getAmountOrFold()%>" /></td>
			</tr>
			<tr>
				<td>種類 : 折價 / 打折：</td>
				<td><input type="TEXT" name="couponType" size="45"
					value="<%=(couponVO == null) ? " " : couponVO.getCouponType()%>" /></td>
			</tr>
			<tr>
				<td>發行張數上限：</td>
				<td><input type="TEXT" name="maxIssueQty" size="45"
					value="<%=(couponVO == null) ? " " : couponVO.getMaxIssueQty()%>" /></td>
			</tr>
			<tr>
				<td>已發行張數：</td>
				<td><input type="TEXT" name="issuedQty" size="45"
					value="<%=(couponVO == null) ? " " : couponVO.getIssuedQty()%>" /></td>
			</tr>
			<tr>
				<td>審核資訊：</td>
				<td><input type="text" name="verificationDetail" size="45"
					value="<%=(couponVO == null) ? " " : couponVO.getVerificationDetail()%>" /></td>
			</tr>
		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<%
java.sql.Timestamp couponStartTime = null;
try {
	couponStartTime = couponVO.getCouponStartTime();
} catch (Exception e) {
	couponStartTime = new java.sql.Timestamp(new GregorianCalendar().getTimeInMillis());
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
		   value: '<%=couponStartTime%>
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