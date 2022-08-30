package com.example.norcomapllication.model.service;

import com.example.norcomapllication.model.entity.UserEntity;
import com.example.norcomapllication.model.entity.enums.OperationSystemType;

import java.math.BigDecimal;
import java.util.Set;

public class DeviceAddServiceModel {
    private Long id;
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
    private boolean canDelete;
    private Set<UserEntity> addedBy;

    public Long getId() {
        return id;
    }

    public DeviceAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstImageUrl() {
        return firstImageUrl;
    }

    public DeviceAddServiceModel setFirstImageUrl(String firstImageUrl) {
        this.firstImageUrl = firstImageUrl;
        return this;
    }

    public String getSecondImageUrl() {
        return secondImageUrl;
    }

    public DeviceAddServiceModel setSecondImageUrl(String secondImageUrl) {
        this.secondImageUrl = secondImageUrl;
        return this;
    }

    public String getThirdImageUrl() {
        return thirdImageUrl;
    }

    public DeviceAddServiceModel setThirdImageUrl(String thirdImageUrl) {
        this.thirdImageUrl = thirdImageUrl;
        return this;
    }

    public String getFourthImageUrl() {
        return fourthImageUrl;
    }

    public DeviceAddServiceModel setFourthImageUrl(String fourthImageUrl) {
        this.fourthImageUrl = fourthImageUrl;
        return this;
    }

    public String getFifthImageUrl() {
        return fifthImageUrl;
    }

    public DeviceAddServiceModel setFifthImageUrl(String fifthImageUrl) {
        this.fifthImageUrl = fifthImageUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public DeviceAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DeviceAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getType() {
        return type;
    }

    public DeviceAddServiceModel setType(String type) {
        this.type = type;
        return this;
    }

    public OperationSystemType getOperationSystem() {
        return operationSystem;
    }

    public DeviceAddServiceModel setOperationSystem(OperationSystemType operationSystem) {
        this.operationSystem = operationSystem;
        return this;
    }

    public String getProcessor() {
        return processor;
    }

    public DeviceAddServiceModel setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public String getChipset() {
        return chipset;
    }

    public DeviceAddServiceModel setChipset(String chipset) {
        this.chipset = chipset;
        return this;
    }

    public String getSizeDevice() {
        return sizeDevice;
    }

    public DeviceAddServiceModel setSizeDevice(String sizeDevice) {
        this.sizeDevice = sizeDevice;
        return this;
    }

    public Long getWeightDevice() {
        return weightDevice;
    }

    public DeviceAddServiceModel setWeightDevice(Long weightDevice) {
        this.weightDevice = weightDevice;
        return this;
    }

    public String getTypeOfScreen() {
        return typeOfScreen;
    }

    public DeviceAddServiceModel setTypeOfScreen(String typeOfScreen) {
        this.typeOfScreen = typeOfScreen;
        return this;
    }

    public BigDecimal getSizeOfScreen() {
        return sizeOfScreen;
    }

    public DeviceAddServiceModel setSizeOfScreen(BigDecimal sizeOfScreen) {
        this.sizeOfScreen = sizeOfScreen;
        return this;
    }

    public String getResolutionOfScreen() {
        return resolutionOfScreen;
    }

    public DeviceAddServiceModel setResolutionOfScreen(String resolutionOfScreen) {
        this.resolutionOfScreen = resolutionOfScreen;
        return this;
    }

    public String getCardMemory() {
        return cardMemory;
    }

    public DeviceAddServiceModel setCardMemory(String cardMemory) {
        this.cardMemory = cardMemory;
        return this;
    }

    public String getDeviceStorage() {
        return deviceStorage;
    }

    public DeviceAddServiceModel setDeviceStorage(String deviceStorage) {
        this.deviceStorage = deviceStorage;
        return this;
    }

    public String getDeviceRamStorage() {
        return deviceRamStorage;
    }

    public DeviceAddServiceModel setDeviceRamStorage(String deviceRamStorage) {
        this.deviceRamStorage = deviceRamStorage;
        return this;
    }

    public String getBackCamera() {
        return backCamera;
    }

    public DeviceAddServiceModel setBackCamera(String backCamera) {
        this.backCamera = backCamera;
        return this;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public DeviceAddServiceModel setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
        return this;
    }

    public String getSpeaker() {
        return speaker;
    }

    public DeviceAddServiceModel setSpeaker(String speaker) {
        this.speaker = speaker;
        return this;
    }

    public String getHeadphoneSlot() {
        return headphoneSlot;
    }

    public DeviceAddServiceModel setHeadphoneSlot(String headphoneSlot) {
        this.headphoneSlot = headphoneSlot;
        return this;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public DeviceAddServiceModel setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
        return this;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public DeviceAddServiceModel setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
        return this;
    }

    public Set<UserEntity> getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Set<UserEntity> addedBy) {
        this.addedBy = addedBy;
    }
}
