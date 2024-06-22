package br.com.fiap.techchallenge.application.usecases.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.impl.FindOrderByDeliveryStatusImpl;
import br.com.fiap.techchallenge.domain.entities.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FindOrderByDeliveryStatusImplTest {

    @Mock
    private OrderGateway orderGateway;

    @InjectMocks
    private FindOrderByDeliveryStatusImpl findOrderByDeliveryStatus;

    @Test
    public void testFindByDeliveryStatus() {
        String status = "DELIVERED";
        Order mockOrder = new Order(); // Suponha que esta seja a classe de seus pedidos.
        List<Order> expectedOrders = List.of(mockOrder);

        when(orderGateway.findByDeliveryStatus(List.of(status))).thenReturn(expectedOrders);

        List<Order> resultOrders = findOrderByDeliveryStatus.findByDeliveryStatus(status);

        verify(orderGateway, times(1)).findByDeliveryStatus(List.of(status));
        assertEquals(expectedOrders, resultOrders);
    }
}

