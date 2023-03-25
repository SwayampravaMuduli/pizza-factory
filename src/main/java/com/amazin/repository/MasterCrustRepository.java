package com.amazin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.amazin.entity.MasterCrust;
@Repository
public interface MasterCrustRepository extends JpaRepository<MasterCrust, Integer> {
	@Query(value="select crust from master_crust where crust=:crust",nativeQuery = true)
	String getCrust(String crust);

}
