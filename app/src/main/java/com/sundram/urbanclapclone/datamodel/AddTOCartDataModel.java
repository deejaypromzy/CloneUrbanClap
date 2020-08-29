package com.sundram.urbanclapclone.datamodel;

public class AddTOCartDataModel {
    private String serviceName;
    private String typeOfService;
    private String price;
    private String quantity;

    public AddTOCartDataModel(String serviceName, String typeOfService, String price, String quantity) {
        this.serviceName = serviceName;
        this.typeOfService = typeOfService;
        this.price = price;
        this.quantity = quantity;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
