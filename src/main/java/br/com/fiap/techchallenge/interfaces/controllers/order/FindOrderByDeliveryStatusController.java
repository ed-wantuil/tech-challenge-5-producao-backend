package br.com.fiap.techchallenge.interfaces.controllers.order;

import java.util.List;

import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;

public interface FindOrderByDeliveryStatusController {

    List<OrderResponse> findByStatus(final String deliveryStatus);
}
