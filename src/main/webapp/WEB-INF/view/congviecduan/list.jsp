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
						<h4 class="card-title">
							Danh Sách hạng mục công việc :<a
								href="<c:url value = "/duan/view/${tenDuAn.duAn.maDuAn }"/>"><strong
								style="color: red;">${tenDuAn.duAn.tenDuAn }</strong></a>

						</h4>
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
									<th>Công việc</th>
									<th>Nội dung</th>
									<th>Nhân viên</th>
									<th>Thời gian mở</th>
									<th>Thời gian đóng</th>
									<th>Tiến độ(%)</th>
									<th>Trạng thái</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="emp" items="${list}">
									<tr>
										<td>${emp.maCongViec}</td>
										<td>${emp.noiDung}</td>
										<td>${emp.nhanVien.hoTenNhanVien}</td>
										<td>${emp.thoiGianMo}</td>
										<td>${emp.thoiGianDong}</td>
										<td>10</td>
										<td>${emp.maTrangThai}</td>
										<td><a href="/congviecduan/edit/${emp.id}"
											class="btn btn-primary">edit</a> <a
											href="/congviecduan?id=${emp.id}" class="btn btn-primary">Check</a>
											</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>



		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />