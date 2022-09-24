<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- <%@ include file="/common/inc/common.jsp"%> --%><html>
<head>
	<%-- <%@ include file="/common/inc/head.jsp"%> --%>
	<link rel="stylesheet" href="../arc/login/login.css">
</head>
<body>

<div class="container_login">
<div class="mdl-grid">
<div class = "mdl-cell mdl-cell--2-col "></div>
<div class = "mdl-cell mdl-cell--8-col" id="row_login">
<s:form method="POST" theme="simple">
				<s:if test="form.blockdate != null">
					<s:text name="errors.login.overlimit"><s:param value="form.blockdate"/></s:text>
				</s:if>
				 <div class="mdl-grid">
        <div class = "mdl-cell mdl-cell--4-col-desktop mdl-cell--2-col-tablet"></div>
        <div class = "mdl-cell mdl-cell--4-col-desktop mdl-cell--4-col-tablet mdl-cell--4-col-phone" id="login-form">
          <h3 class="content-title"><s:text name="managerLogin.title"/></h3>
          <div class="input-name"><s:text name="login.id"/></div>
          <div class="mdl-textfield mdl-js-textfield textfield">
            <s:textfield name="form.loginId" cssClass="mdl-textfield__input" id="loginId" ></s:textfield>
          </div>
          <s:fielderror theme="simple"><s:param name="form.idfail">form.idfail</s:param></s:fielderror>
          <div class="input-password"><s:text name="login.password"/></div>
          <div class="mdl-textfield mdl-js-textfield textfield">
            <s:password name="form.password" cssClass="mdl-textfield__input" id="password"/>
          </div>
          <s:fielderror theme="simple"><s:param name="form.passwordfail">form.passwordfail</s:param></s:fielderror>
          <s:submit id="login-button" action="login_login" cssClass="mdl-button mdl-js-button mdl-js-ripple-effect" key="login.login"/>
        </div>
        <div class = "mdl-cell mdl-cell--4-col-desktop mdl-cell--2-col-tablet"></div>
      </div>
</s:form>
</div>
<div class = "mdl-cell mdl-cell--2-col "></div>
</div>
</div>

<script type="text/javascript"
	src="../../resources/arc/js/material.js"></script>
</body>
</html>