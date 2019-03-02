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
						<h4 class="card-title">Danh Sách Nhân Viên</h4>
						<nav aria-label="Page navigation example">
							<ul class="pagination">

								<c:if test="${indexPage > 1}">
									<li class="page-item"><a href="/nhanvien/1"
										class="page-link">First</a></li>
								</c:if>


								<c:if test="${indexPage > 1}">
									<li class="page-item"><a href="/nhanvien/${indexPage-1}"
										class="page-link">${indexPage-1}</a></li>
								</c:if>


								<li class="page-item"><a href="/nhanvien/${indexPage}"
									class="page-link">${indexPage}</a></li>


								<c:if test="${indexPage < allPage}">
									<li class="page-item"><a href="/nhanvien/${indexPage+1}"
										class="page-link">${indexPage+1}</a></li>
								</c:if>

								<c:if test="${indexPage < allPage}">
									<li class="page-item"><a href="/nhanvien/${allPage}"
										class="page-link">Last</a></li>
								</c:if>

							</ul>
						</nav>
						<div class="content-header-right ">
							<div role="group" aria-label="Button group with nested dropdown"
								class="btn-group float-md-right " id="add-new">
								<a href="<c:url value = "addnhanvien"/>" class="btn btn-info"><span
									class="fa fa-plus"></span> Add new</a>
							</div>

						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Mã nhân viên</th>
									<th>Tên nhân viên</th>
									<th>Ảnh</th>
									<th>Phòng Ban</th>
									<th>Chức danh</th>
									<th>Loại hợp đồng</th>
									<th>Trạng thái</th>
									<th>action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="emp" items="${list}">
									<tr>
										<td>${emp.maNhanVien}</td>
										<td>${emp.hoTenNhanVien}</td>
										<td>${emp.hinhAnh}</td>
										<td>${emp.maPhongBan}</td>
										<td>${emp.maChucDanh}</td>
										<td>${emp.maLoaiHopDong}</td>
										<td>${emp.maTrangThai}</td>
										<td><a href="/nhanvien/editnhanvien/${emp.maNhanVien}"
											class="btn btn-primary">edit</a> <a
											href="/nhanvien/deletenhanvien/${emp.maNhanVien}"
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