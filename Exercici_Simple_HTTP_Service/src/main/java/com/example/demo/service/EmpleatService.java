package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Empleat;
import com.example.demo.model.Treball;
import com.example.demo.repository.EmpleatRepository;

@Service
public class EmpleatService implements IEmpleatService {

	@Autowired
	private EmpleatRepository empleatRepository;

	@Override
	public List<Empleat> getEmployees() {
		return empleatRepository.getEmployees();
	}

	@Override
	public Optional<Empleat> getEmployeeById(int id) {
		return empleatRepository.getEmployeeById(id);
	}
	
	@Override
	public List<Empleat> getEmployeesByJob(Treball treball) {
		return empleatRepository.getEmployeesByJob(treball);
	}

	@Override
	public Empleat addEmployee(Empleat empleat) {
		return empleatRepository.addEmployee(empleat);
	}

	@Override
	public void updateEmployee(Empleat empleat) {
		empleatRepository.updateEmployee(empleat);
	}

	@Override
	public void deleteEmployee(int id) {
		empleatRepository.deleteEmployee(id);
	}

}

