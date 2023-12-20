package com.justplay.payment.resources;

import com.justplay.payment.model.OrderCreateRequest;
import com.justplay.payment.model.OrderResponse;
import com.justplay.payment.services.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentResource {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("createTransaction")
    public OrderResponse createTransaction(@RequestBody OrderCreateRequest orderCreateRequest) {
        return paymentService.createOrder(orderCreateRequest);
    }
}
