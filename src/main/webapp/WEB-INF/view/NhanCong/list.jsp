<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	border: 1px solid #ddd;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

.button-edit {
	padding-left: 45px;
	padding-right: 54px;
	margin-bottom: 10px;
	margin-right: 7px;
	margin-top: 10px;
}

.button-add {
	margin-bottom: 86px;
}

/* css table */
.table-responsive {
	padding-right: 1px;
}

.table-responsive {
	display: block;
	width: 100%;
	overflow-x: auto;
	-webkit-overflow-scrolling: touch;
	-ms-overflow-style: -ms-autohiding-scrollbar;
}

.table {
	margin: 0;
}

.table {
	width: 100%;
	max-width: 100%;
	margin-bottom: 1rem;
	background-color: transparent;
}

table {
	border-collapse: collapse;
}

.table-earning thead th {
	background: #333;
	font-size: 16px;
	color: #fff;
	vertical-align: middle;
	font-weight: 400;
	text-transform: capitalize;
	line-height: 1;
	padding: 20px 10px;
	white-space: nowrap;
	border: 1px solid #7d7e80 !important;
	text-align: center;
}

.table-earning tbody td {
	color: gray;
	padding: 0px 10px;
	white-space: nowrap;
	text-align: center;
}

.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fff;
}
</style>
<div class="main-panel">
	<div class="content-wrapper">
		<div class="page-header">
			<div class="col-lg-12 stretch-card">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Danh Sách Nhân Công</h4>
						<div class="content-header-right ">
							<div role="group" aria-label="Button group with nested dropdown"
								class="btn-group float-md-right " id="add-new">
								<a href="<c:url value = "add_form"/>" class="btn btn-info"><span
									class="fa fa-plus"></span> Add new</a>
							</div>

						</div>
						<nav aria-label="Page navigation example">
							<ul class="pagination">

								<c:if test="${indexPage > 1}">
									<li class="page-item"><a href="/nhancong/list?page=1"
										class="page-link">First</a></li>
								</c:if>


								<c:if test="${indexPage > 1}">
									<li class="page-item"><a
										href="/nhancong/list?page=${indexPage-1}" class="page-link">${indexPage-1}</a></li>
								</c:if>


								<li class="page-item"><a
									href="/nhancong/list?page=${indexPage}" class="page-link">${indexPage}</a></li>


								<c:if test="${indexPage < allPage}">
									<li class="page-item"><a
										href="/nhancong/list?page=${indexPage+1}" class="page-link">${indexPage+1}</a></li>
								</c:if>

								<c:if test="${indexPage < allPage}">
									<li class="page-item"><a
										href="/nhancong/list?page=${allPage}" class="page-link">Last</a></li>
								</c:if>

							</ul>
						</nav>

						<div role="group" aria-label="Button group with nested dropdown"
							class="btn-group float-md-right " id="add-new"
							style="margin-bottom: 10px; float: left !important">
							<h4 style="margin-top: 20px;" class="text-success">${mess != null ? mess : ''}</h4>
						</div>

						<div class="table-responsive table--no-card m-b-30">
							<table
								class="table-bordered table table-borderless table-striped table-earning">
								<thead>
									<tr>
										<th>Mã công việc</th>
										<th>Mã nhân viên</th>
										<th>Nội dung</th>
										<th>Thời gian bắt đầu</th>
										<th>Thời gian kết thúc</th>
										<th>Chi phí</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="emp" items="${list}">
										<tr>
											<td>${emp.maCongViec}</td>
											<td>${emp.maNhanVien}</td>
											<td>${emp.noiDung}</td>
											<s:eval
												expression="T(com.ffse1704.common.Utils).formatDate(emp.thoiGianBatDau)"
												var="thoiGianBatDau" />
											
											<td>${thoiGianBatDau}</td>
											<s:eval
												expression="T(com.ffse1704.common.Utils).formatDate(emp.thoiGianKetThuc)"
												var="thoiGianKetThuc" />
											
											<td>${thoiGianKetThuc}</td>
											<s:eval
												expression="T(com.ffse1704.common.Utils).formatMoney(emp.chiPhi)"
												var="chiPhi" />

											<td>${chiPhi}</td>


											<td><a href="/nhancong/edit/${emp.maCongViec}"
												class="btn btn-primary button-edit">edit</a> <a
												onclick="deleteNhanCong('${emp.maCongViec}', '${emp.maCongViec}')"
												class="btn btn-danger" style="color: white;!improtant">delete</a></td>

										</tr>
									</c:forEach>
								</tbody>

								<div class="modal" id="myModal">
									<div class="modal-dialog">
										<div class="modal-content">

											<!-- Modal Header -->
											<div class="modal-header">
												<h4 class="modal-title">Xóa Thiết Bị</h4>
												<button type="button" class="close" data-dismiss="modal">&times;</button>
											</div>

											<!-- Modal body -->
											<div class="modal-body" id="msgNotice"></div>
											<form id="command" class="forms-sample"
												action="/nhancong/delete" method="post">
												<input id="id" name="maCongViec" type="hidden">
												<!-- Modal footer -->
												<div class="modal-footer">
													<button type="submit" class="btn btn-danger">Xóa</button>
													<button type="button" class="btn btn-danger"
														data-dismiss="modal">Hủy</button>
												</div>

											</form>

										</div>
									</div>
								</div>


							</table>

						</div>
					</div>
				</div>
			</div>
		</div>
	
<script type="text/javascript">
	deleteNhanCong = function(maCongViec, maCongViec) {
		console.log('id deleted: ' + maCongViec);
		$('#id').val(maCongViec);
		$('#msgNotice').text(
				"Bạn có muốn xóa mã công việc " + maCongViec + " không?");
		$('#myModal').modal();
	}
</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />