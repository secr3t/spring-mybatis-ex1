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
			throw new IllegalArgumentException("������ ����ֽ��ϴ�.");
		}
		List<Employee> employees = employeeMapper.searchEmployees(c);
		if (employees.isEmpty()) {
			throw new EmptyResultException("���ǿ� �´� ����� �����ϴ�.");
		}
		return employees;
	}
	
}




















