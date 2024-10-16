package com.sahil.Shop.Model;

public class OtpResponse{


private boolean success;

public OtpResponse(boolean success) {
    this.success = success;
}

public boolean isSuccess() {
    return success;
}

public void setSuccess(boolean success) {
    this.success = success;
}
}