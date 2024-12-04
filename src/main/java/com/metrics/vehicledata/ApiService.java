package com.metrics.vehicledata;

import com.metrics.vehicledata.ApiResponse;
import com.metrics.vehicledata.ApiResponseRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

@Service
public class ApiService {



    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final RestTemplate restTemplate;
    private final ApiResponseRepository repository;

    public ApiService(RestTemplate restTemplate, ApiResponseRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;
    }

    public void fetchAndStoreData() {
        String url = "http://83.212.80.156:5000/trigger";

        try {
            JsonNode response = restTemplate.getForObject(url, JsonNode.class);
            JsonNode data = response.path("api_response").path("data").get(0);

            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setAlt(data.path("alt").asInt());
            apiResponse.setAngle(data.path("angle").asInt());
            apiResponse.setDevId(data.path("dev_id").asInt());
            apiResponse.setEngine(data.path("engine").asInt());
            apiResponse.setExtVolt(data.path("ext_volt").asInt());
            apiResponse.setFuelLt(data.path("fuel_lt").asDouble());
            apiResponse.setLat(data.path("lat").asDouble());
            apiResponse.setLon(data.path("lon").asDouble());
            apiResponse.setNickname(data.path("nickname").asText());
            apiResponse.setOdom(data.path("odom").asLong());
            apiResponse.setRegId(data.path("reg_id").asInt());
            apiResponse.setRpm(data.path("rpm").asInt());
            apiResponse.setSignal(data.path("signal").asText());
            apiResponse.setSpeed(data.path("speed").asInt());

            // Parse the date-time string
            try {
                String timeString = data.path("time").asText();
                LocalDateTime time = LocalDateTime.parse(timeString, DATE_TIME_FORMATTER);
                apiResponse.setTime(time);
            } catch (DateTimeParseException e) {
                e.printStackTrace();
                // Use a default value or handle gracefully
                apiResponse.setTime(null);
            }

            repository.save(apiResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
