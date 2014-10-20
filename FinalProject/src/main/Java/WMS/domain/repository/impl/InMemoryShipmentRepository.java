package WMS.domain.repository.impl;

import WMS.domain.Box;
import WMS.domain.Shipment;
import WMS.domain.repository.ShipmentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: harrisjo
 * Date: 10/20/14
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class InMemoryShipmentRepository implements ShipmentRepository {

    private List<Shipment> listOfShipments;

    public InMemoryShipmentRepository() {
        listOfShipments = new ArrayList<Shipment>();
    }

    public List<Shipment> getAllShipments() {
        return listOfShipments;
    }

    public Shipment getShipmentByOrderNumber(int orderNumber) {
        Shipment shipmentByOrderNumber = null;

        for(Shipment shipment : getAllShipments()) {
            if(orderNumber!=0 && shipment.getOrderNumber()!=0 && shipment.getOrderNumber() == orderNumber){
                shipmentByOrderNumber = shipment;
                break;
            }
        }

        if(shipmentByOrderNumber == null){
            throw new IllegalArgumentException("No order found with the orderNumber: "+ shipmentByOrderNumber);
        }

        return shipmentByOrderNumber;
    }

    public Shipment create(Shipment shipment ) {
        listOfShipments.add(shipment);
        return shipment;
    }

    public void delete(Shipment shipment) {
        listOfShipments.remove(shipment);
    }

}
