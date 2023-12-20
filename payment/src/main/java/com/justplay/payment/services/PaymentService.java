package com.justplay.payment.services;

import com.justplay.payment.model.OrderCreateRequest;
import com.justplay.payment.model.OrderResponse;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import jakarta.annotation.PostConstruct;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    private static String KEY = "rzp_test_SS63dtcJyr6fAo";
    private static String SECRET = "wNwguG2I7yixsqniLEkqIF7c";
    private RazorpayClient client;



    public OrderResponse createOrder(OrderCreateRequest orderCreateRequest) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("amount", orderCreateRequest.getAmount().multiply(new BigDecimal(100)));
            jsonObject.put("currency", "INR");
            jsonObject.put("receipt", orderCreateRequest.getOrderId());
            jsonObject.append("notes", orderCreateRequest.getAdditionalProperties());
            Order createdOrder = client.orders.create(jsonObject);
            return getOrderResponse(orderCreateRequest, createdOrder);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    private static OrderResponse getOrderResponse(OrderCreateRequest orderCreateRequest, Order createdOrder) {
        OrderResponse response = new OrderResponse();
        response.setPaymentId(createdOrder.get("id"));
        response.setOrderId(orderCreateRequest.getOrderId());
        response.setAmount(orderCreateRequest.getAmount());
        return response;
    }

    @PostConstruct
    public void init() {
        try {
            client = new RazorpayClient(KEY, SECRET);
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
    }
}
