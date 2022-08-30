package com.example.norcomapllication.service.impl;

import com.example.norcomapllication.model.view.StatisticsView;
import com.example.norcomapllication.service.StatisticsService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    private int anonymousRequests;
    private int authRequests;
    @Override
    public StatisticsView getStatistics() {
        return new StatisticsView(authRequests,anonymousRequests);
    }
    @Override
    public void onRequest() {
        Authentication authentication = SecurityContextHolder.
                getContext().
                getAuthentication();



        if (authentication != null && (authentication.getPrincipal() instanceof UserDetails)) {
            authRequests++;
        } else {
            anonymousRequests++;
        }
    }
}
