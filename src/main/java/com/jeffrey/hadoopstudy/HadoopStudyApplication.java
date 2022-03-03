package com.jeffrey.hadoopstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HadoopStudyApplication {

    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "F:\\Profession\\hadoop\\hadoop-2.7.1-one");
        SpringApplication.run(HadoopStudyApplication.class, args);
    }

}
