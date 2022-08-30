package com.example.norcomapllication.model.binding;

import com.example.norcomapllication.model.entity.enums.OperationSystemType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class DeviceAddBindingModel {
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

    public Long getId() {
        return id;
    }

    public DeviceAddBindingModel setId(Long id) {
        this.id = id;
        return this;
    }
    @NotNull
    public String getFirstImageUrl() {
        return firstImageUrl;
    }

    public DeviceAddBindingModel setFirstImageUrl(String firstImageUrl) {
        this.firstImageUrl = firstImageUrl;
        return this;
    }
    @NotNull

    public String getSecondImageUrl() {
        return secondImageUrl;
    }

    public DeviceAddBindingModel setSecondImageUrl(String secondImageUrl) {
        this.secondImageUrl = secondImageUrl;
        return this;
    }
    @NotNull

    public String getThirdImageUrl() {
        return thirdImageUrl;
    }

    public DeviceAddBindingModel setThirdImageUrl(String thirdImageUrl) {
        this.thirdImageUrl = thirdImageUrl;
        return this;
    }
    @NotNull
    public String getFourthImageUrl() {
        return fourthImageUrl;
    }

    public DeviceAddBindingModel setFourthImageUrl(String fourthImageUrl) {
        this.fourthImageUrl = fourthImageUrl;
        return this;
    }
    @NotNull
    public String getFifthImageUrl() {
        return fifthImageUrl;
    }

    public DeviceAddBindingModel setFifthImageUrl(String fifthImageUrl) {
        this.fifthImageUrl = fifthImageUrl;
        return this;
    }
    @NotNull
    public String getName() {
        return name;
    }

    public DeviceAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }
    @NotNull
    @Min(100)
    public BigDecimal getPrice() {
        return price;
    }

    public DeviceAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    @NotNull
    public String getType() {
        return type;
    }

    public DeviceAddBindingModel setType(String type) {
        this.type = type;
        return this;
    }
    @NotNull
    public OperationSystemType getOperationSystem() {
        return operationSystem;
    }

    public DeviceAddBindingModel setOperationSystem(OperationSystemType operationSystem) {
        this.operationSystem = operationSystem;
        return this;
    }
    @NotNull
    public String getProcessor() {
        return processor;
    }

    public DeviceAddBindingModel setProcessor(String processor) {
        this.processor = processor;
        return this;
    }
    @NotNull
    public String getChipset() {
        return chipset;
    }

    public DeviceAddBindingModel setChipset(String chipset) {
        this.chipset = chipset;
        return this;
    }
    @NotNull
    public String getSizeDevice() {
        return sizeDevice;
    }

    public DeviceAddBindingModel setSizeDevice(String sizeDevice) {
        this.sizeDevice = sizeDevice;
        return this;
    }
    @NotNull
    public Long getWeightDevice() {
        return weightDevice;
    }

    public DeviceAddBindingModel setWeightDevice(Long weightDevice) {
        this.weightDevice = weightDevice;
        return this;
    }
    @NotNull
    public String getTypeOfScreen() {
        return typeOfScreen;
    }

    public DeviceAddBindingModel setTypeOfScreen(String typeOfScreen) {
        this.typeOfScreen = typeOfScreen;
        return this;
    }
    @NotNull
    @PositiveOrZero
    public BigDecimal getSizeOfScreen() {
        return sizeOfScreen;
    }

    public DeviceAddBindingModel setSizeOfScreen(BigDecimal sizeOfScreen) {
        this.sizeOfScreen = sizeOfScreen;
        return this;
    }
    @NotNull
    public String getResolutionOfScreen() {
        return resolutionOfScreen;
    }

    public DeviceAddBindingModel setResolutionOfScreen(String resolutionOfScreen) {
        this.resolutionOfScreen = resolutionOfScreen;
        return this;
    }
    @NotNull
    public String getCardMemory() {
        return cardMemory;
    }

    public DeviceAddBindingModel setCardMemory(String cardMemory) {
        this.cardMemory = cardMemory;
        return this;
    }
    @NotNull
    public String getDeviceStorage() {
        return deviceStorage;
    }

    public DeviceAddBindingModel setDeviceStorage(String deviceStorage) {
        this.deviceStorage = deviceStorage;
        return this;
    }
    @NotNull
    public String getDeviceRamStorage() {
        return deviceRamStorage;
    }

    public DeviceAddBindingModel setDeviceRamStorage(String deviceRamStorage) {
        this.deviceRamStorage = deviceRamStorage;
        return this;
    }
    @NotNull
    public String getBackCamera() {
        return backCamera;
    }

    public DeviceAddBindingModel setBackCamera(String backCamera) {
        this.backCamera = backCamera;
        return this;
    }
    @NotNull
    public String getFrontCamera() {
        return frontCamera;
    }

    public DeviceAddBindingModel setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
        return this;
    }
    @NotNull
    public String getSpeaker() {
        return speaker;
    }

    public DeviceAddBindingModel setSpeaker(String speaker) {
        this.speaker = speaker;
        return this;
    }
    @NotNull
    public String getHeadphoneSlot() {
        return headphoneSlot;
    }

    public DeviceAddBindingModel setHeadphoneSlot(String headphoneSlot) {
        this.headphoneSlot = headphoneSlot;
        return this;
    }
    @NotNull
    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public DeviceAddBindingModel setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
        return this;
    }

}
