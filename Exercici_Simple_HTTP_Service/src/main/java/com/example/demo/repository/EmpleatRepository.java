package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Empleat;
import com.example.demo.model.Treball;

@Repository
public class EmpleatRepository {

	private static int counter = 0;
	private List<Empleat> employees = new ArrayList<Empleat>();

	public List<Empleat> getEmployees() {
		return employees;
	}
	
	public List<Empleat> getEmployeesByJob(Treball treball) {
		return employees.stream().filter(e -> e.getTreball().equals(treball)).collect(Collectors.toList());
	}

	public Optional<Empleat> getEmployeeById(int id) {
		return employees.stream().filter(e -> e.getId() == id).findFirst();
	}

	public Empleat addEmployee(Empleat employee) {
		counter++;
		employee.setId(counter);
		employees.add(employee);
		return employee;
	}

	public void updateEmployee(Empleat employee) {
		Iterator<Empleat> it = employees.iterator();
		while (it.hasNext()) {
			Empleat e = it.next();
			if (e.getId() == employee.getId()) {
				e.setNom(employee.getNom());
				e.setTreball(employee.getTreball());
				e.setSou(employee.getTreball().getSou());
				break;
			}
		}
	}

	public void deleteEmployee(int id) {
		Iterator<Empleat> it = employees.iterator();
		while (it.hasNext()) {
			Empleat e = it.next();
			if (e.getId() == id) {
				it.remove();
				break;
			}
		}
	}
}

