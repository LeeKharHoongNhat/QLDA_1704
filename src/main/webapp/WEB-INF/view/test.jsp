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
						<div id="timesheet"></div>
					</div>
				</div>
			</div>
		</div>

		<script type="text/javascript">
			new Timesheet('timesheet', 2002, 2018, [
					[ '2002', '09/2004', 'A freaking awesome time', 'lorem' ],
					[ '06/2002', '12/2003', 'Some great memories', 'ipsum' ],
					[ '2003', 'Had very bad luck' ],
					[ '10/2003', '2006', 'At least had fun', 'dolor' ],
					[ '02/2005', '05/2006', 'Enjoyed those times as well',
							'ipsum' ],
					[ '07/2005', '09/2005', 'Bad luck again', 'default' ],
					[ '10/2005', '2008', 'For a long time nothing happened',
							'dolor' ],
					[ '01/2008', '05/2009', 'LOST Season #4', 'lorem' ],
					[ '01/2009', '05/2009', 'LOST Season #4', 'lorem' ],
					[ '02/2010', '05/2010', 'LOST Season #5', 'lorem' ],
					[ '09/2008', '06/2010', 'FRINGE #1 & #2', 'ipsum' ] ]);
		</script>
		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />