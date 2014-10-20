package WMS.controller;

import WMS.domain.*;
import WMS.domain.repository.OrderRepository;
import WMS.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping()
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/order")
    public String showOrder(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Order order = restTemplate.getForObject("http://sleepy-eyrie-4425.herokuapp.com/getOrder", Order.class);
        orderService.create(order);
        ArrayList<String> print = orderService.orderItemTypeCount(orderRepository.getOrderByOrderNumber(order.getOrderNumber()));
        model.addAttribute("orderNumber", order.getOrderNumber());
        model.addAttribute("orderInfo" , print);
        return "order";
    }

    @RequestMapping("/order/all")
    public String showAllOrders(Model model) {
        List<Order> orders = orderRepository.getAllOrders();
        model.addAttribute("orders",orders);
        ArrayList<String> orderNumbers = new ArrayList<String>();
        for ( Order order : orders ) {
            orderNumbers.add(Integer.toString(order.getOrderNumber()));
        }
        model.addAttribute("orderNumbers", orderNumbers);
        return "all";
    }

    @RequestMapping("/order/byId")
    public String showOrderByOrderNumber(@RequestParam(value = "orderNumber", required = false) int orderNumber, Model model) {
        ArrayList<String> print = orderService.orderItemTypeCount(orderRepository.getOrderByOrderNumber(orderNumber));
        model.addAttribute("orderInfo" , print);
        return "byId";
    }

    @RequestMapping(value = "/skip", method = RequestMethod.GET)
    public String skipOrder(@RequestParam(value = "orderNumber") int orderNumber) {
        orderService.delete(orderRepository.getOrderByOrderNumber(orderNumber));
        return "redirect:order";
    }
}
