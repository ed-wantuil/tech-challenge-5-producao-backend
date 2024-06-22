package br.com.fiap.techchallenge.application.usecases.order;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.impl.UpdateDeliveryStatusImpl;
import br.com.fiap.techchallenge.domain.entities.Order;
import br.com.fiap.techchallenge.domain.vos.DeliveryStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UpdateDeliveryStatusImplTest {

    @Mock
    private OrderGateway orderGateway;

    @InjectMocks
    private UpdateDeliveryStatusImpl updateDeliveryStatus;

    @Test
    public void testUpdateDeliveryStatus() {
        String orderId = "uniqueOrderId";
        String newDeliveryStatus = "READY";
        Order mockUpdatedOrder = new Order();
        mockUpdatedOrder.setOrderId(orderId);
        mockUpdatedOrder.setDeliveryStatus(new DeliveryStatus(newDeliveryStatus));
        when(orderGateway.updateDeliveryStatus(orderId, newDeliveryStatus)).thenReturn(mockUpdatedOrder);

        Order resultOrder = updateDeliveryStatus.updateDeliveryStatus(orderId, newDeliveryStatus);

        verify(orderGateway, times(1)).updateDeliveryStatus(orderId, newDeliveryStatus);
        assertNotNull(resultOrder, "O pedido retornado não deve ser nulo.");
        assertEquals(orderId, resultOrder.getOrderId(), "O ID do pedido deve corresponder ao fornecido.");
        assertEquals(newDeliveryStatus, resultOrder.getDeliveryStatus().getStatus().toString(), "O status de entrega do pedido deve ser atualizado para o novo status.");
    }
}
