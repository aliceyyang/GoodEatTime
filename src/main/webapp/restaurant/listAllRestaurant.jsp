<%@page import="restaurant.service.impl.RestaurantServiceImpl"%>
<%@page import="restaurant.service.RestaurantService"%>
<%@ page import="restaurant.vo.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<%
RestaurantService svc = new RestaurantServiceImpl();
List<RestaurantVO> list = svc.getAll();
pageContext.setAttribute("list", list);
%>


<html>
<head>
<meta charset="UTF-8">
<title>好食光餐廳資料</title>
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
<body>
	<table id="table-1">
		<tr>
			<td>
				<h3>好食光餐廳資料</h3>
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
		<%@ include file="../product/page1.file"%>
		<c:forEach var="vo" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
			<tr>
				<td>${vo.restaurantNo}</td>
				<td>${vo.restaurantName}</td>
				<td>${vo.restaurantTel}</td>
				<td>${vo.restaurantBusinessHour}</td>
				<td>${vo.restaurantAddr}</td>
				<td>${vo.restaurantStatus}</td>
				<td>${vo.restaurantAccountInfo}</td>
				<td>${vo.restaurantTaxIDNo}</td>
				<td>${vo.restaurantAccount}</td>
				<td>${vo.restaurantPassword}</td>
				<td><td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/restaurant/RestaurantServlet"
						style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="restaurantNo" value="${vo.restaurantNo}">
			     <input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
			</td>
			<td>
			  <FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/restaurant/RestaurantServlet"
						style="margin-bottom: 0px;">
			     <input type="submit" value="變更狀態">
			     <input type="hidden" name="restaurantNo" value="${vo.restaurantNo}">
			     <input type="hidden" name="action" value="setStatus">
					</FORM>
			</td>
				</td>
				
			</tr>
		</c:forEach>
	</table>
<%@ include file="../product/page2.file"%>

</body>
</html>
