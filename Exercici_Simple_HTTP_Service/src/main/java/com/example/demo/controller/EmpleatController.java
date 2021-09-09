package com.example.demo.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Empleat;
import com.example.demo.model.Treball;
import com.example.demo.service.IEmpleatService;

@RestController
@RequestMapping("/v1")
public class EmpleatController {

	@Autowired
	private IEmpleatService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<?> list(@RequestParam(required = false) Treball treball) {
		if (treball != null) {
			return ResponseEntity.ok(employeeService.getEmployeesByJob(treball));
		}
		return ResponseEntity.ok(employeeService.getEmployees());
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		Optional<Empleat> empleat = employeeService.getEmployeeById(id);

		if (empleat.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(empleat.get());
	}

	@PostMapping("/employees")
	public ResponseEntity<?> add(@RequestBody Empleat e) {
		if (e.getNom() == null) {
			return ResponseEntity.badRequest().build();
		}

		Empleat newEmpleat = employeeService.addEmployee(e);

		return ResponseEntity.created(URI.create("/employees/" + newEmpleat.getId())).body(newEmpleat);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<?> update(@RequestBody Empleat e, @PathVariable int id) {
		if (e.getNom() == null) {
			return ResponseEntity.badRequest().build();
		}
		
		if (employeeService.getEmployeeById(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		e.setId(id);
		employeeService.updateEmployee(e);

		return ResponseEntity.ok("Employee updated");
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		if (employeeService.getEmployeeById(id).isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		employeeService.deleteEmployee(id);

		return ResponseEntity.ok("Employee deleted");
	}

}

