<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="validator"
	uri="http://www.springmodules.org/tags/commons-validator"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=100%,initial-scale=1" />
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons"></link>
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css"></link>
<script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/egovframework/com/chart/chart.css'/>" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.standalone.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {
		packages : [ 'corechart', 'line' ]
	});
	google.charts.setOnLoadCallback(drawBasic);

	function drawBasic(dataList) {
		var chartRowArray = $.makeArray();
		var data = new google.visualization.DataTable();

		data.addColumn('string', 'Test Scenario');
		data.addColumn('number', '<spring:message code="chart.resptime" />');

		$.each(dataList, function(index, chartVO) { // 데이터 =group
			chartRowArray.push([ chartVO.time, chartVO.resptime ]);
			var value = chartVO.time;
			value = value + " ";
			value = value + chartVO.resptime;
		});
		//Create the chart.
		data.addRows(chartRowArray);

		var options = {
			hAxis : {
				title : '<spring:message code="chart.date" />'
			},
			vAxis : {
				title : '<spring:message code="chart.resptime" /> (ms)'
			},
		};

		var chart = new google.visualization.LineChart(document
				.getElementById('chart_div'));

		chart.draw(data, options);
	}
	function drawTable(dataList) {
		var table = "";
		table += "<table class=\"mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp\"><thead><tr>";
		table += "<th><spring:message code="chart.result" /></th>";
		table += "<th><spring:message code="chart.resptime" /></th>";
		table += "<th><spring:message code="chart.time" /></th>";
		table += "<th><spring:message code="chart.error" /></th>";
		table += "</tr></thead>";
		table += "<tbody>";

		$.each(dataList, function(index, chartVO) { // 데이터 =group
			table += "<tr>";
			table = table + "<td>" + "<div id=\"circle\" style=\"background-color:"

			if (chartVO.result == 'TRUE') {
				table = table + "green;"
			} else {
				table = table + "red;"
			}

			table = table + "\"></div></td>";
			table = table + "<td>" + chartVO.resptime + "</td>";
			table = table + "<td>" + chartVO.time + "</td>";
			table = table + "<td>" + chartVO.resultText + "</td>";
			table += "</tr>"

			var resultId = "circle" + chartVO.seq;
			$("#" + resultId).attr("data-result", chartVO.result);

		});
		table += "</tbody></table>";

		//Create the table.
		$('#table_div').html(table);
	}
	$(function() {
		$('#datePickerFrom').datepicker({
			format : "yyyy-mm-dd", // 달력에서 클릭시 표시할 값 형식
			language : "kr",
			todayHighlight : "true"
		});
		$('#datePickerFrom').change(function() {
			var value = $('#datePickerFrom').val();
			value.replace(" ", "");
			if (value == "" || value == null) {
				$("#datePickerFromWrapper").removeClass("is-dirty");
			} else {
				$("#datePickerFromWrapper").addClass("is-dirty");
			}
		});
		$('#datePickerTo').datepicker({
			format : "yyyy-mm-dd", // 달력에서 클릭시 표시할 값 형식
			language : "kr",
			todayHighlight : "true"
		});
		$('#datePickerTo').change(function() {
			var value = $('#datePickerTo').val();
			value.replace(" ", "");
			if (value == "" || value == null) {
				$("#datePickerToWrapper").removeClass("is-dirty");
			} else {
				$("#datePickerToWrapper").addClass("is-dirty");
			}
		});

		$('#search').click(
				function() {
					var from = $('#datePickerFrom').val().replace(" ", "");
					var to = $('#datePickerTo').val().replace(" ", "");
					var msg = from + " " + to;
					if (from == null || from == "" || to == null || to == "") {
						var error = "<spring:message code="title" />";
						alert(error);
					} else {
						var url = "<c:url value="/chart/chartLoad.do"/>";
						url = url + "?from=" + from;
						url = url + "&to=" + to;
						$.ajax({
							url : url,
							type : "GET",
							contentType : "application/json; charset=utf-8;",
							dataType : "json",
							success : function(result) {
								console.log(result);
								$('#search').attr('disabled', false);
								$('html,body').css('cursor', 'default');
								drawBasic(result.data);
								drawTable(result.data);
							},
							beforeSend : function() {
								$('#search').attr('disabled', true);
								$('html,body').css('cursor', 'wait');
							},
							error : function(request, status, error) {
								alert("code:" + request.status + "\n"
										+ "message:" + request.responseText
										+ "\n" + "error:" + error);
							}

						});
					}
				});
	});
</script>
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header">
			<div class="mdl-layout__header-row">
				<span class="mdl-layout-title"><spring:message code="title" /></span>
				<div class="mdl-layout-spacer"></div>
				<nav class="mdl-navigation ">
					<a class="mdl-navigation__link" href="">Link</a> <a
						class="mdl-navigation__link" href="">Link</a> <a
						class="mdl-navigation__link" href="">Link</a> <a
						class="mdl-navigation__link" href="./egovSampleList.do">sample</a>
				</nav>
			</div>
		</header>
		<div class="mdl-layout__drawer">
			<span class="mdl-layout-title"><spring:message code="title" /></span>
			<nav class="mdl-navigation">
				<a class="mdl-navigation__link" href="">Link</a> <a
					class="mdl-navigation__link" href="">Link</a> <a
					class="mdl-navigation__link" href="">Link</a> <a
					class="mdl-navigation__link" href="">Link</a>
			</nav>
		</div>
		<main class="mdl-layout__content">
			<div class="page-content">

				<div class="mdl-grid">
					<div
						class="mdl-cell mdl-cell--2-col-desktop mdl-cell--1-col-tablet mdl-cell--hide-phone"></div>
					<div
						class="mdl-cell mdl-cell--8-col-desktop mdl-cell--4-col-phone mdl-cell--6-col-tablet">
						<h3>
							<spring:message code="chart.title" />
						</h3>
					</div>
					<div
						class="mdl-cell mdl-cell--2-col-desktop mdl-cell--1-col-tablet mdl-cell--hide-phone">
					</div>
				</div>
				<div class="mdl-grid">
					<div
						class="mdl-cell mdl-cell--2-col-desktop mdl-cell--1-col-tablet mdl-cell--hide-phone"></div>
					<div
						class="mdl-cell mdl-cell--8-col-desktop mdl-cell--4-col-phone mdl-cell--6-col-tablet">
						<div class="mdl-grid">
							<form:form commandVO="chartVO">
								<div
									class="mdl-cell mdl-cell--5-col-desktop mdl-cell--8-col-tablet mdl-cell--4-col-phone">
									<div
										class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
										id="datePickerFromWrapper">
										<input class="mdl-textfield__input" type="text"
											id="datePickerFrom"> <label
											class="mdl-textfield__label" for="datePickerFrom">From</label>
									</div>
								</div>
								<div
									class="mdl-cell mdl-cell--2-col-desktop mdl-cell--4-col-phone mdl-cell--8-col-tablet">
									<div class="date-range">~</div>
								</div>
								<div
									class="mdl-cell mdl-cell--5-col-desktop mdl-cell--8-col-tablet mdl-cell--4-col-phone">

									<div
										class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
										id="datePickerToWrapper">
										<input class="mdl-textfield__input" type="text"
											id="datePickerTo"> <label
											class="mdl-textfield__label" for="datePickerTo">To</label>
									</div>
								</div>
							</form:form>
						</div>
						<div class="wd-100">
							<button
								class="mdl-button mdl-js-ripple-effect mdl-js-button mdl-button--raised mdl-button--colored"
								id="search">
								<spring:message code="chart.search" />
							</button>
						</div>

					</div>
					<div
						class="mdl-cell mdl-cell--2-col-desktop mdl-cell--1-col-tablet mdl-cell--hide-phone">
					</div>
				</div>

				<div class="mdl-grid">
					<div
						class="mdl-cell mdl-cell--1-col-desktop mdl-cell--1-col-tablet mdl-cell--hide-phone"></div>

					<div
						class="mdl-cell mdl-cell--10-col-desktop mdl-cell--6-col-tablet mdl-cell--4-phone subtitle">
						<span> <spring:message code="chart.graph" />
						</span>
						<div id="chart_div"></div>

					</div>
					<div
						class="mdl-cell mdl-cell--1-col-desktop mdl-cell--1-col-tablet mdl-cell--hide-phone"></div>
					<div
						class="mdl-cell mdl-cell--1-col-desktop mdl-cell--hide-tablet mdl-cell--hide-phone"></div>
					<div
						class="mdl-cell mdl-cell--10-col-desktop mdl-cell--8-col-tablet mdl-cell--4-phone subtitle subtitle2">
						<span> <spring:message code="chart.table" />
						</span>
						<div id="table_div"></div>
					</div>
					<div
						class="mdl-cell mdl-cell--1-col-desktop mdl-cell--hide-tablet mdl-cell--hide-phone"></div>

				</div>




				<footer class="mdl-mega-footer">
					<div class="mdl-mega-footer__middle-section">

						<div class="mdl-mega-footer__drop-down-section">
							<input class="mdl-mega-footer__heading-checkbox" type="checkbox"
								checked />
							<h1 class="mdl-mega-footer__heading">Features</h1>
							<ul class="mdl-mega-footer__link-list">
								<li><a href="#">About</a></li>
								<li><a href="#">Terms</a></li>
								<li><a href="#">Partners</a></li>
								<li><a href="#">Updates</a></li>
							</ul>
						</div>

						<div class="mdl-mega-footer__drop-down-section">
							<input class="mdl-mega-footer__heading-checkbox" type="checkbox"
								checked />
							<h1 class="mdl-mega-footer__heading">Details</h1>
							<ul class="mdl-mega-footer__link-list">
								<li><a href="#">Specs</a></li>
								<li><a href="#">Tools</a></li>
								<li><a href="#">Resources</a></li>
							</ul>
						</div>

						<div class="mdl-mega-footer__drop-down-section">
							<input class="mdl-mega-footer__heading-checkbox" type="checkbox"
								checked />
							<h1 class="mdl-mega-footer__heading">Technology</h1>
							<ul class="mdl-mega-footer__link-list">
								<li><a href="#">How it works</a></li>
								<li><a href="#">Patterns</a></li>
								<li><a href="#">Usage</a></li>
								<li><a href="#">Products</a></li>
								<li><a href="#">Contracts</a></li>
							</ul>
						</div>

						<div class="mdl-mega-footer__drop-down-section">
							<input class="mdl-mega-footer__heading-checkbox" type="checkbox"
								checked />
							<h1 class="mdl-mega-footer__heading">FAQ</h1>
							<ul class="mdl-mega-footer__link-list">
								<li><a href="#">Questions</a></li>
								<li><a href="#">Answers</a></li>
								<li><a href="#">Contact us</a></li>
							</ul>
						</div>

					</div>

					<div class="mdl-mega-footer__bottom-section">
						<div class="mdl-logo">Title</div>
						<ul class="mdl-mega-footer__link-list">
							<li><a href="#">Help</a></li>
							<li><a href="#">Privacy & Terms</a></li>
						</ul>
					</div>
				</footer>
			</div>
		</main>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.kr.min.js"></script>
</body>
</html>