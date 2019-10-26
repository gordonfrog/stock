package com.lanl.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lanl.model.BaseModel;


public interface BaseDao<T extends BaseModel> extends JpaRepository<T, Serializable> {

}
