<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons"></link>
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css"></link>
<script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.standalone.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
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
				alert("empty value");
			} else {
				$("#datePickerFromWrapper").addClass("is-dirty");
				alert("chage value");
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
				alert("empty value");
			} else {
				$("#datePickerToWrapper").addClass("is-dirty");
				alert("chage value");
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



				<div
					class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
					id="datePickerFromWrapper">
					<input class="mdl-textfield__input" type="text" id="datePickerFrom">
					<label class="mdl-textfield__label" for="datePickerFrom">From</label>
				</div>
				<span> ~ </span>
				<div
					class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"
					id="datePickerToWrapper">
					<input class="mdl-textfield__input" type="text" id="datePickerTo">
					<label class="mdl-textfield__label" for="datePickerTo">To</label>
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