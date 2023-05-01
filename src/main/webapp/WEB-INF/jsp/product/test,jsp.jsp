<head>
    <title>商 品 列 表</title>
    <link rel="stylesheet" href="${contextRoot}/css/bootstrap.min.css">
</head>
<body>
<h1>商 品 列 表</h1>
<jstl:forEach var="products" items="${page.content}">
<div class="container">
    <div class="card">
        <div class="card-header">
            <div class="d-flex justify-content-around">商品名:${products.name}<span>時間:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${products.added}"/></span>
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

                <form method="post" enctype="multipart/form-data action=uploadImage">
                    <input type="hidden" name="id" value="${products.id}" />
                    <input type="file" name="file" />
                    <input type="submit" value="上傳圖片" />

                </form>
            </div>

        </div>
    </div>