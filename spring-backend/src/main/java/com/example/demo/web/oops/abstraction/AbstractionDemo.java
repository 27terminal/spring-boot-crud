package com.example.demo.web.oops.abstraction;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.web.oops.abstraction.FullTimeEmployee;

@RestController
@RequestMapping("/abstractiondemo")
public class AbstractionDemo {

	
	@GetMapping("/test")
	public ResponseEntity<Object> test1() {
		Map<String, Object> res = new HashMap<>();		
		Emp fullTimeEmployee = new FullTimeEmployee("full time employee", 8);
		res.put("salary", fullTimeEmployee.calculateSalary());
		res.put("fullTimeEmployee", fullTimeEmployee);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
