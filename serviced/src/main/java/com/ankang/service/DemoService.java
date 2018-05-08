package com.ankang.service;

import com.ankang.model.User;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.*;

@Service
public class DemoService {
    public String save(String str){
        return str+1;
    }
    public User get(String key){
        User user = new User();
        user.setUserName("ankang");
        user.setPassword("1234");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        return user;
    }
}