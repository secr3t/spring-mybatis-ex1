package com.sample.demo.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.demo.vo.Criteria;
import com.sample.demo.vo.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/META-INF/spring/app-context.xml"})
public class EmployeeService2Tests {
	
	@Autowired
	EmployeeService2 employeeService2;
	
	@Test
	public void testSearchEmployees() throws ParseException {
		Criteria c = new Criteria();
		c.setOpt("job");
		c.setJobs(Arrays.asList("IT_PROG", "AD_VP"));
		c.setMinSalary(10000);
		c.setBeginDate(new SimpleDateFormat("yyyy-MM-dd").parse("2001-01-14 05:00:00"));
		List<Employee> result = employeeService2.searchEmployees(c);
		assertEquals(2, result.size());
	}

}
