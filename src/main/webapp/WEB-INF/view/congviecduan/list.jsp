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
						<h4 class="card-title">Danh Sách hạng mục công việc</h4>
						<nav aria-label="Page navigation example"></nav>
						<div class="content-header-right ">
							<div role="group" aria-label="Button group with nested dropdown"
								class="btn-group float-md-right " id="add-new">
								<a href="<c:url value = "add/${maDuAn }"/>" class="btn btn-info"><span
									class="fa fa-plus"></span> Add New</a>
							</div>

						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Dự án</th>
									<th>Công việc</th>
									<th>Nội dung</th>
									<th>Mã cha</th>
									<th>Nhân viên</th>
									<th>Ngày bắt đầu dự kiến</th>
									<th>Ngày kết thúc dự kiến</th>
									<th>Ngày bắt đầu thực tế</th>
									<th>Ngày kết thúc thực tế</th>
									<th>Trạng thái</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="emp" items="${list}">
									<tr>
										<td>${emp.maDuAn}</td>
										<td>${emp.maCongViec}</td>
										<td>${emp.noiDung}</td>
										<td>${emp.maCha}</td>
										<td>${emp.maNhanVien}</td>
										<td>${emp.ngayBatDauDuKien}</td>
										<td>${emp.ngayKetThucDuKien}</td>
										<td>${emp.ngayBatDauThucTe}</td>
										<td>${emp.ngayKetThucThucTe}</td>
										<td>${emp.maTrangThai}</td>
										<td><a href="/congviecduan/edit/${emp.maCongViec}"
											class="btn btn-primary">edit</a> <a
											href="/congviecduan/remove/${emp.maCongViec}"
											class="btn btn-danger">delete</a>
											<a
											href="/thietbi/viewOneThietBi/${emp.maCongViec}"
											class="btn btn-danger">Thiết Bị</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>



		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />