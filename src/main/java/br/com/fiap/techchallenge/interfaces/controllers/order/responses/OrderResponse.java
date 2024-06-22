package br.com.fiap.techchallenge.interfaces.controllers.order.responses;

import java.time.LocalDate;

import lombok.Builder;


@Builder
public record OrderResponse(String orderId,
                            String customerId,
                            String deliveryStatus,
                            LocalDate created) {
}
