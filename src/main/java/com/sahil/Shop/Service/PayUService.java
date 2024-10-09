package com.sahil.Shop.Service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PayUService {

    private static final String MERCHANT_KEY = "xGHjiQ"; // Replace with your Merchant Key
    private static final String MERCHANT_SALT = "VdcmdsDrMqhL98epHMKW6Pv0vHh9efe7"; // Replace with your Merchant Salt
    private static final String PAYU_BASE_URL = "https://test.payu.in/_payment"; // Use production URL for live

    public Map<String, String> createPaymentRequest(String txnId, String amount, String productInfo, String firstName, String email, String phone, String successUrl, String failureUrl) {
        Map<String, String> params = new HashMap<>();

        // Required PayU Parameters
        params.put("key", MERCHANT_KEY);
        params.put("txnid", txnId); // Unique transaction ID
        params.put("amount", amount); // Amount to be paid
        params.put("productinfo", productInfo);
        params.put("firstname", firstName);
        params.put("email", email);
        params.put("phone", phone);
        params.put("surl", successUrl); // Success URL
        params.put("furl", failureUrl); // Failure URL
        params.put("service_provider", "payu_paisa"); // Required field for PayU

        // Generate the hash
        String hash = generateHash(txnId, amount, productInfo, firstName, email);
        params.put("hash", hash); // Hash generated with all parameters

        return params;
    }

    // Generate SHA-512 hash with the required format
    private String generateHash(String txnId, String amount, String productInfo, String firstName, String email) {
        String data = MERCHANT_KEY + "|" + txnId + "|" + amount + "|" + productInfo + "|" + firstName + "|" + email + "|||||||||||" + MERCHANT_SALT;
        return DigestUtils.sha512Hex(data);
    }

    public String getPayUUrl() {
        return PAYU_BASE_URL;
    }
}

