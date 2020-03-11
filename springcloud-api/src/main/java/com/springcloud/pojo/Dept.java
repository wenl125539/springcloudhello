package com.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data  //get set
@NoArgsConstructor//无参构造
@Accessors(chain = true) //链式写法
public class Dept implements Serializable {
    private long deptno;
    private String dname;
    //当前数据 属于 那个数据库 --微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;

    public Dept(String dname){
        this.dname = dname;
    }
}
