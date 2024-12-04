package com.metrics.vehicledata;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ApiScheduler {

    private final ApiService apiService;

    public ApiScheduler(ApiService apiService) {
        this.apiService = apiService;
    }

    @Scheduled(fixedRate = 60000) // Every 1 minute
    public void fetchData() {
        apiService.fetchAndStoreData();
    }
}
