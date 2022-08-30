package com.example.norcomapllication.model.view;

import com.example.norcomapllication.model.entity.enums.OperationSystemType;

import java.math.BigDecimal;

public class DeviceDetailsView {
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

    public Long getId() {
        return id;
    }

    public DeviceDetailsView setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstImageUrl() {
        return firstImageUrl;
    }

    public DeviceDetailsView setFirstImageUrl(String firstImageUrl) {
        this.firstImageUrl = firstImageUrl;
        return this;
    }

    public String getSecondImageUrl() {
        return secondImageUrl;
    }

    public DeviceDetailsView setSecondImageUrl(String secondImageUrl) {
        this.secondImageUrl = secondImageUrl;
        return this;
    }

    public String getThirdImageUrl() {
        return thirdImageUrl;
    }

    public DeviceDetailsView setThirdImageUrl(String thirdImageUrl) {
        this.thirdImageUrl = thirdImageUrl;
        return this;
    }

    public String getFourthImageUrl() {
        return fourthImageUrl;
    }

    public DeviceDetailsView setFourthImageUrl(String fourthImageUrl) {
        this.fourthImageUrl = fourthImageUrl;
        return this;
    }

    public String getFifthImageUrl() {
        return fifthImageUrl;
    }

    public DeviceDetailsView setFifthImageUrl(String fifthImageUrl) {
        this.fifthImageUrl = fifthImageUrl;
        return this;
    }

    public String getName() {
        return name;
    }

    public DeviceDetailsView setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public DeviceDetailsView setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getType() {
        return type;
    }

    public DeviceDetailsView setType(String type) {
        this.type = type;
        return this;
    }

    public OperationSystemType getOperationSystem() {
        return operationSystem;
    }

    public DeviceDetailsView setOperationSystem(OperationSystemType operationSystem) {
        this.operationSystem = operationSystem;
        return this;
    }

    public String getProcessor() {
        return processor;
    }

    public DeviceDetailsView setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public String getChipset() {
        return chipset;
    }

    public DeviceDetailsView setChipset(String chipset) {
        this.chipset = chipset;
        return this;
    }

    public String getSizeDevice() {
        return sizeDevice;
    }

    public DeviceDetailsView setSizeDevice(String sizeDevice) {
        this.sizeDevice = sizeDevice;
        return this;
    }

    public Long getWeightDevice() {
        return weightDevice;
    }

    public DeviceDetailsView setWeightDevice(Long weightDevice) {
        this.weightDevice = weightDevice;
        return this;
    }

    public String getTypeOfScreen() {
        return typeOfScreen;
    }

    public DeviceDetailsView setTypeOfScreen(String typeOfScreen) {
        this.typeOfScreen = typeOfScreen;
        return this;
    }

    public BigDecimal getSizeOfScreen() {
        return sizeOfScreen;
    }

    public DeviceDetailsView setSizeOfScreen(BigDecimal sizeOfScreen) {
        this.sizeOfScreen = sizeOfScreen;
        return this;
    }

    public String getResolutionOfScreen() {
        return resolutionOfScreen;
    }

    public DeviceDetailsView setResolutionOfScreen(String resolutionOfScreen) {
        this.resolutionOfScreen = resolutionOfScreen;
        return this;
    }

    public String getCardMemory() {
        return cardMemory;
    }

    public DeviceDetailsView setCardMemory(String cardMemory) {
        this.cardMemory = cardMemory;
        return this;
    }

    public String getDeviceStorage() {
        return deviceStorage;
    }

    public DeviceDetailsView setDeviceStorage(String deviceStorage) {
        this.deviceStorage = deviceStorage;
        return this;
    }

    public String getDeviceRamStorage() {
        return deviceRamStorage;
    }

    public DeviceDetailsView setDeviceRamStorage(String deviceRamStorage) {
        this.deviceRamStorage = deviceRamStorage;
        return this;
    }

    public String getBackCamera() {
        return backCamera;
    }

    public DeviceDetailsView setBackCamera(String backCamera) {
        this.backCamera = backCamera;
        return this;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public DeviceDetailsView setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
        return this;
    }

    public String getSpeaker() {
        return speaker;
    }

    public DeviceDetailsView setSpeaker(String speaker) {
        this.speaker = speaker;
        return this;
    }

    public String getHeadphoneSlot() {
        return headphoneSlot;
    }

    public DeviceDetailsView setHeadphoneSlot(String headphoneSlot) {
        this.headphoneSlot = headphoneSlot;
        return this;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public DeviceDetailsView setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
        return this;
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public DeviceDetailsView setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
        return this;
    }
}
