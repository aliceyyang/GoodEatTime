<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>所有餐廳資料</title>
</head>
<body>
	<c:forEach var="vo" items="${list}">
		<tr>
			<td>${vo.restaurantNo}</td>
			<td>${vo.restaurantTel}</td>
			<td>${vo.restaurantName}</td>
			<td>${vo.restaurantTaxIDNo}</td>
			<td>${vo.restaurantAccountInfo}</td>
			<td>${vo.restaurantBusinessHour}</td>
			<td>${vo.restaurantAddr}</td>
			<td>${vo.restaurantStatus}</td>
			<td>${vo.restaurantAccount}</td>
		</tr>
	</c:forEach>
	
	
</body>
</html>
