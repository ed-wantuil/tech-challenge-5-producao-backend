package br.com.fiap.techchallenge.interfaces.controllers.order.impl;

import br.com.fiap.techchallenge.application.usecases.order.UpdateDeliveryStatus;
import br.com.fiap.techchallenge.interfaces.controllers.order.UpdateDeliveryStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.converters.OrderToOrderResponse;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateDeliveryStatusControllerImpl implements UpdateDeliveryStatusController {

    private final UpdateDeliveryStatus updateDeliveryStatus;

    private final OrderToOrderResponse orderToOrderResponse;

    public OrderResponse updateDeliveryStatus(final String id, final String deliveryStatus) {

        final var order = updateDeliveryStatus.updateDeliveryStatus(id, deliveryStatus);

        return orderToOrderResponse.convert(order);
    }
}
