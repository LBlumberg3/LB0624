package com.example.kewltewls.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ToolRentalDao {
    
    private static final Logger logger = LoggerFactory.getLogger(ToolRentalDao.class);

    private ToolRentalRepository repository;

    public ToolRentalDao(ToolRentalRepository repository) {
        this.repository = repository;
    }

    
}
