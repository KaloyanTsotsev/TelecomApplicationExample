package com.example.norcomapllication.model.service;

import java.math.BigDecimal;

public class MobilePlanAddServiceModel {
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
    private String services;
    private Integer servicesCount;

    public Long getId() {
        return id;
    }

    public MobilePlanAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MobilePlanAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getMobilePlanType() {
        return mobilePlanType;
    }

    public MobilePlanAddServiceModel setMobilePlanType(String mobilePlanType) {
        this.mobilePlanType = mobilePlanType;return this;
    }

    public String getInternet() {
        return internet;
    }

    public MobilePlanAddServiceModel setInternet(String internet) {
        this.internet = internet;return this;
    }

    public String getMinutes() {
        return minutes;
    }

    public MobilePlanAddServiceModel setMinutes(String minutes) {
        this.minutes = minutes;return this;
    }

    public String getSms() {
        return sms;
    }

    public MobilePlanAddServiceModel setSms(String sms) {
        this.sms = sms;return this;
    }

    public String getInternetEU() {
        return internetEU;
    }

    public MobilePlanAddServiceModel setInternetEU(String internetEU) {
        this.internetEU = internetEU;return this;
    }

    public String getMinutesEU() {
        return minutesEU;
    }

    public MobilePlanAddServiceModel setMinutesEU(String minutesEU) {
        this.minutesEU = minutesEU;return this;
    }

    public String getSmsEU() {
        return smsEU;
    }

    public MobilePlanAddServiceModel setSmsEU(String smsEU) {
        this.smsEU = smsEU;return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public MobilePlanAddServiceModel setPrice(BigDecimal price) {
        this.price = price;return this;
    }

    public String getServices() {
        return services;
    }

    public MobilePlanAddServiceModel setServices(String services) {
        this.services = services; return this;
    }

    public Integer getServicesCount() {
        return servicesCount;
    }

    public MobilePlanAddServiceModel setServicesCount(Integer servicesCount) {
        this.servicesCount = servicesCount; return this;
    }
}
