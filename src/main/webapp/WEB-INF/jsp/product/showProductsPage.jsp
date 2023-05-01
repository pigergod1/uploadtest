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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product List</title>
    <link rel="stylesheet" href="${contextRoot}/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>商品列表</h1>
    <hr>
    <form action="${contextRoot}/product/add">
        <input type="hidden" name="id" value="${product.id}" />
        <input type="submit" class="btn btn-outline-primary rounded" value="新增" />
    </form>

    <jstl:forEach var="product" items="${page.content}">
        <div class="card my-3">
            <div class="card-body">
                <h5 class="card-title">${product.name}</h5>
                <p class="card-text">
                    <img style="width: 300px; height: 300px;"
                         src="${contextRoot}/product/${product.id}"/>
                    建立時間: <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${product.added}"/><br>
                    數量: ${product.quantity}
                </p>
<%--                <img src="data:image/png;base64,${product.coverImage}" alt="Product Image">--%>
            </div>
            <div class="card-footer d-flex justify-content-between align-items-center">
<%--                <form action="${contextRoot}/product/add">--%>
<%--                    <input type="hidden" name="id" value="${product.id}" />--%>
<%--                    <input type="submit" class="btn btn-outline-primary rounded" value="新增" />--%>
<%--                </form>--%>
                <form action="${contextRoot}/product/update">
                    <input type="hidden" name="id" value="${product.id}" />
                    <input type="submit" class="btn btn-outline-success" value="編輯" />
                </form>
                <form action="${contextRoot}/product/delete" method="POST">
                    <input type="hidden" name="_method" value="delete" />
                    <input type="hidden" name="id" value="${product.id}" />
                    <input type="submit" class="btn btn-outline-danger" value="刪除" onclick="return confirm('Are you sure you want to delete this product?')" />
                </form>
            </div>
        </div>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item">Tables</li>
                <li class="breadcrumb-item active">產品</li>
            </ol>
        </nav>


</jstl:forEach>

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
