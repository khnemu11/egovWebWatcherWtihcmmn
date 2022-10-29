<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/egovframework/com/common/head.jsp"%>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/com/common/common.css'/>" />
<title>SignUp</title>

<link type="text/css" rel="stylesheet" href="<c:url value="/css/egovframework/com/signup/signup.css"/>"/>
</head>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@ include
			file="/WEB-INF/jsp/egovframework/com/common/header.jsp"%>

		<main class="mdl-layout__content">
			<div class="mdl-grid context">
				<div class="mdl-cell--4-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>

				<div
					class="mdl-cell mdl-cell--4-col mdl-card mdl-shadow--16dp util-center util-spacing-h--100px">
					<div class="mdl-card__title">
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
									id="octane" name="locale">
									<option></option>
									<option value="en" selected>English</option>
									<option value="kr">Korean</option>
									<option value="ja">Japanese</option>
								</select> <label class="mdl-textfield__label mdl-color-text--grey"
									for="language">Language</label>
							</div>
							
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--9-col-desktop mdl-cell--7-col-tablet mdl-cell--3-col-phone id-div">
								<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label loginid-div">
									<label class="mdl-textfield__label mdl-color-text--grey"
										for="textfield_new_login_id">Login ID*</label> 
									<form:input class="mdl-textfield__input" type="text"
									id="textfield_new_login_id" name="loginId" path="loginId" />
										<form:errors path="loginId"/>
								</div>
								<span class="id-confirm-button"><input class="mdl-button mdl-js-button mdl-button--raised button-color" id="loginIdLookUpBtn" type="button" onclick="fnCheckId(); " value="<spring:message code='button.inquire' />" /></span>
							</div>
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_new_password">Password*</label> <form:input
									class="mdl-textfield__input" type="password"
									id="textfield_new_password" name="password" path="password"/>
									<form:errors path="password"/>
							</div>

							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_password_confirm">Password(Confirm)*</label> <form:input
									class="mdl-textfield__input" type="password"
									id="textfield_password_confirm" name="passwordConfirm" path="passwordConfirm" oninput="passwordConfirmInput()" />
									<span id="message"></span>
			
									<form:errors path="passwordConfirm" id="aa"/>
							</div>

							<div class="mdl-cell mdl-cell--12-col send-button" align="center">
								<button
									class="mdl-button mdl-js-ripple-effect mdl-js-button mdl-button--raised button-color"
									id="register">Register</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
			<%@ include
					file="/WEB-INF/jsp/egovframework/com/common/footer.jsp"%>
		</main>
	</div>

</body>
<script>
	// error가 있으면 alert 처리 
	<c:if test="${!empty error}">alert("<spring:message code="${error}" />");</c:if>

	
	// 비밀번호와 비밀번호 확인이 같은지 처리 
	let password = $('#textfield_new_password');
	let confirm_password = $('#textfield_password_confirm');
	
	function passwordConfirmInput() {
	 	if(password.val() !== confirm_password.val()){
		  	confirm_password[0].setCustomValidity("<spring:message code="signup.password.validate.different" />");
	  	}
	  	else {
			confirm_password[0].setCustomValidity(''); 
	  	}
	}
	
	
	// 버튼 ajax 처리 
	let button = $('#loginIdLookUpBtn');
	function fnCheckId(){
		let url = "${pageContext.request.contextPath}/signup/checkLoginIdDplctAjax.do";
   		button[0].disabled = true;
   		$('html, body').css('cursor', 'wait');

	    $.ajax({
	        type: "GET",
	        url: url,
	        data: {loginId: $('#textfield_new_login_id').val()},
	        success: function(response){
	        	let jsonData = JSON.parse(response);
	          	if(jsonData['usedCnt'] >= 1){
	          		alert("<spring:message code="login.id.duplicate" />");
	          	}
	          	else{
	          		alert("<spring:message code="login.id.can.use" />");
	          	}
	        },
	        error: function(xhr, status){
	        	alert(xhr + " : " + status);
	        },
	       	complete: function(){
	       		button[0].disabled = false;
	       		$('html, body').css('cursor', 'default');
	       	} 
	    })
	}
</script>
</html>

