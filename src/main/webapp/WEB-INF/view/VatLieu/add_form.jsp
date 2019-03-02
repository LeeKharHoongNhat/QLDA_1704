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
					<h4 class="card-title">Thêm Vật Liệu</h4>
					<div class="content-header-right ">
						<div role="group" aria-label="Button group with nested dropdown"
							class="btn-group float-md-right " id="add-new">
							<a href="<c:url value = "1"/>" class="btn btn-info"><span
								class="fa fa-plus"></span>Back</a>
						</div>

					</div>
					<form:form class="forms-sample" method="post" action="creat" modelAttribute="vatlieu">
						<div class="form-group">
							<label for="exampleInputName1">Mã Công Việc</label>
							<form:input path="maCongViec" class="form-control" />
							<form:errors path="maCongViec" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInputName1">Số Lượng</label>
							<form:input path="soLuong" class="form-control" />
							<form:errors path="soLuong" cssStyle="color: red" />
							<strong style="color: red;">${mess}</strong>
						</div>
						<div class="form-group">
							<label for="exampleInputName1">Đơn giá</label>
							<form:input path="donGia" class="form-control" />
							<form:errors path="donGia" cssStyle="color: red" />
							<strong style="color: red;">${mess}</strong>
						</div>
						<div class="form-group">
							<label for="exampleInputName1">Chi Phí</label>
							<form:input path="chiPhi" class="form-control" />
							<form:errors path="chiPhi" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInputName1">Ghi Chú</label>
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