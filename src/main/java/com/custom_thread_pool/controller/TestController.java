package com.custom_thread_pool.controller;

import com.custom_thread_pool.util.ActiveThread;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

@RestController
public class TestController {

    private final ExecutorService executorService;

    public TestController(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String rrt() {

        executorService.execute(new ActiveThread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    anyMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        return "Hello World!!!";
    }

}
