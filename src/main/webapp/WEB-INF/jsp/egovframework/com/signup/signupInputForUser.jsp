<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/egovframework/com/common/head.jsp"%>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/signup/signup.css'/>" />

<title>SignUp</title>
</head>

<script>
	if(message !== "") {
		alert(message);
	}
	console.log(message);
</script>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@ include
			file="/WEB-INF/jsp/egovframework/com/common/header.jsp"%>

		<main class="mdl-layout__content">
			<div class="mdl-grid">
				<div class="mdl-cell mdl-cell--4-col"></div>

				<div
					class="mdl-cell mdl-cell--4-col mdl-card mdl-shadow--16dp util-center util-spacing-h--100px">
					<div class="mdl-card__title mdl-color--teal-500">
						<h2 class="mdl-card__title-text mdl-color-text--white">SignUp</h2>
					</div>
					<div class="mdl-card__supporting-text mdl-grid">

						<form:form method="POST" action="signupOk.do" commandName="userVO">
							<input type="hidden" name="action" value="register" />
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_new_Email">Email*</label> <form:input
									class="mdl-textfield__input"
									id="textfield_new_Email" name="email" path="email"/>
									<form:errors path="email"/>
							</div>

							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_new_username">Username*</label> <form:input
									class="mdl-textfield__input" type="text"
									id="textfield_new_username" name="name" path="name"/> 
									<form:errors path="name"/>
							</div>

							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_new_nickname">Nickname</label> <input
									class="mdl-textfield__input" type="text"
									id="textfield_new_nickname" name="nickname" />
							</div>

							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_new_company">Company</label> <input
									class="mdl-textfield__input" type="text"
									id="textfield_new_company" name="company" />
							</div>

							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_new_tel">Tel</label> <input
									class="mdl-textfield__input" type="text" id="textfield_new_tel"
									name="tel" />
							</div>
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
								<select
									class="mdl-textfield__input mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col"
									id="octane" name="language">
									<option></option>
									<option value="english" selected>English</option>
									<option value="korean">Korean</option>
									<option value="japanese">Japanese</option>
								</select> <label class="mdl-textfield__label mdl-color-text--grey"
									for="language">Language</label>
							</div>
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_new_login_id">Login ID*</label> <form:input
									class="mdl-textfield__input" type="text"
									id="textfield_new_login_id" name="loginId" path="loginId" />
									<form:errors path="loginId"/>
							</div>

							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_new_password">Password*</label> <form:input
									class="mdl-textfield__input" type="password"
									id="textfield_new_password" name="password" path="password" />
									<form:errors path="password"/>
							</div>

							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_password_confirm">Password(Confirm)*</label> <form:input
									class="mdl-textfield__input" type="password"
									id="textfield_password_confirm" name="passwordConfirm" path="passwordConfirm"/>
									<form:errors path="passwordConfirm"/>
							</div>

							<div class="mdl-cell mdl-cell--12-col send-button" align="center">
								<button
									class="mdl-button mdl-js-ripple-effect mdl-js-button mdl-button--raised mdl-button--colored"
									id="register">Register</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</main>

		<%@ include
			file="/WEB-INF/jsp/egovframework/com/common/footer.jsp"%>
	</div>

</body>
</html>

