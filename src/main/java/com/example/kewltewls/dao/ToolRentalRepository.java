package com.example.kewltewls.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.kewltewls.beans.entities.RentalRecord;

public interface ToolRentalRepository extends CrudRepository<RentalRecord, Integer>{
    
}
