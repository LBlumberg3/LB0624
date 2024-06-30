package com.example.kewltewls.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

/**
 * Useful little bean for troubleshooting issues; when a new HTTP request arrives at the application, a new instance of this bean will be created (as per the @RequestScope annotation), and it will "follow" the request through the various layers of the application stack, with its contents being printed to the console in a standard JSON format. Ensures not only that engineers can easily view what happens with a given request, but also allows log aggregators (e.g, Splunk) to easily aggregate and query the fine-grained details of how the application is running, without relying on the pre-aggregated data available from the prometheus enpoint
 */
@Component
@RequestScope
@Getter
@Setter
public class RequestMetrics {

    private static final Logger logger = LoggerFactory.getLogger(RequestMetrics.class);

    private ObjectMapper mapper;

    public RequestMetrics(ObjectMapper mapper) {
        this.mapper = mapper;
        this.requestStart = System.currentTimeMillis();
    }

    public void start(String requestType){
        this.requestType = requestType;
    }

    public void stop(String requestStatus, String errorMessage){
        this.requestDuration = System.currentTimeMillis() - this.requestStart;
        this.requestStatus = requestStatus;
        this.errorMessage = errorMessage;
        String json = "";
        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException ex){
            logger.error("UNABLE TO TRANSFORM RequestMetrics into JSON!");
        }
        logger.info(json);
    }

    private Long requestStart;
    private String requestType;
    private String requestStatus;
    private Long requestDuration;
    private String errorMessage;
    private String clientName = "NOT_PROVIDED"; // simple default to help debug auth issues

    
}
