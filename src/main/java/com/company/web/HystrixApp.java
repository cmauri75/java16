package com.company.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TO BE COMPLETED
 * https://www.baeldung.com/spring-cloud-netflix-hystrix
 */
@SpringBootApplication
@EnableHystrix
@RestController
public class HystrixApp {


    public static void main(String[] args) {
        SpringApplication.run(HystrixApp.class, args);
    }

    @RequestMapping(value = "/")
    @HystrixCommand(fallbackMethod = "fallback_hello", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String hello() throws InterruptedException {
        Thread.sleep(3000);
        return "Welcome Hystrix";
    }

    private String fallback_hello() {
        return "Request fails. It takes long time to response";
    }

}
