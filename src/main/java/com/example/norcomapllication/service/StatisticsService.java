package com.example.norcomapllication.service;

import com.example.norcomapllication.model.view.StatisticsView;

public interface StatisticsService {
    StatisticsView getStatistics();
    void onRequest();
}
