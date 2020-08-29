package com.sundram.urbanclapclone.datamodel;

public class DataModel {

    private String serviceName;
    private int drawable;
    private String details;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public DataModel(String details) {
        this.details = details;
    }

    public DataModel() {
    }

    public DataModel(String serviceName, int drawable) {
        this.serviceName = serviceName;
        this.drawable = drawable;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }


}
