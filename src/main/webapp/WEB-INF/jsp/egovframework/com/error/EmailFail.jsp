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
<title><spring:message code="email.signIn"/> | <spring:message code="email.check"/></title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/egovframework/com/email/emailSuccess.css'/>" />
</head>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@ include file="/WEB-INF/jsp/egovframework/com/common/header.jsp"%>
		<main class="mdl-layout__content">
		<div class="mdl-grid">
			<div
				class="mdl-cell mdl-cell--2-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>
			<div
				class="mdl-cell mdl-cell--8-col-desktop mdl-cell--4-col-tablet mdl-cell--4-col-phone">
				<span id="title"><spring:message code="email.fail.title" /></span>
			</div>
			<div
				class="mdl-cell mdl-cell--2-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>
		</div>
		<div class="mdl-grid context-grid">
			<div
				class="mdl-cell mdl-cell--4-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>
			<div
				class="mdl-cell mdl-cell--4-col-desktop mdl-cell--4-col-tablet mdl-cell--4-col-phone">
				<span id="context"><spring:message
						code="email.fail.context" /></span>
			</div>
			<div
				class="mdl-cell mdl-cell--4-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>
		</div>
		<%@ include file="/WEB-INF/jsp/egovframework/com/common/footer.jsp"%>
		</main>
	</div>

</body>
</html>

