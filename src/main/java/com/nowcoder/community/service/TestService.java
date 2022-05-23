package com.nowcoder.community.service;

import com.nowcoder.community.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;
    public String find(){
       return testDao.select();
    }

    public TestService( ){
        System.out.println("实例化Service");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化Service");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁Service");
    }
}
