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
<title>Web Watcher</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/egovframework/com/email/email.css'/>" />
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@ include file="/WEB-INF/jsp/egovframework/com/common/header.jsp"%>
		<span class="title">Email Check</span>
		<main class="mdl-layout__content"> <form:form
			commandName="emailVO" name="detailForm" id="detailForm"
			action="./emailCheck.do">
			<div
				class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
				<label class="mdl-textfield__label" for="url"><spring:message
						code="site.url" /></label>
				<form:input id="email" cssClass="mdl-textfield__input" path="email"
					value="${emailVO.email}" />
			</div>
			<button type="submit"
				class="mdl-button mdl-js-ripple-effect mdl-js-button mdl-button--raised mdl-button--colored"
				id="register" onclick="javascript:egov_save();">
				<spring:message code="site.add" />
			</button>
		</form:form> <%@ include file="/WEB-INF/jsp/egovframework/com/common/footer.jsp"%>
		</main>
	</div>
</body>
</html>

