package com.example.norcomapllication.web;

import com.example.norcomapllication.model.binding.MobilePlanAddBindingModel;
import com.example.norcomapllication.model.binding.MobilePlanUpdateBindingModel;
import com.example.norcomapllication.model.service.MobilePlanServiceUpdate;
import com.example.norcomapllication.model.view.MobilePlanDetailsView;
import com.example.norcomapllication.service.MobilePlanService;
import com.example.norcomapllication.service.impl.NorcomUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class MobilePlanController {
    private final MobilePlanService mobilePlanService;
    private final ModelMapper modelMapper;


    public MobilePlanController(MobilePlanService mobilePlanService, ModelMapper modelMapper) {
        this.mobilePlanService = mobilePlanService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/mobile-plans/all")
    public String allMobilePlans(Model model) {
        String fourG = "4G";
        String fiveG = "5G";
        model.addAttribute("plans4G",mobilePlanService.getAll4GTypePlans(fourG));
        model.addAttribute("plans5G",mobilePlanService.getAll5GTypePlans(fiveG));
        return "mobile-plans";
    }


    @PreAuthorize("isOwner(#id)")
    @DeleteMapping("/mobile-plans/{id}")
    public String deleteMobilePlan(@PathVariable Long id, Principal principal) {
        if(mobilePlanService.isOwner(principal.getName(), id)) {
            throw new RuntimeException();
        }
        mobilePlanService.deleteMobilePlan(id);
        return "redirect:/mobile-plans/all";
    }
    @GetMapping("/mobile-plans/add")
    public String addMobilePlanPage(Model model) {
        if(!model.containsAttribute("mobilePlanAddBindingModel")) {
            Map<String,String> plans = new LinkedHashMap<>();
            plans.put("4G","4G");
            plans.put("5G","5G");
            model.addAttribute("mobilePlanAddBindingModel", new MobilePlanAddBindingModel());
            model.addAttribute("plans",plans);
        }
        return "add-mobile-plan";
    }
    @PostMapping("/mobile-plans/add")
    public String addMobilePlan(@Valid MobilePlanAddBindingModel mobilePlanAddBindingModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                @AuthenticationPrincipal NorcomUser user,
                                @RequestParam(value = "services" ,required = false) String services) {
        if(bindingResult.hasErrors()) {
            Map<String,String> plans = new LinkedHashMap<>();
            plans.put("4G","4G");
            plans.put("5G","5G");
            redirectAttributes.addFlashAttribute("mobilePlanAddBindingModel",mobilePlanAddBindingModel);
            redirectAttributes.addFlashAttribute("plans",plans);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.mobilePlanAddBindingModel",bindingResult);
            return "redirect:/mobile-plans/add";
        }
        if(services == null) {
            mobilePlanAddBindingModel.setServices("");
            mobilePlanAddBindingModel.setServicesCount(0);
        } else {
            mobilePlanAddBindingModel.setServices(services);
            mobilePlanAddBindingModel.setServicesCount(services.split(",").length);
        }

        mobilePlanService.addMobilePlan(mobilePlanAddBindingModel,user.getUserIdentifier());
        return "redirect:/mobile-plans/all";
    }
    @GetMapping("/mobile-plans/{id}/edit-mobile-plan")
    public String editMobilePlan(@PathVariable Long id, Model model, @AuthenticationPrincipal NorcomUser user) {
        MobilePlanDetailsView mobilePlanDetailsView = mobilePlanService.findById(id,user.getUserIdentifier());
        MobilePlanUpdateBindingModel mobilePlanUpdateBindingModel = modelMapper.map(mobilePlanDetailsView, MobilePlanUpdateBindingModel.class);
        model.addAttribute("mobilePlanUpdateBindingModel",mobilePlanUpdateBindingModel);
        return "edit-mobile-plan";
    }

    @GetMapping("/mobile-plans/{id}/edit-mobile-plan/errors")
    public String editOfferErrors(@PathVariable Long id, Model model) {
        Map<String,String> plans = new LinkedHashMap<>();
        plans.put("4G","4G");
        plans.put("5G","5G");
        model.addAttribute("plans",plans);
        return "edit-mobile-plan";
    }

    @PatchMapping("/mobile-plans/{id}/edit-mobile-plan")
    public String editMobilePlan(@PathVariable Long id,@Valid MobilePlanUpdateBindingModel mobilePlanUpdateBindingModel,BindingResult bindingResult,RedirectAttributes redirectAttributes,@PathVariable(value = "services",required = false) String services) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("mobilePlanUpdateBindingModel",mobilePlanUpdateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.mobilePlanUpdateBindingModel",bindingResult);
            return "redirect:/mobile-plans/" + id +"/edit-mobile-plan/errors";
        }
        if(services == null) {
            mobilePlanUpdateBindingModel.setServices("");
            mobilePlanUpdateBindingModel.setServicesCount(0);
        } else {
            mobilePlanUpdateBindingModel.setServices(services);
            mobilePlanUpdateBindingModel.setServicesCount(services.split(",").length);
        }
        MobilePlanServiceUpdate mobilePlanServiceUpdate = modelMapper.map(mobilePlanUpdateBindingModel,MobilePlanServiceUpdate.class);
        mobilePlanServiceUpdate.setId(id);
        mobilePlanService.updateMobilePlan(mobilePlanServiceUpdate);
        return "redirect:/mobile-plans/all";
    }
}
