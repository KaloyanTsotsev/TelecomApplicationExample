package com.example.norcomapllication.model.view;


import java.math.BigDecimal;
import java.util.Set;

public class MobilePlanDetailsView {
    private Long id;
    private String name;
    private String mobilePlanType;
    private String internet;
    private String minutes;
    private String sms;
    private String internetEU;
    private String minutesEU;
    private String smsEU;
    private BigDecimal price;
    boolean canDelete;
    private String services;
    private Integer servicesCount;


    public Long getId() {
        return id;
    }

    public MobilePlanDetailsView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MobilePlanDetailsView setName(String name) {
        this.name = name;
        return this;
    }

    public String getMobilePlanType() {
        return mobilePlanType;
    }

    public MobilePlanDetailsView setMobilePlanType(String mobilePlanType) {
        this.mobilePlanType = mobilePlanType;return this;
    }

    public String getInternet() {
        return internet;
    }

    public MobilePlanDetailsView setInternet(String internet) {
        this.internet = internet;return this;
    }

    public String getMinutes() {
        return minutes;
    }

    public MobilePlanDetailsView setMinutes(String minutes) {
        this.minutes = minutes;return this;
    }

    public String getSms() {
        return sms;
    }

    public MobilePlanDetailsView setSms(String sms) {
        this.sms = sms;return this;
    }

    public String getInternetEU() {
        return internetEU;
    }

    public MobilePlanDetailsView setInternetEU(String internetEU) {
        this.internetEU = internetEU;return this;
    }

    public String getMinutesEU() {
        return minutesEU;
    }

    public MobilePlanDetailsView setMinutesEU(String minutesEU) {
        this.minutesEU = minutesEU;return this;
    }

    public String getSmsEU() {
        return smsEU;
    }

    public MobilePlanDetailsView setSmsEU(String smsEU) {
        this.smsEU = smsEU;return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public MobilePlanDetailsView setPrice(BigDecimal price) {
        this.price = price;return this;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public MobilePlanDetailsView setCanDelete(boolean canDelete) {
        this.canDelete = canDelete; return this;
    }

    public String getServices() {
        return services;
    }

    public MobilePlanDetailsView setServices(String services) {
        this.services = services; return this;
    }

    public Integer getServicesCount() {
        return servicesCount;
    }

    public MobilePlanDetailsView setServicesCount(Integer servicesCount) {
        this.servicesCount = servicesCount; return this;
    }
}
