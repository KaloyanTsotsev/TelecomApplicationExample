package com.example.norcomapllication.service;

import com.example.norcomapllication.model.binding.MobilePlanAddBindingModel;
import com.example.norcomapllication.model.entity.MobilePlanEntity;
import com.example.norcomapllication.model.service.MobilePlanAddServiceModel;
import com.example.norcomapllication.model.service.MobilePlanServiceUpdate;
import com.example.norcomapllication.model.view.MobilePlanDetailsView;

import java.util.Collection;
import java.util.List;

public interface MobilePlanService {
    List<MobilePlanDetailsView> getAll4GTypePlans(String fourG);

    List<MobilePlanDetailsView> getAll5GTypePlans(String fiveG);

    void deleteMobilePlan(Long id);

    MobilePlanAddServiceModel addMobilePlan(MobilePlanAddBindingModel mobilePlanAddBindingModel, String userIdentifier);

    MobilePlanDetailsView findById(Long id, String user);

    void updateMobilePlan(MobilePlanServiceUpdate mobilePlanServiceUpdate);

    boolean isOwner(String name, Long id);

    Collection<MobilePlanEntity> getAllPlans();
}
