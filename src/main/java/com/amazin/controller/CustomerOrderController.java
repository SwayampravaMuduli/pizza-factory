package com.amazin.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazin.PizzaFactoryServiceApplication;
import com.amazin.Dto.PizzaDto;
import com.amazin.Dto.SideDto;
import com.amazin.Dto.ToppingDto;
import com.amazin.entity.Pizza;
import com.amazin.entity.Sides;
import com.amazin.entity.Topping;
import com.amazin.repository.MasterCrustRepository;
import com.amazin.repository.MasterPizzaRepository;
import com.amazin.repository.MasterSidesRepository;
import com.amazin.repository.MasterToppingsRepository;
import com.amazin.repository.PizzaRepository;
import com.amazin.repository.SidesRepository;
import com.amazin.repository.ToppingRepository;

@RestController
@RequestMapping("/order")
public class CustomerOrderController {
	@Autowired
	private PizzaRepository pizzaRepository;
	@Autowired
	private ToppingRepository toppingRepository;
	@Autowired
	private SidesRepository sidesRepository;
	@Autowired
	private MasterCrustRepository masterCrustRepository;
	@Autowired
	private MasterPizzaRepository masterPizzaRepository;
	@Autowired
	private MasterToppingsRepository masterToppingRepository;
	@Autowired
	private MasterSidesRepository masterSidesRepository;

	@PostMapping("/customer")
	public ResponseEntity<String> createPizza(@RequestBody PizzaDto pizzaDto) {
		this.masterCrustRepository = (MasterCrustRepository) PizzaFactoryServiceApplication.ctx
				.getBean((Class) MasterCrustRepository.class);
		this.masterPizzaRepository = (MasterPizzaRepository) PizzaFactoryServiceApplication.ctx
				.getBean((Class) MasterPizzaRepository.class);
		this.masterToppingRepository=(MasterToppingsRepository) PizzaFactoryServiceApplication.ctx
				.getBean((Class) MasterToppingsRepository.class);
		this.masterSidesRepository=(MasterSidesRepository) PizzaFactoryServiceApplication.ctx
				.getBean((Class) MasterSidesRepository.class);
		Float priceOne = pizzaDto.getPrice();

		// check if you are a customer or not
		if (!pizzaDto.getUserType().equals("Customer")) {
			return ResponseEntity.badRequest().body("you are not a customer to order the pizza");
		} else {
			String pizzaName = masterPizzaRepository.getPizza(pizzaDto.getName());

			if (!pizzaDto.getName().equals(pizzaName)) {
				return ResponseEntity.badRequest().body(pizzaName + "is not available");
				// }

			}
			List<ToppingDto> toppings=pizzaDto.getToppings();
			
			for (ToppingDto toppingDto :toppings) {
				
				
			String toppingsName=masterToppingRepository.getToppinngs(toppingDto.getName());
			
			if(toppingsName==null) {
				return ResponseEntity.badRequest().body(toppingDto.getName() + "is not available");
				

			}
			
		
			List<SideDto> sideItems=pizzaDto.getSides();
			
			for(SideDto sides:sideItems) {
				String sideItemsOne=	masterSidesRepository.getSides(sides.getName());
				if(sideItemsOne==null) {
					return ResponseEntity.badRequest().body(sides.getName() + "is not  available");
					

				}
			}
			
			}
			String crustName = masterCrustRepository.getCrust(pizzaDto.getCrust());

			if (!pizzaDto.getCrust().equals(crustName)) {
				return ResponseEntity.badRequest().body(crustName + "is not available");

			}
			// Check if the pizza is vegetarian and if it has non-vegetarian toppings.
			if (pizzaDto.getType().equals("veg")) {
				for (ToppingDto toppingDto : pizzaDto.getToppings()) {
					if (!toppingDto.getType().equals("veg")) {
						return ResponseEntity.badRequest()
								.body("A vegetarian pizza cannot have non-vegetarian toppings.");
					}

				}
			}

			// Check if the pizza is non-vegetarian and if it has paneer topping
			if (pizzaDto.getType().equals("non-veg")) {
				boolean hasPaneerTopping = false;
				for (ToppingDto toppingDto : pizzaDto.getToppings()) {
					if (toppingDto.getName().equals("Paneer")) {
						hasPaneerTopping = true;
						break;
					}
				}
				if (hasPaneerTopping) {
					return ResponseEntity.badRequest().body("A non-vegetarian pizza cannot have paneer topping.");
				}
			}

			// Check if only one type of crust can be selected for any pizza
			Set<String> crustTypes = new HashSet<>();
			for (Pizza pizza : pizzaRepository.findAll()) {
				crustTypes.add(pizza.getCrust());
			}
			if (crustTypes.contains(pizzaDto.getCrust())) {
				return ResponseEntity.badRequest().body("Only one type of crust can be selected for any pizza.");
			}

			// Check if only one non-veg topping can be added in non-vegetarian pizza
			if (pizzaDto.getType().equals("non-veg")) {
				int numNonVegToppings = 0;
				for (ToppingDto toppingDto : pizzaDto.getToppings()) {
					if (toppingDto.getType().equals("non-veg")) {
						numNonVegToppings++;
					}
				}
				if (numNonVegToppings > 1) {
					return ResponseEntity.badRequest()
							.body("Only one non-veg topping can be added in non-vegetarian pizza.");
				}
			}
			// Large size pizzas come with any 2 toppings of customers choice with no
			// additional cost

			if (pizzaDto.getSize().equals("Medium") || pizzaDto.getSize().equals("Regular")) {

				for (ToppingDto toppingDto : pizzaDto.getToppings()) {

					float price = toppingDto.getPrice();
					
					priceOne += price;

				}

			}

			List<SideDto> sides = pizzaDto.getSides();
			
			if (sides != null) {
				
				for (SideDto side : pizzaDto.getSides()) {
					if (side.getName().equals("Cold Drink")) {
						priceOne += side.getCount() * side.getPrice();
						
					} else if (side.getName().equals("Mouse cake")) {
						priceOne += side.getCount() * side.getPrice();
					}
				}
			}

			// Save the pizza and its toppings in the database

			Pizza pizza = new Pizza(pizzaDto.getId(), pizzaDto.getName(), pizzaDto.getType(), pizzaDto.getSize(),
					pizzaDto.getCrust(), pizzaDto.getPrice());
			pizza = pizzaRepository.save(pizza);
			for (ToppingDto toppingDto : pizzaDto.getToppings()) {
				Topping topping = new Topping(toppingDto.getId(), toppingDto.getType(), toppingDto.getName(),
						toppingDto.getPrice());
				topping = toppingRepository.save(topping);

			}
			for (SideDto sideDto : pizzaDto.getSides()) {
				Sides sidesItems = new Sides(sideDto.getId(), sideDto.getPrice(), sideDto.getName(),
						sideDto.getCount());
				sidesItems = sidesRepository.save(sidesItems);
			}

		}
		return ResponseEntity.ok("You are successfully choose pizza from menu and now you have to pay " + priceOne
				+ " to order this pizza ");
	}

}
