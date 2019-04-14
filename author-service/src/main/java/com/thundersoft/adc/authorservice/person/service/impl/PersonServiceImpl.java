package com.thundersoft.adc.authorservice.person.service.impl;

import com.thundersoft.adc.authorservice.person.dao.PersonDao;
import com.thundersoft.adc.authorservice.person.model.PersonDO;
import com.thundersoft.adc.authorservice.person.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hetao.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonDao personDao;

    /**
     * 添加
     *
     * @param personDO
     * @return
     * @throws Exception
     */
    @Override
    public boolean addPerson(PersonDO personDO)  {
        boolean result = personDao.addPerson(personDO) > 0;
        return result;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean removePerson(String id) throws Exception {
        return personDao.removePerson(id) > 0;
    }

    /**
     * 修改
     *
     * @param person
     * @return
     * @throws Exception
     */
    @Override
    public boolean modifyPerson(PersonDO person) throws Exception {
        return personDao.modifyPerson(person) > 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public PersonDO getPerson(String id) throws Exception {
        return personDao.getPerson(id);
    }

    /**
     * 查询列表
     *
     * @param person
     * @return
     * @throws Exception
     */
    @Override
    public List<PersonDO> queryPersonList(PersonDO person) throws Exception {
        return personDao.queryPersonList(person);
    }


}
