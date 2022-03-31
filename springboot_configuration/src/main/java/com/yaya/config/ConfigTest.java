package com.yaya.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import java.time.Duration;
import java.time.temporal.ChronoUnit;


@Data
//@Component
@ConfigurationProperties(prefix = "servers")
@Validated
public class ConfigTest {
    private String ipAddress;
    @Max(value = 8888, message = "数值过大")
    private Integer port;
    private Long timeout;
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeOut;
}