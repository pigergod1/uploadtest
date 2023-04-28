<%--
  Created by IntelliJ IDEA.
  User: volum
  Date: 2023/4/19
  Time: 上午 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jstl:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>商 品 列 表</title>
    <link rel="stylesheet" href="${contextRoot}/css/bootstrap.min.css">
</head>
<body>
<h1>商 品 列 表</h1>
<jstl:forEach var="products" items="${page.content}">
    <div class="card">
        <div class="card-header">
            <div class="d-flex justify-content-around">商品名:${products.name}<span>開版時間:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${products.added}"/></span>
            </div>
            ${products.quantity}
        </div>

        <div class="card-body">

            <div style="display:flex">
                <form action="${contextRoot}/product/add">
                    <input type="hidden" name="id" value="${products.id}" />
                    <input type="submit" class="btn btn-outline-primary rounded" value="新增" style="display:inline-block;"/>
                </form>

                <form action="${contextRoot}/product/update">
                    <input type="hidden" name="id" value="${products.id}" />
                    <input type="submit" class="btn btn-outline-success" value="編輯" style="display:inline-block;"/>
                </form>

                <form action="${contextRoot}/product/delete" method="Post">
                    <input type="hidden" name="_method" value="delete" />
                    <input type="hidden" name="id" value="${products.id}" />
                    <input type="submit" class="btn btn-outline-secondary" value="刪除" />
                </form>
            </div>

        </div>
    </div>
</jstl:forEach>
            <br />
            <jstl:forEach var="pageNumber" begin="1" end="${page.totalPages}">
                <jstl:choose>
                    <jstl:when test="${page.number != pageNumber-1 }">
                        <a href="${contextRoot}/product?p=${pageNumber}">${pageNumber}</a>
                    </jstl:when>
                    <jstl:otherwise>
                        ${pageNumber}
                    </jstl:otherwise>

                </jstl:choose>

                <jstl:if test="${page.number != page.totalPages }">
                    <span> | </span>
                </jstl:if>

            </jstl:forEach>
        </div>
    </div>
</div>
</body>
</html>
