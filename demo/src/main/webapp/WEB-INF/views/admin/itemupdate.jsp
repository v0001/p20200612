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
		<h4>선택된 목록</h4>
		
		<form action="/admin/itemupdate" method="post">
		<input type="submit" class="btn btn-success" value="일괄수정" />
		
		<table class="table table-sm">
			<thead>
				<tr>
					<th>상품번호 </th>
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
					<td>${tmp.itemno}<input type = "hidden"  name = "no[]" value = "${tmp.itemno}"></td>
					<td><input type = "text" name = "name[]" value = "${tmp.itemname}"/></td>
					<td><input type = "text" name = "price[]" value = "${tmp.itemprice}"/></td>
					<td><input type = "text" name = "qty[]" value = "${tmp.itemqty}"/></td>
					<td><input type = "text" name = "des[]" value = "${tmp.itemdes}"/></td>
					<td>${tmp.itemdate}</td>
				</tr>
				</c:forEach>
			</tbody>							
		</table>
		</form>
		
	</div>
</body>
</html>