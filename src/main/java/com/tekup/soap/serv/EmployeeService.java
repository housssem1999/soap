package com.tekup.soap.serv;


import com.tekup.soap.dto.Employee;

public interface EmployeeService {
	Employee getEmployeeById(int empId);
	boolean addEmployee(Employee employee);
}
