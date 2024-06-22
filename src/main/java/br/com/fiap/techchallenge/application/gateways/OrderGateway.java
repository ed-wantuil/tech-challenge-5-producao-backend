package br.com.fiap.techchallenge.application.gateways;

import java.util.List;

import br.com.fiap.techchallenge.domain.entities.Order;


public interface OrderGateway {

    List<Order> findByDeliveryStatus(List<String> status);

    Order updateDeliveryStatus(String id, String deliveryStatus);

    Order findById(String id);

    void create(Order order);
}
