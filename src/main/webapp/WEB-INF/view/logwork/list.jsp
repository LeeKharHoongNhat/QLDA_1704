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
						<h4 class="card-title">${checkOne.duAn.tenDuAn }***Task
							LogWork***${checkOne.congViec.noiDung }</h4>
						<nav aria-label="Page navigation example">
							<ul class="pagination">

								<c:if test="${indexPage > 1}">
									<li class="page-item"><a href="/logwork/1"
										class="page-link">First</a></li>
								</c:if>


								<c:if test="${indexPage > 1}">
									<li class="page-item"><a href="//logwork/1/${indexPage-1}"
										class="page-link">${indexPage-1}</a></li>
								</c:if>


								<li class="page-item"><a href="//logwork/1/${indexPage}"
									class="page-link">${indexPage}</a></li>


								<c:if test="${indexPage < allPage}">
									<li class="page-item"><a href="//logwork/1/${indexPage+1}"
										class="page-link">${indexPage+1}</a></li>
								</c:if>

								<c:if test="${indexPage < allPage}">
									<li class="page-item"><a href="//logwork/1/${allPage}"
										class="page-link">Last</a></li>
								</c:if>

							</ul>
						</nav>
						<div role="group" aria-label="Button group with nested dropdown"
							class="btn-group float-md-right " id="add-new"
							style="margin-bottom: 10px;">
							<a href="newlogwork?maDuAn=${checkOne.duAn.maDuAn }&maCongViec=${checkOne.congViec.maCongViec}&checkTime=${checkTime}" class="btn btn-info"><span
								class="fa fa-plus"></span> LogWork</a>
						</div>
						<%-- <div role="group" aria-label="Button group with nested dropdown"
							class="btn-group float-md-right " id="add-new"
							style="margin-bottom: 10px; float: left !important">
							<h4 style="margin-top: 20px;" class="text-success">${msg != null ? msg : ''}
								delete success!</h4>
						</div> --%>

					</div>
					<div class="container">
						<h4 class=" mdi mdi-alarm-check"> Tiến độ hiện tại</h4>
						<br>
						<h4 style="padding-left: 490px;">All time: ${timeAll}h</h4>
						<div class="progress" >
							<div class="progress-bar bg-gradient-info" role="progressbar"
								style="width: ${persentTime}%" aria-valuenow="65"
								aria-valuemin="0" aria-valuemax="100"></div>
						</div>
						<label><strong style="color: blue;">${timeLogWork}h
								logged</strong> <strong style="color: red; margin-left: 910px;">${timeRemainning}h
								remaining </strong></label>
					</div>

					<br>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Nhân Viên</th>
								<th>Nội Dung</th>
								<th>Thời Gian</th>
								<th>action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="emp" items="${list}">
								<tr>
									<td>${emp.nhanVien.hoTenNhanVien}</td>
									<td>${emp.noiDung}</td>
									<td>${emp.thoiGian}</td>
									<td><a href="/logwork/editlogwork/${emp.id}"
										class="btn btn-primary">edit</a> <a
										onclick="deleteLogWork'${emp.id}')" class="btn btn-danger"
										style="color: white;!improtant">delete</a></td>
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
											action="/logwork/delete" method="post">
											<input id="id" name="id" class="form-control" type="hidden">
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
		deleteLogWork = function(id) {
			console.log('id deleted: ' + id);
			$('#id').val(id);
			$('#myModal').modal();
		}
	</script>

	<jsp:include page="/WEB-INF/view/templates/footer.jsp" />