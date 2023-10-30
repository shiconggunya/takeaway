package com.apply.reggie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.AntPathMatcher;


@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class ReggieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReggieApplication.class,args);
        System.out.println(1111);
    }
}
