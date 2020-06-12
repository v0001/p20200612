<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 글쓰기</title>
	<link href = "${PageContext.request.contextPath}/resources/css/bootstrap.css" rel = "stylesheet"/>
</head>
<body>
	
	<div class = "container">
		<div style = "width:1000px; padding:20px ; border: 1px solid #cccccc;">
			<form action="/board/insert" method = "post" enctype="multipart/form-data">
				<div class = "form-inline" style = "margin:5px;">
					<label style = "width:100px">제목</label>
					<input type = "text" class = "form-control" name = "brd_title" placeholder="글제목"/><br/>
				</div>
				<div class = "form-inline" style = "margin:5px;">
					<label style = "width:100px">내용</label>
					<input type = "text" class = "form-control" name = "brd_content" placeholder="글내용"/><br/>
				</div>
				<div class = "form-inline" style = "margin:5px;">
					<label style = "width:100px">사용자 ID</label>
					<input type = "text" class = "form-control" name = "brd_id" value = "${userid}" readonly/><br/>
				</div>
				<div class = "form-inline" style = "margin:5px;">
					<label style = "width:100px">이미지</label>
					<input type = "file"  name = "imgs"/><br/>
				</div>
				
				<div class = "form-inline" style = "margin:5px;">
					<label style = "width:100px">등록 날짜</label>
					<input type = "date" class = "form-control" name = "brd_date"/><br/>
				</div> 
				
				<div class = "form-inline" style = "margin:5px;">
					<label style = "width:100px"></label>
					<input type = "submit" class = "btn btn-success" value = "등록" />&nbsp;
					<a href = "/" class = "btn btn-secondary">홈으로</a>
				</div>
			</form>
			</div>
			</div>
</body>
</html>