////package com.cognizant.orm_learn;
////
////import org.springframework.boot.SpringApplication;
////import org.springframework.boot.autoconfigure.SpringBootApplication;
////
////@SpringBootApplication
////public class OrmLearnApplication {
////
////	public static void main(String[] args) {
////		SpringApplication.run(OrmLearnApplication.class, args);
////	}
////
////}
//
////
//package com.cognizant.orm_learn; //last working
//
//import java.util.List;
//
//import com.cognizant.orm_learn.model.Country;
//import com.cognizant.orm_learn.service.CountryService;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//
//@SpringBootApplication
//public class OrmLearnApplication {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
//    private static CountryService countryService;
//
//    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
//        LOGGER.info("Inside main");
//        countryService = context.getBean(CountryService.class);
//        testGetAllCountries();
//    }
//
//    private static void testGetAllCountries() {
//        LOGGER.info("Start");
//        List<Country> countries = countryService.getAllCountries();
//        LOGGER.debug("countries={}", countries);
//        LOGGER.info("End");
//    }
//} //last working

package com.cognizant.orm_learn;

import java.util.List;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        // Get Beans
        countryService = context.getBean(CountryService.class);
        employeeService = context.getBean(EmployeeService.class);

        // Run use cases
        testGetAllCountries();
        testAddEmployee();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start - Get All Countries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End - Get All Countries");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start - Add Employee");

        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setSalary(80000);

        employeeService.addEmployee(emp);

        LOGGER.debug("Saved Employee: {}", emp);
        LOGGER.info("End - Add Employee");
    }
}

