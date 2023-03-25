package com.amazin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazin.entity.MasterPizza;
import com.amazin.entity.MasterSides;
import com.amazin.entity.MasterToppings;
import com.amazin.entity.SizePrice;
import com.amazin.repository.MasterCrustRepository;
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
	private MasterCrustRepository masterCrustRepository;
	@Autowired
	private SizePriceRepository sizeRepository;

	// vendor add the pizza
	@PostMapping("/addPizza")
	public ResponseEntity<String> addPizza(@RequestBody MasterPizza masterPizza) {
		if (masterPizza == null) {
			return ResponseEntity.badRequest().body("body should not have empty");
		}
		if (masterPizza.getName() == null) {
			return ResponseEntity.badRequest().body("pizza must have a name");
		}

		if (masterPizza.getSizeAndPrice() == null) {
			return ResponseEntity.badRequest()
					.body("pizza must have a size like Regular/Large/Medium and must have prices");
		}

		masterPizza = masterPizzaRepository.save(masterPizza);
		for (SizePrice sizePrice : masterPizza.getSizeAndPrice()) {
			SizePrice sidesItems = new SizePrice(sizePrice.getId(), sizePrice.getName(), sizePrice.getSize(),
					sizePrice.getPrice());
			sidesItems = sizeRepository.save(sidesItems);
		}

		return ResponseEntity.ok("you successfully added pizza");
	}

	// vendor add the toppings
	@PostMapping("/addToppings")
	public ResponseEntity<String> addToppings(@RequestBody MasterToppings masterToppings) {
		if (masterToppings == null) {
			return ResponseEntity.badRequest().body("body should not have empty");
		}
		if (masterToppings.getName() == null) {
			return ResponseEntity.badRequest().body("toppings must have a name");
		}

		if (masterToppings.getPrice() == null) {
			return ResponseEntity.badRequest().body("toppings must  have price");
		}

		masterToppings = masterToppingRepository.save(masterToppings);

		return ResponseEntity.ok("you successfully added toppings");

	}

	// vendor add the sides
	@PostMapping("/addSides")
	public ResponseEntity<String> addCrust(@RequestBody MasterSides masterSides) {
		if (masterSides == null) {
			return ResponseEntity.badRequest().body("body should not have empty");
		}
		if (masterSides.getName() == null) {
			return ResponseEntity.badRequest().body("sides must have a name");
		}
		if (masterSides.getPrice() == null) {
			return ResponseEntity.badRequest().body("sides must have price");
		}

		masterSides = masterSidesRepository.save(masterSides);

		return ResponseEntity.ok("you successfully added sides");

	}

	// vendor update the pizza
	@PatchMapping("/pizza/{id}")
	public ResponseEntity<String> updatePizzaPartially(@PathVariable(value = "id") int id,
			@RequestBody MasterPizza masterPizza) throws Exception {
		try {
			MasterPizza masterPizzaOne = masterPizzaRepository.findById(id).get();
			masterPizzaOne.setName(masterPizza.getName());
			masterPizzaOne.setSizeAndPrice(masterPizza.getSizeAndPrice());
			masterPizzaRepository.save(masterPizzaOne);
			return ResponseEntity.ok("you successfully updated pizza");
		} catch (Exception e) {

			return ResponseEntity.badRequest().body(id + " id  is not pesent");
		}
	}

	// vendor update the toppings
	@PatchMapping("/Toppings/{id}")
	public ResponseEntity<String> updateToppings(@PathVariable(value = "id") int id,
			@RequestBody MasterToppings masterToppings) throws Exception {

		try {
			MasterToppings masterToppingsOne = masterToppingRepository.findById(id).get();
			masterToppingsOne.setName(masterToppings.getName());
			masterToppingsOne.setPrice(masterToppings.getPrice());
			masterToppingRepository.save(masterToppingsOne);
			return ResponseEntity.ok("you successfully updated toppings");
		} catch (Exception e) {

			return ResponseEntity.badRequest().body(id + " id  is not pesent");
		}

	}
	// vendor update the sides
		@PatchMapping("/sides/{id}")
		public ResponseEntity<String> updateSides(@PathVariable(value = "id") int id,
				@RequestBody MasterSides masterSides) throws Exception {

			try {
				MasterSides masterSidesOne = masterSidesRepository.findById(id).get();
				masterSidesOne.setName(masterSides.getName());
				masterSidesOne.setPrice(masterSides.getPrice());
				masterSidesRepository.save(masterSidesOne);
				return ResponseEntity.ok("you successfully updated sides");
			} catch (Exception e) {

				return ResponseEntity.badRequest().body(id + " id  is not pesent");
			}

		}

}
