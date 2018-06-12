package com.tizianasellitto.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tizianasellitto.beans.Inventory;
import com.tizianasellitto.service.InventoryService;

@RestController
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;

	@RequestMapping("/inventory")
	public List<Inventory> getAllInventories() {
		return inventoryService.getAllInventories();
	}

	@RequestMapping("/inventory/{id}")
	public Inventory getInventory(@PathVariable Long id) {
		Optional<Inventory> inventory = inventoryService.getInventory(id);
		if (!inventory.isPresent())
			throw new EntityNotFoundException("Inventory id-" + id + " Not Found");
		return inventory.get();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/inventory")
	public void addInventory(@Valid @RequestBody Inventory inventory) {
		inventoryService.addInventory(inventory);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/inventory")
	public void updateInventory(@Valid @RequestBody Inventory inventory) {
		inventoryService.updateInventory(inventory);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/inventory/{id}")
	public void deleteTopic(@PathVariable Long id) {
		inventoryService.deleteInventory(id);
	}
}
