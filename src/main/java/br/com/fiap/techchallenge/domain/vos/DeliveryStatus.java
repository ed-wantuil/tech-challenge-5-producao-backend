package br.com.fiap.techchallenge.domain.vos;


import br.com.fiap.techchallenge.domain.enums.DeliveryStatusEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class DeliveryStatus {

    DeliveryStatusEnum status;

    public DeliveryStatus(final String status) {
        validate(status);

        this.status = DeliveryStatusEnum.valueOf(status);
    }

    private void validate(final String status) {
        if (status == null) {
            throw new IllegalArgumentException("Delivery status cannot be null");
        }
    }
}
