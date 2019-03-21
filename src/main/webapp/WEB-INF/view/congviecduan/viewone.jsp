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
							Thông Tin Dự Án: <strong style="color: red;">${view.duAn.tenDuAn}</strong>
						</h4>
						<div class="content-header-right ">
							<div role="group" aria-label="Button group with nested dropdown"
								class="btn-group float-md-right " id="add-new">
								<a
									href="<c:url value = "/congviecduan/list?maDuAn=${view.maDuAn}&page=1"/>"
									class="btn btn-info"><span class="fa fa-plus"></span>Back</a>
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
									<th>Trạng thái</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>

								<tr>
									<td>${view.maCongViec}</td>
									<td>${view.noiDung}</td>
									<td>${view.nhanVien.hoTenNhanVien}</td>
									<td>${view.thoiGianMo}</td>
									<td>${view.thoiGianDong}</td>
									<td>${view.maTrangThai}</td>
									<td><a href="/congviecduan/edit/${view.id}"
										class="btn btn-primary">edit</a> <a
										href="/congviecduan/${view.id}">LogWork</a></td>
								</tr>


							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>


		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />