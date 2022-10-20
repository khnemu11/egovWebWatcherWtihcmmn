<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/egovframework/com/common/header.css'/>" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons"></link>
<link rel="stylesheet"
	href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css"></link>
<script defer="defer" src="https://code.getmdl.io/1.3.0/material.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<header class="mdl-layout__header">
	<div class="mdl-layout__header-row">
		<!-- Title -->
		<span class="mdl-layout-title">Title</span>
		<!-- Add spacer, to align navigation to the right -->
		<div class="mdl-layout-spacer"></div>
		<!-- Navigation. We hide it in small screens. -->
		<c:choose>
			<c:when test="${userSeq == 0 || empty userSeq}">
				<nav class="mdl-navigation">
					<a class="mdl-navigation__link" href="<c:url value='/login.do'/>"><span
						class="material-symbols-outlined"> login </span></a> <a
						class="mdl-navigation__link" href="<c:url value='/signup.do'/>"><span
						class="material-symbols-outlined"> person_add </span></a>
				</nav>
			</c:when>
			<c:otherwise>
				<nav class="mdl-navigation">
					<span class="material-symbols-outlined"> person </span><span>user
						name</span> <a class="mdl-navigation__link"
						href="<c:url value='/logout.do'/>"><span
						class="material-symbols"> logout </span></a>
				</nav>
			</c:otherwise>
		</c:choose>
	</div>
</header>
<div class="mdl-layout__drawer">
	<span class="mdl-layout-title">Menu</span>
	<c:choose>
		<c:when test="${userSeq == 0 || empty userSeq}">
			<nav class="mdl-navigation">
				<a class="mdl-navigation__link" href="<c:url value='/login.do'/>"><span>
						login </span></a> <a class="mdl-navigation__link"
					href="<c:url value='/signup.do'/>"><span> Sign Up </span></a>
			</nav>
		</c:when>
		<c:otherwise>
			<nav class="mdl-navigation">
				<span class="material-symbols-outlined"> person </span><span>user
					name</span> <a class="mdl-navigation__link"
					href="<c:url value='/logout.do'/>">Log Out</a>
			</nav>
		</c:otherwise>
	</c:choose>
	<!-- 	<nav class="mdl-navigation">
		<a class="mdl-navigation__link" href="">Link</a> <a
			class="mdl-navigation__link" href="">Link</a> <a
			class="mdl-navigation__link" href="">Link</a> <a
			class="mdl-navigation__link" href="">Link</a>
	</nav> -->
</div>