package br.com.fiap.techchallenge.application.usecases.order;

import java.util.List;

import br.com.fiap.techchallenge.domain.entities.Order;

public interface OrderListNotDone {

    List<Order> orderListNotDone();
}
