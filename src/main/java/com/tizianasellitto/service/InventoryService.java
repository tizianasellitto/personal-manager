package com.tizianasellitto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tizianasellitto.beans.Inventory;
import com.tizianasellitto.dao.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository repository;
	
	public List<Inventory> getAllInventories() {
		List<Inventory> inventories = new ArrayList<>();
		repository.findAll().forEach(inventories::add);
		return inventories;
	}

	public Inventory getInventory(Long id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return repository.findById(id).get();
	}

	public void addInventory(Inventory inventory) {
		repository.save(inventory);
		
	}

	public void updateInventory(Inventory inventory) {
		repository.save(inventory);
	}

	public void deleteInventory(Long id) {
		//topics.removeIf(t -> t.getId().equals(id));
		repository.deleteById(id);
	}
}
