package com.tweb.icekeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tweb.icekeeper")
public class IceKeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(IceKeeperApplication.class, args);
    }
}