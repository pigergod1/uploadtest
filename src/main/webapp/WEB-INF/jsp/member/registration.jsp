<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<title>註冊會員</title>
</head>

<body>
	<div>
		<form:form modelAttribute="user" method="post"
			action="${contextRoot}/registration/post">
			<jstl:choose>
				<jstl:when test="${error != null}">
					姓名:<form:input path="name" />
					<span>${error.name}</span>
					<br />
					username:<form:input path="username" />
					<span>${error.username}</span>
					<br />
					密碼:<form:input path="password" />
					<span>${error.password}</span>
					<br />
					信箱:<form:input path="email" />
					<span>${error.email}</span>
					<br />
					<button type="submit">送出</button>
				</jstl:when>
				<jstl:otherwise>
					姓名:<form:input path="name" />
					<br />
					username:<form:input path="username" />
					<br />
					密碼:<form:input path="password" />
					<br />
					信箱:<form:input path="email" />
					<br />
					<button type="submit">送出</button>
				</jstl:otherwise>
			</jstl:choose>
		</form:form>

	</div>
</body>

</html>