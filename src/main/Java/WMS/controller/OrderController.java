package WMS.controller;

import WMS.domain.*;
import WMS.domain.repository.OrderRepository;
import WMS.domain.repository.ShipmentRepository;
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

    @RequestMapping(value = "/skip", method = RequestMethod.GET)
    public String skipOrder(@RequestParam(value = "orderNumber") int orderNumber) {
        orderService.delete(orderRepository.getOrderByOrderNumber(orderNumber));
        return "redirect:order";
    }

}
