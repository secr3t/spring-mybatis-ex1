package com.sample.demo.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.demo.exception.EmptyResultException;
import com.sample.demo.vo.Criteria;
import com.sample.demo.vo.Employee;

import org.junit.Ignore;
import org.junit.Test;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/META-INF/spring/app-context.xml"})
public class EmployeeServiceTests {

	@Autowired
	EmployeeService employeeService;
	
	@Ignore
	@Test
	public void testConfig() {
		assertNotNull(employeeService);
	}
	
	@Ignore
	@Test
	public void testSearchEmployees() {
		List<Employee> result = null; 
		result = employeeService.searchEmployees(null);
		assertEquals(107, result.size());
		assertThat(result.size(), is(107));
		
		Employee employee = new Employee();
		employee.setDepartmentId(new Long(80));
		result = employeeService.searchEmployees(employee);
		assertEquals(34, result.size());
		assertThat(result.size(), is(34));
		
		employee.setDepartmentId(new Long(80));
		employee.setJobId("SA_MAN");
		result = employeeService.searchEmployees(employee);
		assertEquals(5, result.size());
	}
	
	@Ignore
	@Test
	public void testFindEmployees() {
		Criteria c = new Criteria();
		c.setOpt("job");
		c.setKeyword("SA_MAN");
		
		List<Employee> result = employeeService.findEmployees(c);
		assertEquals(5, result.size());
	}
	
	@Ignore
	@Test
	public void testGetEmployees() {
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("job", "SA_MAN");
		map.put("dept", 80);
		
		List<Employee> result = employeeService.getEmployees(map);
		assertEquals(34, result.size());
	}
	
	@Ignore
	@Test
	public void testTakeEmployees() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 100);
		
		List<Map<String, Object>> result = employeeService.takeEmployees(map);
		assertEquals(1, result.size());
		
		for (Map<String, Object>  emp : result) {
			System.out.println(emp.get("EMPLOYEE_ID"));
			System.out.println(emp.get("JOB_ID"));
			System.out.println(emp.get("SALARY"));
		}
	}
	
	@Ignore
	@Test
	public void  testFetchEmployees() {
		Criteria c = new Criteria();
		c.setDepts(Arrays.asList(10, 20, 30, 40));
		
		List<Employee> result = employeeService.fetchEmployees(c);
		assertEquals(10, result.size());
	}
	
	@Ignore
	@Test
	public void testUpdateEmployee() {
		Employee e = new Employee();
		e.setId(new Long(100));
		e.setFirstName("Hong");
		e.setLastName("Gildong");
		
		employeeService.updateEmployee(e);
		
	
	}
	
	@Ignore
	@Test(expected=EmptyResultException.class)
	public void testEmptyResultException() {
		Employee employee = new Employee();
		employee.setDepartmentId(new Long(1234));
		
		employeeService.searchEmployees(employee);
	}
	
}














