<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
.container {
	border: 0px solid #dedede;
	background-color: #f1f1f1;
	border-radius: 30px;
	padding: 10px;
	margin: 10px 0;
}

.darker {
	border-color: #ccc;
	background-color: #dfe4e8;
}

.container::after {
	content: "";
	clear: both;
	display: table;
}

.container img {
	float: left;
	max-width: 60px;
	width: 100%;
	margin-right: 20px;
	border-radius: 50%;
}

.container img.right {
	float: right;
	margin-left: 20px;
	margin-right: 0;
}

.time-right {
	float: right;
	color: #aaa;
}

.time-left {
	float: left;
	color: #999;
}

.content {
	float: right;
}
}
</style>

<c:forEach var="emp" items="${nhatkys}">
	<div class="container darker">
		<img src="/resources/images/logo.png" alt="Avatar"
			style="width: 100%;">
		<div class="content">
			<h4>${emp.nhanVien.hoTenNhanVien}</h4>
			<s:eval
				expression="T(com.ffse1704.common.Utils).formatDateTime(emp.thoiGianDangTai)"
				var="postingtime" />
			<span class="time-left">${postingtime}</span>
		</div>
		<p>${emp.noiDung}</p>
	</div>
</c:forEach>