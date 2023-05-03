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

        </div>
        <div class="card-footer d-flex justify-content-between align-items-center">

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






    <body>
    <div class="container">
        <h1 class="my-5">商品列表</h1>
        <hr>
        <form action="${contextRoot}/product/add">
            <input type="hidden" name="id" value="${product.id}" />
            <input type="submit" class="btn btn-primary rounded mb-3" value="新增商品" />
        </form>
        javascript
        Copy code
        <div class="row row-cols-1 row-cols-md-3 g-4">
            <jstl:forEach var="product" items="${page.content}">
                <div class="col">
                    <div class="card h-100">
                        <img src="${contextRoot}/product/${product.id}" class="card-img-top" alt="${product.name}">
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">建立時間: <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss EEEE" value="${product.added}"/><br>數量: ${product.quantity}</p>
                        </div>
                        <div class="card-footer">
                            <form action="${contextRoot}/product/update">
                                <input type="hidden" name="id" value="${product.id}" />
                                <button type="submit" class="btn btn-primary">編輯</button>
                            </form>
                            <form action="${contextRoot}/product/delete" method="POST">
                                <input type="hidden" name="_method" value="delete" />
                                <input type="hidden" name="id" value="${product.id}" />
                                <button type="submit" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this product?')">刪除</button>
                            </form>
                        </div>
                    </div>
                </div>
            </jstl:forEach>
        </div>
    </div>
    </body>