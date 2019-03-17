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
						<h4 class="card-title">Danh Sách Dự Án</h4>
						<nav aria-label="Page navigation example">
							<ul class="pagination">

								<c:if test="${indexPage > 1}">
									<li class="page-item"><a href="/duan/${trangThai}&1"
										class="page-link">First</a></li>
								</c:if>


								<c:if test="${indexPage > 1}">
									<li class="page-item"><a
										href="/duan/${trangThai}&${indexPage-1}" class="page-link">${indexPage-1}</a></li>
								</c:if>


								<li class="page-item"><a
									href="/duan/${trangThai}&${indexPage}" class="page-link">${indexPage}</a></li>


								<c:if test="${indexPage < allPage}">
									<li class="page-item"><a
										href="/duan/${trangThai}&${indexPage+1}" class="page-link">${indexPage+1}</a></li>
								</c:if>

								<c:if test="${indexPage < allPage}">
									<li class="page-item"><a
										href="/duan/${trangThai}&${allPage}" class="page-link">Last</a></li>
								</c:if>

							</ul>
						</nav>
						<div class="content-header-right ">
							<div role="group" aria-label="Button group with nested dropdown"
								class="btn-group float-md-right " id="add-new">
								<a href="<c:url value = "addduan"/>" class="btn btn-info"><span
									class="fa fa-plus"></span> Add new</a>
							</div>
							<div role="group" aria-label="Button group with nested dropdown"
								class="btn-group float-md-right " id="add-new"
								style="margin-bottom: 10px; float: left !important">
								<a href="<c:url value = "/duan/TTDA1&1"/>"
									class="btn btn-gradient-dark btn-rounded btn-fw"><span
									class="fa fa-plus" style="margin: 5px;"></span> Đang Chạy</a> <a
									href="<c:url value = "/duan/TTDA2&1"/>"
									class="btn btn-gradient-dark btn-rounded btn-fw"><span
									class="fa fa-plus" style="margin: 5px;"></span> Test</a> <a
									href="<c:url value = "/duan/TTDA3&1"/>"
									class="btn btn-gradient-dark btn-rounded btn-fw"><span
									class="fa fa-plus" style="margin: 5px;"></span> Chờ Bàn Giao</a> <a
									href="<c:url value = "/duan/TTDA4&1"/>"
									class="btn btn-gradient-dark btn-rounded btn-fw"><span
									class="fa fa-plus" style="margin: 5px;"></span>Đã Bàn Giao </a>
								<%-- <h4 style="margin-top: 20px;" class="text-success">${msg != null ? msg : ''}
									delete success!</h4> --%>
							</div>
						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Mã dự án</th>
									<th>Tên dự án</th>
									<th>Khách hàng</th>
									<th>Phòng ban</th>
									<th>PM</th>
									<th>Trạng thái</th>
									<th>action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="emp" items="${list}">
									<tr>
										<td>${emp.maDuAn}</td>
										<td>${emp.tenDuAn}</td>
										<td>${emp.khachHang.tenKhachHang}</td>
										<td>${emp.phongBan.tenPhongBan}</td>
										<td>${emp.nhanVienPm.hoTenNhanVien}</td>
										<td>${emp.trangThai.tenTieuThuc}</td>
										<td>
										<a href="/duan/view/${emp.maDuAn}"
											class="btn btn-warning">Chi Tiết</a>
										<a href="/duan/editduan/${emp.maDuAn}"
											class="btn btn-primary">edit</a>
											</td>
									</tr>
								</c:forEach>
								<!-- The Modal -->

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>



		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />