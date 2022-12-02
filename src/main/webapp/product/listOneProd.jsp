<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="product.service.*"%>
<%@ page import="product.vo.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	ProdInfoVO prodInfoVO = (ProdInfoVO) request.getAttribute("prodInfoVO"); //Concroller 存入req的ProdInfoVO物件
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
		<th>產品類別編號</th>
		<th>產品名稱</th>
		<th>產品價格</th>
		<th>產品庫存</th>
		<th>產品說明</th>
		<th>產品規格</th>
		<th>評論數量</th>
		<th>總評論星等</th>
	</tr>
	<tr>
		<td><%=prodInfoVO.getProdNo()%></td>
		<td><%=prodInfoVO.getRestaurantNo()%></td>
		<td><%=prodInfoVO.getProdCategoryNo()%></td>
		<td><%=prodInfoVO.getProdName()%></td>
		<td><%=prodInfoVO.getProdPrice()%></td>
		<td><%=prodInfoVO.getProdStock()%></td>
		<td><%=prodInfoVO.getProdDescription()%></td>
		<td><%=prodInfoVO.getProdContent()%></td>
		<td><%=prodInfoVO.getProdCommentQty()%></td>
		<td><%=prodInfoVO.getTotalCommentRating()%></td>
	</tr>
</table>

</body>
</html>