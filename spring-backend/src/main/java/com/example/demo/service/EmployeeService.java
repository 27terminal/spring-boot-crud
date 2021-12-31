package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import com.example.demo.data.models.Employee;
import com.example.demo.data.payloads.request.EmployeeRequest;
import com.example.demo.data.payloads.response.MessageResponse;

@Component
public interface EmployeeService {
    MessageResponse createEmployee(EmployeeRequest employeeRequest);
    Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);
    void deleteEmployee(Integer employeeId);
    Employee getASingleEmployee(Integer employeeId);
    List<Employee> getAllEmployee();
}
