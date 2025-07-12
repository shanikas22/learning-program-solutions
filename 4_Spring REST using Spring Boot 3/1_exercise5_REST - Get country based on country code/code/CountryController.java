//package com.cognizant.spring_learn.controller;
//
//import com.cognizant.spring_learn.Country;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class CountryController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
//
//    @RequestMapping("/country")
//    public Country getCountryIndia() {
//        LOGGER.debug("START: getCountryIndia()");
//        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//        Country country = context.getBean("country", Country.class);
//        LOGGER.debug("Country: {}", country);
//        LOGGER.debug("END: getCountryIndia()");
//        return country;
//    }
//}
package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.debug("START: getCountry() with code = {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.debug("Country found: {}", country);
        LOGGER.debug("END: getCountry()");
        return country;
    }
}
