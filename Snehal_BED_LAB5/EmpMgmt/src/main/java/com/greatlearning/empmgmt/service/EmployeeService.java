package com.greatlearning.empmgmt.service;

import java.util.List;

import com.greatlearning.empmgmt.entity.Employee;

public interface EmployeeService {
	List<Employee> fetchAllEmployees();

	Employee saveEmployee(Employee employee);

	Employee fetchEmployeeById(Long id);

	Employee updateEmployee(Employee employee);

	void deleteEmployeeById(Long id);
}
