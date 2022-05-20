package com.example.demo.web;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collcetion")
public class CollectionExample {

	@GetMapping("/queue")
	public ResponseEntity<Object> test1() {

		Queue<String> elementsQueue = new LinkedList<>();
		elementsQueue.add("element1");
		elementsQueue.add("element2");
		elementsQueue.add("element3");
		elementsQueue.add("element4");

		elementsQueue.add(null);
		elementsQueue.add(null);

		return new ResponseEntity<Object>(elementsQueue, HttpStatus.OK);
	}

	@GetMapping("/map")
	public ResponseEntity<Object> map() {

		Map<String, Object> val = new HashMap<String, Object>();
		val.put("element1", "val1");
		val.put("element2", "val2");
		val.put("element3", "val3");
		val.put("element4", "val4");
		return new ResponseEntity<Object>(val, HttpStatus.OK);
	}

}
