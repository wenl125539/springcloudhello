package com.springcloud.controller;

import com.springcloud.pojo.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//提供RestFulf服务
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

     @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
         System.out.println(dept.toString());
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept addDept(@PathVariable(value = "id") Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> addDept(){
        return deptService.queryAll();
    }
}
