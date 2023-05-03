
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jstl:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="${contextRoot}/css/bootstrap.min.css">

    <script>


    </script>
</head>

<body>




    </div>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-8">
            <h1>新增產品</h1>
            <div class="card">
                <div class="card-header"></div>
                <div  class="card-body">
                    <form:form class="form-control" modelAttribute="product"
                               method="post" action="${contextRoot}/product/post" enctype="multipart/form-data">
                        <div style="margin-bottom: 8px">
                            <span>數量</span>
                            <form:input path="quantity" class="form-control" id="" cols="30"
                                       rows="10"></form:input></div>
                        <div style="margin-bottom: 8px">
                            <span>名字</span>
                            <form:input  path="name" class="form-control" id="" cols="30"
                                       rows="10"></form:input ></div>
                        <div style="margin-bottom: 8px">
<%--                            <span>圖檔</span>--%>
<%--                            <form method="post" enctype="multipart/form-data action=uploadImage">--%>
<%--                                <input type="hidden" name="id" value="${products.id}" />--%>
<%--                                <input type="file" name="imageFile" />--%>
<%--                                <input type="submit" value="上傳圖片" />--%>
                            <form:input  action="/upload" type="file" path="ImageFile" class="form-control" id="" cols="30" rows="10" readonly="true"></form:input >
<%--                            <img src="data:image/png;base64,${Base64.getEncoder().encodeToString(product.image)}" />--%>
                        </div>
                         <div style="margin-bottom: 8px">
                             <span>分類</span>
                             <form:input  path="category" class="form-control" id="" cols="30"
                                       rows="10"></form:input ></div>
                        <div style="margin-bottom: 8px">
                            <span>價格</span>
                            <form:input  path="price" class="form-control" id="" cols="30"
                                       rows="10"></form:input ></div>
                        <div style="margin-bottom: 8px">
                            <span>數量</span>
                            <form:input  path="description" class="form-control" id="" cols="30"
                                       rows="10"></form:input ></div>

                        <button type="submit" class="btn btn-primary">送出</button>
                    </form:form>

                </div>
            </div>

            <br />
            <div class="card">
                <div class="card-header">最新的資料 時間: <span><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${latest.added}"/></span></div>
                <div class="card-body">



                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>

