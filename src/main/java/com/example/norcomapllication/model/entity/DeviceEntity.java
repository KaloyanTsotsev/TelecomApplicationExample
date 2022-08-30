package com.example.norcomapllication.model.entity;

import com.example.norcomapllication.model.entity.enums.OperationSystemType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "devices")
public class DeviceEntity extends BaseEntity{
    private String firstImageUrl;
    private String secondImageUrl;
    private String thirdImageUrl;
    private String fourthImageUrl;
    private String fifthImageUrl;
    private String name;
    private BigDecimal price;
    private String type;
    private OperationSystemType operationSystem;
    private String processor;
    private String chipset;
    private String sizeDevice;
    private Long weightDevice;
    private String typeOfScreen;
    private BigDecimal sizeOfScreen;
    private String resolutionOfScreen;
    private String cardMemory;
    private String deviceStorage;
    private String deviceRamStorage;
    private String backCamera;
    private String frontCamera;
    private String speaker;
    private String headphoneSlot;
    private String batteryCapacity;
    private UserEntity user;
    private Set<OrderEntity> orders;


    public DeviceEntity() {
    }
    @Column(columnDefinition = "LONGTEXT")
    public String getFirstImageUrl() {
        return firstImageUrl;
    }

    public DeviceEntity setFirstImageUrl(String firstImageUrl) {
        this.firstImageUrl = firstImageUrl;
        return this;
    }
    @Column(columnDefinition = "LONGTEXT")
    public String getSecondImageUrl() {
        return secondImageUrl;
    }

    public DeviceEntity setSecondImageUrl(String secondImageUrl) {
        this.secondImageUrl = secondImageUrl;
        return this;
    }
    @Column(columnDefinition = "LONGTEXT")
    public String getThirdImageUrl() {
        return thirdImageUrl;
    }

    public DeviceEntity setThirdImageUrl(String thirdImageUrl) {
        this.thirdImageUrl = thirdImageUrl;
        return this;
    }
    @Column(columnDefinition = "LONGTEXT")
    public String getFourthImageUrl() {
        return fourthImageUrl;
    }

    public DeviceEntity setFourthImageUrl(String fourthImageUrl) {
        this.fourthImageUrl = fourthImageUrl;
        return this;
    }
    @Column(columnDefinition = "LONGTEXT")
    public String getFifthImageUrl() {
        return fifthImageUrl;
    }

    public DeviceEntity setFifthImageUrl(String fifthImageUrl) {
        this.fifthImageUrl = fifthImageUrl;
        return this;
    }
    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public DeviceEntity setName(String name) {
        this.name = name;
        return this;
    }
    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public DeviceEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column(nullable = false)
    public String getType() {
        return type;
    }

    public DeviceEntity setType(String type) {
        this.type = type;
        return this;
    }
    @Enumerated(EnumType.STRING)
    public OperationSystemType getOperationSystem() {
        return operationSystem;
    }

    public DeviceEntity setOperationSystem(OperationSystemType operationSystem) {
        this.operationSystem = operationSystem;
        return this;
    }
    @Column(nullable = false)
    public String getProcessor() {
        return processor;
    }

    public DeviceEntity setProcessor(String processor) {
        this.processor = processor;
        return this;
    }
    @Column(nullable = false)
    public String getChipset() {
        return chipset;
    }

    public DeviceEntity setChipset(String chipset) {
        this.chipset = chipset;
        return this;
    }
    @Column(name = "device_size",nullable = false)
    public String getSizeDevice() {
        return sizeDevice;
    }

    public DeviceEntity setSizeDevice(String sizeDevice) {
        this.sizeDevice = sizeDevice;
        return this;
    }
    @Column(name="device_weight",nullable = false)
    public Long getWeightDevice() {
        return weightDevice;
    }

    public DeviceEntity setWeightDevice(Long weightDevice) {
        this.weightDevice = weightDevice;
        return this;
    }
    @Column(name = "type_of_screen",nullable = false)
    public String getTypeOfScreen() {
        return typeOfScreen;
    }

    public DeviceEntity setTypeOfScreen(String typeOfScreen) {
        this.typeOfScreen = typeOfScreen;
        return this;
    }
    @Column(name = "size_of_screen",nullable = false)
    public BigDecimal getSizeOfScreen() {
        return sizeOfScreen;
    }

    public DeviceEntity setSizeOfScreen(BigDecimal sizeOfScreen) {
        this.sizeOfScreen = sizeOfScreen;
        return this;
    }
    @Column(name = "resolution_of_screen",nullable = false)
    public String getResolutionOfScreen() {
        return resolutionOfScreen;
    }

    public DeviceEntity setResolutionOfScreen(String resolutionOfScreen) {
        this.resolutionOfScreen = resolutionOfScreen;
        return this;
    }
    @Column(name = "card_memory",nullable = false)
    public String getCardMemory() {
        return cardMemory;
    }

    public DeviceEntity setCardMemory(String cardMemory) {
        this.cardMemory = cardMemory;
        return this;
    }
    @Column(name = "device_storage",nullable = false)
    public String getDeviceStorage() {
        return deviceStorage;
    }

    public DeviceEntity setDeviceStorage(String deviceStorage) {
        this.deviceStorage = deviceStorage;
        return this;
    }
    @Column(name = "device_ram",nullable = false)
    public String getDeviceRamStorage() {
        return deviceRamStorage;
    }

    public DeviceEntity setDeviceRamStorage(String deviceRamStorage) {
        this.deviceRamStorage = deviceRamStorage;
        return this;
    }
    @Column(name = "back_camera",nullable = false ,columnDefinition = "TEXT")
    public String getBackCamera() {
        return backCamera;
    }

    public DeviceEntity setBackCamera(String backCamera) {
        this.backCamera = backCamera;
        return this;
    }
    @Column(name = "front_camera",nullable = false)
    public String getFrontCamera() {
        return frontCamera;
    }

    public DeviceEntity setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
        return this;
    }
    @Column(name = "speaker",nullable = false)
    public String getSpeaker() {
        return speaker;
    }

    public DeviceEntity setSpeaker(String speaker) {
        this.speaker = speaker;
        return this;
    }
    @Column(name = "headphone_slot",nullable = false)
    public String getHeadphoneSlot() {
        return headphoneSlot;
    }

    public DeviceEntity setHeadphoneSlot(String headphoneSlot) {
        this.headphoneSlot = headphoneSlot;
        return this;
    }
    @Column(name = "battery_capacity",nullable = false)
    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public DeviceEntity setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
        return this;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    public UserEntity getUser() {
        return user;
    }

    public DeviceEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }
    @OneToMany(mappedBy = "device")
    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public DeviceEntity setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }
}
