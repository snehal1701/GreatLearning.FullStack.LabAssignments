package com.greatlearning.empmgmt.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.empmgmt.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
