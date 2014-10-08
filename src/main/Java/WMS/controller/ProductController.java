package WMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by harrisjo on 10/8/14.
 */

@Controller
public class ProductController {
    @RequestMapping("/product")
    public String getProducts() {
        return "products";
    }

}
