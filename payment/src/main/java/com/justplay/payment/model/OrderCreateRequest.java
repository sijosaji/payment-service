package com.justplay.payment.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;
@Data
public class OrderCreateRequest {
    private UUID orderId;
    private BigDecimal amount;
    private Map<Object, Object> additionalProperties;
}
