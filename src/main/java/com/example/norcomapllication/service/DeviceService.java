package com.example.norcomapllication.service;

import com.example.norcomapllication.model.binding.DeviceAddBindingModel;
import com.example.norcomapllication.model.service.DeviceAddServiceModel;
import com.example.norcomapllication.model.service.DeviceUpdateServiceModel;
import com.example.norcomapllication.model.view.DeviceDetailsView;
import com.example.norcomapllication.model.view.DeviceSummaryView;

import java.util.List;

public interface DeviceService {

    List<DeviceSummaryView> getAllDevices();

    DeviceDetailsView findById(Long id, String name);

    boolean isOwner(String name, Long id);

    void deleteDevice(Long id);

    void updateOffer(DeviceUpdateServiceModel serviceModel);

    DeviceAddServiceModel addDevice(DeviceAddBindingModel deviceAddBindingModel, String userIdentifier);
    void initDevices();

    List<DeviceSummaryView> getAllBySearch(String keyword);
}
