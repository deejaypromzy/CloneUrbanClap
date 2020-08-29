package com.sundram.urbanclapclone.datamodel;

public class CarpenterDataModel {
    private String serviceName, rupee, rupeeOff, quantity;
    private double totalPrice;

    public CarpenterDataModel(String serviceName, String quantity, String rupee, String rupeeOff, double totalPrice) {
        this.serviceName = serviceName;
        this.quantity = quantity;
        this.rupee = rupee;
        this.rupeeOff = rupeeOff;
        this.totalPrice = totalPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRupee() {
        return rupee;
    }

    public void setRupee(String rupee) {
        this.rupee = rupee;
    }

    public String getRupeeOff() {
        return rupeeOff;
    }

    public void setRupeeOff(String rupeeOff) {
        this.rupeeOff = rupeeOff;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
