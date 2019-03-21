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
					<h4 class="card-title">Sửa thông tin phòng ban</h4>
					<div class="content-header-right ">
						<div role="group" aria-label="Button group with nested dropdown"
							class="btn-group float-md-right "">
							<a href="<c:url value = "/phongban/${command.trangThai}&1"/>" class="btn btn-info"><span
								class="fa fa-plus"></span>Back</a>
						</div>

					</div>
					<form:form class="forms-sample" method="post"
						action="qlda/phongban/editsavephongban">
						<div class="form-group">
							<label for="exampleInputName1">Mã phòng ban</label>
							<form:input path="maPhongBan" class="form-control" />
							<form:errors path="maPhongBan" cssStyle="color: red" />
							<strong style="color: red;">${mess}</strong>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail3">Tên Phòng Ban</label>
							<form:input path="tenPhongBan" class="form-control" />
							<form:errors path="tenPhongBan" cssStyle="color: red" />
						</div>
						
						<div class="form-group">
							<label for="exampleInputEmail3">Trạng Thái</label>
							<form:select path="trangThai"
								class="custom-select block round" id="maTieuThuc" >
								<c:forEach items="${listTrangThai}" var="ltt">
									<form:option value="${ltt.maTieuThuc}" label="${ltt.tenTieuThuc}" />
								</c:forEach>
							</form:select> 
						</div>
						<button type="submit" class="btn btn-gradient-primary mr-2">Edit</button>
						<button class="btn btn-light" type="reset">Cancel</button>
					</form:form>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />