<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>好食光餐廳查詢</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #F08632;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }

  h4 {
    color: blue;
    display: inline;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>好食光餐廳查詢</h3></td></tr>
</table>

<p>合作餐廳後台管理</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllRestaurant.jsp'>List All Restaurant</a></li>
  <br>
  
  
  <li>
    <FORM METHOD="post" ACTION="RestaurantServlet" >
        <b>輸入餐廳編號:</b>
        <input type="text" name="restaurantNo">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="svc" scope="page" class="restaurant.service.impl.RestaurantServiceImpl" />
   
  <li>
     <FORM METHOD="post" ACTION="RestaurantServlet" >
       <b>選擇餐廳編號:</b>
       <select size="1" name="restaurantNo">
         <c:forEach var="restaurantVO" items="${svc.all}" > 
          <option value="${restaurantVO.restaurantNo}">${restaurantVO.restaurantNo}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>

  <li>
     <FORM METHOD="post" ACTION="RestaurantServlet" >
       <b>選擇餐廳名稱:</b>
       <select size="1" name="restaurantNo">
         <c:forEach var="restaurantVO" items="${svc.all}" > 
          <option value="${restaurantVO.restaurantNo}">${restaurantVO.restaurantName}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>

</body>
</html>