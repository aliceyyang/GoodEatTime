<%@page import="restaurant.vo.RestaurantVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="restaurant.*"%>
<!DOCTYPE html>
<%
RestaurantVO vo = (RestaurantVO) request.getAttribute("restaurantVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>餐廳資料修改</title>

<style>
table#table-1 {
	background-color: #F08632;
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
				<h3>餐廳資料修改</h3>
				<h4>
					<a href="selectRestaurant.jsp"><img
						src="../product/images/back1.gif" width="100" height="32"
						border="0">返回搜尋</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料修改:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="RestaurantServlet" name="form1">
		<table>
			<tr>
				<td>餐廳編號:<font color=red><b>*</b></font></td>
				<td><%=vo.getRestaurantNo()%></td>
			</tr>
			<tr>
				<td>餐廳名稱:</td>
				<td><input type="TEXT" name="restaurantName" size="45"
					value="<%=vo.getRestaurantName()%>" /></td>
			</tr>
			<tr>
				<td>電話:</td>
				<td><input type="TEXT" name="restaurantTel" size="45"
					value="<%=vo.getRestaurantTel()%>" /></td>
			</tr>
			<tr>
				<td>營業時間:</td>
				<td><input type="TEXT" name="restaurantBusinessHour" size="45"
					value="<%=vo.getRestaurantBusinessHour()%>" /></td>
			</tr>
			<tr>
				<td>地址:</td>
				<td><input type="TEXT" name="restaurantAddr" size="45"
					value="<%=vo.getRestaurantAddr()%>" /></td>
			</tr>
			<tr>
				<td>狀態:<font color=red><b>*</b></font></td>
				<td><%=vo.getRestaurantStatus()%></td>
			</tr>
			<tr>
				<td>帳戶資訊:</td>
				<td><input type="TEXT" name="restaurantAccountInfo" size="45"
					value="<%=vo.getRestaurantAccountInfo()%>" /></td>
			</tr>
			<tr>
				<td>統一編號:</td>
				<td><input type="TEXT" name="restaurantTaxIDNo" size="45"
					value="<%=vo.getRestaurantTaxIDNo()%>" /></td>
			</tr>
			<tr>
				<td>帳號:</td>
				<td><input type="TEXT" name="restaurantAccount" size="45"
					value="<%=vo.getRestaurantAccount()%>" /></td>
			</tr>
			<tr>
				<td>密碼:</td>
				<td><input type="TEXT" name="restaurantPassword" size="45"
					value="<%=vo.getRestaurantPassword()%>" /></td>
			</tr>
		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="restaurantNo" value="<%=vo.getRestaurantNo()%>"> <input
			type="submit" value="送出修改">
	</FORM>
</body>