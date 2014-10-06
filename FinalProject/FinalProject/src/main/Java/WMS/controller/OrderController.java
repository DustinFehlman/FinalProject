package WMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class OrderController {

    @RequestMapping("/order")
    public String welcome(Model model) {
        ArrayList<ArrayList<String>> print = WebPrinter.printToWeb();

        model.addAttribute("boxCount", print.get(0));
        model.addAttribute("webPrinter" , print.get(1));
        model.addAttribute("orderInfo" , print.get(2));


        return "order";
    }

}

