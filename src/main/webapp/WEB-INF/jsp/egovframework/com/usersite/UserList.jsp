<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<%@ include file="/WEB-INF/jsp/egovframework/com/common/head.jsp"%>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/com/com.css' />">

</head>

<script type="text/javascript">

<c:if test="${!empty resultMsg}">alert("<spring:message code="${resultMsg}" />");</c:if>

function fncCheckAll() {
    var checkField = document.listForm.checkField;
    if(document.listForm.checkAll.checked) {
        if(checkField) {
            if(checkField.length > 1) {
                for(var i=0; i < checkField.length; i++) {
                    checkField[i].checked = true;
                }
            } else {
                checkField.checked = true;
            }
        }
    } else {
        if(checkField) {
            if(checkField.length > 1) {
                for(var j=0; j < checkField.length; j++) {
                    checkField[j].checked = false;
                }
            } else {
                checkField.checked = false;
            }
        }
    }
}
function fnDeleteUser() {
    var checkField = document.listForm.checkField;
    var id = document.listForm.checkId;
    var checkedIds = "";
    var checkedCount = 0;
    if(checkField) {
        if(checkField.length > 1) {
            for(var i=0; i < checkField.length; i++) {
                if(checkField[i].checked) {
                    checkedIds += ((checkedCount==0? "" : ",") + id[i].value);
                    checkedCount++;
                }
            }
        } else {
            if(checkField.checked) {
                checkedIds = id.value;
            }
        }
    }
    if(checkedIds.length > 0) {
        if(confirm("<spring:message code="common.delete.msg" />")){
        	document.listForm.checkedIdForDel.value=checkedIds;
            document.listForm.action = "<c:url value='/user/userDelete.do'/>";
            document.listForm.submit();
        }
    }
}
function fnSelectUser(id) {
    document.listForm.selectedId.value = id;
    array = id.split(":");
    if(array[0] == "") {
    } else {
        userTy = array[0];
        userId = array[1];
    }
   	document.listForm.selectedId.value = userId;
    document.listForm.action = "<c:url value='/uss/umt/EgovUserSelectUpdtView.do'/>";
    document.listForm.submit();

}
function fnAddUserView() {
    document.listForm.action = "<c:url value='/uss/umt/EgovUserInsertView.do'/>";
    document.listForm.submit();
}
function fnLinkPage(pageNo){
    document.listForm.pageIndex.value = pageNo;
    document.listForm.action = "<c:url value='/uss/umt/EgovUserManage.do'/>";
    document.listForm.submit();
}
function fnSearch(){
	document.listForm.pageIndex.value = 1;
	document.listForm.action = "<c:url value='/uss/umt/EgovUserManage.do'/>";
    document.listForm.submit();
}
function fnViewCheck(){
    if(insert_msg.style.visibility == 'hidden'){
    	insert_msg.style.visibility = 'visible';
    }else{
    	insert_msg.style.visibility = 'hidden';
    }
}
</script>

<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">

		<main class="mdl-layout__content">
			<div class="mdl-grid">
				<div
					class="mdl-cell--2-col-desktop mdl-cell--2-col-tablet mdl-cell--hide-phone"></div>

				<form name="listForm"
					action="<c:url value='./userSite.do'/>" method="post">
					<div class="board">
						<h1>${pageTitle}
							<spring:message code="title.list" />
						</h1>

						<!-- 검색영역 -->
						<div class="search_box"
							title="<spring:message code="common.searchCondition.msg" />">
							<ul>
								<li>
									<!-- 조건 --> <select name="searchCondition" id="searchCondition"
									title="<spring:message code="usersite.userManageSsearch.searchConditioTitle" />">
										<!--  -->
										<option value="0"
											<c:if test="${userSiteVO.searchCondition == '0'}">selected="selected"</c:if>><spring:message
												code="usersite.userManageSsearch.searchConditionLoginId" /></option>
										<!-- ID  -->
										<option value="1"
											<c:if test="${empty userSiteVO.searchCondition || userSiteVO.searchCondition == '1'}">selected="selected"</c:if>><spring:message
												code="usersite.userManageSsearch.searchConditionCompany" /></option>
										<!-- Name -->
								</select>
								</li>
								<!-- 검색키워드 및 조회버튼 -->
								<li><input class="s_input" name="searchKeyword" type="text"
									size="35"
									title="<spring:message code="title.search" /> <spring:message code="input.input" />"
									value='<c:out value="${userSiteVO.searchKeyword}"/>'
									maxlength="255"> <input type="submit" class="s_btn"
									value="<spring:message code="button.inquire" />"
									title="<spring:message code="title.inquire" /> <spring:message code="input.button" />" />
									<input type="button" class="s_btn"
									onClick="fnDeleteUser(); return false;"
									value="<spring:message code="title.delete" />"
									title="<spring:message code="title.delete" /> <spring:message code="input.button" />" />
									<span class="btn_b"><a
										href="<c:url value='/uss/umt/EgovMberInsertView.do'/>"
										onClick="fnAddUserView(); return false;"
										title="<spring:message code="button.create" /> <spring:message code="input.button" />"><spring:message
												code="button.create" /></a></span></li>
							</ul>
						</div>


						<table class="board_list"
							summary="<spring:message code="common.summary.list" arguments="${pageTitle}" />">
							<caption>${pageTitle}
								<spring:message code="title.list" />
							</caption>
							<colgroup>
								<col style="width: 5%;">
								<col style="width: 3%;">

								<col style="width: 20%;">
								<col style="width: 10%;">
								<col style="width: 10%;">
								<col style="width: 10%;">
								<col style="width: 15%;">
								<col style="width: 10%;">
								<col style="width:;">

							</colgroup>
							<thead>
								<tr>
									<th><spring:message code="table.num" /></th>
									<!-- 번호 -->
									<th><input type="checkbox" name="checkAll" class="check2"
										onclick="javascript:fncCheckAll()"
										title="<spring:message code="input.selectAll.title" />"></th>
									<!-- 전체선택 -->

									<th><spring:message code="usersite.userManageList.email" /></th>
									<th><spring:message code="usersite.userManageList.name" /></th>
									<th><spring:message code="usersite.userManageList.company" /></th>
									<th><spring:message code="usersite.userManageList.tel" /></th>
									<th><spring:message code="usersite.userManageList.loginId" /></th>
									<th><spring:message
											code="usersite.userManageList.siteList" /></th>
									<th><spring:message code="usersite.userManageList.action" /></th>

								</tr>
							</thead>
							<tbody class="ov">
								<c:if test="${fn:length(resultList) == 0}">
									<tr>
										<td colspan="9"><spring:message code="common.nodata.msg" /></td>
									</tr>
								</c:if>
								<c:forEach var="result" items="${resultList}" varStatus="status">
									<tr>
										<td><c:out value="${status.count}" /></td>
										<td><input name="checkField"
											title="checkField <c:out value="${status.count}"/>"
											type="checkbox" /> <input name="checkId" type="hidden"
											value="<c:out value='${result.seq}'/>:<c:out value='${result.loginId}'/>" />
										</td>
										<td><c:out value="${result.email}" /></td>
										<td><c:out value="${result.name}" /></td>
										<td><c:out value="${result.company}" /></td>
										<td><c:out value="${result.tel}" /></td>
										<td><c:out value="${result.login_id}" /></td>

										<td><a href="../site/SiteList/${result.seq}.do"><span
												class="material-icons">search</span></a></td>
										<td><a href="userInfo.do?userSeq=${result.seq}"><span
												class="material-icons">edit</span></a><a><span
												class="material-icons" onclick="fnDeleteUser(); return false;">delete</span></a></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>

						<!-- paging navigation -->
						<div class="pagination">
							<ul>
								<ui:pagination paginationInfo="${paginationInfo}" type="image"
									jsFunction="fnLinkPage" />
							</ul>
						</div>

						<input name="selectedId" type="hidden" /> <input
							name="checkedIdForDel" type="hidden" /> <input name="pageIndex"
							type="hidden" value="<c:out value='${userSiteVO.pageIndex}'/>" />
					</div>
				</form>

			</div>



		</main>
	</div>




</body>
</html>