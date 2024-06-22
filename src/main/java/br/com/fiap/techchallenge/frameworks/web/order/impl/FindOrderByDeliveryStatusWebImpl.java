package br.com.fiap.techchallenge.frameworks.web.order.impl;

import java.util.List;

import br.com.fiap.techchallenge.frameworks.web.order.FindOrderByDeliveryStatusWeb;
import br.com.fiap.techchallenge.interfaces.controllers.order.FindOrderByDeliveryStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class FindOrderByDeliveryStatusWebImpl implements FindOrderByDeliveryStatusWeb {

    private final FindOrderByDeliveryStatusController findOrderByStatusController;

    public List<OrderResponse> findByStatus(final String deliveryStatus) {
        return findOrderByStatusController.findByStatus(deliveryStatus);
    }
}
