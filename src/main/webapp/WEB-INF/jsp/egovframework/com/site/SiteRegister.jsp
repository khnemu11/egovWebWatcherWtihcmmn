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
<c:set var="userSeq" value="${loginInfo.userSeq}" />
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
<title><c:if test="${registerFlag == 'register'}">
		<spring:message code="site.add" />
	</c:if> <c:if test="${registerFlag == 'modify'}">
		<spring:message code="site.edit" />
	</c:if></title>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="siteVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
// -->
function egov_selectList(){
	var url = "<c:url value="/WebWatcher/site/SiteList/${userSeq}.do"/>";
	location.fref=url;
}
function egov_save(){
	frm = document.getElementById("detailForm");
	frm.action = "<c:url value="${registerFlag == 'register' ? '/site/addSite.do' : '/site/updateSite.do'}"/>";
    frm.submit();
}
function delete_site(seq) {
	if(confirm("정말로 삭제하시겠습니까?")){
		var url = "./deleteSite/";
		url= url+ seq;
		url=url+".do";
		location.href = url;
	}
}
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
		<%@ include file="/WEB-INF/jsp/egovframework/com/common/header.jsp"%>

		<main class="mdl-layout__content"> <form:form
			commandName="siteVO" name="detailForm" id="detailForm"
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
				<div class="url-div">
					<div
						class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
						<label class="mdl-textfield__label" for="url"><spring:message
								code="site.url" /></label>
						<form:input path="url" value="${siteVO.url}"
							cssClass="mdl-textfield__input" id="url" />

					</div>
					<div class="error-field">
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
						<c:if test="${registerFlag == 'register'}">
							<div class="error-field">
								<form:errors path="fileName" />
							</div>
						</c:if>
					</div>
					<div class="mdl-button mdl-button--primary mdl-button--icon"
						id="mdl-button--file">
						<i class="material-icons">attach_file</i>
					</div>
				</div>
				<div id="sysbtn">
					<a href="<c:url value="/site/SiteList/${userSeq}.do"/>"><span
						class="material-symbols-outlined"> arrow_back </span></a>

					<c:if test="${registerFlag == 'modify'}">
						<a href="javascript:delete_site(${siteVO.seq});"><span
							class="material-symbols-outlined">delete</span></a>
					</c:if>

					<a href="javascript:document.detailForm.reset();"><span
						class="material-symbols-outlined"> refresh </span></a>
					<button
						class="mdl-button mdl-js-ripple-effect mdl-js-button mdl-button--raised mdl-button--colored"
						id="register" onclick="javascript:egov_save();">
						<c:if test="${registerFlag == 'register'}">
							<spring:message code="site.add" />
						</c:if>
						<c:if test="${registerFlag == 'modify'}">
							<spring:message code="site.edit" />
						</c:if>
					</button>
				</div>
			</div>
		</form:form> <%@ include file="/WEB-INF/jsp/egovframework/com/common/footer.jsp"%>
		</main>
	</div>
</body>
</html>

