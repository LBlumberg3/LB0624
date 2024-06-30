package com.example.kewltewls.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ToolInfoDao {

    private static final Logger logger = LoggerFactory.getLogger(ToolInfoDao.class);

    private ToolInfoRepository repository;

    public ToolInfoDao(ToolInfoRepository repository) {
        this.repository = repository;
    }

    
    
}
