package com.thundersoft.adc.authorservice.person.dao;

import com.thundersoft.adc.authorservice.person.model.PersonDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PersonDao {

    int addPerson(PersonDO personDO);

    int removePerson(String id) throws Exception;

    int modifyPerson(PersonDO person) throws Exception;

    PersonDO getPerson(String id) throws Exception;

    List<PersonDO> queryPersonList(PersonDO person) throws Exception;


}
