package com.justplay.payment.model;
import lombok.Data;

import java.util.UUID;
import java.math.BigDecimal;
@Data
public class OrderResponse {
    private String paymentId;
    private UUID orderId;
    private BigDecimal amount;
}
