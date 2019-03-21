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
						<div role="group" aria-label="Button group with nested dropdown"
							class="btn-group float-md-right " id="add-new"
							style="margin-bottom: 10px;">
							<a href="addnhanvien" class="btn btn-info"><span
								class="fa fa-plus"></span> Add new</a>
						</div>
						<%-- <div role="group" aria-label="Button group with nested dropdown"
							class="btn-group float-md-right " id="add-new"
							style="margin-bottom: 10px; float: left !important">
							<h4  style="margin-top: 20px;" class="text-success">
							${msg != null ? msg : ''}
							delete success!</h4>
						</div> --%>

					</div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Mã Nhân Viên</th>
								<th>Tên Nhân Viên</th>
								<th>Phòng Ban</th>
								<th>Chức Danh</th>
								<th>Loại Hợp Đồng</th>
								<th>Trạng Thái</th>
								<th>action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="emp" items="${list}">
								<tr>
									<td>${emp.maNhanVien}</td>
									<td>${emp.hoTenNhanVien}</td>
									<td>${emp.phongBan.tenPhongBan}</td>
									<td>${emp.ttChucDanh.tenTieuThuc}</td>
									<td>${emp.ttLoaiHD.tenTieuThuc}</td>
									<td>${emp.ttTrangThai.tenTieuThuc}</td>
									<td>
									<a href="/nhanvien/viewNhanVien/${emp.maNhanVien}"
										class="btn btn-primary">View</a>
									<a href="/nhanvien/editnhanvien/${emp.maNhanVien}"
										class="btn btn-primary">edit</a> <a
										onclick="deletenhanvien('${emp.maNhanVien}')"
										class="btn btn-danger" style="color: white;!improtant">delete</a></td>
								</tr>
							</c:forEach>
							<!-- The Modal -->
							<div class="modal" id="myModal">
								<div class="modal-dialog">
									<div class="modal-content">

										<!-- Modal Header -->
										<div class="modal-header">
											<h4 class="modal-title">Modal Heading</h4>
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>

										<!-- Modal body -->
										<div class="modal-body">Modal body..</div>
										<form id="command" class="forms-sample"
											action="/nhanvien/delete" method="post">
											<input id="manhanvien" name="manhanvien"
												class="form-control" type="hidden">
											<!-- Modal footer -->
											<div class="modal-footer">
												<button type="submit" class="btn btn-danger">Delete</button>
												<button type="button" class="btn btn-danger"
													data-dismiss="modal">Close</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		deletenhanvien = function(id) {
			console.log('id deleted: ' + id);
			$('#maNhanVien').val(id);
			$('#myModal').modal();
		}
	</script>

	<jsp:include page="/WEB-INF/view/templates/footer.jsp" />