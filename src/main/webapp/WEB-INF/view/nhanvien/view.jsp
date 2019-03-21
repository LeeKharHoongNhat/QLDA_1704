<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.avatar {
height: 50px; width: 50px
}
</style>
<div class="main-panel">
	<div class="content-wrapper">
		 <div class="col-md-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Thông Tin Nhân Viên</h4>
                  <p class="card-description">
                    Horizontal form layout
                  </p>
                  <form class="forms-sample">
                    <div class="form-group row">
                      <label for="exampleInputUsername2" class="col-sm-3 col-form-label">Mã Nhân Viên :</label>
                      <div class="col-sm-9">
                       <p>${viewOne.maNhanVien}</p>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="exampleInputEmail2" class="col-sm-3 col-form-label">Tên Nhân Viên :</label>
                      <div class="col-sm-9">
                       <p> ${viewOne.hoTenNhanVien} </p>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="exampleInputMobile" class="col-sm-3 col-form-label">Giới Tính :</label>
                      <div class="col-sm-9">
                        <p> ${viewOne.gioiTinh} </p>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="exampleInputMobile" class="col-sm-3 col-form-label">Số CMND :</label>
                      <div class="col-sm-9">
                        <p> ${viewOne.soChungMinhThu} </p>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="exampleInputMobile" class="col-sm-3 col-form-label">Địa Chỉ :</label>
                      <div class="col-sm-9">
                        <p> ${viewOne.diaChi} </p>
                      </div>
                    </div>
                     <div class="form-group row">
                      <label for="exampleInputMobile" class="col-sm-3 col-form-label">Số Điện Thoại :</label>
                      <div class="col-sm-9">
                       <p> ${viewOne.soDienThoai} </p>
                      </div>
                    </div>
                     <div class="form-group row">
                      <label for="exampleInputMobile" class="col-sm-3 col-form-label">Email :</label>
                      <div class="col-sm-9">
                        <p> ${viewOne.email} </p>
                      </div>
                    </div>
                     <div class="form-group row">
                      <label for="exampleInputMobile" class="col-sm-3 col-form-label">Hình Ảnh :</label>
                      <div class="col-sm-9">
                        <img  src="/resources/images/noimg.png" alt="${viewOne.hinhAnh}" class="avatar" >  
                      </div>
                    </div>
                     <div class="form-group row">
                      <label for="exampleInputMobile" class="col-sm-3 col-form-label"> Phòng Ban :</label>
                      <div class="col-sm-9">
                        <p> ${viewOne.phongBan.tenPhongBan} </p>
                      </div>
                    </div>
                     <div class="form-group row">
                      <label for="exampleInputMobile" class="col-sm-3 col-form-label"> Chức Danh :</label>
                      <div class="col-sm-9">
                        <p> ${viewOne.ttChucDanh.tenTieuThuc} </p>
                      </div>
                    </div>
                     <div class="form-group row">
                      <label for="exampleInputMobile" class="col-sm-3 col-form-label">Loại Hợp Đồng :</label>
                      <div class="col-sm-9">
                       <p> ${viewOne.ttLoaiHD.tenTieuThuc} </p>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="exampleInputMobile" class="col-sm-3 col-form-label">Ngày Bắt đầu HĐ :</label>
                      <div class="col-sm-9">
                        <p> ${viewOne.ngayBatDauHopDong} </p>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="exampleInputMobile" class="col-sm-3 col-form-label">Ngày Kết Thúc HĐ :</label>
                      <div class="col-sm-9">
                        <p> ${viewOne.ngayKetThucHopDong} </p>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="exampleInputMobile" class="col-sm-3 col-form-label">Trạng Thái :</label>
                      <div class="col-sm-9">
                        <p> ${viewOne.ttTrangThai.tenTieuThuc} </p>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="exampleInputPassword2" class="col-sm-3 col-form-label">Password :</label>
                      <div class="col-sm-9">
                        <p> ${viewOne.passWord} </p>
                      </div>
                    </div>
            
                   
                   
                    <a href="<c:url value="/nhanvien/1"> </c:url> " class="btn btn-primary"" >Back</a>
                  </form>
                </div>
              </div>
            </div>
	</div>
</div>


	<jsp:include page="/WEB-INF/view/templates/footer.jsp" />