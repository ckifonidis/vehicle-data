CREATE TABLE api_response (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              alt INT NOT NULL,
                              angle INT NOT NULL,
                              dev_id INT NOT NULL,
                              engine INT NOT NULL,
                              ext_volt INT NOT NULL,
                              fuel_lt DOUBLE NOT NULL,
                              lat DOUBLE NOT NULL,
                              lon DOUBLE NOT NULL,
                              nickname VARCHAR(255) NOT NULL,
                              odom BIGINT NOT NULL,
                              reg_id INT NOT NULL,
                              rpm INT NOT NULL,
                              status_signal VARCHAR(10) NOT NULL, -- Renamed from "signal" to "status_signal"
                              speed INT NOT NULL,
                              event_time DATETIME NOT NULL -- Renamed from "time" to "event_time"
);
