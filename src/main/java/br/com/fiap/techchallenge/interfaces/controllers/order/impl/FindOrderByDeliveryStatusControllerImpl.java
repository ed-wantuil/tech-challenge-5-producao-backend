package br.com.fiap.techchallenge.interfaces.controllers.order.impl;

import java.util.List;

import br.com.fiap.techchallenge.application.usecases.order.FindOrderByDeliveryStatus;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.interfaces.controllers.order.FindOrderByDeliveryStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.converters.OrderToOrderResponse;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class FindOrderByDeliveryStatusControllerImpl implements FindOrderByDeliveryStatusController {

    private final FindOrderByDeliveryStatus orderFindByStatus;

    private final OrderToOrderResponse orderToOrderResponse;

    public List<OrderResponse> findByStatus(final String deliveryStatus) {
        final List<Order> orders = orderFindByStatus.findByDeliveryStatus(deliveryStatus);

        return orders.stream()
                .map(orderToOrderResponse::convert)
                .toList();
    }
}
