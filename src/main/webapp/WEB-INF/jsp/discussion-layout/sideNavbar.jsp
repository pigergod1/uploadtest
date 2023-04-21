<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<link href="${contextRoot}/css/sideNavbar.css" rel="stylesheet">
</head>
<body>
	<div class="area"></div>
	<nav class="main-menu">
		<ul>
			<li class="has-subnav"><a href="${contextRoot}/index"> <i
					class="fa fa-camera-retro fa-2x"></i> <span class="nav-text">
						主頁</span>
			</a></li>
			<li><a href="${contextRoot}/articleManagement"> <i
					class="fa fa-home fa-2x"></i> <span class="nav-text"> 文章管理(編輯、刪除) </span>
			</a></li>
			<li class="has-subnav"><a
				href="${contextRoot}/commentManagement"> <i
					class="fa fa-globe fa-2x"></i> <span class="nav-text"> 評論管理</span>
			</a></li>
			<li class="has-subnav"><a
				href="${contextRoot}/notificationManagement"> <i
					class="fa fa-comments fa-2x"></i> <span class="nav-text">
						通知管理 </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-film fa-2x"></i> <span
					class="nav-text"> 搜索框 </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-book fa-2x"></i> <span
					class="nav-text"> Surveying Jobs </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-cogs fa-2x"></i> <span
					class="nav-text"> Tools & Resources </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-map-marker fa-2x"></i> <span
					class="nav-text"> Member Map </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-info fa-2x"></i> <span
					class="nav-text"> Documentation </span>
			</a></li>
		</ul>

		<ul class="logout">
			<li><a href="#"> <i class="fa fa-power-off fa-2x"></i> <span
					class="nav-text"> Logout </span>
			</a></li>
		</ul>
	</nav>
	<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
	<script src="${contextRoot}/js/jquery-3.6.4.min.js"></script>
</body>
</html>