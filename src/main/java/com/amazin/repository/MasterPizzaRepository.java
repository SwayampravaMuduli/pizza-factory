package com.amazin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amazin.entity.MasterPizza;

@Repository
public interface MasterPizzaRepository extends JpaRepository<MasterPizza, Integer> {
	@Query(value="select name from master_pizza where name=:name",nativeQuery = true)
	String getPizza(String name);

}
