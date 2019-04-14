/**
 * Copyright (C) 2018 BOE Technology Group Corporation Limited
 */

package com.thundersoft.adc.trainserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* auth服务组织接口.
* @author :glj
* @ClassName: SheduleOrgService
* @date 2018年10月10日 下午8:23:06
*/
@FeignClient(value = "author-service")
public interface SheduleOrgService {

    /**
     * function(调用AUTH-SERVICE，获取根组织名称).
     * @return String 返回类型
     */
    @RequestMapping(value = "/sys/user/getServerName", method = RequestMethod.GET)
    String getServerName();

}
