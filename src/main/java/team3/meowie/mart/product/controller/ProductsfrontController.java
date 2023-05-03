package team3.meowie.mart.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import team3.meowie.mart.product.model.Product;
import team3.meowie.mart.product.model.ProductRepository;
import team3.meowie.mart.product.service.ProductService;

import java.util.List;

/**
 * ClassName:ProductsfrontController
 * Description:
 * Create:2023/5/3 上午 11:17
 */
@Controller
public class ProductsfrontController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @GetMapping(value = "/product/pig/{id}") //顯示圖片
    public ResponseEntity<byte[]> getCoverImage(@PathVariable("id") Integer id) {
        byte[] image = productService.getProductById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }


    @GetMapping("/product/pig")
    public String goShowProducts(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
        Page<Product> page = productService.findByPageMain(pageNumber);
        model.addAttribute("page", page);
        Product latest = productService.getLatest();
        model.addAttribute("latest", latest);
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product/storeindex";
    }

}
