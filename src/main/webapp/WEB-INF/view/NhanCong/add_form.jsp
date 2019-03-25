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
					<h4 class="card-title">Thêm Nhân Công</h4>
					<div class="content-header-right ">
						<div role="group" aria-label="Button group with nested dropdown"
							class="btn-group float-md-right " id="add-new"></div>

					</div>
					<form:form class="forms-sample" method="post" action="create"
						modelAttribute="nhancong">
						<div class="form-group">
							<label for="exampleInputName1">Mã Công Việc</label>
							<form:input path="maCongViec" class="form-control" />
							<form:errors path="maCongViec" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInputName1">Mã Nhân Viên</label>
							<form:errors path="maNhanVien" cssStyle="color: red" />
							<form:select path="maNhanVien" cssClass="form-control" mutiple="true">
								<c:forEach items="${choice}" var="nv">
									<option value="${nv.maNhanVien}">${nv.maNhanVien}</option>
								</c:forEach>
							</form:select>
						</div>
					
						<div class="form-group">
							<label for="exampleInputName1">Nội Dung</label>
							<form:input path="noiDung" class="form-control" />
							<form:errors path="noiDung" cssStyle="color: red" />

						</div>
						<div class="form-group">
							<label for="exampleInputEmail3">Thời Gian Bắt Đầu</label>
							<form:input type="date" path="thoiGianBatDau"
								class="form-control" />
							<form:errors path="thoiGianBatDau" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInputEmail3">Thời Gian Kết Thúc</label>
							<form:input type="date" path="thoiGianKetThuc"
								class="form-control"/>
							<form:errors path="thoiGianKetThuc" cssStyle="color: red" />
						</div>
						<div class="form-group">
							<label for="exampleInputName1">Chi Phí</label>
							<form:input path="chiPhi" class="form-control" />
							<form:errors path="chiPhi" cssStyle="color: red" />
						</div>

						<button type="submit" class="btn btn-gradient-primary mr-2">THÊM</button>
						<button class="btn btn-light" type="reset">HỦY</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />