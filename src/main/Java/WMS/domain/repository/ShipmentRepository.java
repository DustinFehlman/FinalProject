package WMS.domain.repository;

import WMS.domain.Shipment;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: harrisjo
 * Date: 10/20/14
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ShipmentRepository {
    Shipment create(Shipment shipment);
    Shipment delete(Shipment shipment);
    Shipment getShipmentByOrderNumber(int orderNumber);
    List<Shipment> getAllShipments();
}
