<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
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
.button-edit{
    padding-left: 45px;
    padding-right: 54px;
    margin-bottom: 10px;
    margin-right: 7px;
    margin-top: 10px;
}

.button-add{
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
						<h4 class="card-title">Danh Sách Thiết Bị</h4>
						<nav aria-label="Page navigation example"></nav>
						<div class="content-header-right ">
							<div role="group" aria-label="Button group with nested dropdown"
								class="btn-group float-md-right " id="add-new">
								<a href="<c:url value = "add/${maCV }"/>" class="btn btn-info button-add"><span
									class="fa fa-plus"></span> Add New</a>
							</div>

						</div>
						<div class="table-responsive table--no-card m-b-30">
							<table class="table-bordered table table-borderless table-striped table-earning">
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
											<s:eval expression="T(com.ffse1704.common.Utils).formatDate(emp.thoiGianBatDauThueMuon)" var="startDay" />
											<td>${startDay}</td>
											<s:eval expression="T(com.ffse1704.common.Utils).formatDate(emp.thoiGianKetThucThueMuon)" var="endtDay" />
											<td>${endtDay}</td>
											<td>${emp.ghiChu}</td>
											<td>${emp.donGia}</td>
											<td>${emp.chiPhi}</td>
											<td><a href="/thietbi/edit/${emp.id}"
												class="btn btn-primary button-edit">Sửa</a><a
												onclick="deleteThietBi('${emp.id}', '${emp.tenThietBi}')"
												class="btn btn-danger" style="color: white;!improtant">Xóa</a></td>
										</tr>
									</c:forEach>
									<!-- The Modal -->
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
													action="/thietbi/remove" method="post">
													<input id="id" name="id" type="hidden">
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
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	deleteThietBi = function(id, tenThietBi) {
		console.log('id deleted: ' + id);
		$('#id').val(id);
		$('#msgNotice').text(
				"Bạn có muốn xóa thiết bị " + tenThietBi + " không?");
		$('#myModal').modal();
	}
</script>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />