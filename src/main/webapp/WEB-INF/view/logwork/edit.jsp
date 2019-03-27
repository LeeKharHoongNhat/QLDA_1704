<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="main-panel">
	<div class="content-wrapper">
		<div class="col-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">
						Dự Án:<strong style="color: red;">${checkOne.duAn.tenDuAn }</strong>
					</h4>
					<h4 class="card-title">
						Hạng Mục:<strong style="color: red;">${checkOne.congViec.noiDung}</strong>
					</h4>
					<h4 class="card-title">Edit LogWork</h4>
					<div class="container">
						<h4 style="padding-left: 490px;">All time: ${timeAll}h</h4>
						<div class="progress">
							<div class="progress-bar bg-gradient-info" role="progressbar"
								style="width: ${persentTime}%" aria-valuenow="65"
								aria-valuemin="0" aria-valuemax="100"></div>
						</div>
						<label><strong style="color: blue;">${timeLogWork}h
								logged</strong> <strong style="color: red; margin-left: 800px;">${timeRemainning}h
								remaining </strong></label>
					</div>
					<input type="hidden" value="${timeRemainning}" id="timeRemainning" />
					<input type="hidden" value="${checkOne.thoiGian}" id="timeTaskLog" />
					<br>
					<form:form class="forms-sample" method="post" action="submiteditlogwork">
					
					<input type="hidden" value="${checkOne.maDuAn}" id="maDuAn" name="maDuAn" />
					<input type="hidden" value="${checkOne.maCongViec}" id="maCongViec" name="maCongViec" />
					<input type="hidden" value="${checkOne.maNhanVien}" id="maNhanVien" name="maNhanVien" />
					<input type="hidden" value="${checkTime}" id="checkTime" name="checkTime" />
						<div class="form-group">
							<label for="exampleInputName1">Nội dung</label>
							<form:input path="noiDung" class="form-control" />
							<form:errors path="noiDung" cssStyle="color: red" />
							<strong style="color: red;">${mess}</strong>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail3">Thời Gian(h)</label>
							<form:input path="thoiGian" class="form-control" />
							<form:errors path="thoiGian" cssStyle="color: red" id="msgThoiGian" />
							<span style="color:red;" id="msgCheckTime"> </span>
						</div>
						<button type="submit" class="btn btn-gradient-primary mr-2">Submit</button>
						<button class="btn btn-light" type="reset">Cancel</button>
					</form:form>
				</div>
			</div>
		</div>

		<script type="text/javascript">
			$(document).ready(function() {
				$("#thoiGian").change(function() {
					console.log(this.value);
					var timeRmnning = $("#timeRemainning").val();
					var timeTask = $("#timeTaskLog").val();
					if((parseInt(timeRmnning)+parseInt(timeTask)) <parseInt(this.value)){
						$("#msgCheckTime").text("Số thời gian Logwork phải nhỏ hơn thời gian Remainning!").show();
						$("#msgThoiGian").hide();
					}else{
						$("#msgCheckTime").hide();
					}
				});
			});
		</script>
		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />