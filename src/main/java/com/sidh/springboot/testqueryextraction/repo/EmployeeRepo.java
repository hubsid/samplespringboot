package com.sidh.springboot.testqueryextraction.repo;

import com.sidh.springboot.testqueryextraction.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo  extends CrudRepository<Employee, Integer> {

}
