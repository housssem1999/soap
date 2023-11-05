package com.tekup.soap.dto.config;

import com.tekup.soap.dto.Employee;
import com.tekup.soap.serv.EmployeeServiceImple;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sarje.AddEmployeeRequest;
import com.sarje.AddEmployeeResponse;
import com.sarje.EmployeeInfo;
import com.sarje.GetEmployeeByIdRequest;
import com.sarje.GetEmployeeByIdResponse;
import com.sarje.ServiceStatus;


@Endpoint
public class EmployeeEndpoint {

	private static final String NAMESPACE_URI = "http://www.sarje.com/employees";
	@Autowired
	private EmployeeServiceImple employeeService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
	@ResponsePayload
	public GetEmployeeByIdResponse getArticle(@RequestPayload GetEmployeeByIdRequest request) {
		GetEmployeeByIdResponse response = new GetEmployeeByIdResponse();
		EmployeeInfo employeeInfo = new EmployeeInfo();
		BeanUtils.copyProperties(employeeService.getEmployeeById(request.getEmpId()), employeeInfo);
		response.setEmployeeInfo(employeeInfo);
		return response;
	}
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addArticle(@RequestPayload AddEmployeeRequest request) {
		AddEmployeeResponse response = new AddEmployeeResponse();		
    	ServiceStatus serviceStatus = new ServiceStatus();		
		Employee employee = new Employee();
		employee.setEmpName(request.getEmpName());
		employee.setSalary(request.getSalary());		
        boolean flag = employeeService.addEmployee(employee);
        if (flag == false) {
        	   serviceStatus.setServiceCode("CONFLICT"); 
        	   serviceStatus.setMessage("Content Already Available");
        	   response.setServiceStatus(serviceStatus);
        } else {
		EmployeeInfo employeeInfo = new EmployeeInfo();
	    BeanUtils.copyProperties(employee, employeeInfo);
//			response.setEmployeeInfo(employeeInfo);
			serviceStatus.setServiceCode("SUCCESS");
			serviceStatus.setMessage("Content Added Successfully");
			response.setServiceStatus(serviceStatus);
        }
        return response;
	}
	

}