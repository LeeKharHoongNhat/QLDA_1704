<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Home</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- plugins:css -->
<link rel="stylesheet"
	href="<c:url value="/resources/vendors/iconfonts/mdi/css/materialdesignicons.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/vendors/css/vendor.bundle.base.css"/>">
<!-- endinject -->
<!-- inject:css -->
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/fullcalendar.css"/>">
<!-- endinject -->
<link rel="shortcut icon"
	href="<c:url value="/resources/images/favicon.png"/>" />


<!-- Timesheet -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/timesheet.css"/>">
<script type="text/javascript"
	src="<c:url value="/resources/js/timesheet.js"/>"></script>
<!-- <script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
 --><script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<!-- end Timesheet -->

<!-- <style type="text/css">
input {
	border: 1px solid #fff;
	margin: 0;
	font-size: 20px;
}

input:focus, input:active, input:hover {
	outline: 1px solid #eee;
	background-color: #eee;
}

select {
	border: 1px solid #fff;
	margin: 0;
	padding: 0;
	font-size: 20px;
	border: 0;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
}

table {
	border: 1px solid #999;
	border-collapse: collapse;
	border-spacing: 0;
}

table td {
	padding: 0;
	margin: 0;
	border: 1px solid #999;
}

table th {
	background-color: #aaa;
	min-width: 20px;
	border: 1px solid #999;
}
}
</style> -->

</head>
<body>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->
		<nav
			class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
			<div
				class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
				<a class="navbar-brand brand-logo" href="index.html"><img
					src="<c:url value="/resources/images/Joker.png"/>" alt="logo"
					/ style="height: 60px;"></a> <a
					class="navbar-brand brand-logo-mini" href="index.html"><img
					src="<c:url value="/resources/images/logo-mini.svg"/>" alt="logo" /></a>
			</div>
			<div class="navbar-menu-wrapper d-flex align-items-stretch">
				<div class="search-field d-none d-md-block">
					<form class="d-flex align-items-center h-100" action="#">
						<div class="input-group">
							<div class="input-group-prepend bg-transparent">
								<i class="input-group-text border-0 mdi mdi-magnify"></i>
							</div>
							<input type="text" class="form-control bg-transparent border-0"
								placeholder="Search projects">
						</div>
					</form>
				</div>
				<ul class="navbar-nav navbar-nav-right">
					<li class="nav-item nav-profile dropdown"><a
						class="nav-link dropdown-toggle" id="profileDropdown" href="#"
						data-toggle="dropdown" aria-expanded="false">
							<div class="nav-profile-img">
								<img
									src="<c:url value="/resources/images/faces/facezero.jpg" />"
									alt="image"> <span class="availability-status online"></span>
							</div>
							<div class="nav-profile-text">
								<p class="mb-1 text-black">Joker</p>
							</div>
					</a>
						<div class="dropdown-menu navbar-dropdown"
							aria-labelledby="profileDropdown">
							<a class="dropdown-item" href="#"> <i
								class="mdi mdi-cached mr-2 text-success"></i> Activity Log
							</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#"> <i
								class="mdi mdi-logout mr-2 text-primary"></i> Signout
							</a>
						</div></li>
					<li class="nav-item d-none d-lg-block full-screen-link"><a
						class="nav-link"> <i class="mdi mdi-fullscreen"
							id="fullscreen-button"></i>
					</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link count-indicator dropdown-toggle"
						id="messageDropdown" href="#" data-toggle="dropdown"
						aria-expanded="false"> <i class="mdi mdi-email-outline"></i> <span
							class="count-symbol bg-warning"></span>
					</a>
						<div
							class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
							aria-labelledby="messageDropdown">
							<h6 class="p-3 mb-0">Messages</h6>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item preview-item">
								<div class="preview-thumbnail">
									<img src="<c:url value="/resources/images/faces/face4.jpg"/>"
										alt="image" class="profile-pic">
								</div>
								<div
									class="preview-item-content d-flex align-items-start flex-column justify-content-center">
									<h6 class="preview-subject ellipsis mb-1 font-weight-normal">Mark
										send you a message</h6>
									<p class="text-gray mb-0">1 Minutes ago</p>
								</div>
							</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item preview-item">
								<div class="preview-thumbnail">
									<img src="<c:url value="/resources/images/faces/face2.jpg"/>"
										alt="image" class="profile-pic">
								</div>
								<div
									class="preview-item-content d-flex align-items-start flex-column justify-content-center">
									<h6 class="preview-subject ellipsis mb-1 font-weight-normal">Cregh
										send you a message</h6>
									<p class="text-gray mb-0">15 Minutes ago</p>
								</div>
							</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item preview-item">
								<div class="preview-thumbnail">
									<img src="<c:url value="/resources/images/faces/face3.jpg"/>"
										alt="image" class="profile-pic">
								</div>
								<div
									class="preview-item-content d-flex align-items-start flex-column justify-content-center">
									<h6 class="preview-subject ellipsis mb-1 font-weight-normal">Profile
										picture updated</h6>
									<p class="text-gray mb-0">18 Minutes ago</p>
								</div>
							</a>
							<div class="dropdown-divider"></div>
							<h6 class="p-3 mb-0 text-center">4 new messages</h6>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link count-indicator dropdown-toggle"
						id="notificationDropdown" href="#" data-toggle="dropdown"> <i
							class="mdi mdi-bell-outline"></i> <span
							class="count-symbol bg-danger"></span>
					</a>
						<div
							class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
							aria-labelledby="notificationDropdown">
							<h6 class="p-3 mb-0">Notifications</h6>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item preview-item">
								<div class="preview-thumbnail">
									<div class="preview-icon bg-success">
										<i class="mdi mdi-calendar"></i>
									</div>
								</div>
								<div
									class="preview-item-content d-flex align-items-start flex-column justify-content-center">
									<h6 class="preview-subject font-weight-normal mb-1">Event
										today</h6>
									<p class="text-gray ellipsis mb-0">Just a reminder that you
										have an event today</p>
								</div>
							</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item preview-item">
								<div class="preview-thumbnail">
									<div class="preview-icon bg-warning">
										<i class="mdi mdi-settings"></i>
									</div>
								</div>
								<div
									class="preview-item-content d-flex align-items-start flex-column justify-content-center">
									<h6 class="preview-subject font-weight-normal mb-1">Settings</h6>
									<p class="text-gray ellipsis mb-0">Update dashboard</p>
								</div>
							</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item preview-item">
								<div class="preview-thumbnail">
									<div class="preview-icon bg-info">
										<i class="mdi mdi-link-variant"></i>
									</div>
								</div>
								<div
									class="preview-item-content d-flex align-items-start flex-column justify-content-center">
									<h6 class="preview-subject font-weight-normal mb-1">Launch
										Admin</h6>
									<p class="text-gray ellipsis mb-0">New admin wow!</p>
								</div>
							</a>
							<div class="dropdown-divider"></div>
							<h6 class="p-3 mb-0 text-center">See all notifications</h6>
						</div></li>
					<li class="nav-item nav-logout d-none d-lg-block"><a
						class="nav-link" href="#"> <i class="mdi mdi-power"></i>
					</a></li>
					<li class="nav-item nav-settings d-none d-lg-block"><a
						class="nav-link" href="#"> <i
							class="mdi mdi-format-line-spacing"></i>
					</a></li>
				</ul>
				<button
					class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
					type="button" data-toggle="offcanvas">
					<span class="mdi mdi-menu"></span>
				</button>
			</div>
		</nav>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
				<ul class="nav">
					<li class="nav-item nav-profile"><a href="#" class="nav-link">
							<div class="nav-profile-image">
								<img
									src="<c:url value="/resources/images/faces/facezero.jpg" />"
									alt="profile"> <span class="login-status online"></span>
								<!--change to offline or busy as needed-->
							</div>
							<div class="nav-profile-text d-flex flex-column">
								<span class="font-weight-bold mb-2">Lê Khả Hồng Nhật</span> <span
									class="text-secondary text-small">Project Manager</span>
							</div> <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
					</a></li>

					<!-- start home  -->
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/"/>"> <span class="menu-title">Home</span>
							<i class="mdi mdi-home menu-icon"></i>
					</a></li>
					<!-- end home -->


					<!-- start phong ban  -->
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/phongban/TTPB1&1"/>"> <span
							class="menu-title">Phòng Ban</span> <i
							class="mdi mdi-contacts menu-icon"></i>
					</a></li>
					</li>
					<!-- end phong ban  -->

					<!-- start nhan vien  -->
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/nhanvien/1"/>"> <span class="menu-title">Nhân
								Viên</span> <i class="mdi mdi-contacts menu-icon"></i>
					</a></li>
					<!-- end nhan vien  -->
					<!-- start du an  -->
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/duan/TTDA1&1"/>"> <span
							class="menu-title">Dự Án</span> <i
							class="mdi mdi-contacts menu-icon"></i>
					</a></li>
					<!-- end du an -->
					<!-- start tieu thuc  -->
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/tieuthuc/1"/>"> <span class="menu-title">Tiêu
								thức</span> <i class="mdi mdi-format-list-bulleted menu-icon"></i>
					</a>
						<ul>
							<c:forEach var="emp" items="${listTieuThucCha}">
								<li>${emp.tenTieuThuc}</li>
							</c:forEach>

						</ul></li>
					<!-- end tieu thuc  -->


					<!-- start khach hang  -->
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/khachhang/1"/>"> <span class="menu-title">Khách
								Hàng</span> <i class="mdi mdi-contacts menu-icon"></i>
					</a></li>
					<!-- end khach hang  -->
					<!-- start nhat ky cong viec  -->
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/nhatkycongviec"/>"> <span
							class="menu-title">Nhật Ký Công Việc</span> <i
							class="mdi mdi-contacts menu-icon"></i>
					</a></li>
					<!-- end nhat ky cong viec  -->
				</ul>
			</nav>