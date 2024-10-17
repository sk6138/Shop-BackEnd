package com.sahil.Shop.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sahil.Shop.Model.EmailRequest;
import com.sahil.Shop.Model.OtpRequest;
import com.sahil.Shop.Model.OtpResponse;
import com.sahil.Shop.Model.PhoneRequest;
import com.sahil.Shop.Model.Profile;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class ProfileController {

    // Simulated OTP storage for demo (in-memory)
    private String storedPhoneOtp = "123456"; // For phone OTP
    private String storedEmailOtp = "123456"; // For email OTP

    // Endpoint to send OTP to the phone
    @PostMapping("/sendPhoneOtp")
    public ResponseEntity<String> sendPhoneOtp(@RequestBody PhoneRequest phoneRequest) {
        // Logic to send OTP via SMS would go here
        return ResponseEntity.ok("OTP sent to phone number: " + phoneRequest.getPhone());
    }

    // Endpoint to verify phone OTP
    @PostMapping("/verifyPhoneOtp")
    public ResponseEntity<OtpResponse> verifyPhoneOtp(@RequestBody OtpRequest otpRequest) {
        if (otpRequest.getOtp().equals(storedPhoneOtp)) {
            return ResponseEntity.ok(new OtpResponse(true));
        }
        return ResponseEntity.ok(new OtpResponse(false));
    }

    // Endpoint to send OTP to the email
    @PostMapping("/sendEmailOtp")
    public ResponseEntity<String> sendEmailOtp(@RequestBody EmailRequest emailRequest) {
        // Logic to send OTP via email would go here
        return ResponseEntity.ok("OTP sent to email: " + emailRequest.getEmail());
    }

    // Endpoint to verify email OTP
    @PostMapping("/verifyEmailOtp")
    public ResponseEntity<OtpResponse> verifyEmailOtp(@RequestBody OtpRequest otpRequest) {
        if (otpRequest.getOtp().equals(storedEmailOtp)) {
            return ResponseEntity.ok(new OtpResponse(true));
        }
        return ResponseEntity.ok(new OtpResponse(false));
    }

    // Endpoint to save user profile data
    @PostMapping("/saveProfile")
    public ResponseEntity<String> saveProfile(@RequestBody Profile profile) {
        // Here you would save the profile data to the database
        return ResponseEntity.ok("Profile saved for user: " + profile.getFullName());
    }
}
