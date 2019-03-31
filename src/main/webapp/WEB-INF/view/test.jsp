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

					<!-- /widget calendar -->
					<div class="widget widget-nopad">
						<div class="widget-header">
							<i class="icon-list-alt"></i>
							<h3>Recent News</h3>
						</div>
						<!-- /widget-header -->
						<div class="widget-content">
							<div id="calendar"></div>
						</div>
						<!-- /widget-content -->
					</div>
					<!-- /widget calendar -->





					<!-- /widget -->
					<div class="widget">
						<div class="widget-header">
							<i class="icon-signal"></i>
							<h3>Tiến Độ Dự Án</h3>
						</div>
						<!-- /widget-header -->
						<div class="widget-content">
							<canvas id="area-chart" class="chart-holder" height="400"
								width="1100"> </canvas>
							<!-- /area-chart -->
						</div>
						<!-- /widget-content -->
					</div>
					<!-- /widget -->
				</div>


			</div>
		</div>

		<script type="text/javascript"
			src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.7.2/jquery.min.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/calendar/excanvas.min.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/calendar/chart.min.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/calendar/bootstrap.js"/>"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/js/calendar/fullcalendar.min.js"/>"></script>
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

		<script type="text/javascript">
			var lineChartData = {
				labels : [ "January", "February", "March", "April", "May",
						"June", "July","Augus", "September", "October", "November",
						"December" ],
				datasets : [{
					fillColor : "rgba(151,187,205,0.5)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					data : [ 28, 48, 50, 55, 67, 87, 90, 91, 92, 93, 94, 100 ]
				} ]

			}

			var myLine = new Chart(document.getElementById("area-chart")
					.getContext("2d")).Line(lineChartData);

			$(document).ready(function() {
				var date = new Date();
				var d = date.getDate();
				var m = date.getMonth();
				var y = date.getFullYear();
				var calendar = $('#calendar').fullCalendar({
					header : {
						left : 'prev,next today',
						center : 'title',
						right : 'month,agendaWeek,agendaDay'
					},
					selectable : true,
					selectHelper : true,
					select : function(start, end, allDay) {
						var title = prompt('Event Title:');
						if (title) {
							calendar.fullCalendar('renderEvent', {
								title : title,
								start : start,
								end : end,
								allDay : allDay
							}, true // make the event "stick"
							);
						}
						calendar.fullCalendar('unselect');
					},
					editable : true,
					events : [ {
						title : 'All Day Event',
						start : new Date(y, m, 1)
					}, {
						title : 'Long Event',
						start : new Date(y, m, d + 5),
						end : new Date(y, m, d + 7)
					}, {
						id : 999,
						title : 'Repeating Event',
						start : new Date(y, m, d - 3, 16, 0),
						allDay : false
					}, {
						id : 999,
						title : 'Repeating Event',
						start : new Date(y, m, d + 4, 16, 0),
						allDay : false
					}, {
						title : 'Meeting',
						start : new Date(y, m, d, 10, 30),
						allDay : false
					}, {
						title : 'Lunch',
						start : new Date(y, m, d, 12, 0),
						end : new Date(y, m, d, 14, 0),
						allDay : false
					}, {
						title : 'Birthday Party',
						start : new Date(y, m, d + 1, 19, 0),
						end : new Date(y, m, d + 1, 22, 30),
						allDay : false
					}, {
						title : 'EGrappler.com',
						start : new Date(y, m, 28),
						end : new Date(y, m, 29),
						url : 'http://EGrappler.com/'
					} ]
				});
			});
		</script>
		<!-- /Calendar -->


		<jsp:include page="/WEB-INF/view/templates/footer.jsp" />