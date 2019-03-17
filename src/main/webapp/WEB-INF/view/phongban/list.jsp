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
						<h4 class="card-title">Danh Sách Phòng Ban</h4>
						<nav aria-label="Page navigation example">
							<ul class="pagination">

								<c:if test="${indexPage > 1}">
									<li class="page-item"><a href="/phongban/${trangThai}&1"
										class="page-link">First</a></li>
								</c:if>


								<c:if test="${indexPage > 1}">
									<li class="page-item"><a
										href="/phongban/${trangThai}&${indexPage-1}" class="page-link">${indexPage-1}</a></li>
								</c:if>


								<li class="page-item"><a
									href="/phongban/${trangThai}&${indexPage}" class="page-link">${indexPage}</a></li>


								<c:if test="${indexPage < allPage}">
									<li class="page-item"><a
										href="/phongban/${trangThai}&${indexPage+1}" class="page-link">${indexPage+1}</a></li>
								</c:if>

								<c:if test="${indexPage < allPage}">
									<li class="page-item"><a
										href="/phongban/${trangThai}&${allPage}" class="page-link">Last</a></li>
								</c:if>

							</ul>
						</nav>
						<div class="content-header-right ">
							<div role="group" aria-label="Button group with nested dropdown"
								class="btn-group float-md-right " id="add-new">
								<a href="<c:url value = "addphongban"/>" class="btn btn-info"><span
									class="fa fa-plus"></span> Add new</a>
							</div>
							<div role="group" aria-label="Button group with nested dropdown"
								class="btn-group float-md-right " id="add-new"
								style="margin-bottom: 10px; float: left !important">
								<a href="<c:url value = "/phongban/TTPB1&1"/>" class="btn btn-gradient-dark btn-rounded btn-fw"><span
									class="fa fa-plus" style="margin :5px;"></span> Hoạt động</a>
									<a href="<c:url value = "/phongban/TTPB2&1"/>" class="btn btn-gradient-dark btn-rounded btn-fw"><span
									class="fa fa-plus" style="margin :5px;"></span> nghỉ</a>
								<%-- <h4 style="margin-top: 20px;" class="text-success">${msg != null ? msg : ''}
									delete success!</h4> --%>
							</div>
						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Mã phòng ban</th>
									<th>Tên phòng ban</th>
									<th>Trạng Thái</th>
									<th>action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="emp" items="${list}">
									<tr>
										<td>${emp.maPhongBan}</td>
										<td>${emp.tenPhongBan}</td>
										<td>${emp.ttTrangThai.tenTieuThuc}</td>
										<td><a href="/phongban/editphongban/${emp.maPhongBan}"
											class="btn btn-primary">edit</a></td>
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