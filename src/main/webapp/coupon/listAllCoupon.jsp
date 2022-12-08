<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.tibame.tga104.coupon.service.*" %>
<%@ page import="com.tibame.tga104.coupon.vo.*" %>

<%
	CouponServiceImpl couponSvc = new CouponServiceImpl();
	List<CouponVO> list = couponSvc.getAll();
	pageContext.setAttribute("list", list);
%>

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
<body bgcolor="white">

<h4>此頁練習採用 EL 的寫法取值:</h4>
	<table id="table-1">
		<tr><td>
			 <h3>所有優惠券資料 - listAllCoupon.jsp</h3>
			 <h4><a href="selectCoupon.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
		</td></tr>
	</table>
	
	<table>
		<tr>
			<th>優惠券編號</th>
			<th>餐廳編號</th>
			<th>管理員編號</th>
			<th>申請日期</th>
			<th>優惠券名稱</th>
			<th>開始時間</th>
			<th>結束時間</th>
			<th>審核狀態</th>
			<th>優惠券內容</th>
			<th>訂單金額滿多少可以使用</th>
			<th>金額 / 折數</th>
			<th>種類 : 折價 / 打折</th>
			<th>發行張數上限</th>
			<th>已發行張數</th>
			<th>審核資訊</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>
		<%@ include file="page1.file" %> 
		<c:forEach var="couponVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
	
	
		<tr>
			<td>${couponVO.couponNo}</td>
			<td>${couponVO.restaurantNo}</td>
			<td>${couponVO.adminNo}</td>
			<td>${couponVO.couponApplyDate}</td>
			<td>${couponVO.couponName}</td>
			<td>${couponVO.couponStartTime}</td>
			<td>${couponVO.couponEndTime}</td>
			<td>${couponVO.verified}</td>
			<td>${couponVO.couponContent}</td>
			<td>${couponVO.usageLimitation}</td>
			<td>${couponVO.amountOrFold}</td>
			<td>${couponVO.couponType}</td>
			<td>${couponVO.maxIssueQty}</td>
			<td>${couponVO.issuedQty}</td>
			<td>${couponVO.verificationDetail}</td>
			<td>
			<form method="post" action="<%=request.getContextPath()%>/coupon/CouponController" style="margin-bottom: 0px;">
			<input type="submit" value="修改">
			<input type="hidden" name="couponNo" value="${couponVO.couponNo}">
			<input type="hidden" name="action" value="updateCoupon"></form>
		</td>
		<td>
			<form method="post" action="<%=request.getContextPath()%>/coupon/CouponController" style="margin-bottom: 0px;">
			<input type="submit" value="刪除">
			<input type="hidden" name="couponNo" value="${couponVO.couponNo}">
			<input type="hidden" name="action" value="deleteCoupon"></form>
		</td>
	</tr>			
</c:forEach>
</table>
<%@ include file="page2.file" %>
</body>
</html>