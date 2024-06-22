package br.com.fiap.techchallenge.frameworks.configs;

import br.com.fiap.techchallenge.application.gateways.OrderGateway;
import br.com.fiap.techchallenge.application.usecases.order.CreateOrder;
import br.com.fiap.techchallenge.application.usecases.order.FindOrderByDeliveryStatus;
import br.com.fiap.techchallenge.application.usecases.order.FindOrderById;
import br.com.fiap.techchallenge.application.usecases.order.OrderListNotDone;
import br.com.fiap.techchallenge.application.usecases.order.UpdateDeliveryStatus;
import br.com.fiap.techchallenge.application.usecases.order.impl.CreateOrderImpl;
import br.com.fiap.techchallenge.application.usecases.order.impl.FindOrderByIdImpl;
import br.com.fiap.techchallenge.application.usecases.order.impl.OrderListNotDoneImpl;
import br.com.fiap.techchallenge.application.usecases.order.impl.UpdateDeliveryStatusImpl;
import br.com.fiap.techchallenge.frameworks.web.order.FindOrderByDeliveryStatusWeb;
import br.com.fiap.techchallenge.frameworks.web.order.FindOrderByIdWeb;
import br.com.fiap.techchallenge.frameworks.web.order.OrderListNotDoneWeb;
import br.com.fiap.techchallenge.frameworks.web.order.UpdateDeliveryStatusWeb;
import br.com.fiap.techchallenge.frameworks.web.order.impl.FindOrderByDeliveryStatusWebImpl;
import br.com.fiap.techchallenge.frameworks.web.order.impl.FindOrderByIdWebImpl;
import br.com.fiap.techchallenge.frameworks.web.order.impl.OrderListNotDoneWebImpl;
import br.com.fiap.techchallenge.frameworks.web.order.impl.UpdateDeliveryStatusWebImpl;
import br.com.fiap.techchallenge.interfaces.controllers.order.FindOrderByDeliveryStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.FindOrderByIdController;
import br.com.fiap.techchallenge.interfaces.controllers.order.OrderListNotDoneController;
import br.com.fiap.techchallenge.interfaces.controllers.order.UpdateDeliveryStatusController;
import br.com.fiap.techchallenge.interfaces.controllers.order.converters.OrderToOrderResponse;
import br.com.fiap.techchallenge.interfaces.controllers.order.impl.FindOrderByDeliveryStatusControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.order.impl.FindOrderByIdControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.order.impl.OrderListNotDoneControllerImpl;
import br.com.fiap.techchallenge.interfaces.controllers.order.impl.UpdateDeliveryStatusControllerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderBean {


    @Bean
    OrderToOrderResponse orderToOrderResponse() {
        return new OrderToOrderResponse();
    }

    @Bean
    CreateOrder createOrder(final OrderGateway orderGateway) {
        return new CreateOrderImpl(orderGateway);
    }

    @Bean
    FindOrderByDeliveryStatus orderFindByStatus(final OrderGateway orderRepository) {
        return new br.com.fiap.techchallenge.application.usecases.order.impl.FindOrderByDeliveryStatusImpl(orderRepository);
    }

    @Bean
    FindOrderByDeliveryStatusController orderFindByStatusController(final FindOrderByDeliveryStatus orderFindByStatus,
                                                                    final OrderToOrderResponse orderToOrderResponse) {
        return new FindOrderByDeliveryStatusControllerImpl(orderFindByStatus, orderToOrderResponse);
    }

    @Bean
    FindOrderByDeliveryStatusWeb findOrderByStatusWeb(final FindOrderByDeliveryStatusController findOrderByStatusController) {
        return new FindOrderByDeliveryStatusWebImpl(findOrderByStatusController);
    }

    @Bean
    OrderListNotDoneWeb orderListNotDoneWeb(final OrderListNotDoneController orderListNotDoneController) {
        return new OrderListNotDoneWebImpl(orderListNotDoneController);
    }

    @Bean
    OrderListNotDone orderListNotDone(final OrderGateway orderGateway) {
        return new OrderListNotDoneImpl(orderGateway);
    }

    @Bean
    OrderListNotDoneController orderListNotDoneController(final OrderListNotDone orderListNotDone,
                                                          final OrderToOrderResponse orderToOrderResponse) {
        return new OrderListNotDoneControllerImpl(orderListNotDone, orderToOrderResponse);
    }

    @Bean
    UpdateDeliveryStatus updateDeliveryStatus(final OrderGateway orderGateway) {
        return new UpdateDeliveryStatusImpl(orderGateway);
    }

    @Bean
    UpdateDeliveryStatusController updateDeliveryStatusController(final UpdateDeliveryStatus updateDeliveryStatus,
                                                                  final OrderToOrderResponse orderToOrderResponse) {
        return new UpdateDeliveryStatusControllerImpl(updateDeliveryStatus, orderToOrderResponse);
    }

    @Bean
    UpdateDeliveryStatusWeb updateDeliveryStatusWeb(final UpdateDeliveryStatusController updateDeliveryStatusController) {
        return new UpdateDeliveryStatusWebImpl(updateDeliveryStatusController);
    }

    @Bean
    FindOrderById findOrderById(final OrderGateway orderGateway) {
        return new FindOrderByIdImpl(orderGateway);
    }

    @Bean
    FindOrderByIdController findOrderByIdController(final FindOrderById findOrderById,
                                                    final OrderToOrderResponse orderToOrderResponse) {
        return new FindOrderByIdControllerImpl(findOrderById, orderToOrderResponse);
    }

    @Bean
    FindOrderByIdWeb findOrderByIdWeb(final FindOrderByIdController findOrderByIdController) {
        return new FindOrderByIdWebImpl(findOrderByIdController);
    }
}
