<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
</head>

<body>
	<c:url var="tempLink" value="/admin" />

	<h2>Thêm Thông Tin Người Dùng</h2>

	<form action="${tempLink}/addCustomer" method="POST">
		<label for="lname">Họ và Tên:</label><br> <input type="text"
			name="fullname"><br> <br> <label for="lname">Số
			Điện Thoại</label><br> <input type="text" name="phoneNumber"><br>
		<br> <label for="lname">Email</label><br> <input type="text"
			name="email"><br> <br> <label for="lname">Địa
			Chỉ</label><br> <input type="text" name="address"><br> <br>
		<label for="lname">Tên Tài Khoản</label><br> <input type="text"
			name="username"><br> <br> <label for="lname">Mật
			Khẩu</label><br> <input type="text" name="password"><br> <br>
		<label for="lname">Vai Trò</label><br> <select name="role">
			<option value="1">Admin</option>
			<option value="2">Customer</option>
		</select> <br> <input type="submit" value="Submit"><br> <a
			href="${tempLink }">Quay Lại</a>
	</form>
</body>
</html>