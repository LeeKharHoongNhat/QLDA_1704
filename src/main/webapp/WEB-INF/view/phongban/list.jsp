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
								<h4 style="margin-top: 20px;" class="text-success">${msg != null ? msg : ''}
									delete success!</h4>
							</div>
						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Mã phòng ban</th>
									<th>Tên phòng ban</th>
									<th>action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="emp" items="${list}">
									<tr>
										<td>${emp.maPhongBan}</td>
										<td>${emp.tenPhongBan}</td>
										<td><a href="/phongban/editphongban/${emp.maPhongBan}"
											class="btn btn-primary">edit</a><a
										onclick="deletePhongBan('${emp.maPhongBan}')"
										class="btn btn-danger" style="color: white;!improtant">delete</a></td>
								</tr>
							</c:forEach>
							<!-- The Modal -->
							<div class="modal" id="myModal">
								<div class="modal-dialog">
									<div class="modal-content">

										<!-- Modal Header -->
										<div class="modal-header">
											<h4 class="modal-title">Xác nhận xóa?</h4>
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>

										<!-- Modal body -->
										<div class="modal-body">Xóa ?</div>
										<form id="command" class="forms-sample"
											action="/phongban/delete" method="post">
											<input id=maPhongBan name="maPhongBan"
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
		deletePhongBan = function(id) {
			console.log('id deleted: ' + id);
			$('#maPhongBan').val(id);
			$('#myModal').modal();
		}
	</script>

		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />