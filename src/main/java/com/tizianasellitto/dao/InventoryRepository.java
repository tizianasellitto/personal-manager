package com.tizianasellitto.dao;

import org.springframework.data.repository.CrudRepository;

import com.tizianasellitto.beans.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Long>{

}
