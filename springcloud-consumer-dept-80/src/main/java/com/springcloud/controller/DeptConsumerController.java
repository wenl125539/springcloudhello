package com.springcloud.controller;

import com.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //消费者 不应该拥有service层
    //RestTemplate 供直接调用
    //(url,实体《map》,class<T> responseType)
    //链接 返回类型
    @Autowired
    private RestTemplate restTemplate; //提供多种便捷访问http服务的方法  简单restful服务模板

    private static final String REST_URL = "http://localhost:8001";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept getDept(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public Boolean add(@RequestBody Dept dept){
        return restTemplate.postForObject(REST_URL+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> getAll(){
        return restTemplate.getForObject(REST_URL+"/dept/list",List.class);
    }
}
