package org.csoft.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * Hello world!
 *
 */
@SpringBootConfiguration
@EnableZuulServer
public class ZuulApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(ZuulApp.class, args);
    }
}
