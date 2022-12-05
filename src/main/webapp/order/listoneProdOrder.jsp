<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="order.service.*"%>
<%@ page import="order.vo.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	ProdOrderVO prodOrderVO = (ProdOrderVO) request.getAttribute("prodOrderVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>訂單資料 - listOneEmp.jsp</title>

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
	width: 600px;
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
		 <h3>訂單資料 - ListOneEmp.jsp</h3>
		 <h4><a href="selectProdOrder.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>商城訂單編號</th>
		<th>會員編號</th>
		<th>餐廳編號</th>
		<th>優惠券編號</th>
		<th>訂單狀態</th>
		<th>訂單時間</th>
		<th>收貨時間</th>
		<th>出貨時間</th>
		<th>運費</th>
		<th>訂單原始金額</th>
		<th>訂單折扣後金額</th>
		<th>紅利點數</th>
		<th>收貨人姓名</th>
		<th>收貨人電話</th>
		<th>收貨人MAIL</th>
		<th>收貨地址</th>
		<th>發票號碼</th>
		<th>統一編號</th>
	</tr>
	<tr>
		<td><%=prodOrderVO.getProdOrderNo()%></td>
		<td><%=prodOrderVO.getMemberNo()%></td>
		<td><%=prodOrderVO.getRestaurantNo()%></td>
		<td><%=prodOrderVO.getCouponNo()%></td>
		<td><%=prodOrderVO.getOrderStatus()%></td>
		<td><%=prodOrderVO.getProdOrderDate()%></td>
		<td><%=prodOrderVO.getProdOrderReveiveTime()%></td>
		<td><%=prodOrderVO.getProdOderDeliverTime()%></td>
		<td><%=prodOrderVO.getDeliverFee()%></td>
		<td><%=prodOrderVO.getAmountBeforeCoupon()%></td>
		<td><%=prodOrderVO.getAmountAfterCoupon()%></td>
		<td><%=prodOrderVO.getProdOrderPoint()%></td>
		<td><%=prodOrderVO.getProdOrderReceiverName()%></td>
		<td><%=prodOrderVO.getProdOrderReceiverTel()%></td>
		<td><%=prodOrderVO.getProdOrderReceiverMail()%></td>
		<td><%=prodOrderVO.getProdOrderReceiverAddress()%></td>
		<td><%=prodOrderVO.getInvoiceNumber()%></td>
		<td><%=prodOrderVO.getTaxIDNumber()%></td>
	</tr>
</table>

</body>
</html>