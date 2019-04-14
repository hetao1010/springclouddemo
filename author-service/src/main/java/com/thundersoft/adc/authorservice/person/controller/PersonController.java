package com.thundersoft.adc.authorservice.person.controller;

import com.thundersoft.adc.authorservice.person.model.PersonDO;
import com.thundersoft.adc.authorservice.person.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hetao on 2019/4/5.
 */
@RestController
@RequestMapping(value = "/person")
@Api("PersonController")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "添加人员")
    public PersonDO addPerson(PersonDO personDO) throws Exception {
        Assert.notNull(personDO, "对象不能为空");
        boolean result = personService.addPerson(personDO);
        if (result){
            return personService.getPerson(personDO.getId());
        }
        return new PersonDO();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PersonDO getPerson(@PathVariable String id) throws Exception {

        Assert.hasText(id, "ID不能为空");
        return personService.getPerson(id);
    }

}
