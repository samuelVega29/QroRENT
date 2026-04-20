package com.usta.qrorent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.usta.qrorent.entities")
@EnableJpaRepositories(basePackages = "com.usta.qrorent.models.DAO")
public class QroRentApplication {
    public static void main(String[] args) {
        SpringApplication.run(QroRentApplication.class, args);
    }
}
