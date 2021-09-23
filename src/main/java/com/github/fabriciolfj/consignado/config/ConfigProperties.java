package com.github.fabriciolfj.consignado.config;

import lombok.Getter;
import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

import static com.github.fabriciolfj.consignado.constants.Constants.LEGACY_INSS_ENABLE;

@Getter
@ConfigurationProperties(prefix = "featuretoogle")
@Configuration
public class ConfigProperties {

    private boolean legacy;

    @Autowired
    private FF4j ff4j;

    @PostConstruct
    public void populate() {
        if (!ff4j.exist(LEGACY_INSS_ENABLE)) {
            ff4j.createFeature(new Feature(LEGACY_INSS_ENABLE, legacy));
        }
    }

}
