package br.com.fiap.techchallenge.frameworks.db.converters;

import java.util.Objects;
import java.util.UUID;

import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.frameworks.db.entities.OrderEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderToOrderEntity {

    public OrderEntity convert(final Order order) {
        return OrderEntity
                .builder()
                .orderId(Objects.nonNull(order.getOrderId()) ? UUID.fromString(order.getOrderId()) : null)
                .customerId(Objects.nonNull(order.getCustomerId()) ? UUID.fromString(order.getCustomerId()) : null)
                .deliveryStatus(Objects.nonNull(order.getDeliveryStatus()) ? order.getDeliveryStatus().getStatus().toString() : null)
                .created(order.getCreated())
                .build();
    }
}
