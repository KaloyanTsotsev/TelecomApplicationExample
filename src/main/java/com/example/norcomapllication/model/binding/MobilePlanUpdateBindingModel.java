package com.example.norcomapllication.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class MobilePlanUpdateBindingModel {
    private Long id;
    private String name;
//    public String mobilePlanType;
    public String internet;
    public String minutes;
    public String sms;
    public String internetEU;
    public String minutesEU;
    public String smsEU;
    public BigDecimal price;
    private String services;
    private Integer servicesCount;

    public Long getId() {
        return id;
    }

    public MobilePlanUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public MobilePlanUpdateBindingModel setName(String name) {
        this.name = name;
        return this;
    }

//    @NotNull
//    public String getMobilePlanType() {
//        return mobilePlanType;
//    }
//
//    public MobilePlanUpdateBindingModel setMobilePlanType(String mobilePlanType) {
//        this.mobilePlanType = mobilePlanType;
//        return this;
//    }

    @NotNull
    public String getInternet() {
        return internet;
    }

    public MobilePlanUpdateBindingModel setInternet(String internet) {
        this.internet = internet;
        return this;
    }

    @NotNull
    public String getMinutes() {
        return minutes;
    }

    public MobilePlanUpdateBindingModel setMinutes(String minutes) {
        this.minutes = minutes;
        return this;
    }

    @NotNull
    public String getSms() {
        return sms;
    }

    public MobilePlanUpdateBindingModel setSms(String sms) {
        this.sms = sms;
        return this;
    }

    @NotNull
    public String getInternetEU() {
        return internetEU;
    }

    public MobilePlanUpdateBindingModel setInternetEU(String internetEU) {
        this.internetEU = internetEU;
        return this;
    }

    @NotNull
    public String getMinutesEU() {
        return minutesEU;
    }

    public MobilePlanUpdateBindingModel setMinutesEU(String minutesEU) {
        this.minutesEU = minutesEU;
        return this;
    }

    @NotNull
    public String getSmsEU() {
        return smsEU;
    }

    public MobilePlanUpdateBindingModel setSmsEU(String smsEU) {
        this.smsEU = smsEU;
        return this;
    }

    @NotNull
    @PositiveOrZero
    public BigDecimal getPrice() {
        return price;
    }

    public MobilePlanUpdateBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getServices() {
        return services;
    }

    public MobilePlanUpdateBindingModel setServices(String services) {
        this.services = services; return this;
    }

    public Integer getServicesCount() {
        return servicesCount;
    }

    public MobilePlanUpdateBindingModel setServicesCount(Integer servicesCount) {
        this.servicesCount = servicesCount; return this;
    }
}
