package com.amazin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazin.entity.Sides;
@Repository
public interface SidesRepository extends JpaRepository<Sides, Integer>{

}
