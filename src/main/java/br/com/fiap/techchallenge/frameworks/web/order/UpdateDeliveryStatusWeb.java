package br.com.fiap.techchallenge.frameworks.web.order;

import br.com.fiap.techchallenge.interfaces.controllers.order.responses.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UpdateDeliveryStatusWeb {

    @Operation(summary = "Update delivery status",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Order updated"),
            })
    @PatchMapping("/order/update-delivery-status")
    OrderResponse updateDeliveryStatus(@RequestParam String id, @RequestParam("delivery-status") String deliveryStatus);
}
