package team3.meowie.mart.product.dao;


import team3.meowie.mart.product.dto.ProductQueryParams;
import team3.meowie.mart.product.dto.ProductRequest;
import team3.meowie.mart.product.model.Product;

import java.util.List;
/**
 * ClassName:ProductDao
 * Description:
 * Create:2023/4/24 下午 06:40
 */
    public interface ProductDao {

        //查詢所有商品
        List<Product> getProducts(ProductQueryParams productQueryParams);

        Product getProductById(Integer productId);

        //返回值是Integer，因為我們預期會返回一個productId給前端
        //參數是productRequest
        Integer createProduct(ProductRequest productRequest);


        void updateProduct(Integer productId, ProductRequest productRequest);

        void deleteProductById(Integer productId);

    }
