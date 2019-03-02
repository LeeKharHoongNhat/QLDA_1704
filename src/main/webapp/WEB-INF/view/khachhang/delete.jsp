<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="main-panel">
	<div class="content-wrapper">
		<div class="col-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">Xóa tông tin khách hàng ?</h4>
					<form:form class="forms-sample" method="post"
						action="submitdeletekhachhang">
						<div class="form-group">
							<label for="exampleInputName1">Mã khách hàng</label>
							<form:input path="maKhachHang" class="form-control" />
							<form:errors path="maKhachHang" cssStyle="color: red" />
							<strong style="color: red;">${mess}</strong>
						</div>
						<div class="form-group">
							<label for="exampleInputName2">Tên khách hàng</label>
							<form:input path="tenKhachHang" class="form-control" />
							<form:errors path="tenKhachHang" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInput3">Địa chỉ</label>
							<form:input path="diaChi" class="form-control" />
							<form:errors path="diaChi" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInput4">Số điện thoại</label>
							<form:input path="soDienThoai" class="form-control" />
							<form:errors path="soDienThoai" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInput5">Email</label>
							<form:input path="email" class="form-control" />
							<form:errors path="email" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInput6">Mã số thuế</label>
							<form:input path="maSoThue" class="form-control" />
							<form:errors path="maSoThue" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInput7">Só tài khoản</label>
							<form:input path="soTaiKhoan" class="form-control" />
							<form:errors path="soTaiKhoan" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInput8">Ghi chú</label>
							<textarea class="form-control" id="exampleTextarea1" rows="4"></textarea>
						</div>
						<button type="submit" class="btn btn-gradient-primary mr-2">Delete</button>
						<a href="<c:url value="/khachhang/1" />"><button type="button"
								class="btn btn-light">Cancel</button></a>
					</form:form>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />