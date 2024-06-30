package com.example.kewltewls.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.kewltewls.beans.entities.RentableTool;

public interface ToolInfoRepository extends CrudRepository<RentableTool, String>{
    
}
