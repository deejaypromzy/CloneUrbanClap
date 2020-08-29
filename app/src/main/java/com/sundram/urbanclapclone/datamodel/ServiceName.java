package com.sundram.urbanclapclone.datamodel;

public class ServiceName {
    //search view adapter
    private String serviceName;

    //variable for home screen service list
    private String service_txt_one;
    private String service_txt_two;
    private String service_txt_three;
    private int drawable;
    //end

    //service one home scree one
    public ServiceName(String serviceName, String service_txt_one, String service_txt_two, String service_txt_three, int
            drawable) {
        this.serviceName = serviceName;
        this.service_txt_one = service_txt_one;
        this.service_txt_two = service_txt_two;
        this.service_txt_three = service_txt_three;
        this.drawable=drawable;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getService_txt_one() {
        return service_txt_one;
    }
    //service one home screen two

    public String getService_txt_two() {
        return service_txt_two;
    }
    //service one home screen three

    public String getService_txt_three() {
        return service_txt_three;
    }
    //constructor for home screen service list item

    public ServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}