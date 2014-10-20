package WMS.controller;

import WMS.domain.Box;
import WMS.domain.repository.OrderRepository;
import WMS.service.BoxService;
import WMS.service.OrderService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


/**
 * Created by harrisjo on 10/6/14.
 */
@Controller
public class BoxController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BoxService boxService;

    @RequestMapping("/box")
    public String getBoxes(@RequestParam( value = "order", required = true) int order, Model model) {

        ArrayList<Box> boxes = boxService.sortOrder(orderRepository.getOrderByOrderNumber(order));
        ArrayList<String> items = boxService.boxItems(boxes);
        String count = boxService.countBoxes(boxes);

        model.addAttribute("count", count);
        model.addAttribute("items", items);

        return "box";

    }
}
