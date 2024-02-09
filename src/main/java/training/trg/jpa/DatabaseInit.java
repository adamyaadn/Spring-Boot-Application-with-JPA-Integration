package training.trg.jpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import training.trg.jpa.data.Employee;
import training.trg.jpa.repository.EmployeeRepository;

@Component
public class DatabaseInit implements CommandLineRunner{

	@Autowired
	EmployeeRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.save(new Employee(100,"Alex",88388,LocalDate.of(2010,10,6)));
		repo.save(new Employee(200,"Luke",88388,LocalDate.of(2010,10,6)));
		repo.save(new Employee(300,"Hayley",88388,LocalDate.of(2010,10,6)));
		
		System.out.println("3 rows inserted.");
		
	}

}
