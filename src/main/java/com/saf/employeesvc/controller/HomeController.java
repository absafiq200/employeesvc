package com.saf.employeesvc.controller;

import com.saf.employeesvc.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/v1")
public class HomeController {

    private List<Employee> lstEmp = new ArrayList<>();

    @PostMapping("/createemp")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

        lstEmp.add(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.status(HttpStatus.OK).body(lstEmp);
    }

    @GetMapping("/addemp")
    public ResponseEntity<Employee> addDefaultEmployee() {
        Employee ee = Employee.builder().id(new Random().nextInt())
                .firstname("first_" + new Random().nextInt())
                .lastname("last_"+new Random().nextInt())
                .email("Email_"+new Random().nextInt()).build();
        lstEmp.add(ee);
        return ResponseEntity.status(HttpStatus.CREATED).body(ee);
    }

}
