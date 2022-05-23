package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("mybatis")
@Primary// 优先调用实现类
public class TestDaoMybatisImpl implements TestDao{
    @Override
    public String select() {
        return "Mybatis";
    }
}
