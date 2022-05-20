package com.example.demo.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/string")
public class StringHadnlingController {

	@GetMapping("/string-test")
	public ResponseEntity<Object> test1(){
		
		//General opration
		String s1 = "Parth";
		String s2 = new String("Kharecha");			
		
		Map<String, String> res = new HashMap<>();
		res.put("first name", s1);
		res.put("first name length",String.valueOf(s1.length()));
		res.put("last name", s2);
		res.put("last name lenght", String.valueOf(s2.length()));
		
		
		//Char to string
		char chars[] = {
			    'a',
			    'b',
			    'c'
			};
		
		String s3 = new String(chars);
		
		res.put("char to string", s3);
		
		String cs1 = "Hello World";
		String cs2 = "Hello World";
		String cs3 = "Java";
		String cs4 = "Guides";

		//Comparison result
		res.put("comparison 1", String.valueOf(cs1.compareTo(cs2)));
		res.put("comparison 2", String.valueOf(cs1.compareTo(cs3)));
		res.put("comparison 3", String.valueOf(cs1.compareTo(cs4)));
		
		res.put("Concat", "parth".concat(" kharecha"));
		res.put("Replce Hello => l with w", "Hello".replace('l', 'w'));
		res.put("return empty object", new String());

		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	
	
}
