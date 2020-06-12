<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>물품일괄등록</title>
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"	rel="stylesheet"/>
</head>

<body>
	<div class="container">
		<form action = "/board/insertbatch" method = "post">
		<table class="table table-sm">
		작성자 : <input type = "text" name = "userid" value = "${userid}" readonly/>
		
			<c:forEach var="i" begin="1" end="2" step="1">
			<tr>
				<td><input type="text" name="title[]" placeholder="제목" /></td>
				<td><input type="text" name="content[]" placeholder="내용"  /></td>
			</tr>
			</c:forEach>
		</table>
		<input type="submit" class="btn btn-success" value="일괄추가" />
		</form>
	</div>

	<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>

				<c:forEach var="i" begin="1" end="${cnt}" step="1">
				<li class="page-item"><a class="page-link" href="/board/list?page=${i}">${i}</a></li>
				</c:forEach>
				
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>

</body>
</html>
