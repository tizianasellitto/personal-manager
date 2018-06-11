package com.tizianasellitto.controller;

import java.util.List;

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
	public Inventory getInventory(@PathVariable Long id ) {
		return inventoryService.getInventory(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/inventory")
	public void addInventory(@RequestBody Inventory inventory) {
		inventoryService.addInventory(inventory);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/inventory")
	public void updateInventory(@RequestBody Inventory inventory) {
		inventoryService.updateInventory(inventory);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/inventory/{id}")
	public void deleteTopic(@PathVariable Long id) {
		inventoryService.deleteInventory(id);
	}
}
