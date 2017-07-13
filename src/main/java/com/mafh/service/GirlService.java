package com.mafh.service;

import com.mafh.dao.Girl;
import com.mafh.enums.MessageEnum;
import com.mafh.exception.AgeException;
import com.mafh.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mafh on 2017/6/27 0027.12:25
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(22);
        girlA.setName("王丹丹");
        girlA.setSex("男");
        girlRepository.save(girlA);
        Girl girlB = new Girl();
        girlB.setAge(233);
        girlB.setName("曹丹");
        girlB.setSex("女女");
        girlRepository.save(girlB);
    }

    public void checkAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            /*
            返回你还在上小学吧
             */
            throw new AgeException(MessageEnum.PRIMARY_SCHOOL);
        }else if(age < 16){
            /*
            返回你可能在上初中
             */
            throw new AgeException(MessageEnum.MIDDLE_SHCOOL);
        }
        /*
        处理其它逻辑
        。。。
         */
    }

    /**
     * 查询出一个对象信息
     * @param id
     * @return Girl
     */
    public Girl finOne(Integer id){
        return girlRepository.findOne(id);
    }
}
