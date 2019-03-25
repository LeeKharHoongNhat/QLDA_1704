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
					<h4 class="card-title">Sửa</h4>
					<div class="content-header-right ">
						<div role="group" aria-label="Button group with nested dropdown"
							class="btn-group float-md-right " id="add-new"></div>

					</div>

					<form:form class="forms-sample" method="post"
						action="/vatlieu/update">
						<div class="form-group">
							<label for="exampleInputName1">Mã Công Việc</label>
							<form:input path="maCongViec" class="form-control" />
							<form:errors path="maCongViec" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInputName1">Số lượng</label>
							<form:input path="soLuong" class="form-control" />
							<form:errors path="soLuong" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInputName1">Đơn giá</label>
							<form:input path="donGia" class="form-control" />
							<form:errors path="donGia" cssStyle="color: red" />

						</div>
						<div class="form-group">
							<label for="exampleInputEmail3">Chi phí</label>
							<form:input path="chiPhi" class="form-control" />
							<form:errors path="chiPhi" cssStyle="color: red" />
							
						</div>
						<div class="form-group">
							<label for="exampleInputEmail3">Ghi chú</label>
							<form:input path="ghiChu" class="form-control" />
							<form:errors path="ghiChu" cssStyle="color: red" />
							
						</div>
						<button type="submit" class="btn btn-gradient-primary mr-2">Submit</button>
						<button class="btn btn-light" type="reset">Cancel</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />