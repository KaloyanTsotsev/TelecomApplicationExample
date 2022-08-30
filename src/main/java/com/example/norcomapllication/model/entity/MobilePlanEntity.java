package com.example.norcomapllication.model.entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "mobile_plans")
public class MobilePlanEntity extends BaseEntity {
    private String name;
    private String mobilePlanType;
    private String internet;
    private String minutes;
    private String sms;
    private String internetEU;
    private String minutesEU;
    private String smsEU;
    private BigDecimal price;
    private Set<OrderEntity> orders;
    private UserEntity user;
    private String services;
    private Integer servicesCount;
    public MobilePlanEntity() {
    }
    @Column(nullable = false,unique = true)
    public String getName() {
        return name;
    }

    public MobilePlanEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false)
    public String getMobilePlanType() {
        return mobilePlanType;
    }

    public MobilePlanEntity setMobilePlanType(String mobilePlanType) {
        this.mobilePlanType = mobilePlanType;
        return this;
    }
    @Column(nullable = false)
    public String getInternet() {
        return internet;
    }

    public MobilePlanEntity setInternet(String internet) {
        this.internet = internet;
        return this;
    }
    @Column(nullable = false)
    public String getMinutes() {
        return minutes;
    }

    public MobilePlanEntity setMinutes(String minutes) {
        this.minutes = minutes;
        return this;
    }
    @Column(nullable = false)
    public String getSms() {
        return sms;
    }

    public MobilePlanEntity setSms(String sms) {
        this.sms = sms;
        return this;
    }
    @Column(nullable = false)
    public String getInternetEU() {
        return internetEU;
    }

    public MobilePlanEntity setInternetEU(String internetEU) {
        this.internetEU = internetEU;
        return this;
    }
    @Column(nullable = false)
    public String getMinutesEU() {
        return minutesEU;
    }

    public MobilePlanEntity setMinutesEU(String minutesEU) {
        this.minutesEU = minutesEU;
        return this;
    }
    @Column(nullable = false)
    public String getSmsEU() {
        return smsEU;
    }

    public MobilePlanEntity setSmsEU(String smsEU) {
        this.smsEU = smsEU;
        return this;
    }
    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public MobilePlanEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @OneToMany(mappedBy = "mobilePlan")
    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public MobilePlanEntity setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    public UserEntity getUser() {
        return user;
    }

    public MobilePlanEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
    @Column(name = "services")
    public String getServices() {
        return services;
    }

    public MobilePlanEntity setServices(String services) {
        this.services = services; return this;
    }
    @Column(name = "service_count")
    public Integer getServicesCount() {
        return servicesCount;
    }

    public MobilePlanEntity setServicesCount(Integer servicesCount) {
        this.servicesCount = servicesCount; return this;
    }

}
