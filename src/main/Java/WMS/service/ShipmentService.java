package WMS.service;

import WMS.domain.Shipment;

/**
 * Created with IntelliJ IDEA.
 * User: harrisjo
 * Date: 10/20/14
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ShipmentService {

    Shipment create(Shipment shipment);
    void delete(Shipment shipment);
}
