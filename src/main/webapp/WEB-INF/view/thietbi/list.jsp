<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="main-panel">
	<div class="content-wrapper">
		<div class="page-header">
			<div class="col-lg-12 stretch-card">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Danh Sách Thiết Bị</h4>
						<nav aria-label="Page navigation example"></nav>
						<div class="content-header-right ">
							<div role="group" aria-label="Button group with nested dropdown"
								class="btn-group float-md-right " id="add-new">
								<a href="<c:url value = "add/${maCV }"/>" class="btn btn-info"><span
									class="fa fa-plus"></span> Add New</a>
							</div>

						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Mã Công Việc</th>
									<th>Tên Thiết Bị</th>
									<th>Thời Gian Bắt Đầu Thuê Mượn</th>
									<th>Thời Gian Kết Thúc Thuê Mượn</th>
									<th>Ghi Chú</th>
									<th>Đơn Giá</th>
									<th>Chi Phí</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="emp" items="${viewOne}">
									<tr>
										<td>${emp.maCongViec}</td>
										<td>${emp.tenThietBi}</td>
										<td>${emp.thoiGianBatDauThueMuon}</td>
										<td>${emp.thoiGianKetThucThueMuon}</td>
										<td>${emp.ghiChu}</td>
										<td>${emp.donGia}</td>
										<td>${emp.chiPhi}</td>
										<td><a href="/thietbi/viewOneThietBi/edit/${emp.id}"
											class="btn btn-primary">edit</a> <a
											href="/thietbi/viewOneThietBi/remove/${emp.id}"
											class="btn btn-danger">delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>



		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />