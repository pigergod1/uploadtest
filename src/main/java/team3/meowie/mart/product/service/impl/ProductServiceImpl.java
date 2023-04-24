package team3.meowie.mart.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team3.meowie.mart.product.dao.ProductDao;
import team3.meowie.mart.product.dto.ProductQueryParams;
import team3.meowie.mart.product.dto.ProductRequest;
import team3.meowie.mart.product.model.Product;
import team3.meowie.mart.product.service.ProductService;

import java.util.List;

/**
 * ClassName:ProductServiceImpl
 * Description:
 * Create:2023/4/24 下午 06:39
 */
@Component
public class ProductServiceImpl implements ProductService {

    //注入ProductDao
    @Autowired
    private ProductDao productDao;
    //直接去 call ProductDao的 getProductById 方法
    @Override
    public Product getProductById(Integer productId) {

        return productDao.getProductById(productId);
    }

    //去實作createProduct方法


    @Override
    public Integer createProduct(ProductRequest productRequest) {
        //直接去call ProductDao裡面的createProduct方法
        return productDao.createProduct(productRequest);
        //接下來去實作ProductDao層
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        //直接去call ProductDao裡面的updateProduct方法
        productDao.updateProduct(productId,productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        //直接去call ProductDao裡面的deleteProductById方法
        productDao.deleteProductById(productId);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        //把category傳入ProductDao裡面的getProducts方法
        //用productQueryParams修正之後，變成把productQueryParams傳入dao層
        return  productDao.getProducts(productQueryParams);
    }
}