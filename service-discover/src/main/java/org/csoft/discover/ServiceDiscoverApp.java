package org.csoft.discover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoverApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ServiceDiscoverApp.class, args);
    	
    }
}
