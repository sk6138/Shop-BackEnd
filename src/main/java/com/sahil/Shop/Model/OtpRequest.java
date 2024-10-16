package com.sahil.Shop.Model;

public class OtpRequest {
    private String phoneOrEmail;
    private String otp;

    // Getters and Setters
    public String getPhoneOrEmail() {
        return phoneOrEmail;
    }

    public void setPhoneOrEmail(String phoneOrEmail) {
        this.phoneOrEmail = phoneOrEmail;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
