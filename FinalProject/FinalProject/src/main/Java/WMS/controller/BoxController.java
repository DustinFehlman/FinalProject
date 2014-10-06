package WMS.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created by harrisjo on 10/6/14.
 */
public class BoxController {
    @RequestMapping("/box")
    public String getBoxes(Model model) {
        ArrayList<ArrayList<String>> print = WebPrinter.printToWeb();

        model.addAttribute("boxCount", print.get(0));
        model.addAttribute("webPrinter" , print.get(1));
        model.addAttribute("orderInfo" , print.get(2));

        return "box";
    }
}
