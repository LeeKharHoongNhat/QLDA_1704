<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	padding: 20px 100px;
	white-space: nowrap;
	text-align: center;
}

.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fff;
}

.listbox {
	float: right;
	width: 200px;
	margin-bottom: 14px;
}
.textarea{
border-radius: 30px;
}
//

</style>
<div class="main-panel">
	<div class="content-wrapper">
		<div class="page-header">
			<div class="col-lg-12 stretch-card">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Nhật Ký Công Việc</h4>
						<nav aria-label="Page navigation example"></nav>
						<div class="content-header-right "></div>
						<div class="form-group">
							<select class="btn btn-info dropdown-toggle listbox"
								id="maDuAnselect">
								<c:forEach items="${listDuAn}" var="x">
									<option value="${x.maDuAn}">${x.tenDuAn}</option>
								</c:forEach>
							</select>
							<!-- validate error mess -->
						</div>
						<div class="table-responsive table--no-card m-b-30">

							<div id="content-table"></div>
							<script type="text/javascript"> 
							var mda ="${MDA!=null ? MDA : ''}";
							
							
							
							
							</script>
							<form:form class="forms-sample" method="post"
								action="/add">
								<div class="form-group">
									<label>Nội Dung</label> <input id="maDuAnHiden"type="hidden" name="maDuAn">
									<textarea class="form-control textarea" name="noiDung" rows="4"></textarea>
								</div>
								<button type="submit" class="btn btn-outline-success round btn-min-width mr-1 mb-1">Thêm</button>
								<a href="<c:url value="/nhatkycongviec"> </c:url> "
									class="btn btn-outline-danger round btn-min-width mr-1 mb-1">Hủy</a>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="<c:url value="/resources/js/nhatkycongviec-script.js"/>"></script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />