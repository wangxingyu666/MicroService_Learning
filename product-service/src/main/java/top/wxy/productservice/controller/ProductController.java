package top.wxy.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 笼中雀
 */
@RestController
public class ProductController {

    @GetMapping("/product")
    public String getProduct(@RequestParam String productId){
        return "Product:"+productId;
    }
}
