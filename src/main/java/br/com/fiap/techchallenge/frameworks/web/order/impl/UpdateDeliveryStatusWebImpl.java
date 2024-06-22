package br.com.fiap.techchallenge.frameworks.web.order.impl;

import br.com.fiap.techchallenge.frameworks.web.order.UpdateDeliveryStatusWeb;
import br.com.fiap.techchallenge.interfaces.controllers.order.UpdateDeliveryStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateDeliveryStatusWebImpl implements UpdateDeliveryStatusWeb {

    private final UpdateDeliveryStatusController updateDeliveryStatusController;

    public OrderResponse updateDeliveryStatus(final String id, final String deliveryStatus) {
        return updateDeliveryStatusController.updateDeliveryStatus(id, deliveryStatus);
    }
}
