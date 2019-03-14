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
					<h4 class="card-title">Sửa thông tin tiêu thức</h4>
					<div class="content-header-right ">
						<div role="group" aria-label="Button group with nested dropdown"
							class="btn-group float-md-right "">
							<a href="<c:url value = "/tieuthuc/1"/>" class="btn btn-info"><span
								class="fa fa-plus"></span>Back</a>
						</div>

					</div>
					<form:form class="forms-sample" method="post"
						action="tieuthuc/editsavetieuthuc">
						<div class="form-group">
							<label for="exampleInputName1">Mã tiêu thức</label>
							<form:input path="maTieuThuc" class="form-control" />
							<form:errors path="maTieuThuc" cssStyle="color: red" />
							<strong style="color: red;">${mess}</strong>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail3">Tên tiêu thức</label>
							<form:input path="tenTieuThuc" class="form-control" />
							<form:errors path="tenTieuThuc" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInputEmail3">Mã cha</label>
							<form:input path="maCha" class="form-control" />
							<form:errors path="maCha" cssStyle="color: red" />
						</div>
						<button type="submit" class="btn btn-gradient-primary mr-2">Edit</button>
						<button class="btn btn-light" type="reset">Cancel</button>
					</form:form>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />