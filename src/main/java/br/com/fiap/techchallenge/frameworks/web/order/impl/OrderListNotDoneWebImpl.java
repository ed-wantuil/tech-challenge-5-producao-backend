package br.com.fiap.techchallenge.frameworks.web.order.impl;

import java.util.List;

import br.com.fiap.techchallenge.frameworks.web.order.OrderListNotDoneWeb;
import br.com.fiap.techchallenge.interfaces.controllers.order.OrderListNotDoneController;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderListNotDoneWebImpl implements OrderListNotDoneWeb {

    private final OrderListNotDoneController orderListNotDoneController;

    public List<OrderResponse> orderListNotDone() {
        return orderListNotDoneController.orderListNotDone();
    }
}
