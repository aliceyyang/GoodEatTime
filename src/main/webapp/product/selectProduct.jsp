<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>GoodEatTime Product | Home </title>
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
<body bgcolor="white">
	
	<table id="table-1">
	   <tr><td><h3>GoodEatTime Product | Home </h3><h4>( Practice )</h4></td></tr>
	</table>
	
	<p>此為產品管理的後台首頁</p>
	
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
	  <li>
	  <FORM METHOD="post" ACTION="ProdInfoController" >
	        <input type="hidden" name="action" value="getAll">
	        <input type="submit" value="List all Products.">
	    </FORM> 
	  <br><br></li>
	  
	  
	  <li>
	    <FORM METHOD="post" ACTION="ProdInfoController" >
	        <b>輸入產品編號 (如 1):</b>
	        <input type="text" name="prodNo">
	        <input type="hidden" name="action" value="getOne_For_Display">
	        <input type="submit" value="送出">
	    </FORM>
	  </li>
	
	  <jsp:useBean id="prodInfoService" scope="page" class="product.service.ProdInfoService" />
	   
	  <li>
	     <FORM METHOD="post" ACTION="ProdInfoController" >
	       <b>選擇產品編號:</b>
	       <select size="1" name="prodNo">
	         <c:forEach var="productInfoVO" items="${prodInfoService.all}" > 
	          <option value="${productInfoVO.prodNo}">${productInfoVO.prodNo}
	         </c:forEach>   
	       </select>
	       <input type="hidden" name="action" value="getOne_For_Display">
	       <input type="submit" value="送出">
	    </FORM>
	  </li>
	  
	  <jsp:useBean id="prodCategoryService" scope="page" class="product.service.ProdCategoryService" />
	  
	  <li>
	     <FORM METHOD="post" ACTION="ProdInfoController" >
	       <b>選擇產品類別:</b>
	       <select size="1" name="prodCategoryNo">
	         <c:forEach var="prodCategoryVO" items="${prodCategoryService.all}" > 
	          <option value="${prodCategoryVO.prodCategoryNo}">${prodCategoryVO.prodCategory}
	         </c:forEach>   
	       </select>
	       <input type="hidden" name="action" value="get_FromProdCategory">
	       <input type="submit" value="送出">
	     </FORM>
	  </li>
	</ul>
	
	
	
	<h3>產品管理</h3>
	
	<ul>
	  <li><a href='addProduct.jsp'>Add</a> a new Product</li>
	</ul>
	
	 
</body>
</html>