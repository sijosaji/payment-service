package com.justplay.payment.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;
@Data
public class RefundResponse {
    private String paymentId;
    private UUID orderId;
    private BigDecimal amount;
    private String refundId;
}
