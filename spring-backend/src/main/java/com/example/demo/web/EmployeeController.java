package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.demo.data.models.Employee;
import com.example.demo.data.payloads.request.EmployeeRequest;
import com.example.demo.data.payloads.response.MessageResponse;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Integer id) {
        Employee employee = employeeService.getASingleEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addEmployee( @RequestBody EmployeeRequest employee) {
        MessageResponse newEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public Optional<Employee> updateEmployee( @PathVariable Integer id, @RequestBody EmployeeRequest employee) {
        return employeeService.updateEmployee(id, employee);
//        MessageResponse updateEmployee = employeeService.updateEmployee(id, employee);
//        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/test1")
    public ResponseEntity<String> testMethod1(){
    	int x =100, y = 0;
    	try {
    		int total = x/y;
    		System.out.println(total);
    		String res = "final result " + total;
    		return new ResponseEntity<>(res, HttpStatus.OK);		
    	}catch (Exception e) {
			// TODO: handle exception
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
    }
    
    @GetMapping("/test2")
    public ResponseEntity<String> testMethod2(){
    	int x =100, y = 0;
    	try {
    		int total = x/y;
    		System.out.println(total);
    		String res = "final result " + total;
    		return new ResponseEntity<>(res, HttpStatus.OK);		
    	}catch (Exception e) {
			// TODO: handle exception
    		return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
    }
}
