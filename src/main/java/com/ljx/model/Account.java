package com.ljx.model;

public class Account {

	private String name;
	private int id;
	private double money;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", id=" + id + ", money=" + money + "]";
	}
}
