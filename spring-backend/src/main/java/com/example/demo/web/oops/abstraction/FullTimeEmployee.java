package com.example.demo.web.oops.abstraction;

public class FullTimeEmployee extends Emp {

	public FullTimeEmployee(String name, int paymentPerHour) {
		super(name, paymentPerHour);
	}

	public int calculateSalary() {
		return getPaymentPerHour() * 8;
	}
}
