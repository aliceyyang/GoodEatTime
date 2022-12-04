<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="product.service.*"%>
<%@ page import="product.vo.*"%>
<%@ page import="java.util.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<jsp:useBean id="prodPicService" scope="page" class="product.service.ProdPicService" />
<%
	ProdInfoVO prodInfoVO = (ProdInfoVO) request.getAttribute("prodInfoVO"); //Concroller 存入req的ProdInfoVO物件
	List<ProdPicVO> list = (List<ProdPicVO>)request.getAttribute("prodPiclist");
    pageContext.setAttribute("list",list);
%>

<html>
<head>
<title>產品資料 - listOneProd.jsp</title>

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
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>產品資料 - listOneProd.jsp</h3>
		 <h4><a href="selectProduct.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>產品編號</th>
		<th>餐廳編號</th>
		<th>產品類別</th>
		<th>產品名稱</th>
		<th>產品價格</th>
		<th>產品庫存</th>
		<th>產品說明</th>
		<th>產品規格</th>
		<th>評論數量</th>
		<th>總評論星等</th>
	</tr>
	<jsp:useBean id="prodCategoryService" scope="page" class="product.service.ProdCategoryService" />
	<tr>
		<td><%=prodInfoVO.getProdNo()%></td>
		<td><%=prodInfoVO.getRestaurantNo()%></td>
		<td>${prodCategoryService.getOneProdCategory(prodInfoVO.prodCategoryNo).prodCategory}</td>
		<td><%=prodInfoVO.getProdName()%></td>
		<td><%=prodInfoVO.getProdPrice()%></td>
		<td><%=prodInfoVO.getProdStock()%></td>
		<td><%=prodInfoVO.getProdDescription()%></td>
		<td><%=prodInfoVO.getProdContent()%></td>
		<td><%=prodInfoVO.getProdCommentQty()%></td>
		<td><%=prodInfoVO.getTotalCommentRating()%></td>
	</tr>
</table>
<h3>產品圖片管理</h3>
	
	<ul>
	  <li><a href='addProduct.jsp'>Add</a> a new Picture</li>
	</ul>
<table>
	<tr>
		<th style="width: 40%">產品圖片說明</th>
		<th style="width: 60%">產品圖片</th>
	</tr>
	<c:forEach var="prodPicVO" items="${list}">
	<tr>
		<th>${prodPicVO.prodPicRemark}
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/product/ProdInfoController" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="prodPicNo"  value="${prodPicVO.prodPicNo}">
			     <input type="hidden" name="action"	value="updatePic"></FORM>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/product/ProdInfoController" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="prodPicNo"  value="${prodPicVO.prodPicNo}">
			     <input type="hidden" name="action"	value="deletePic"></FORM>
		</th>
		<th>${prodPicVO.prodPic}</th>
	</tr>
	</c:forEach>
</table>

</body>
</html>