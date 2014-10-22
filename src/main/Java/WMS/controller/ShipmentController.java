package WMS.controller;

import WMS.domain.Box;
import WMS.domain.Order;
import WMS.domain.Shipment;
import WMS.domain.repository.OrderRepository;
import WMS.domain.repository.ShipmentRepository;
import WMS.service.BoxService;
import WMS.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harrisjo on 10/8/14.
 */

@Controller
public class ShipmentController {
    @Autowired
    private ShipmentRepository shipmentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ShipmentService shipmentService;
    @Autowired
    private BoxService boxService;

    @RequestMapping("/shipment/byId")
    public String showOrderByOrderNumber(@RequestParam(value = "orderNumber", required = false) int orderNumber, Model model) {
        ArrayList<Box> boxes = shipmentRepository.getShipmentByOrderNumber(orderNumber).getBoxes();
        ArrayList<String> items = boxService.boxItems(boxes);
        String count = boxService.countBoxes(boxes);
        model.addAttribute("orderNumber", Integer.toString(orderNumber));
        model.addAttribute("count", count);
        model.addAttribute("items", items);
        return "byId";
    }

    @RequestMapping("/shipment")
    public String getBoxes(@RequestParam( value = "orderNumber", required = true) int orderNumber, Model model) {
        ArrayList<Box> boxes = boxService.sortOrder(orderRepository.getOrderByOrderNumber(orderNumber));
        Shipment shipment = new Shipment(orderNumber, boxes);
        shipmentService.create(shipment);
        ArrayList<String> items = boxService.boxItems(boxes);
        String count = boxService.countBoxes(boxes);
        model.addAttribute("count", count);
        model.addAttribute("items", items);
        model.addAttribute("orderNumber", Integer.toString(orderNumber));

        return "shipment";

    }

    @RequestMapping("/shipment/all")
    public String showAllOrders(Model model) {
        List<Shipment> shipments = shipmentRepository.getAllShipments();
        model.addAttribute("shipments",shipments);
        ArrayList<String> orderNumbers = new ArrayList<String>();
        for ( Shipment shipment : shipments ) {
            orderNumbers.add(Integer.toString(shipment.getOrderNumber()));
        }
        model.addAttribute("orderNumbers", orderNumbers);
        return "all";
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public String skipOrder(@RequestParam(value = "orderNumber") int orderNumber) {
        shipmentService.delete(shipmentRepository.getShipmentByOrderNumber(orderNumber));
        return "redirect:shipment/all";
    }

}
