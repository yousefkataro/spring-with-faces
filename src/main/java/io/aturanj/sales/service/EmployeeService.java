package io.aturanj.sales.service;

import io.aturanj.sales.model.Employee;

import java.util.List;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	
}
