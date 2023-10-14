package org.csoft.coupen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * CoupenApp Bootstrap class
 *
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class CoupenApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(CoupenApp.class, args);
    }
}
