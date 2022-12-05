<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="order.service.*"%>
<%@ page import="order.vo.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	ProdOrderService prodOrderService = new ProdOrderService();
	List<ProdOrderVO> list = prodOrderService.getAll();
	pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>所有訂單資料 - getallProdOrder.jsp</title>

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
		<tr>
			<td>
				<h3>所有訂單資料 - getallProdOrder.jsp</h3>
				<h4>
					<a href="selectProdOrder.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
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
		<%@ include file="page1.file"%>
		<c:forEach var="prodOrderVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${prodOrderVO.prodOrderNo}</td>
				<td>${prodOrderVO.memberNo}</td>
				<td>${prodOrderVO.restaurantNo}</td>
				<td>${prodOrderVO.couponNo}</td>
				<td>${prodOrderVO.orderStatus}</td>
				<td>${prodOrderVO.prodOrderDate}</td>
				<td>${prodOrderVO.prodOrderReveiveTime}</td>
				<td>${prodOrderVO.prodOderDeliverTime}</td>
				<td>${prodOrderVO.deliverFee}</td>
				<td>${prodOrderVO.amountBeforeCoupon}</td>
				<td>${prodOrderVO.amountAfterCoupon}</td>
				<td>${prodOrderVO.prodOrderPoint}</td>
				<td>${prodOrderVO.prodOrderReceiverName}</td>
				<td>${prodOrderVO.prodOrderReceiverTel}</td>
				<td>${prodOrderVO.prodOrderReceiverMail}</td>
				<td>${prodOrderVO.prodOrderReceiverAddress}</td>
				<td>${prodOrderVO.invoiceNumber}</td>
				<td>${prodOrderVO.taxIDNumber}</td>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>