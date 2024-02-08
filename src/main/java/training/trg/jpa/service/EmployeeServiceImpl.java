package training.trg.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.trg.jpa.data.Employee;
import training.trg.jpa.exceptions.DuplicateDataException;
import training.trg.jpa.exceptions.NonExistentDataAccess;
import training.trg.jpa.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repo;
	
	@Override
	public Employee createData(Employee emp) {
		if(repo.existsById(emp.getEmpId())) {
			throw new DuplicateDataException();
		} else {
			repo.save(emp);
		}
		return emp;
	}

	@Override
	public Employee updateData(Employee emp) {
		if(repo.existsById(emp.getEmpId())) {
			repo.save(emp);
		} else {
			throw new NonExistentDataAccess();
		}
		return emp;
	}

	@Override
	public Employee getData(int empId) {
		if(repo.existsById(empId)) {
			return repo.getOne(empId);
		}else {
			throw new NonExistentDataAccess();
		}
	}

	@Override
	public List<Employee> getAllData() {
		List<Employee> list = repo.findAll();
		return list;
	}

	@Override
	public void deleteData(int empId) {
		if(repo.existsById(empId)) {
			repo.delete(repo.getOne(empId));
		} else {
			throw new NonExistentDataAccess();
		}
		
	}

}
