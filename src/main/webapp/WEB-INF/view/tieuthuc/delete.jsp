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
					<h4 class="card-title">Xóa tiêu thức ?</h4>
					<form:form class="forms-sample" method="post" action="submitdeletetieuthuc">
						<div class="form-group">
							<label for="exampleInputName1">Mã tiêu thức: </label>
							<form:hidden path="maTieuThuc" class="form-control" />
							<strong>${command.maTieuThuc}</strong>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail3">Tên tiêu thức: </label>
							<form:hidden path="tenTieuThuc" class="form-control" />
							<strong>${command.tenTieuThuc}</strong>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail3">Mã cha: </label>
							<form:hidden path="maCha" class="form-control" />
							<strong>${command.maCha}</strong>
						</div>
						<button type="submit" class="btn btn-gradient-primary mr-2">Delete</button>
						<a href="<c:url value="/tieuthuc/1" />"><button type="button"
								class="btn btn-light">Cancel</button></a>
					</form:form>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />