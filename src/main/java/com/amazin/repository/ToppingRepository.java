package com.amazin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazin.entity.Topping;
@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer> {

}
