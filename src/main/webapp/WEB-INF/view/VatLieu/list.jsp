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
						<h4 class="card-title">Danh Sách Vật Liệu</h4>
						<nav aria-label="Page navigation example">
							<ul class="pagination">

								<c:if test="${indexPage > 1}">
									<li class="page-item"><a href="/vatlieu/1"
										class="page-link">First</a></li>
								</c:if>


								<c:if test="${indexPage > 1}">
									<li class="page-item"><a href="/vatlieu/${indexPage-1}"
										class="page-link">${indexPage-1}</a></li>
								</c:if>


								<li class="page-item"><a href="/vatlieu/${indexPage}"
									class="page-link">${indexPage}</a></li>


								<c:if test="${indexPage < allPage}">
									<li class="page-item"><a href="/vatlieu/${indexPage+1}"
										class="page-link">${indexPage+1}</a></li>
								</c:if>

								<c:if test="${indexPage < allPage}">
									<li class="page-item"><a href="/vatlieu/${allPage}"
										class="page-link">Last</a></li>
								</c:if>

							</ul>
						</nav>
						<div class="content-header-right ">
							<div role="group" aria-label="Button group with nested dropdown"
								class="btn-group float-md-right " id="add-new">
								<a href="<c:url value = "add_form"/>" class="btn btn-info"><span
									class="fa fa-plus"></span> Add new</a>
							</div>

						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Mã công việc</th>
									<th>Số lượng</th>
									<th>đơn giá</th>
									<th>Chi phí</th>
									<th>Ghi chú</th>
									<th>action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="emp" items="${list}">
									<tr>
										<td>${emp.maCongViec}</td>
										<td>${emp.soLuong}</td>
										<td>${emp.donGia}</td>
										<td>${emp.chiPhi}</td>
										<td>${emp.ghiChu}</td>

										<td><a href="/vatlieu/editvatlieu/${emp.maCongViec}"
											class="btn btn-primary">edit</a> <a
											href="/vatlieu/editvatlieu/${emp.maCongViec}"
											class="btn btn-danger">delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />