package WMS.service.impl;

import WMS.domain.Shipment;
import WMS.domain.repository.ShipmentRepository;
import WMS.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: harrisjo
 * Date: 10/20/14
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    ShipmentRepository shipmentRepository;

    public Shipment create(Shipment shipment) {
        return shipmentRepository.create(shipment);
    }
}
