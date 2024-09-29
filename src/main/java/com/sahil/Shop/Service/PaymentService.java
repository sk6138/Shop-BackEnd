 package com.sahil.Shop.Service;
 import com.stripe.Stripe;
 import com.stripe.model.PaymentIntent;
 import com.stripe.param.PaymentIntentCreateParams;
 import java.util.Collections; // Ensure this is imported

 public class PaymentService {

     public PaymentIntent createPaymentIntent(int amount) throws Exception {
         // Set your secret key. Replace this with your actual secret key.
         Stripe.apiKey = "sk_test_12345"; 

         // Build payment intent parameters
         PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
             .setAmount((long) amount * 100) // Amount in smallest currency unit (e.g., cents)
             .setCurrency("usd")
             .addAllPaymentMethodType(Collections.singletonList("card")) // Correct usage of singletonList
             .build();

         // Create and return the payment intent
         return PaymentIntent.create(params);
     }
 }

