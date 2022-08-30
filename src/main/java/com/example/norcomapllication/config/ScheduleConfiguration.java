package com.example.norcomapllication.config;

import com.example.norcomapllication.service.DeviceService;
import com.example.norcomapllication.service.MobilePlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled",matchIfMissing = true)
public class ScheduleConfiguration {
    Logger logger = LoggerFactory.getLogger(ScheduleConfiguration.class);
    private final DeviceService deviceService;
    private final MobilePlanService mobilePlanService;

    public ScheduleConfiguration(DeviceService deviceService, MobilePlanService mobilePlanService) {
        this.deviceService = deviceService;
        this.mobilePlanService = mobilePlanService;
    }


    @Scheduled(cron = "0 0 20 * * *")
    public void listingsCountSchedule(){

        Integer deviceCount = deviceService.getAllDevices().size();
        Integer mobilePlanCount = mobilePlanService.getAllPlans().size();

        logger.info("Current devices count is: {}" , deviceCount);
        logger.info("Current mobile plans count is: {}" , mobilePlanCount);

    }
}
