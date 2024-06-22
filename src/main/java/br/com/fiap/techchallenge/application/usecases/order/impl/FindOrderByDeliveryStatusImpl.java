package br.com.fiap.techchallenge.application.usecases.order.impl;

import java.util.List;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.FindOrderByDeliveryStatus;
import br.com.fiap.techchallenge.domain.entities.Order;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindOrderByDeliveryStatusImpl implements FindOrderByDeliveryStatus {
    private final OrderGateway orderGateway;

    @Override
    public List<Order> findByDeliveryStatus(final String status) {
        final var statusList = List.of(status);

        return orderGateway.findByDeliveryStatus(statusList);
    }
}
