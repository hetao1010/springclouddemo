package com.thundersoft.adc.authorservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/user")
@Api("UserController相关的api")
@EnableFeignClients(basePackages = "com.*")
public class UserController {
    @Value("${spring.application.name}")
    private String serverName;

    @ApiOperation(value = "获取服务名")
    @RequestMapping(value = "/getServerName", method = RequestMethod.GET)
    public String getServerName(){
         return "welcome to " + serverName;
    }
}
