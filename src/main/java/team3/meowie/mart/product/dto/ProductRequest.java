package team3.meowie.mart.product.dto;

import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;
import team3.meowie.mart.product.constant.ProductCategory;

/**
 * ClassName:ProductRequest
 * Description:
 * Create:2023/4/24 下午 06:41
 */
public class ProductRequest {
    //決定好前端要傳過來的參數，做gettersetter

    @NotNull
    private String productName;
    @NotNull
    private ProductCategory category;
    @NotNull
    private String imageurl;
    @NotNull

    private Integer price;
    @NotNull

    private Integer stock;
    @NotNull

    private String description;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
