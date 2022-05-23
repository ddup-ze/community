package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("hiber")
public class TestDaoHiberImpl implements TestDao{
    @Override
    public String select() {
        return "Hiber";
    }
}
