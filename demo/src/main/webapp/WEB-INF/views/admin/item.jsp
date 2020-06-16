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
		
		<form action="/admin/item" method="post">
		<a href="/admin/iteminsert" class="btn btn-success">일괄추가</a>
		<input type = "submit" name = "btn" class = "btn btn-success" value = "일괄수정"/>
		<input type = "submit" name = "btn" class = "btn btn-success" value = "일괄삭제"/>
		
		<table class = "table table-sm">

			<thead>
				<tr>
					<th><input type = "checkbox" />번호 </th>
					<th>상품이름 </th>
					<th>상품가격</th>
					<th>수량</th>
					<th>상품설명</th>
					<th>날짜 </th>
					<th>비고 </th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="tmp" items="${list}">
				<tr>
					<td><input type="checkbox" name="chk[]" value="${tmp.itemno}" /></td>
					<td class = "tditemno">${tmp.itemno}</td>
					<td>${tmp.itemname}</td>
					<td>${tmp.itemprice}</td>
					<td>${tmp.itemqty}</td>
					<td>${tmp.itemdes}</td>
					<td>${tmp.itemdate}</td>
					<td>
						<a href="#" class="btn btn-sm btn-danger mydeletebtn">삭제</a>
						<a href="#" class="btn btn-sm btn-primary myupdatebtn">수정</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>							
		</table>
	</div>
	
		<div class="modal" tabindex="-1" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Modal title</h5>
						<button type="button" class="close"
							data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<input type = "text" class = "form-control"	placeholder = "물품번호"/>	
						<input type = "text" class = "form-control"	placeholder = "물품명"/>
						<input type = "text" class = "form-control"	placeholder = "가격"/>
						<input type = "text" class = "form-control"	placeholder = "재고수량"/>
						<textarea rows = "6" class = "form-control"	placeholder = "내용"/></textarea>			
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">
							Close
						</button>
						<button type="button" class="btn btn-primary">
							Save changes
						</button>
					</div>
				</div>
			</div>
		</div>

	<script src = "${pageContext.request.contextPath}/resources/js/jquery-3.5.1.min.js" type = "text/javascript"></script>
	<script src = "${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type = "text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	
	<script type = "text/javascript">
		//jquery 라이브러리 사용 시작
		$(function(){
			$('.myupdatebtn').click(function(){
				//class가 modal인 것을 찾아서 화면에 표시
				$('.modal').modal('show');
				})
			$('.mydeletebtn').click(function(){
				var idx = $(this).index('.mydeletebtn');
				var no = $('.tditemno').eq(idx).text();

				Swal.fire({
					  title: '삭제 확인',
					  text: "삭제 하시겠습니까?",
					  icon: 'warning',
					  showCancelButton: true,
					  confirmButtonColor: '#3085d6',
					  cancelButtonColor: '#d33',
					  confirmButtonText: 'Yes, delete it!'
					}).then((result) => {
					  if (result.value) {
						  window.location.href = "/admin/itemdeleteone?no=" + no;

					  }
					})
				
				
/* 				var result = confirm('삭제하시겠습니까?');				
				if(result){
					window.location.href = "/admin/itemdelteone?no=" +no;
					} */

			});
		});
	</script>
</body>
</html>