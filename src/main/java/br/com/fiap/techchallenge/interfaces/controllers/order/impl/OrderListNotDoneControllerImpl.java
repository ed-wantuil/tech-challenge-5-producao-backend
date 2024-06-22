package br.com.fiap.techchallenge.interfaces.controllers.order.impl;

import java.util.List;

import br.com.fiap.techchallenge.application.usecases.order.OrderListNotDone;
import br.com.fiap.techchallenge.interfaces.controllers.order.OrderListNotDoneController;
import br.com.fiap.techchallenge.interfaces.controllers.order.converters.OrderToOrderResponse;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderListNotDoneControllerImpl implements OrderListNotDoneController {

    private final OrderListNotDone orderListNotDone;

    private final OrderToOrderResponse orderToOrderResponse;

    public List<OrderResponse> orderListNotDone() {
        final var orders = orderListNotDone.orderListNotDone();

        return orders.stream().map(orderToOrderResponse::convert).toList();
    }

}
