package com.example.norcomapllication.model.service;

import java.math.BigDecimal;

public class MobilePlanServiceUpdate {
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
    private boolean canDelete;

    public Long getId() {
        return id;
    }

    public MobilePlanServiceUpdate setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MobilePlanServiceUpdate setName(String name) {
        this.name = name;
        return this;
    }

    public String getMobilePlanType() {
        return mobilePlanType;
    }

    public MobilePlanServiceUpdate setMobilePlanType(String mobilePlanType) {
        this.mobilePlanType = mobilePlanType;return this;
    }

    public String getInternet() {
        return internet;
    }

    public MobilePlanServiceUpdate setInternet(String internet) {
        this.internet = internet;return this;
    }

    public String getMinutes() {
        return minutes;
    }

    public MobilePlanServiceUpdate setMinutes(String minutes) {
        this.minutes = minutes;return this;
    }

    public String getSms() {
        return sms;
    }

    public MobilePlanServiceUpdate setSms(String sms) {
        this.sms = sms;return this;
    }

    public String getInternetEU() {
        return internetEU;
    }

    public MobilePlanServiceUpdate setInternetEU(String internetEU) {
        this.internetEU = internetEU;return this;
    }

    public String getMinutesEU() {
        return minutesEU;
    }

    public MobilePlanServiceUpdate setMinutesEU(String minutesEU) {
        this.minutesEU = minutesEU;return this;
    }

    public String getSmsEU() {
        return smsEU;
    }

    public MobilePlanServiceUpdate setSmsEU(String smsEU) {
        this.smsEU = smsEU;return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public MobilePlanServiceUpdate setPrice(BigDecimal price) {
        this.price = price;return this;
    }

    public String getServices() {
        return services;
    }

    public MobilePlanServiceUpdate setServices(String services) {
        this.services = services; return this;
    }

    public Integer getServicesCount() {
        return servicesCount;
    }

    public MobilePlanServiceUpdate setServicesCount(Integer servicesCount) {
        this.servicesCount = servicesCount; return this;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }
}
