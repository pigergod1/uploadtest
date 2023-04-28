package team3.meowie.mart.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import team3.meowie.mart.product.model.Product;
import team3.meowie.mart.product.model.ProductRepository;
import team3.meowie.mart.product.service.ProductService;

import java.io.IOException;
import java.util.List;

/**
 * ClassName:ProductsController
 * Description:
 * Create:2023/4/27 下午 07:26
 */
@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/add")
    public String addProduct(Model model,ModelAndView modelAndView) {
        model.addAttribute("product", new Product());

        Product latest = productService.getLatest();
        model.addAttribute("latest", latest);
        return "product/addProductPage";
    }


    @PostMapping("/product/post")
    public String postProduct(Product product, Model model) {
        productService.addProduct(product);

        model.addAttribute("product", new Product());

        Product latest = productService.getLatest();
        model.addAttribute("latest", latest);
        return "product/addProductPage";
    }

    @GetMapping("/product")
    public String goShowProducts(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
        Page<Product> page = productService.findByPage(pageNumber);
        model.addAttribute("page", page);
        Product latest = productService.getLatest();
        model.addAttribute("latest", latest);
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product/showProductsPage";
    }

    @DeleteMapping("/product/delete")
    public String deleteProductById(@RequestParam Integer id) {
        productService.deleteProductById(id);
        return "redirect:/product";
    }

    @GetMapping("/product/update") //
    public String updateProductById(@RequestParam("id") Integer id, Model model) {
//        Product product = productService.findProductById(id);
        model.addAttribute("product", productService.findProductById(id));
        return "product/updateProductPage";
    }

    @PutMapping("/product/editpage")
    public String putEditedProduct(@ModelAttribute("product") Product product) throws IOException {

            productService.updateById(product);


        return "redirect:/product";

    }
}


