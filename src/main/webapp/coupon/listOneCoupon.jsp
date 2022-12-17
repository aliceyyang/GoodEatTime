<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.tibame.tga104.coupon.service.*" %>
<%@ page import="com.tibame.tga104.coupon.vo.*" %>

<html>
<head>
<title>優惠券資料 - listOneCoupon.jsp</title>

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
<body bgcolor="white">

<h4>此頁練習採用 EL 的寫法取值:</h4>
	<table id="table-1">
		<tr><td>
			 <h3>所有優惠券資料 - listOneCoupon.jsp</h3>
			 <h4><a href="selectCoupon.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
		</td></tr>
	</table>
	
	<table>
		<tr>
			<th>優惠券編號</th>
			<th>餐廳編號</th>
			<th>優惠券名稱</th>
			<th>審核狀態</th>
			<th>優惠券內容</th>
		</tr>
	
		<tr>
	<c:forEach var="couponVO" items="${list}">
			<tr>
			<form method="post" action="Manage" style="margin-bottom: 0px;">
				<td>${couponVO.couponNo}</td>
				<td>${couponVO.restaurantNo}</td>
				<td>${couponVO.couponName}</td>
				<td>${couponVO.verified}</td>
				<td>${couponVO.couponContent}</td>
			</form>
			</tr>			
		</c:forEach>
	</tr>			
</table>
</body>
</html>