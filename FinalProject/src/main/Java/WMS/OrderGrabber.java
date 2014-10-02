package WMS;

import org.springframework.web.client.RestTemplate;


//Grabs order from link, and put into an order object
public class OrderGrabber {

    public static Order getOrderContents() {
        RestTemplate restTemplate = new RestTemplate();
        Order order = restTemplate.getForObject("http://sleepy-eyrie-4425.herokuapp.com/getOrder", Order.class);

        return order;
    }
}




