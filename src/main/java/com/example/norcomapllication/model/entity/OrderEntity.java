package com.example.norcomapllication.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity{
    public UserEntity user;
    public String phoneNumber;
    public DeviceEntity device;
    public MobilePlanEntity mobilePlan;

    @ManyToOne(fetch = FetchType.EAGER)
    public UserEntity getUser() {
        return user;
    }

    public OrderEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
    @Column(name = "phone_number",unique = true)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrderEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;

    }

    @ManyToOne(fetch = FetchType.EAGER)
    public DeviceEntity getDevice() {
        return device;
    }

    public OrderEntity setDevice(DeviceEntity device) {
        this.device = device;
        return this;

    }
    @ManyToOne(fetch = FetchType.EAGER)
    public MobilePlanEntity getMobilePlan() {
        return mobilePlan;
    }

    public OrderEntity setMobilePlan(MobilePlanEntity mobilePlan) {
        this.mobilePlan = mobilePlan;
        return this;

    }

}
