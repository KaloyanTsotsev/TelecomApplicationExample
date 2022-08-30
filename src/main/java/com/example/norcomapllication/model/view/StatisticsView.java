package com.example.norcomapllication.model.view;

public class StatisticsView {
    private final int authRequests;
    private final int anonRequests;

    public StatisticsView(int authRequests, int anonRequests) {
        this.authRequests = authRequests;
        this.anonRequests = anonRequests;
    }

    public int getTotalRequests() {
        return anonRequests + authRequests;
    }

    public int getAuthRequests() {
        return authRequests;
    }


    public int getAnonRequests() {
        return anonRequests;
    }
}
