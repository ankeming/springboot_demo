package com.ankang.web;

import com.ankang.model.User;
import com.ankang.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisCacheManager cacheManager;
    @Autowired
    private DemoService demoService;
    @GetMapping(value = "/say")
    public String say(){
//        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
//        valueOperations.set("key","aaa");
//        String name = valueOperations.get("key");
//        Object ankang = stringRedisTemplate.opsForValue().get("ankang");
//        User user = new User();
//        user.setUserName("ankang");
//        user.setPassword("12324");
//        redisTemplate.opsForValue().set("user",user);
//        User user1 = (User) redisTemplate.opsForValue().get("user");
//        System.out.println(user1.toString());
//        return "Hello Spring Boot!"+ankang;
          return demoService.save("hello Spring boot!");
    }
    @GetMapping(value = "/get")
    public User get(@RequestParam(value = "key") String key){
//        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
//        valueOperations.set("key","aaa");
//        String name = valueOperations.get("key");
//        Object ankang = stringRedisTemplate.opsForValue().get("ankang");
//        User user = new User();
//        user.setUserName("ankang");
//        user.setPassword("12324");
//        redisTemplate.opsForValue().set("user",user);
//        User user1 = (User) redisTemplate.opsForValue().get("user");
//        System.out.println(user1.toString());
//        return "Hello Spring Boot!"+ankang;
        return demoService.get(key);
    }
}
