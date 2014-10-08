package WMS.controller;

import WMS.domain.Items;
import WMS.domain.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by harrisjo on 10/8/14.
 */

@Controller
public class ProductController {
    @RequestMapping("/product")
    public String getProducts(@RequestParam(value="productId")int productId,@RequestParam(value="order")Order order, ModelMap model) {
        ArrayList<Items> items = order.getItems();
        Items product = items.get(productId);
        model.addAttribute(product);
        return "products";
    }

}
