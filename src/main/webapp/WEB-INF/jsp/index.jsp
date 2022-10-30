<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	/**
* @Class Name : SiteList.jsp
* @Description : Site List 화면
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=100%,initial-scale=1" />
<title>Web Watcher</title>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons"></link>
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css"></link>
<script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/egovframework/com/top/top.css"/>" />
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@ include file="/WEB-INF/jsp/egovframework/com/common/header.jsp"%>

		<main class="mdl-layout__content">



		<div class="top">
			<div class="context top-context">
				<h3 class="slogun">The Best Way of Web Site Management</h3>
				<img class="logo"
					src="<c:url value='/images/egovframework/com/main/logo_without_color.png'/>" />
				<button class="mdl-button mdl-js-button mdl-js-ripple-effect start">
					Get Started</button>
			</div>
			<div class="top-divider"></div>
			<div class="context divider-bottom"></div>
		</div>
		<div class="mid">
			<div class="mdl-grid mid-grid">
				<div
					class="mdl-cell mdl-cell--6-col-desktop mdl-cell--4-col-tablet mdl-cell--4-col-phone context-img">
					<img class="context-img"
					src="<c:url value='/images/egovframework/com/main/programming.png'/>" />
				</div>
				<div
					class="mdl-cell mdl-cell--6-col-desktop mdl-cell--4-col-phone mdl-cell--4-col-tablet context-description">
					<span class="mid-title">더이상 직접 테스트하지 마세요</span>
					<span class="mid-sub">테스트 시나리오만 등록하면 정해진 시간마다 자동으로 테스팅을 실행합니다.</span>
				</div>
			</div>
		</div>


		<div class="mdl-grid">
			<div
				class="mdl-cell mdl-cell--2-col-desktop mdl-cell--1-col-tablet mdl-cell--hide-phone"></div>
			<div
				class="mdl-cell mdl-cell--8-col-desktop mdl-cell--4-col-phone mdl-cell--6-col-tablet">

			</div>
			<div
				class="mdl-cell mdl-cell--2-col-desktop mdl-cell--1-col-tablet mdl-cell--hide-phone">
			</div>
		</div>

		<%@ include file="/WEB-INF/jsp/egovframework/com/common/footer.jsp"%>
		</main>
	</div>
</body>
</html>











