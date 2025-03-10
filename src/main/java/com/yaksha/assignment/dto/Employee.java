package com.yaksha.assignment.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public class Employee {
	private int id;
	private String name;
	private String position;

	// Constructor
	public Employee() {
	}

	// Constructor
	public Employee(int id, String name, String position) {
		this.id = id;
		this.name = name;
		this.position = position;
	}

	// Getters and Setters

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
