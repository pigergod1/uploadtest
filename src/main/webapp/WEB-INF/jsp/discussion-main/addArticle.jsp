<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Article Submission Form</title>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<link rel="stylesheet"
	href="${contextRoot}/css/discussion/bootstrap.min.css" />
<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
<script src="${contextRoot}/js/jquery-3.6.4.min.js"></script>

<link href="${contextRoot}/css/discussion/sideNavbar.css"
	rel="stylesheet" />
</head>

<body>
	<jsp:include page="../discussion-layout/sideNavbar.jsp"></jsp:include>

	<div class="container">
		<h2>新增文章</h2>
		<form:form action="${contextRoot}/dic/submitArticle/post"
			method="post" enctype="multipart/form-data" modelAttribute="postDto">
			<div class="form-group">
				<label for="title">Title:</label>
				<form:input path="title" type="text" class="form-control" id="title"
					name="title"></form:input>
			</div>
			<div class="form-group">
				<label for="content">Content:</label>
				<form:textarea path="content" class="form-control" id="content"
					placeholder="Enter content" name="content" rows="5"></form:textarea>
			</div>


			<div class="mb-3">
				<label for="formFile" class="form-label">photo:</label>
				<form:input path="image" type="file" class="form-control"
					id="formFile" accept="image/*" />
			</div>
			<button type="submit" class="btn btn-primary" style="float: right">
				Submit</button>
		</form:form>
	</div>
</body>
</html>
