<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.bookingtraveltour.dto.*"%>

<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=utf-8" />
<title>Admin template</title>
</head>
<body>
	<c:url var="varTemp" value="/admin/addCustomer" />


	<a href="${varTemp }">Thêm Thông Tin Khách Hàng</a>
	<br />
	<table border="1">
		<thead>
			<tr>
				<th>Họ và Tên</th>
				<th>Email</th>
				<th>Số Điện Thoại</th>
				<th>Tên Tài Khoản</th>
				<th>Vai Trò</th>
				<th>Trạng Thái</th>
				<th>Hành Động</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${viewWithList }">
				<c:url var="edit" value="/admin/editCustomer">
					<c:param name="customerId" value="${list.id}" />
				</c:url>

				<tr>
					<td>${list.fullname }</td>
					<td>${list.email }</td>
					<td>${list.phoneNumber }</td>
					<td>${list.username }</td>
					<td>${list.role_name }</td>


					<td><c:choose>
							<c:when test="${list.status }">Đang Hoạt Động </c:when>
							<c:otherwise> Đã Khóa </c:otherwise>
						</c:choose></td>
					<td><a href="${edit}" />Edit</td>

				</tr>
			</c:forEach>
			<br />

			<c:forEach var="c" begin="1" end="${endPage }">
				<c:url var="tempLink" value="${contextPath}/admin">
					<c:param name="index" value="${c}" />
				</c:url>
				<a href="${tempLink }"> ${c}</a>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>