<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<link href="${contextRoot}/css/discussion/sideNavbar.css"
	rel="stylesheet">


<!-- <script type="text/javascript" src="../js/discussion/articleManagement"></script> -->
<title>Index</title>

</head>


<body>
	<jsp:include page="../discussion-layout/sideNavbar.jsp"></jsp:include> <!-- navbar -->
<%-- 	<jsp:include page="../discussion-layout/addArticleModal.jsp"></jsp:include><!-- 跳出編輯視窗 --> --%>
</body>
</html>