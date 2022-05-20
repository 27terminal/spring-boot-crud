package com.example.demo.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

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
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployee();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		Employee employee = employeeService.getASingleEmployee(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<MessageResponse> addEmployee(@RequestBody EmployeeRequest employee) {
		MessageResponse newEmployee = employeeService.createEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public Optional<Employee> updateEmployee(@PathVariable Integer id, @RequestBody EmployeeRequest employee) {
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
	public ResponseEntity<String> testMethod1() {
		int x = 100, y = 0;
		try {
			int total = x / y;
			System.out.println(total);
			String res = "final result " + total;
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}

	@GetMapping("/test2")
	public ResponseEntity<Object> testMethod2() {

		int[] intArray = new int[2];
		intArray[0] = 10;
		intArray[1] = 20;

		int[] intArray2 = new int[] { 30, 40 };

		String[] anArrayOfStrings = new String[5];
		anArrayOfStrings[0] = "abc"; // initialize first element
		anArrayOfStrings[1] = "xyz"; // initialize second element
		anArrayOfStrings[2] = "name"; // and so forth
		anArrayOfStrings[3] = "address";
		anArrayOfStrings[4] = "id";

		String[][] multiArrya = { { "Mr.", "Mrs.", "Ms." }, { "Parth", "Viral" } };

		String rndEl1 = String.valueOf(intArray[new Random().nextInt(intArray.length)]);
		String rndEl2 = String.valueOf(intArray2[new Random().nextInt(intArray2.length)]);
		String rndEl3 = anArrayOfStrings[new Random().nextInt(anArrayOfStrings.length)];

		String rndEl4 = multiArrya[0][0] + multiArrya[1][0];
		String rndEl5 = multiArrya[0][0] + multiArrya[1][1];

		String[] randam = { rndEl1, rndEl2, rndEl3, rndEl4, rndEl5 };

		Object test = new Object[] { intArray, anArrayOfStrings, intArray2, multiArrya, randam };

		return new ResponseEntity<>(test, HttpStatus.OK);
	}

	@GetMapping("/test3")
	public ResponseEntity<Object> testMethod3() {

		char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'a', 't', 'e', 'd' };
		char[] copyTo = new char[7];

		System.arraycopy(copyFrom, 2, copyTo, 0, 7);

		Object res1 = new Object[] { copyFrom, copyTo };

		int[] source = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int[] dest = Arrays.copyOf(source, source.length);

		Object res2 = new Object[] { source, dest };
		
		String[] strArray1 = { "abc", "cdf", "pqr" };
		String[] strArray2 = { "abc", "cdf", "pqr" };
		boolean isDeepEquals= Arrays.deepEquals(strArray1, strArray2);
		

		Map<String, Object> res = new HashMap<String, Object>();
		
		res.put("res1 copy array using =>  arrayCopy", res1);
		res.put("res2 copy array using => copuOf ", res2);
		res.put("res3=> arrya are deepEquals", isDeepEquals);
		res.put("res4=> arrya toString", Arrays.toString(strArray2));

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/array-to-arraylist")
	public ResponseEntity<Object> arrayToArraylist() {
		String[] anArrayOfStrings = { "Agra", "Mysore", "Chandigarh", "Bhopal" };
		List<String> strList = Arrays.asList(anArrayOfStrings);

		anArrayOfStrings[0] = "Modasa";

		Map<String, Object> res = new HashMap<String, Object>();
		res.put("res1", anArrayOfStrings);
		res.put("res2", strList);
		res.put("varType1", anArrayOfStrings.getClass().getName());
		res.put("varType2", strList.getClass().getSimpleName());
		
		
		final String[] array = { "abc", "xyz", "pqr", "XYZ", "parth" };
		int[] array2 = { 10, 20, 15, 22, 35 };
		
		List<String> strList2 = new ArrayList<>();
		Collections.addAll(strList2, array);

		res.put("res3", array);
		res.put("res4", strList2);
		res.put("res6", Arrays.binarySearch(array2, 35));

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/arraylist-to-array")
	public ResponseEntity<Object> ArraylistToArray() {
		List<String> strList = new ArrayList<>();
		strList.add("abc");
		strList.add("xyz");
		strList.add("pqr");
		strList.add("mno");

		String[] strArr = null;

		strArr = strList.toArray(new String[strList.size()]);

		Map<String, Object> res = new HashMap<String, Object>();
		res.put("res1", strList);
		res.put("res2", strArr);
		res.put("strList-Type1", strList.getClass().getSimpleName());
		res.put("strArr-Type2", strArr.getClass().getSimpleName());

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping("/sorting")
	public ResponseEntity<Object> sorting() {

		// Date sorting
		LocalDate[] dates = { LocalDate.now(), LocalDate.of(2017, 12, 12) };

		Map<String, Object> res = new HashMap<String, Object>();
		res.put("res1 => date array ", Arrays.toString(dates));
		Arrays.sort(dates);
		
		res.put("res2 sort date arrya ", Arrays.toString(dates));
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
