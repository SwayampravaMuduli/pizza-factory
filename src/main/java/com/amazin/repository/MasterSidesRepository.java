package com.amazin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amazin.entity.MasterSides;

@Repository
public interface MasterSidesRepository extends JpaRepository<MasterSides, Integer>{
	@Query(value="select name from master_sides where name=:name",nativeQuery = true)
	String getSides(String name);

}
