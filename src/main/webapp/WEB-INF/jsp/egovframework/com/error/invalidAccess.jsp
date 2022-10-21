<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/egovframework/com/common/head.jsp"%>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/com/common/common.css'/>" />
<title>Login</title>
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@ include
			file="/WEB-INF/jsp/egovframework/com/common/header.jsp"%>

		<main class="mdl-layout__content">
			<h2><spring:message code="error.invalidAccess.title"/></h2>
			
			<%@ include
			file="/WEB-INF/jsp/egovframework/com/common/footer.jsp"%>
		</main>
	</div>

	<script type="text/javascript" src="../../resources/arc/js/material.js"></script>
</body>
</html>