package com.sahil.Shop.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sahil.Shop.Service.PayUService;

import java.util.Map;

@RestController
@CrossOrigin(origins = "https://shop-frontend-plum.vercel.app/")
@RequestMapping("/api/payu")
public class PayUController {

    private final PayUService payUService;

    public PayUController(PayUService payUService) {
        this.payUService = payUService;
    }

    // Create a payment request and return PayU URL and parameters
    @PostMapping("/create-payment")
    public ResponseEntity<Map<String, String>> createPayment(@RequestBody PaymentRequest paymentRequest) {
        String successUrl = "https://shop-frontend-plum.vercel.app/#/success"; // Your frontend success URL
        String failureUrl = "https://shop-frontend-plum.vercel.app/#/cancel"; // Your frontend failure URL

        Map<String, String> params = payUService.createPaymentRequest(
                paymentRequest.getTxnId(),
                paymentRequest.getAmount(),
                paymentRequest.getProductInfo(),
                paymentRequest.getFirstName(),
                paymentRequest.getEmail(),
                paymentRequest.getPhone(),
                successUrl,
                failureUrl
        );

        return ResponseEntity.ok(params);
    }

    @GetMapping("/payu-url")
    public ResponseEntity<String> getPayUUrl() {
        return ResponseEntity.ok(payUService.getPayUUrl());
    }
}

// Payment request object
class PaymentRequest {
    private String txnId;
    private String amount;
    private String productInfo;
    private String firstName;
    private String email;
    private String phone;

    // Getters and Setters
    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

