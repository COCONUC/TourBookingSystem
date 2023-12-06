<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Customer</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<c:url var="save" value="/admin/editCustomer" />
	<c:url var="back" value="/admin" />
	<h1>EDIT</h1>
	<div>

		<form action="${save }" method="POST">
			<input type="hidden" name="user_id" value="${customerInfor.id}">
			<div class="row-12">

				<div class="col-6">
					<label>Họ và Tên</label> <input type="text" class="form-control"
						value="${customerInfor.fullname }" name="fullname"> <br>
				</div>
				<div class="col-6">
					<label>Phone Number</label> <input type="text" class="form-control"
						value="${customerInfor.phoneNumber }" name="phoneNumber">
					<br>
				</div>
			</div>
			<div class="row-12">
				<div class="col-6">
					<label>Address</label> <input type="text" class="form-control"
						value="${customerInfor.address }" name="address"> <br>
				</div>
				<div class="col-6">
					<label>Vai trò</label> <select name="role">
						<c:forEach var="list" items="${roleList }">
							<option value="${list.id }">${list.role_name }</option>

						</c:forEach>
					</select>


				</div>
			</div>
			<input type="submit" value="Save"> <br> <a
				href="${back }">Quay Lại</a>
		</form>
		<br>
		<!-- <button type="button" class="btn btn-secondary">Đóng</button> -->


	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>