package com.thundersoft.adc.trainserver.controller;

import com.thundersoft.adc.trainserver.service.SheduleOrgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/train")
@Api("TrainController相关的api")
@EnableFeignClients(basePackages = "com.*")
public class TrainController {

    @Autowired
    private SheduleOrgService sheduleOrgService;
    private static Logger logger = Logger.getLogger(TrainController.class);

    @ApiOperation(value = "feign调用")
    @RequestMapping(value = "/feignAuthor", method = RequestMethod.GET)
    public String getServerName(){
        logger.info("开始feign调用-----------------------");
        return sheduleOrgService.getServerName();
    }
}
