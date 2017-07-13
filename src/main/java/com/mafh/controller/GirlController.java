package com.mafh.controller;

import com.mafh.dao.Girl;
import com.mafh.domain.Message;
import com.mafh.repository.GirlRepository;
import com.mafh.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by mafh on 2017/6/27 0027.09:54
 */
@RestController
public class GirlController {

    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 获取所有的女生列表
     * @return List<Girl></>
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        System.out.println("run......");
        logger.info("run......");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param name
     * @param age
     * @param sex
     * @return Girl
     */
    @PostMapping(value = "/girl")
    public Girl addGirl(@RequestParam("name") String name,@RequestParam("age") Integer age,@RequestParam("sex") String sex){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setName(name);
        girl.setSex(sex);
        return girlRepository.save(girl);
    }

    /**
     * 添加一个女生对象
     * @param girl
     * @param bindingResult
     * @return Girl
     */
    @PostMapping(value = "/girl/add2")
    public Girl addGirl2(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlRepository.save(girl);
    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/{id}")
    public Girl findGirl(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新女生信息
     * @param id
     * @param name
     * @param age
     * @param sex
     * @return Girl
     */
    @PutMapping(value="/girl/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,@RequestParam("name") String name,@RequestParam("age") Integer age,@RequestParam("sex") String sex){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setSex(sex);
        girl.setName(name);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除一个女孩
     * @param id
     */
    @DeleteMapping(value = "/girl/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 通过年龄查询女生
     * @param age
     * @return
     */
    @GetMapping(value="/girl/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 用于阐述事务管理
     */
    @GetMapping(value = "/girl/two")
    public void insertTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value="/girl/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.checkAge(id);
    }
}
