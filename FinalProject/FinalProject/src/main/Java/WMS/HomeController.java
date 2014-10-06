package WMS;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String welcome(Model model) {
        ArrayList<ArrayList<String>> print = WebPrinter.printToWeb();

        model.addAttribute("boxCount", print.get(0));
        model.addAttribute("webPrinter" , print.get(1));
        model.addAttribute("orderInfo" , print.get(2));


        return "welcome";
    }

}

