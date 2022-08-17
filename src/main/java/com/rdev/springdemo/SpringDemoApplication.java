package com.rdev.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class SpringDemoApplication {

	@Autowired
	ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@GetMapping("/items")
	public @ResponseBody Iterable<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@PostMapping("/item")
	public @ResponseBody String addItem(@RequestParam String name, @RequestParam String category,
			@RequestParam Boolean available) {
		Item item = new Item();
		item.setItem(name);
		item.setCategory(category);
		item.setAvailable(available);

		itemRepository.save(item);
		return "Item Saved !!";
	}
}
