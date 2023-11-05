package com.tekup.soap.serv;


import java.util.Optional;

import com.tekup.soap.dao.EmployeeRepository;
import com.tekup.soap.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImple implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(int empId) {
		Optional<Employee> opt = employeeRepository.findById(empId);
		return opt.get(); 
	}

	@Override
	public boolean addEmployee(Employee employee) {
		employee  = employeeRepository.save(employee);
		return true;
	}
	
	

}
