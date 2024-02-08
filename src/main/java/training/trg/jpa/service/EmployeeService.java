package training.trg.jpa.service;

import java.util.List;

import training.trg.jpa.data.Employee;

public interface EmployeeService {
	Employee createData(Employee emp);
	Employee updateData(Employee emp);
	Employee getData(int empId);
	List<Employee> getAllData();
	void deleteData(int empId);
}
