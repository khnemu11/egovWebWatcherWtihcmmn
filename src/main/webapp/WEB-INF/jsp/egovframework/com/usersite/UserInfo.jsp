<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Update</title>
<%@ include file="/WEB-INF/jsp/egovframework/com/common/head.jsp"%>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/com/com.css' />">

<script type="text/javascript"
	src="<c:url value='/js/egovframework/com/sym/ccm/zip/EgovZipPopup.js' />"></script>

<script type="text/javaScript" defer="defer">
function fnListPage(){
    document.userSiteVO.action = "<c:url value='/uss/umt/EgovUserManage.do'/>";
    document.userSiteVO.submit();
}
function fnDeleteUser(checkedIds) {
	if(confirm("<spring:message code="common.delete.msg" />")){
	    document.listForm.checkedIdForDel.value=checkedIds;
	    document.listForm.action = "<c:url value='/user/userDelete.do'/>";
	    document.listForm.submit();
	}
}


function fnUpdate(form){
	if(confirm("<spring:message code="common.save.msg" />")){
	    if(validateUserManageVO(form)){
	    	form.submit();
	        return true;
	    }else{
	    	return false;
	    }
	}
}
function fn_egov_inqire_cert() {
	var url = "<c:url value='/uat/uia/EgovGpkiRegist.do' />";
	var popupwidth = '500';
	var popupheight = '400';
	var title = '인증서';

	Top = (window.screen.height - popupheight) / 3;
	Left = (window.screen.width - popupwidth) / 2;
	if (Top < 0) Top = 0;
	if (Left < 0) Left = 0;
	Future = "fullscreen=no,toolbar=no,location=no,directories=no,status=no,menubar=no,	scrollbars=no,resizable=no,left=" + Left + ",top=" + Top + ",width=" + popupwidth + ",height=" + popupheight;
	PopUpWindow = window.open(url, title, Future)
	PopUpWindow.focus();
}

function fn_egov_dn_info_setting(dn) {
	var frm = document.userSiteVO;

	frm.subDn.value = dn;
}

</script>
</head>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@ include file="/WEB-INF/jsp/egovframework/com/common/header.jsp"%>

		<main class="mdl-layout__content">
			<div class="mdl-grid">
				<div
					class="mdl-cell--3-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>

				<form:form commandName="userSiteVO" action="userUpdate.do"
					name="listForm" method="post"
					onSubmit="fnUpdate(document.forms[0]); return false;">
					<div class="wTableFrm">
						<!-- User seq -->
						<input type="hidden" name="seq"
							value="<c:out value='${userSiteVO.seq}'/>" />
						<!-- 상세정보 사용자 삭제시 prameter 전달용 input -->
						<input name="checkedIdForDel" type="hidden" />
						<!-- 검색조건 유지 -->
						<input type="hidden" name="searchCondition"
							value="<c:out value='${userSiteVO.searchCondition}'/>" /> <input
							type="hidden" name="searchKeyword"
							value="<c:out value='${userSiteVO.searchKeyword}'/>" /> <input
							type="hidden" name="pageIndex"
							value="<c:out value='${userSiteVO.pageIndex}'/>" />
						<!-- for validation -->

						<!-- 타이틀 -->
						<h2>${pageTitle}
							<spring:message code="title.update" />
						</h2>

						<table class="wTable"
							summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
							<caption>${pageTitle}
								<spring:message code="title.create" />
							</caption>
							<colgroup>
								<col style="width: 22%;">
								<col style="width:;">
							</colgroup>
							<tbody>
								<!-- 입력/선택 -->
								<c:set var="inputTxt">
									<spring:message code="input.input" />
								</c:set>
								<c:set var="inputSelect">
									<spring:message code="input.cSelect" />
								</c:set>
								<c:set var="inputSelect">
									<spring:message code="input.select" />
								</c:set>
								<!-- 로그인 아이디 -->
								<c:set var="title">
									<spring:message code="usersite.userManageList.loginId" />
								</c:set>
								<tr>
									<th><label for="loginId">${title}</label> <span
										class="pilsu">*</span></th>
									<td class="left"><form:input path="loginId"
											id="loginId" title="${title} ${inputTxt}"
											cssClass="txaIpUmt" size="30" maxlength="50" readonly="true"/>
										<div>
											<form:errors path="loginId" cssClass="error" />
										</div></td>
								</tr>

								<!-- 비밀번호 -->
								<c:set var="title">
									<spring:message code="usersite.deptUserManageRegist.pass" />
								</c:set>
								<tr>
									<th><label for="password">${title}</label> <span
										class="pilsu">*</span></th>
									<td class="left"><input type="password" name="password"
											id="password" title="${title} ${inputTxt}" size="30" maxlength="50" />
										<div>
											<form:errors path="password" cssClass="error" />
										</div></td>
								</tr>

								<!-- 이메일주소 -->
								<c:set var="title">
									<spring:message code="usersite.deptUserManageRegist.email" />
								</c:set>
								<tr>
									<th><label for="email">${title}</label> <span
										class="pilsu">*</span></th>
									<td class="left"><form:input path="email"
											id="mberEmailAdres" title="${title} ${inputTxt}"
											cssClass="txaIpUmt" size="30" maxlength="50" />
										<div>
											<form:errors path="email" cssClass="error" />
										</div></td>
								</tr>

								<!-- 이름 -->
								<c:set var="title">
									<spring:message code="usersite.deptUserManageRegist.name" />
								</c:set>
								<tr>
									<th><label for="name">${title}</label> <span class="pilsu">*</span></th>
									<td class="left"><form:input path="name" id="userName"
											title="${title} ${inputTxt}" cssClass="txaIpUmt" size="30"
											maxlength="50" />
										<div>
											<form:errors path="name" cssClass="error" />
										</div></td>
								</tr>

								<!-- 닉네임 -->
								<c:set var="title">
									<spring:message code="usersite.deptUserManageRegist.dispname" />
								</c:set>
								<tr>
									<th><label for="dispname">${title}</label></th>
									<td class="left"><form:input path="dispname"
											title="${title} ${inputTxt}" size="50" maxlength="60" />
										<div>
											<form:errors path="dispname" cssClass="error" />
										</div></td>
								</tr>

								<!-- 회사 -->
								<c:set var="title">
									<spring:message code="usersite.deptUserManageRegist.company" />
								</c:set>
								<tr>
									<th><label for="company">${title}</label></th>
									<td class="left"><form:input path="company"
											title="${title} ${inputTxt}" size="50" maxlength="60" />
										<div>
											<form:errors path="company" cssClass="error" />
										</div></td>
								</tr>

								<!-- 헨드폰번호 -->
								<c:set var="title">
									<spring:message code="usersite.deptUserManageRegist.phone" />
								</c:set>
								<tr>
									<th><label for="tel">${title}</label></th>
									<td class="left"><form:input path="tel" id="tel"
											title="${title} ${inputTxt}" cssClass="txaIpUmt" size="20"
											maxlength="15" />
										<div>
											<form:errors path="tel" cssClass="error" />
										</div></td>
								</tr>
							</tbody>
						</table>


						<!-- 하단 버튼 -->
						<div class="btn">
							<input type="submit" class="s_submit"
								value="<spring:message code="button.save" />"
								title="<spring:message code="button.save" /> <spring:message code="input.button" />" />
							<button class="btn_s2"
								onClick="fnDeleteUser('<c:out value='${userSiteVO.seq}'/>:<c:out value='${userSiteVO.loginId}'/>'); return false;"
								title="<spring:message code="button.delete" /> <spring:message code="input.button" />">
								<spring:message code="button.delete" />
							</button>
							<span class="btn_s"><a
								href="<c:url value='/user/userSite.do' />"
								title="<spring:message code="button.list" /> <spring:message code="input.button" />"><spring:message
										code="button.list" /></a></span>
							<button class="btn_s2"
								onClick="document.userSiteVO.reset(); return false;"
								title="<spring:message code="button.reset" /> <spring:message code="input.button" />">
								<spring:message code="button.reset" />
							</button>
						</div>
						<div style="clear: both;"></div>

					</div>
				</form:form>

			</div>



			<%@ include file="/WEB-INF/jsp/egovframework/com/common/footer.jsp"%>
		</main>
	</div>
</body>
</html>