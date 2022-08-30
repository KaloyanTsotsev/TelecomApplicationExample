package com.example.norcomapllication.web;

import com.example.norcomapllication.service.StatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatisticsController {
    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/statistics")
    public ModelAndView stats() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("statistics",statisticsService.getStatistics());
        modelAndView.setViewName("stats");
        return modelAndView;
    }
}
