package br.com.fiap.techchallenge.application.usecases.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.impl.OrderListNotDoneImpl;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.enums.DeliveryStatusEnum;
import br.com.fiap.techchallenge.domain.vos.DeliveryStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderListNotDoneImplTest {

    @Mock
    private OrderGateway orderGateway;

    @InjectMocks
    private OrderListNotDoneImpl orderListNotDone;

    @Test
    public void testOrderListNotDone() {
        Order olderOrder = createOrder("1", LocalDate.now().minusDays(2), new DeliveryStatus("PREPARING"));
        Order newerOrder = createOrder("2", LocalDate.now(), new DeliveryStatus("RECEIVED"));
        List<Order> mockOrders = Arrays.asList(newerOrder, olderOrder);

        List<String> expectedStatuses = Arrays.asList(
                DeliveryStatusEnum.READY.toString(),
                DeliveryStatusEnum.PREPARING.toString(),
                DeliveryStatusEnum.RECEIVED.toString());

        when(orderGateway.findByDeliveryStatus(expectedStatuses)).thenReturn(mockOrders);

        List<Order> resultOrders = orderListNotDone.orderListNotDone();

        verify(orderGateway, times(1)).findByDeliveryStatus(expectedStatuses);
        assertNotNull(resultOrders);
        assertEquals(2, resultOrders.size(), "Deve retornar dois pedidos.");
        assertTrue(resultOrders.get(0).getCreated().isBefore(resultOrders.get(1).getCreated()), "Os pedidos devem estar ordenados pela data de criação.");

        // Verifica a ordenação diretamente
        List<Order> expectedOrdering = mockOrders.stream()
                .sorted(Comparator.comparing(Order::getCreated))
                .collect(Collectors.toList());
        assertEquals(expectedOrdering, resultOrders, "A lista de pedidos deve estar ordenada corretamente pela data de criação.");
    }

    private Order createOrder(String id, LocalDate created, DeliveryStatus deliveryStatus) {
        Order order = new Order();
        order.setOrderId(id);
        order.setCreated(created);
        order.setDeliveryStatus(deliveryStatus);

        return order;
    }
}
