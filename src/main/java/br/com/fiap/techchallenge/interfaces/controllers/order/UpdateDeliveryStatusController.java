package br.com.fiap.techchallenge.interfaces.controllers.order;

import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;

public interface UpdateDeliveryStatusController {

    OrderResponse updateDeliveryStatus(String id, String deliveryStatus);
}
