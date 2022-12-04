<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="product.service.*"%>
<%@ page import="product.vo.*"%>

<%
ProdInfoVO prodInfoVO = (ProdInfoVO) request.getAttribute("prodInfoVO"); //Concroller 存入req的ProdInfoVO物件
%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>產品資料新增 - addProd.jsp</title>

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
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
  * {
  	box-sizing: border-box;
  }
  form {
  	width: 100%;
  	display: inline-block;
  }
  table.left {
  	width: 40%;
  	display: inline-block;
  }
  div.right {
  	width: 55%;
  	display: inline-block;
  	vertical-align: top;
  }
  p {
  	margin-top: 8px;
  	margin-bottom: 8px;
  }
  textarea.right {
  	width: 100%;
  	height: 80px;
  	overflow: auto;
  }
  div.divider {
  	height: 15px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>產品資料新增 - addProd.jsp</h3>
		 <h4><a href="selectProduct.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="ProdInfoController" name="form1">
<table class="left">
	<tr>
		<td>產品編號:</td>
		<td>新增成功後自動增加</td>
	</tr>
	<tr>
		<td>餐廳編號:</td>
		<td><input name="restaurantNo" type="text" size="45" value="<%=prodInfoVO==null? 1 : prodInfoVO.getRestaurantNo()%>"></td>
	</tr>
	<jsp:useBean id="prodCategoryService" scope="page" class="product.service.ProdCategoryService" />
	<tr>
		<td>產品類別:</td>
		<td><select size="1" name="prodCategoryNo">
			<c:forEach var="prodCategoryVO" items="${prodCategoryService.all}">
				<option value="${prodCategoryVO.prodCategoryNo}" ${(prodInfoVO.prodCategoryNo==prodCategoryVO.prodCategoryNo)?'selected':'' } >${prodCategoryVO.prodCategory}
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>產品名稱:</td>
		<td><input name="prodName" type="text" size="45" value="<%=prodInfoVO==null? " ":prodInfoVO.getProdName()%>"></td>
	</tr>
	<tr>
		<td>產品價格:</td>
		<td><input type="TEXT" name="prodPrice" size="45"	value="<%=prodInfoVO==null? 1 :prodInfoVO.getProdPrice()%>" /></td>
	</tr>
	<tr>
		<td>產品庫存:</td>
		<td><input type="TEXT" name="prodStock" size="45" value="<%=prodInfoVO==null? 0:prodInfoVO.getProdStock()%>" /></td>
	</tr>
	<tr>
		<td>評論數量:</td>
		<td>
			0
			<input type="hidden" name="prodCommentQty" size="45" value="0" />
		</td>
	</tr>
	<tr>
		<td>總評論星等:</td>
		<td>
			0
			<input type="hidden" name="totalCommentRating" size="45" value="0" />
		</td>
	</tr>
	

</table>
<div class="right">
	<p>產品說明: </p>
	<textarea class="right" name="prodDescription" ><%=prodInfoVO==null? " ":prodInfoVO.getProdDescription()%></textarea>
	<div class="divider"></div>
	<p>產品規格: </p>
	<textarea class="right" name="prodContent" ><%=prodInfoVO==null? " ":prodInfoVO.getProdContent()%></textarea>
</div>
<br>
<input type="hidden" name="action" value="addProduct">
<input type="submit" value="送出新增"></FORM>
</body>
</html>