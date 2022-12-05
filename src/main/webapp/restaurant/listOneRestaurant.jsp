<%@page import="restaurant.vo.RestaurantVO"%>
<%@ page import="restaurant.service.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%
RestaurantVO restaurantvo = (RestaurantVO) request.getAttribute("restaurantVO");
%>

<html>
<head>
<title>餐廳資料</title>

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
	width: 100%;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>

</head>
<body bgcolor='white'>


	<table id="table-1">
		<tr>
			<td>
				<h3>餐廳資料</h3>
				<h4>
					<a href="selectRestaurant.jsp"><img
						src="../product/images/back1.gif" width="100" height="32"
						border="0">返回搜尋</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>餐廳編號</th>
			<th>名稱</th>
			<th>電話</th>
			<th>營業時間</th>
			<th>地址</th>
			<th>狀態</th>
			<th>帳戶資訊</th>
			<th>統一編號</th>
			<th>帳號</th>
			<th>密碼</th>
		</tr>
		<tr>
			<td><%=restaurantvo.getRestaurantNo()%></td>
			<td><%=restaurantvo.getRestaurantName()%></td>
			<td><%=restaurantvo.getRestaurantTel()%></td>
			<td><%=restaurantvo.getRestaurantBusinessHour()%></td>
			<td><%=restaurantvo.getRestaurantAddr()%></td>
			<td><%=restaurantvo.getRestaurantStatus()%></td>
			<td><%=restaurantvo.getRestaurantAccountInfo()%></td>
			<td><%=restaurantvo.getRestaurantTaxIDNo()%></td>
			<td><%=restaurantvo.getRestaurantAccount()%></td>
			<td><%=restaurantvo.getRestaurantPassword()%></td>
		</tr>
	</table>

</body>
</html>