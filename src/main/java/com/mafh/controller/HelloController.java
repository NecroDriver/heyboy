package com.mafh.controller;

import com.mafh.properties.PeopleProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by mafh on 2017/6/26 0026.13:14
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @Value("${author}")
    private String author;
    @Autowired
    private PeopleProperties peopleProperties;

    @RequestMapping(value = {"/boy","/girl"},method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "id",required = false,defaultValue = "-1") Integer id){
        return id+"-------"+author+"------"+peopleProperties.toString();
    }

    @GetMapping(value = "{id}/child")
    public String sayChild(@PathVariable(value = "id") Integer id){
        return id+"-------"+author+"------"+peopleProperties.toString();
    }
}
