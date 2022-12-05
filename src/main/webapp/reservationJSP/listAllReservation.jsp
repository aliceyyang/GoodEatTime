<%@page import="reservation.service.impl.ReserveTimeServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="reservation.*"%>
<%@ page import="reservation.vo.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    ReserveTimeServiceImpl reservationSvc = new ReserveTimeServiceImpl();
    List<ReserveTimeVO> list = reservationSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有訂位時段資料</title>

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
	width: 800px;
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

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有訂位時段資料</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>訂位時段編號</th>
		<th>餐廳編號</th>
		<th>訂位時段</th>
		<th>容許訂位人數</th>
		<th>營業時間</th>
	</tr>

	<c:forEach var="reserveTimeVO" items="${list}">
		
		<tr>
			<td>${reserveTimeVO.reserveTimeNo}</td>
			<td>${reserveTimeVO.restaurantNo}</td>
			<td>${reserveTimeVO.reserveTime}</td>
			<td>${reserveTimeVO.weekDay}</td>
			<td>${reserveTimeVO.allowReserveNum}</td>
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/restaurant/setReservation" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="empno"  value="${reserveTimeVO.reserveTimeNo}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/restaurant/setReservation" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="empno"  value="${reserveTimeVO.reserveTimeNo}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
</c:forEach>
</table>
<%-- <%@ include file="page2.file" %> --%>

</body>
</html>