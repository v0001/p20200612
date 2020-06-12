<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>상품 목록</title>
	<link href = "${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"/>
</head>
<body>
	<div class = "container">
		<h4>상품 목록</h4>
		
		<table class = "table">
			<thead>
				<tr>
					<th>번호 </th>
					<th>상품이름 </th>
					<th>상품가격</th>
					<th>수량</th>
					<th>상품설명</th>
					<th>날짜 </th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="tmp" items="${list}">
				<tr>
					<td>${tmp.itemno}</td>
					<td>${tmp.itemname}</td>
					<td>${tmp.itemprice}</td>
					<td>${tmp.itemqty}</td>
					<td>${tmp.itemdes}</td>
					<td>${tmp.itemdate}</td>
				</tr>
				</c:forEach>
			</tbody>							
		</table>
		
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>

				<c:forEach var="i" begin="1" end="${cnt}" step="1">
				<li class="page-item"><a class="page-link" href="/board/list?page=${i}">${i}</a></li>
				</c:forEach>
				
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>
	</div>
	
	
	
</body>
</html>