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
						<h4 class="card-title">Danh Mục Dự Án</h4>
					
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
									<th>Mã dự án</th>
									<th>Mã tiêu thức</th>
									
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="dm" items="${list}">
									<tr>
										<td>${dm.thongTinDuAn.tenDuAn}</td>
										<td>${dm.tieuThuc.tenTieuThuc}</td>
										

										<td><a href=""
											class="btn btn-primary">edit</a> <a
											href=""
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