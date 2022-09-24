<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
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

<c:set var="registerFlag" value="${empty siteVO.seq ? '등록' : '수정'}"/>			

<title> <c:out value="${registerFlag}"/> </title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/sample.css'/>"/>

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
</script>
</head>
<body>

<form:form commandName="siteVO" name="detailForm" id="detailForm" >
<div id="content_pop">
	<!-- 타이틀 -->
	<div id="title">
		<ul>
			<li><img src="<c:url value='/images//title_dot.gif'/>" alt="" /><c:out value="${registerFlag}"/></li>
		</ul>
	</div>
	<!-- // 타이틀 -->
	<div id="table">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" >
		<colgroup>
			<col width="150"/>
			<col width=""/>
		</colgroup>
			
		<c:if test="${registerFlag == '수정'}">
		</c:if>
		<c:if test="${registerFlag == '등록'}">
		</c:if>		
		<tr>
			<th>seq</th>
			<td>
				<form:input path="seq" cssClass="txt"/>
				&nbsp;<form:errors path="seq" />
			</td>
		</tr>	
		<tr>
			<th>user_seq</th>
			<td>
				<form:input path="userSeq" cssClass="txt"/>
				&nbsp;<form:errors path="userSeq" />
			</td>
		</tr>	
		<tr>
			<th>url</th>
			<td>
				<form:input path="url" cssClass="txt"/>
				&nbsp;<form:errors path="url" />
			</td>
		</tr>	
		<tr>
			<th>version</th>
			<td>
				<form:input path="version" cssClass="txt"/>
				&nbsp;<form:errors path="version" />
			</td>
		</tr>	
		<tr>
			<th>file_name</th>
			<td>
				<form:input path="fileName" cssClass="txt"/>
				&nbsp;<form:errors path="fileName" />
			</td>
		</tr>	
		<tr>
			<th>file_path</th>
			<td>
				<form:input path="filePath" cssClass="txt"/>
				&nbsp;<form:errors path="filePath" />
			</td>
		</tr>	
		<tr>
			<th>ctime</th>
			<td>
				<form:input path="ctime" cssClass="txt"/>
				&nbsp;<form:errors path="ctime" />
			</td>
		</tr>	
		<tr>
			<th>cdate</th>
			<td>
				<form:input path="cdate" cssClass="txt"/>
				&nbsp;<form:errors path="cdate" />
			</td>
		</tr>	
		<tr>
			<th>utime</th>
			<td>
				<form:input path="utime" cssClass="txt"/>
				&nbsp;<form:errors path="utime" />
			</td>
		</tr>	
		<tr>
			<th>udate</th>
			<td>
				<form:input path="udate" cssClass="txt"/>
				&nbsp;<form:errors path="udate" />
			</td>
		</tr>	
		<tr>
			<th>dtime</th>
			<td>
				<form:input path="dtime" cssClass="txt"/>
				&nbsp;<form:errors path="dtime" />
			</td>
		</tr>	
		<tr>
			<th>ddate</th>
			<td>
				<form:input path="ddate" cssClass="txt"/>
				&nbsp;<form:errors path="ddate" />
			</td>
		</tr>	
	</table>
  </div>
	<div id="sysbtn">
		<ul>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_selectList();">List</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_save();"><c:out value='${registerFlag}'/></a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			<c:if test="${registerFlag == '수정'}">
			<li><span class="btn_blue_l"><a href="javascript:fn_egov_delete();">삭제</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li>
			</c:if>
			<li><span class="btn_blue_l"><a href="javascript:document.detailForm.reset();">Reset</a><img src="<c:url value='/images//btn_bg_r.gif'/>" alt="" /></span></li></ul>
	</div>
</div>
<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
</form:form>
</body>
</html>

