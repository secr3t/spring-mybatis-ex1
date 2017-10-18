package com.sample.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.exception.EmptyResultException;
import com.sample.demo.mappers.EmployeeMapper2;
import com.sample.demo.vo.Criteria;
import com.sample.demo.vo.Employee;

@Service
public class EmployeeServiceImpl2 implements EmployeeService2 {

	@Autowired
	private EmployeeMapper2 employeeMapper;
	
	public List<Employee> searchEmployees(Criteria c) {
		if (c == null) {
			throw new IllegalArgumentException("조건이 비어있습니다.");
		}
		List<Employee> employees = employeeMapper.searchEmployees(c);
		if (employees.isEmpty()) {
			throw new EmptyResultException("조건에 맞는 사원이 없습니다.");
		}
		return employees;
	}
	
}




















