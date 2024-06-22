package br.com.fiap.techchallenge.application.usecases.order.impl;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.UpdateDeliveryStatus;
import br.com.fiap.techchallenge.domain.entities.Order;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateDeliveryStatusImpl implements UpdateDeliveryStatus {

    private final OrderGateway orderGateway;

    @Override
    public Order updateDeliveryStatus(final String id, final String deliveryStatus) {

        return orderGateway.updateDeliveryStatus(id, deliveryStatus);
    }
}
