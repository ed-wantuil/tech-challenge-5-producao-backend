package br.com.fiap.techchallenge.application.usecases.order.impl;

import java.util.Comparator;
import java.util.List;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.OrderListNotDone;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.enums.DeliveryStatusEnum;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderListNotDoneImpl implements OrderListNotDone {
    private final OrderGateway orderGateway;

    @Override
    public List<Order> orderListNotDone() {
        final var status = List.of(DeliveryStatusEnum.READY.toString(),
                DeliveryStatusEnum.PREPARING.toString(),
                DeliveryStatusEnum.RECEIVED.toString());

        final var orders = orderGateway.findByDeliveryStatus(status);

        return orders.stream()
                .sorted(Comparator.comparing(Order::getCreated))
                .toList();
    }
}
