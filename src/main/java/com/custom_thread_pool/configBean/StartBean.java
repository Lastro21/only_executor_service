package com.custom_thread_pool.configBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class StartBean {

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(2);
    }

}
