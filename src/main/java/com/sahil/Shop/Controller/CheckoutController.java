//
//package com.sahil.Shop.Controller;
//
//import com.stripe.Stripe;
//import com.stripe.model.checkout.Session;
//import com.stripe.param.checkout.SessionCreateParams;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/checkout")
//@CrossOrigin(origins = "http://localhost:5173") // Adjust to your frontend's URL
//public class CheckoutController {
//
//   
//    private String stripeSecretKey="sk_test_51Q3BhqP6fYAkdHlVUosQzSXCBLt0mcd7ZBqCcMwOpTjkVSWlFcjvmne354dkWhw3TY71LDyxIepn2V64x3sc59JJ00wqvvMhFt"; // Use your actual secret key
//
//
//    @PostMapping("/create-session")
//    public Map<String, Object> createCheckoutSession(@RequestBody Map<String, Object> data) throws Exception {
//        // Set the Stripe Secret Key from configuration
//        Stripe.apiKey = stripeSecretKey;
//
//        // Retrieve the price from the request body
//        Number amountNumber = (Number) data.get("price");
//        if (amountNumber == null) {
//            throw new IllegalArgumentException("Price is required");
//        }
//        double priceInINR = amountNumber.doubleValue();
//
//        // Convert INR to paise
//        long priceInPaise = Math.round(priceInINR * 100);
//
//        // Create a checkout session with INR currency
//        SessionCreateParams params = SessionCreateParams.builder()
//            .setMode(SessionCreateParams.Mode.PAYMENT) // Specify mode (payment or subscription)
//            .setSuccessUrl("http://localhost:5173/success") // Success URL
//            .setCancelUrl("http://localhost:5173/cancel")  // Cancel URL
//            .addLineItem(
//                SessionCreateParams.LineItem.builder()
//                    .setQuantity(1L)
//                    .setPriceData(
//                        SessionCreateParams.LineItem.PriceData.builder()
//                            .setCurrency("inr") // Set currency to INR
//                            .setUnitAmount(priceInPaise) // Price in paise
//                            .setProductData(
//                                SessionCreateParams.LineItem.PriceData.ProductData.builder()
//                                    .setName("Product Name") // Replace with your product name
//                                    .build()
//                            )
//                            .build()
//                    )
//                    .build()
//            )
//            .build();
//
//        // Create the session
//        Session session = Session.create(params);
//
//        // Return session ID to the frontend
//        Map<String, Object> responseData = new HashMap<>();
//        responseData.put("id", session.getId());
//        return responseData;
//    }
//}
//
package com.sahil.Shop.Controller;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin(origins = "http://localhost:5173") // Adjust to your frontend's URL
public class CheckoutController {

  private String stripeSecretKey="sk_test_51Q3BhqP6fYAkdHlVUosQzSXCBLt0mcd7ZBqCcMwOpTjkVSWlFcjvmne354dkWhw3TY71LDyxIepn2V64x3sc59JJ00wqvvMhFt"; // Use your actual secret key


    @PostMapping("/create-session")
    public Map<String, Object> createCheckoutSession(@RequestBody Map<String, Object> data) throws Exception {
        // Set the Stripe Secret Key
        Stripe.apiKey = stripeSecretKey;

        // Get product details from request body
//        String productTitle =(String) data.get("prodctTitle");
        String productName = (String) data.get("name");
        String productDescription = (String) data.get("description");
        Number amountNumber = (Number) data.get("price");
        int price = amountNumber.intValue();
        long priceInPaise = price * 100; // Convert to paise if using INR

        // Create a checkout session
        SessionCreateParams params = SessionCreateParams.builder()
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl("http://localhost:5173/success")
            .setCancelUrl("http://localhost:5173/cancel")
            .addLineItem(
                SessionCreateParams.LineItem.builder()
                    .setQuantity(1L)
                    .setPriceData(
                        SessionCreateParams.LineItem.PriceData.builder()
                            .setCurrency("inr") // Set to INR
                            .setUnitAmount(priceInPaise) // Price in paise
                            .setProductData(
                                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                    
                                    .setName(productName) // Set product name
                                    .setDescription(productDescription) // Set product description
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
            .build();

        // Create the session
        Session session = Session.create(params);

        // Return session ID to the frontend
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("id", session.getId());
        return responseData;
    }
}
