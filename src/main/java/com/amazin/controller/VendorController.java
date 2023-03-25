package com.amazin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazin.Dto.SideDto;
import com.amazin.entity.MasterPizza;
import com.amazin.entity.Sides;
import com.amazin.entity.SizePrice;
import com.amazin.repository.MasterPizzaRepository;
import com.amazin.repository.MasterSidesRepository;
import com.amazin.repository.MasterToppingsRepository;
import com.amazin.repository.SizePriceRepository;

@RestController
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private MasterPizzaRepository masterPizzaRepository;
	@Autowired
	private MasterToppingsRepository masterToppingRepository;
	@Autowired
	private MasterSidesRepository masterSidesRepository;
	@Autowired
	private SizePriceRepository sizeRepository;
	
	@PostMapping("/addPizza")
	public ResponseEntity<String> addPizza(@RequestBody MasterPizza masterPizza){
		if(masterPizza==null) {
			return ResponseEntity.badRequest().body("body should not have empty");
		}
		if(masterPizza.getName()==null) {
			return ResponseEntity.badRequest().body("pizza must have a name");
		}
//		if(masterPizza.getType()==null) {
//			return ResponseEntity.badRequest().body("pizza must have a type veg/non-veg");
//		}
		if(masterPizza.getSizeAndPrice()==null) {
			return ResponseEntity.badRequest().body("pizza must have a size like Regular/Large/Medium and must have prices");
		}
//		if(masterPizza.getPrice()==null) {
//			return ResponseEntity.badRequest().body("pizza must have a price");
//		}
		
		masterPizza=masterPizzaRepository.save(masterPizza);
		for(SizePrice sizePrice : masterPizza.getSizeAndPrice()) {
			SizePrice sidesItems=new SizePrice(sizePrice.getId(),sizePrice.getName(), sizePrice.getSize(),sizePrice.getPrice());
			sidesItems=sizeRepository.save(sidesItems);
		}
		
		 return ResponseEntity.ok("you successfully added pizza");
		
		
	}

}
