package com.java.hib;

public class CustomerAuthorization {
    private int authId;
    private int custId;
    private String otp;
    private String status;

    public CustomerAuthorization() {
        // Default constructor
    }

    public CustomerAuthorization(int authId, int custId, String otp, String status) {
        this.authId = authId;
        this.custId = custId;
        this.otp = otp;
        this.status = status;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CustomerAuthorization{" +
                "authId=" + authId +
                ", custId=" + custId +
                ", otp='" + otp + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
