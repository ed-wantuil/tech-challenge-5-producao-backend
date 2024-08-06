package br.com.fiap.techchallenge.frameworks.db.impl;

import java.util.List;
import java.util.UUID;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.frameworks.db.converters.OrderEntityToOrder;
import br.com.fiap.techchallenge.frameworks.db.converters.OrderToOrderEntity;
import br.com.fiap.techchallenge.frameworks.db.entities.OrderEntity;
import br.com.fiap.techchallenge.frameworks.db.repositories.SpringDataOrderRepository;
import br.com.fiap.techchallenge.frameworks.exception.NotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderGateway {

    private final SpringDataOrderRepository springDataOrderRepository;

    private final OrderToOrderEntity orderToOrderEntity;

    private final OrderEntityToOrder orderEntityToOrder;

    @Override
    public List<Order> findByDeliveryStatus(final List<String> status) {
        final List<OrderEntity> orderEntities = (List<OrderEntity>) springDataOrderRepository.findAll();

        return orderEntities
                .stream()
                .map(orderEntityToOrder::convert)
                .toList();
    }

    @Override
    public Order updateDeliveryStatus(final String id, final String deliveryStatus) {
        var orderEntity = springDataOrderRepository.findById(UUID.fromString(id)).orElseThrow(NotFound::new);

        orderEntity.setDeliveryStatus(deliveryStatus);
        orderEntity = springDataOrderRepository.save(orderEntity);

        return orderEntityToOrder.convert(orderEntity);
    }


    @Override
    public Order findById(final String id) {
        final var oderEntity = springDataOrderRepository.findById(UUID.fromString(id)).orElseThrow(NotFound::new);

        return orderEntityToOrder.convert(oderEntity);
    }

    @Override
    public void create(Order order) {
        final var orderEntity = orderToOrderEntity.convert(order);

        springDataOrderRepository.save(orderEntity);
    }
}
