package com.tizianasellitto.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "manufacturer", "color" }) })
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "{name.EMPTY}")
	@Length(max = 140)
	private String name;

	@NotEmpty(message = "{description.EMPTY}")
	@Length(max = 140)
	private String description;

	@NotEmpty(message = "{manufacturer.EMPTY}")
    @Length(max = 140)
	private String manufacturer;

    @Length(max = 140)
	private String color;
	
	@Positive
	private Integer weight;
	
    @Length(max = 255)
	private String note;

	public Inventory() {

	}

	public Inventory(Long id, String name, String description, String manufacturer, String color, Integer weight,
			String note) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.manufacturer = manufacturer;
		this.color = color;
		this.weight = weight;
		this.note = note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", description=" + description + ", manufacturer="
				+ manufacturer + ", color=" + color + ", weight=" + weight + ", note=" + note + "]";
	}
}
