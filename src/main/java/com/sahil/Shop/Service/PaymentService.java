 package com.sahil.Shop.Service;
 import com.stripe.Stripe;
 import com.stripe.model.PaymentIntent;
 import com.stripe.param.PaymentIntentCreateParams;
 import java.util.Arrays; // Ensure this is imported

 public class PaymentService {

     public PaymentIntent createPaymentIntent(int amount) throws Exception {
         // Set your secret key. Replace this with your actual secret key.
         Stripe.apiKey = "sk_test_12345"; 

         // Build payment intent parameters
         PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
             .setAmount((long) amount * 100) // Amount in smallest currency unit (e.g., cents)
             .setCurrency("inr") // Correct currency code for Indian Rupees
    .addAllPaymentMethodType(Arrays.asList("card", "upi", "netbanking", "wallet"))  .build();

         // Create and return the payment intent
         return PaymentIntent.create(params);
     }
 }

