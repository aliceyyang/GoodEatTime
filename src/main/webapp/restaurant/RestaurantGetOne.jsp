<%@page import="restaurant.vo.RestaurantVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<%
RestaurantVO restaurantVO = (RestaurantVO) request.getAttribute("vo");

String errorMsg = (String) request.getAttribute("errorMsg");
%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	  
	    <FORM METHOD="post" ACTION="restaurant/getOne" >
	        <div>輸入餐廳編號:</div>
	        <input type="text" name="restaurantNo">
	        <input type="submit" value="送出">                    
	    </FORM>
	  
</body>
</html>