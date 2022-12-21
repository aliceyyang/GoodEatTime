<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.tibame.tga104.coupon.service.*" %>
<%@ page import="com.tibame.tga104.coupon.vo.*" %>

<html>
<head>
<title>所有優惠券資料 - listAllCoupon.jsp</title>
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
<body>
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
		<c:forEach var="couponVO" items="${list}">
			<tr>
			<form method="post" action="Manage" style="margin-bottom: 0px;">
			<td>${couponVO.couponNo}</td>
				<td>${couponVO.restaurantNo}</td>
				<td>
					<input type="text" name="couponName" value="${couponVO.couponName}">
				</td>
				<td>
					<input type="text" name="verified" value="${couponVO.verified}">
				</td>
				<td>
					<input type="text" name="couponContent" value="${couponVO.couponContent}">
				</td>
				<td>
				<input type="hidden" name="couponNo" value="${couponVO.couponNo}">
				<input type="submit" value="修改">
				</td>
			</form>
				
				<td>
					<form method="post" action="delete" style="margin-bottom: 0px;">
						<input type="hidden" name="couponNo" value="${couponVO.couponNo}">
						<input type="submit" value="刪除">
					</form>
				</td>
			</tr>			
		</c:forEach>
	</table>
</body>
</html>