package com.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.BadRequestException;
import com.employee.exception.ResourceNotFoundException;
import com.employee.model.dto.EmployeeDto;
import com.employee.model.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private  EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		if(employeeDto.getId()!=null) {
			throw new RuntimeException("Employee already exists");
		}
		Employee entity = modelMapper.map(employeeDto, Employee.class);
		Employee savedEntity = employeeRepository.save(entity);
		EmployeeDto convertedToEmployeeDto = modelMapper.map(savedEntity, EmployeeDto.class);
		return convertedToEmployeeDto;
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		if(employeeDto.getId()==null || id==null || employeeDto.getId()!=id) {
			throw new BadRequestException("Please provide some data id mismatch");
		}
		employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
		Employee entity = modelMapper.map(employeeDto, Employee.class);
		Employee savedEntity = employeeRepository.save(entity);
		EmployeeDto convertedToEmployeeDto = modelMapper.map(savedEntity, EmployeeDto.class);
		return convertedToEmployeeDto;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
		employeeRepository.delete(employee);
		
		
	}

	@Override
	public EmployeeDto getSingleEmployee(Long id) {
	    Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found"));

		return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employeeList = employeeRepository.findAll();
		if(employeeList.isEmpty()) {
			throw new ResourceNotFoundException("Employee not found");
		}
		List<EmployeeDto> returnValue = new ArrayList<>();
		for(int i=0;i<employeeList.size();i++) {
			returnValue.add(modelMapper.map(employeeList.get(i), EmployeeDto.class));
			
		}
		return returnValue;
	}

	@Override
	public EmployeeDto getEmployeeByEmpCodeAndCompanyName(String empCode, String companyName) {
		// TODO Auto-generated method stub
		Employee employee= employeeRepository.findByEmpCodeAndCompanyName(empCode, companyName).orElseThrow(()-> new ResourceNotFoundException("emp not fount"+empCode+"companyName "+companyName));
		return modelMapper.map(employee, EmployeeDto.class);
	}
	
}
