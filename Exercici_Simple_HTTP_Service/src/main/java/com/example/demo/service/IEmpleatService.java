package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Empleat;
import com.example.demo.model.Treball;

public interface IEmpleatService {

	public List<Empleat> getEmployees();

	public List<Empleat> getEmployeesByJob(Treball treball);

	public Optional<Empleat> getEmployeeById(int id);

	public Empleat addEmployee(Empleat empleat);

	public void updateEmployee(Empleat empleat);

	public void deleteEmployee(int id);

}

