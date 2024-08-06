package br.com.fiap.techchallenge.application.usecases.order.impl;

import static java.util.Objects.isNull;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.CreateOrder;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.vos.DeliveryStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateOrderImpl implements CreateOrder {

    private final OrderGateway orderGateway;

    @Override
    public void create(final Order order) {
        if (isNull(order.getDeliveryStatus())) {
            order.setDeliveryStatus(new DeliveryStatus("RECEIVED"));
        }

        orderGateway.create(order);
    }
}
