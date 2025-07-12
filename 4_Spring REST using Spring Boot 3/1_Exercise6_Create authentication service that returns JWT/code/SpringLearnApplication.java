////package com.cognizant.spring_learn;
////
////import org.springframework.boot.SpringApplication;
////import org.springframework.boot.autoconfigure.SpringBootApplication;
////import org.slf4j.Logger;
////import org.slf4j.LoggerFactory;
////
////@SpringBootApplication
////public class SpringLearnApplication {
////
////	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
////
////	public static void main(String[] args) {
////		SpringApplication.run(SpringLearnApplication.class, args);
////		LOGGER.info("Inside main()");
////	}
////}
//package com.cognizant.spring_learn;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class SpringLearnApplication {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
//
//    public static void main(String[] args) {
//        displayCountry();
//    }
//
//    public static void displayCountry() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//        Country country = context.getBean("country", Country.class);
//        LOGGER.debug("Country : {}", country.toString());
//    }
//}

package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringLearnApplication.class, args);
        displayCountry();  // calling legacy XML logic after Spring Boot starts
    }

    public static void displayCountry() {
        LOGGER.debug("START: displayCountry()");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("country", Country.class);
        LOGGER.debug("Country : {}", country.toString());
        LOGGER.debug("END: displayCountry()");
    }
}

