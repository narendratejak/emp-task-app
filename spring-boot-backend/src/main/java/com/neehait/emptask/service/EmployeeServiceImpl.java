package com.neehait.emptask.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neehait.emptask.entity.Department;
import com.neehait.emptask.entity.Employee;
import com.neehait.emptask.repository.DeptRepository;
import com.neehait.emptask.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private DeptRepository depetRepo;

	@Override
	public Employee creteEmployee(Employee emp) {
		
		Department dept = emp.getDept();
		System.out.println(dept);
		System.out.println(depetRepo.findById(dept.getId()));
        if (dept != null && dept.getId() != null) {
            // Load the department from the database
            Optional<Department> byId = depetRepo.findById(dept.getId());
            
            boolean present = byId.isPresent();
            
            if(!present) {
            	dept = depetRepo.save(dept);
            }else {
            	dept=byId.get();
            }
                    
        } 
        emp.setDept(dept);

        // Save the employee
        return repository.save(emp);
	}

	@Override
	public Employee getEmployeebyId(int id) {
		
		Employee getemployeeById = repository.getemployeeById(id);
		
		
		
		System.out.println(getemployeeById);
		return getemployeeById;
	}

}
