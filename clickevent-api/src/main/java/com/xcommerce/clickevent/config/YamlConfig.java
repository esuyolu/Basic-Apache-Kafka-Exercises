package com.xcommerce.clickevent.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YamlConfig {

    private String topic;
    private String bootstrap_server;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBootstrap_server() {
        return bootstrap_server;
    }

    public void setBootstrap_server(String bootstrap_server) {
        this.bootstrap_server = bootstrap_server;
    }
}