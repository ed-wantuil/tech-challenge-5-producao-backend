package br.com.fiap.techchallenge.frameworks.db.converters;

import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.vos.DeliveryStatus;
import br.com.fiap.techchallenge.frameworks.db.entities.OrderEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderEntityToOrder {

    public Order convert(final OrderEntity orderEntity) {
        return Order
                .builder()
                .orderId(orderEntity.getOrderId().toString())
                .customerId(orderEntity.getCustomerId().toString())
                .deliveryStatus(new DeliveryStatus(orderEntity.getDeliveryStatus()))
                .created(orderEntity.getCreated())
                .build();
    }
}
