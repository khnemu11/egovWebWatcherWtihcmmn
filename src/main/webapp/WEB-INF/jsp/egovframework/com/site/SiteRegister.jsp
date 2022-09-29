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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=100%,initial-scale=1" />
<c:set var="userSeq" value="${userSeq}" />
<title>Web Watcher</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons"></link>
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css"></link>
<script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/egovframework/com/site/siteRegister.css'/>" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<c:set var="registerFlag"
	value="${siteVO.seq == 0 ? 'register' : 'modify'}" />
<script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>
<title><c:out value="${registerFlag}" /></title>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="siteVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* 글 목록 화면 function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/site/SiteList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 삭제 function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/site/deleteSite.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* 글 등록 function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation기능 보완 */
	
  	frm.action = "<c:url value="${registerFlag == '등록' ? '/site/addSite.do' : '/site/updateSite.do'}"/>";
    frm.submit();

}
// -->
function delete_site(seq) {
	if(confirm("정말로 삭제하시겠습니까?")){
		var url = "./deleteSite/";
		url= url+ seq;
		url=url+".do";
		location.href = url;
	}
}
        $(document).ready(function(){
        		var text = '${error == 'error' ? "error" :"none"}';
        		console.log(text);
        		if(text == "error"){
        			alert("중복된 파일 이름이 존재합니다.");
        		}
        });
        $(function(){
        	 $('#mdl-button--file').click(function(){
         		$('#uploadBtn').click();
        	 });
        	 
        	 $("#uploadBtn").change(function(){
        		 $("#uploadFile").val($("#uploadBtn")[0].files[0].name);	 
        	 });
        });
        document.addEventListener('keydown', function(event) {
			if (event.keyCode === 13) {
			event.preventDefault();
			};
		}, true); //form 내용 발송 시 엔터키를 누르면 화면이 다시 리로드 되는 것을 막아 엔터로 form을 발송하는 것을 막는 키
   
</script>
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header">
		<div class="mdl-layout__header-row">
			<span class="mdl-layout-title"><spring:message code="title" /></span>
			<div class="mdl-layout-spacer"></div>
			<nav class="mdl-navigation mdl-layout--large-screen-only"> <a
				class="mdl-navigation__link" href="">Link</a> <a
				class="mdl-navigation__link" href="">Link</a> <a
				class="mdl-navigation__link" href="">Link</a> <a
				class="mdl-navigation__link" href="./egovSampleList.do">sample</a> </nav>
		</div>
		</header>
		<div class="mdl-layout__drawer">
			<span class="mdl-layout-title"><spring:message code="title" /></span>
			<nav class="mdl-navigation"> <a class="mdl-navigation__link"
				href="">Link</a> <a class="mdl-navigation__link" href="">Link</a> <a
				class="mdl-navigation__link" href="">Link</a> <a
				class="mdl-navigation__link" href="">Link</a> </nav>
		</div>
		<main class="mdl-layout__content">
		<div class="page-content">



			<form:form commandName="siteVO" name="detailForm" id="detailForm"
				enctype="multipart/form-data">
				<form:input type="hidden" id="userSeq" path="userSeq"
					value="${userSeq}" />
				<div id="content_pop">
					<!-- 타이틀 -->
					<span class="mdl-layout-title title"> <c:if
							test="${registerFlag == 'register'}">
							<spring:message code="site.add" />
						</c:if> <c:if test="${registerFlag == 'modify'}">
							<spring:message code="site.edit" />
						</c:if>
					</span>
					<div class="file-div">
						<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<label class="mdl-textfield__label" for="url"><spring:message
									code="site.url" /></label>
							<form:input path="url" value="${siteVO.url}" maxlength="30"
								cssClass="mdl-textfield__input" id="url" />
							<form:errors path="url" />
						</div>
						<span id="blank"></span>
					</div>
					<div class="file-div">
						<div class="mdl-textfield mdl-js-textfield mdl-textfield--file">
							<form:input cssClass="mdl-textfield__input" placeholder="File"
								type="text" path="" id="uploadFile" readonly="true" />

							<form:input type="file" path="file" id="uploadBtn" />
							<c:if test="${registerFlag == 'modify'}">
								<spring:message code="site.currFile"
									arguments="${siteVO.fileName}" />
								<form:input type="hidden" id="seq" path="seq"
									value="${siteVO.seq}" />
								<form:input type="hidden" id="fileId" path="fileId"
									value="${siteVO.fileId}" />
							</c:if>
						</div>
						<div class="mdl-button mdl-button--primary mdl-button--icon"
							id="mdl-button--file">
							<i class="material-icons">attach_file</i>
						</div>
					</div>

					<div id="sysbtn">
						<a href="javascript:fn_egov_selectList();"><span
							class="material-symbols-outlined"> arrow_back </span></a>

						<c:if test="${registerFlag == 'modify'}">
							<a href="javascript:delete_site(${siteVO.seq});"><span
								class="material-symbols-outlined">delete</span></a>
						</c:if>
						
						<a href="javascript:document.detailForm.reset();"><span
							class="material-symbols-outlined"> refresh </span></a>
						<button
							class="mdl-button mdl-js-ripple-effect mdl-js-button mdl-button--raised mdl-button--colored"
							id="register" onclick="javascript:fn_egov_save();">
							<c:if test="${registerFlag == 'register'}">
								<spring:message code="site.add" />
							</c:if>
							<c:if test="${registerFlag == 'modify'}">
								<spring:message code="site.edit" />
							</c:if>
						</button>
					</div>
				</div>
				<!-- 검색조건 유지 -->
				<input type="hidden" name="searchCondition"
					value="<c:out value='${searchVO.searchCondition}'/>" />
				<input type="hidden" name="searchKeyword"
					value="<c:out value='${searchVO.searchKeyword}'/>" />
				<input type="hidden" name="pageIndex"
					value="<c:out value='${searchVO.pageIndex}'/>" />
			</form:form>







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
</body>
</html>

