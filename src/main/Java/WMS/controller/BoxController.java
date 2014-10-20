package WMS.controller;

import WMS.domain.Box;
import WMS.domain.Items;
import WMS.domain.repository.OrderRepository;
import WMS.service.BoxService;
import WMS.service.OrderService;
import WMS.service.WebPrinter;
import org.json.JSONArray;
import org.json.JSONObject;
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
    private WebPrinter webPrinter;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BoxService boxService;

    @RequestMapping("/box")
    public String getBoxes(@RequestParam( value = "order", required = true) int order, Model model) {

        ArrayList<Box> boxes = boxService.sortOrder(orderRepository.getOrderByOrderNumber(order));
        ArrayList<String> items = webPrinter.boxItems(boxes);
        String count = webPrinter.countBoxes(boxes);

        model.addAttribute("count", count);
        model.addAttribute("items", items);

        return "box";

    }

    @RequestMapping("/boxObject")
    public String getBoxesAsObjects(@RequestParam( value = "order", required = true) int order, Model model) {

        ArrayList<Box> boxes = boxService.sortOrder(orderRepository.getOrderByOrderNumber(order));
       //ArrayList<String> items = webPrinter.boxItems(boxes);
        //String count = webPrinter.countBoxes(boxes);

        JSONArray jsonBoxList = new JSONArray();

        for ( Box box : boxes ) {
            int x = 1;
            JSONObject jsonBox = new JSONObject();
            jsonBox.put("boxNumber", x);
            JSONArray jsonItemList = new JSONArray();
            for ( Items item : box.getBoxContents() ) {
                JSONObject jsonItem = new JSONObject();
                jsonItem.put("itemName", item.getName());
                jsonItem.put("itemSku", item.getSku());
                jsonItemList.put(jsonItem);
            }
            jsonBox.put("items", jsonItemList);
            jsonBoxList.put(jsonBox);
            x++;
        }

        model.addAttribute("jsonObject", jsonBoxList);
        //model.addAttribute("count", count);
        //model.addAttribute("items", items);

        return "boxObject";

    }

}
