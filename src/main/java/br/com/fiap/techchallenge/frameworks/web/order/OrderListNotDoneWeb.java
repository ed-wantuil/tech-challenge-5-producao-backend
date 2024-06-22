package br.com.fiap.techchallenge.frameworks.web.order;

import java.util.List;

import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface OrderListNotDoneWeb {

    @Operation(summary = "Order list not done",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List order not done")
            })
    @GetMapping("/order/not-done")
    List<OrderResponse> orderListNotDone();
}
