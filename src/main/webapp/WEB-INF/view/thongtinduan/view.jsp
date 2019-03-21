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
						<h4 class="card-title" >Thông Tin Dự Án: <strong style="color:red;">${command.tenDuAn}</strong></h4>
						<div class="content-header-right ">
							<div role="group" aria-label="Button group with nested dropdown"
								class="btn-group float-md-right " id="add-new">
								<a href="<c:url value = "/duan/${command.trangThai.maTieuThuc}&1"/>" class="btn btn-info"><span
									class="fa fa-plus"></span>Back</a>
							</div>

						</div>

		
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Mã dự án</th>
									<th>Khách hàng</th>
									<th>Phòng ban</th>
									<th>PM</th>
									<th>Ngày bắt đầu</th>
									<th>Ngày kết thúc</th>
									<th>Ngày Bàn Giao</th>
									<th>Giá trị dự án</th>
									<th>Đã thanh toán</th>
									<th>Trạng thái</th>
									<th>action</th>
								</tr>
							</thead>
							<tbody>

								<tr>
									<td>${command.maDuAn}</td>
									<td>${command.khachHang.tenKhachHang}</td>
									<td>${command.phongBan.tenPhongBan}</td>
									<td>${command.nhanVienPm.hoTenNhanVien}</td>
									<td>${command.ngayBatDau}</td>
									<td>${command.ngayKetThuc}</td>
									<td>${command.ngayBanGiao}</td>
									<td>${command.giaTriHopDong}</td>
									<td>${command.daThanhToan}</td>
									<td>${command.trangThai.tenTieuThuc}</td>
									<td><a href="/duan/editduan/${command.maDuAn}"
										class="btn btn-primary">edit</a> <a
										href="/congviecduan/list?maDuAn=${command.maDuAn}&page=1"
										class="btn btn-warning">Nhiệm Vụ</a></td>
								</tr>


							</tbody>
						</table>
					</div>
				</div>
			</div>
			
		</div>


		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />