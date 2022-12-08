<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Test_ProdOrder</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>ProdOrder: Home</h3><h4>( TEST )</h4></td></tr>
</table>

<p>This is the Home page for GoodEatTime: select_ProdOrder</p>

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
  <li><a href='getallProdOrder.jsp'>List</a> all ProdOrders.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="ProdOrderServlet" >
        <b>輸入訂單編號 (如1):</b>
        <input type="text" name="prodOrderNo">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="prodOrderService" scope="page" class="com.tibame.tga104.order.service.ProdOrderService" />
   
  <li>
     <FORM METHOD="post" ACTION="ProdOrderServlet" >
       <b>選擇訂單編號:</b>
       <select size="1" name="prodOrderNo">
         <c:forEach var="prodOrderVO" items="${prodOrderService.all}" > 
          <option value="${prodOrderVO.prodOrderNo}">${prodOrderVO.prodOrderNo}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>

</ul>


<h3>員工管理</h3>

<ul>
  <li><a href='addProdOrder.jsp'>Add</a> a new ProdOrder.</li>
</ul>

</body>
</html>