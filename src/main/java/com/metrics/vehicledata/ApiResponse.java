package com.metrics.vehicledata;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
public class ApiResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int alt;
    private int angle;
    private int devId;
    private int engine;
    private int extVolt;
    private double fuelLt;
    private double lat;
    private double lon;
    private String nickname;
    private long odom;
    private int regId;
    private int rpm;
    @Column(name = "status_signal")
    private String signal;
    private int speed;
    @Column(name = "event_time")
    private LocalDateTime time;
}
