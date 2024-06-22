package br.com.fiap.techchallenge.application.usecases.order;

import br.com.fiap.techchallenge.domain.entities.Order;

public interface UpdateDeliveryStatus {
    Order updateDeliveryStatus(String id, String deliveryStatus);
}
