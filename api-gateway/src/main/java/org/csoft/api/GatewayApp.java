package org.csoft.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Gateway App
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(GatewayApp.class, args);
    }
}
