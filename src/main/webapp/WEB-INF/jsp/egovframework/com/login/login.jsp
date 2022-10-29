<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/egovframework/com/common/head.jsp"%>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/com/common/common.css'/>" />
	<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/com/login/login.css'/>" />
<title>Login</title>
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@ include
			file="/WEB-INF/jsp/egovframework/com/common/header.jsp"%>

		<main class="mdl-layout__content">
			
			<div class="mdl-grid login-context">
				<div class="mdl-cell--4-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>

				<div
					class="mdl-cell mdl-cell--4-col mdl-card mdl-shadow--16dp util-center util-spacing-h--100px">
					<div class="mdl-card__title">
						<h2 class="mdl-card__title-text mdl-color-text--white">Login</h2>
					</div>
					<div class="mdl-card__supporting-text mdl-grid">

						<form:form action="loginOk.do" method="POST" commandName="loginVO">
							<input type="hidden" name="action" value="login" />
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_new_login_id">ID</label> <form:input
									class="mdl-textfield__input" path="loginId" type="text"
									id="textfield_new_login_id" name="loginId" />
									<form:errors path="loginId"/>
							</div>

							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_new_password">Password</label> <form:input
									class="mdl-textfield__input" type="password"
									id="textfield_new_password" name="password" path="password"/>
									<form:errors path="password" />
							</div>

							<div class="mdl-cell mdl-cell--12-col send-button" align="center">
								<button
									class="mdl-button mdl-js-ripple-effect mdl-js-button mdl-button--raised button-color"
									id="login">LOG IN</button>
								<div class="modal"><!-- Place at bottom of page --></div>
							</div>

							<div class="mdl-cell mdl-cell--12-col send-button" align="center">
								<button class="mdl-button mdl-js-button mdl-js-ripple-effect"
									id="Register">SignUp</button>
							</div>

							<div class="mdl-cell mdl-cell--12-col" align="center">
								<a href="#" class="mdl-color-text--red">Forgot Password?</a>
							</div>
						</form:form>
					</div>
				</div>
			</div>
			<%@ include
			file="/WEB-INF/jsp/egovframework/com/common/footer.jsp"%>
		</main>
	</div>

	<script type="text/javascript" src="../../resources/arc/js/material.js"></script>
</body>
</html>