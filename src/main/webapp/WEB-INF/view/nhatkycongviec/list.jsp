<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

.button-edit {
	padding-left: 45px;
	padding-right: 54px;
	margin-bottom: 10px;
	margin-right: 7px;
	margin-top: 10px;
}

.button-add {
	margin-bottom: 86px;
}

/* css table */
.table-responsive {
	padding-right: 1px;
}

.table-responsive {
	display: block;
	width: 100%;
	overflow-x: auto;
	-webkit-overflow-scrolling: touch;
	-ms-overflow-style: -ms-autohiding-scrollbar;
}

.table {
	margin: 0;
}

.table {
	width: 100%;
	max-width: 100%;
	margin-bottom: 1rem;
	background-color: transparent;
}

table {
	border-collapse: collapse;
}

.table-earning thead th {
	background: #333;
	font-size: 16px;
	color: #fff;
	vertical-align: middle;
	font-weight: 400;
	text-transform: capitalize;
	line-height: 1;
	padding: 20px 10px;
	white-space: nowrap;
	border: 1px solid #7d7e80 !important;
	text-align: center;
}

.table-earning tbody td {
	color: gray;
	padding: 20px 100px;
	white-space: nowrap;
	text-align: center;
}

.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fff;
}
</style>
<div class="main-panel">
	<div class="content-wrapper">
		<div class="page-header">
			<div class="col-lg-12 stretch-card">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Nhật Ký Công Việc</h4>
						<nav aria-label="Page navigation example"></nav>
						<div class="content-header-right "></div>
						<div class="table-responsive table--no-card m-b-30">
							<table
								class="table-bordered table table-borderless table-striped table-earning">
								<thead>
									<tr>
										<th>Tên Nhân Viên</th>
										<th>Nội Dung</th>
										<th>Thời Gian Đăng Tải</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="emp" items="${view}">
										<tr>
											<td>${emp.nhanVien.hoTenNhanVien}</td>
											<td>${emp.noiDung}</td>
											<td>${emp.thoiGianDangTai}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<form:form class="forms-sample" method="post"
								action="/nhatkicongviec/save">
								<div class="form-group">
									<label >Nội Dung</label>
									<input type="hidden" name="maNv" value="${maNv}" >
									<input type="hidden" name="maDuAn" >
									<textarea class="form-control" name="noiDung" rows="4"></textarea>
								</div>
								<button type="submit" class="btn btn-gradient-primary mr-2">Thêm</button>
								<a href="<c:url value="/nhatkycongviec"> </c:url> "
									class="btn btn-light">Hủy</a>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />