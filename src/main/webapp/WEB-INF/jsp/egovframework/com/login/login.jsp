<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jsp/egovframework/com/common/head.jsp"%>
<title>Login</title>
</head>
<body>
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@ include
			file="/WEB-INF/jsp/egovframework/com/common/header.jsp"%>

		<main class="mdl-layout__content">
			<div class="mdl-grid">
				<div class="mdl-cell mdl-cell--4-col"></div>

				<div
					class="mdl-cell mdl-cell--4-col mdl-card mdl-shadow--16dp util-center util-spacing-h--100px">
					<div class="mdl-card__title mdl-color--teal-500">
						<h2 class="mdl-card__title-text mdl-color-text--white">Login</h2>
					</div>
					<div class="mdl-card__supporting-text mdl-grid">

						<form:form action="loginOk.do" method="POST" commandName="loginVO">
							<input type="hidden" name="action" value="login" />
							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_new_login_id">ID</label> <form:input
									class="mdl-textfield__input" path="loginId" type="text"
									id="textfield_new_login_id" name="loginId" />
									<form:errors path="loginId"/>
							</div>

							<div
								class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
								<label class="mdl-textfield__label mdl-color-text--grey"
									for="textfield_new_password">Password</label> <form:input
									class="mdl-textfield__input" type="password"
									id="textfield_new_password" name="password" path="password"/>
									<form:errors path="password" />
							</div>

							<div class="mdl-cell mdl-cell--12-col send-button" align="center">
								<button
									class="mdl-button mdl-js-ripple-effect mdl-js-button mdl-button--raised mdl-button--colored"
									id="login">LOG IN</button>
							</div>

							<div class="mdl-cell mdl-cell--12-col send-button" align="center">
								<button class="mdl-button mdl-js-button mdl-js-ripple-effect"
									id="Register">SignUp</button>
							</div>

							<div class="mdl-cell mdl-cell--12-col" align="center">
								<a href="#">Forgot Password?</a>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</main>
		
		<%@ include
			file="/WEB-INF/jsp/egovframework/com/common/footer.jsp"%>
	</div>

	<script type="text/javascript" src="../../resources/arc/js/material.js"></script>
</body>
</html>



<!-- 
<figure class="front">
                <div class="mdl-card mdl-shadow--6dp">
                    <div class="mdl-card__title mdl-color--primary mdl-color-text--white relative">
                        <h2 class="mdl-card__title-text">Simple Login</h2>
                    </div>

                    <div class="mdl-card__supporting-text">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" id="login"/>
                            <label class="mdl-textfield__label" for="login">Login</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="password" id="password"/>
                            <label class="mdl-textfield__label" for="password">Password</label>
                        </div>
                    </div>

                    <div class="mdl-card__actions mdl-card--border">
                        <div class="mdl-grid">
                            <button class="mdl-cell mdl-cell--12-col mdl-button mdl-button--raised mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-color-text--white">
                                Login
                            </button>

                        </div>

                        <div class="mdl-grid">
                            <div class="mdl-cell mdl-cell--12-col">
                                <a onClick='flip("show-left")' class="mdl-color-text--primary">Sign up!</a>
                                <a onClick='flip("show-bottom")' class="mdl-color-text--primary" style="float: right">Lost
                                    Password?</a>
                            </div>
                        </div>
                    </div>
                </div>
            </figure> -->