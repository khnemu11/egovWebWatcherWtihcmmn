<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/jsp/egovframework/com/common/head.jsp"%>
	<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/signup/signup.css'/>"/>
	
	<title>Signup</title>
</head>
<body>
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
	<%@ include file="/WEB-INF/jsp/egovframework/com/common/header.jsp"%>
		
	<main class="mdl-layout__content">
		<div class="page-content">
			
				<div class="mdl-layout mdl-js-layout">

    <section class="container">
        <div id="cube" class="show-front">
            <figure class="left">
                <div class="mdl-card mdl-shadow--6dp">
                    <div class="mdl-card__title mdl-color--primary mdl-color-text--white relative">
                        <a class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon"
                           onClick='flip("show-front")'>
                            <i class="material-icons">arrow_back</i>
                        </a>
                        <h2 class="mdl-card__title-text">Sign up</h2>
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

                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="password" id="password2"/>
                            <label class="mdl-textfield__label" for="password2">Password repeat</label>
                        </div>
                    </div>

                    <div class="mdl-card__actions mdl-card--border">
                        <div class="mdl-grid">
                            <button class="mdl-cell mdl-cell--12-col mdl-button mdl-button--raised mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-color-text--white">
                                Sign up
                            </button>
                        </div>
                    </div>
                </div>

            </figure>
        </div>
    </section>
</div>
				

		</div>
	</main>

	<%@ include file="/WEB-INF/jsp/egovframework/com/common/footer.jsp"%>
</div>

</body>
</html>

