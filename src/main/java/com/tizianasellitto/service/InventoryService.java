package com.tizianasellitto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public Optional<Inventory> getInventory(Long id) {
		return repository.findById(id);
	}

	public void addInventory(Inventory inventory) {
		repository.save(inventory);
	}

	public void updateInventory(Inventory inventory) {
		repository.save(inventory);
	}

	public void deleteInventory(Long id) {
		repository.deleteById(id);
	}
}
