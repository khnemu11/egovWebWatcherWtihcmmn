<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="validator"
	uri="http://www.springmodules.org/tags/commons-validator"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	/**
* @Class Name : SiteRegister.jsp
* @Description : Site Register 화면
* @Modification Information
* 
* @author 김수현
* @since 2022-09-24
* @version 1.0
* @see
*  
* Copyright (C) All right reserved.
*/
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/WEB-INF/jsp/egovframework/com/common/head.jsp"%>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<title><spring:message code="email.signIn"/> | <spring:message code="email.check"/></title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/egovframework/com/email/email.css'/>" />
</head>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@ include file="/WEB-INF/jsp/egovframework/com/common/header.jsp"%>

		<main class="mdl-layout__content"> <form:form
			commandName="emailVO" name="detailForm" id="detailForm"
			action="./emailCheck.do">
			<div class="mdl-grid">
				<div
					class="mdl-cell mdl-cell--4-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>
				<div
					class="mdl-cell mdl-cell--4-col-desktop mdl-cell--4-col-tablet mdl-cell--4-col-phone">
					<span id="title"><spring:message code="email.title" /></span>
				</div>
				<div
					class="mdl-cell mdl-cell--4-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>
			</div>
			<div class="mdl-grid">
				<div
					class="mdl-cell mdl-cell--3-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>
				<div
					class="mdl-cell mdl-cell--6-col-desktop mdl-cell--4-col-tablet mdl-cell--4-col-phone"
					id="input">
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<label class="mdl-textfield__label" for="url"><spring:message
								code="email.email" /></label>
						<form:input id="email" cssClass="mdl-textfield__input"
							path="email" value="${emailVO.email}" />
					</div>
					<div class="error-field">
						<form:errors path="email" />
					</div>
				</div>
				<div
					class="mdl-cell mdl-cell--3-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>
			</div>
			<div class="mdl-grid">
				<div
					class="mdl-cell mdl-cell--3-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>
				<div
					class="mdl-cell mdl-cell--6-col-desktop mdl-cell--4-tablet mdl-cell--4-col-phone"
					id="submit">
					<div class="w-80">
						<button type="submit"
							class="mdl-button mdl-js-ripple-effect mdl-js-button mdl-button--raised mdl-button--colored"
							id="register" onclick="javascript:egov_save();">
							<spring:message code="email.submit" />
						</button>
					</div>

				</div>
				<div
					class="mdl-cell mdl-cell--3-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>
			</div>




		</form:form> <%@ include file="/WEB-INF/jsp/egovframework/com/common/footer.jsp"%>
		</main>
	</div>

</body>
</html>

