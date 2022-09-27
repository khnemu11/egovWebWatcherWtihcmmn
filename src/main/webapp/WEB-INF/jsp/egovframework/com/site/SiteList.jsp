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
<c:set var="userSeq" value="${userSeq}" />
<title>Web Watcher</title>

<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"></link>
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css"></link>
<script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/egovframework/com/site/site.css'/>" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<script>
function delete_site(seq) {
	if(confirm("정말로 삭제하시겠습니까?")){
		var url = "./deleteSite/";
		url= url+ seq;
		url=url+".do";
		location.href = url;
	}
}
<!--
/* 글 수정 화면 function */


function fn_egov_select(seq) {
    document.getElementById("listForm").seq.value = seq;
   	document.getElementById("listForm").action = "<c:url value='/site/updateSiteView.do'/>";
   	document.getElementById("listForm").submit();
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/site/addSiteView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/site/SiteList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header">
		<div class="mdl-layout__header-row">
			<span class="mdl-layout-title"><spring:message code="title" /></span>
			<div class="mdl-layout-spacer"></div>
			<nav class="mdl-navigation "> <a
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

			<div class="mdl-grid">
				<div
					class="mdl-cell mdl-cell--2-col-desktop mdl-cell--1-col-tablet mdl-cell--hide-phone"></div>
				<div
					class="mdl-cell mdl-cell--8-col-desktop mdl-cell--4-col-phone mdl-cell--6-col-tablet">
					<h3>
						<spring:message code="site.title" />
					</h3>
				</div>
				<div
					class="mdl-cell mdl-cell--2-col-desktop mdl-cell--1-col-tablet mdl-cell--hide-phone">
				</div>
			</div>



			<div class="mdl-grid">
				<div
					class="mdl-cell mdl-cell--1-col-desktop mdl-cell--hide-tablet mdl-cell--hide-phone"></div>
				<div
					class="mdl-cell mdl-cell--10-col-desktop mdl-cell--8-col-tablet mdl-cell--4-phone">
					<form:form commandName="searchVO" id="listForm" name="listForm"
						method="post">
						<input type="hidden" name="seq" />
						<div id="sysbtn">
							<a href="javascript:fn_egov_addView();"><span
								class="material-symbols-outlined add">add</span></a>
						</div>

						<table
							class="mdl-data-table mdl-js-data-table mdl-data-table mdl-shadow--2dp">
							<thead>
								<tr>
									<th><spring:message code="site.no" /></th>
									<th><spring:message code="site.url" /></th>
									<th><spring:message code="site.file.name" /></th>
									<th><spring:message code="site.download" /></th>
									<th>Result</th>
									<th><spring:message code="site.action" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="result" items="${resultList}" varStatus="status">
									<div class="listTile">
										<ul class='demo-list-two mdl-list'>
											<li class="mdl-list__item mdl-list__item--two-line"><span
												class="mdl-list__item-primary-content"><span id="url"><c:out
															value="${result.url}" /></span> </span> <span
												class="mdl-list__item-secondary-content"> <span
													class="mdl-list__item-secondary-info"></span> <a
													class="mdl-list__item-secondary-action"
													href="#"> <span
														class="material-symbols-outlined"> monitoring </span>
												</a>
											</span><span class="mdl-list__item-secondary-content"> <span
													class="mdl-list__item-secondary-info"></span> <a
													href="javascript:fn_egov_select('<c:out value="${result.seq}"/>')"><span
														class="material-symbols-outlined">edit</span></a>
											</span> <span class="mdl-list__item-secondary-content"> <span
													class="mdl-list__item-secondary-info"></span><a
													href="javascript:void(0)"
													onclick="delete_site(${result.siteSeq});"><span
														class="material-symbols-outlined">delete</span></a>
											</span></li>
											<li class="mdl-list__item mdl-list__item--two-line"><span
												class="mdl-list__item-primary-content"><c:out
														value="${result.fileName}" /></span> <span
												class="mdl-list__item-secondary-content"> <span
													class="mdl-list__item-secondary-info"></span> <a
													class="mdl-list__item-secondary-action"
													href="javascript:void()"
													onclick="window.open(encodeURI('<c:url value='/cmm/fms/selectFileInfs.do?'/>param_atchFileId=${result.fileId}'))">
														<span class="material-symbols-outlined">
															file_download </span>
												</a>
											</span></li>
										</ul>
									</div>
									<tr>

										<td class="listtd"><c:out value="${status.count}" /></td>
										<td class="listtd"><c:out value="${result.url}" /></td>
										<td class="listtd"><c:out value="${result.fileName}" /></td>
										<td class="listtd"><a href="javascript:void()"
											onclick="window.open(encodeURI('<c:url value='/cmm/fms/selectFileInfs.do?'/>param_atchFileId=${result.fileId}'))">
												<span class="material-symbols-outlined">
													file_download </span>
										</a></td>
										<td class="listtd"><a href="#"> <span
												class="material-symbols-outlined"> monitoring </span>
										</a></td>

										<td class="listtd"><c:out value="" /><a
											href="javascript:void(0)"
											onclick="delete_site(${result.siteSeq});"><span
												class="material-symbols-outlined">delete</span></a> <a
											href="javascript:fn_egov_select('<c:out value="${result.seq}"/>')"><span
												class="material-symbols-outlined">edit</span></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<!-- /List -->
						<div id="paging" align="center">
							<ui:pagination paginationInfo="${paginationInfo}" type="image"
								jsFunction="fn_egov_link_page" />
							<form:hidden path="pageIndex" />
						</div>


					</form:form>


				</div>
				<div
					class="mdl-cell mdl-cell--1-col-desktop mdl-cell--hide-tablet mdl-cell--hide-phone"></div>

			</div>

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
	<script defer src="https://code.getmdl.io/1.3.0/material.min.js" />
</body>
</html>











