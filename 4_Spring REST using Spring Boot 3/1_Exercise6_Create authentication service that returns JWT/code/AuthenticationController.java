////package com.cognizant.spring_learn.controller;
////
////import com.cognizant.spring_learn.util.JwtUtil;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
//////import javax.servlet.http.HttpServletRequest;
////import jakarta.servlet.http.HttpServletRequest;
////
////import java.util.Base64;
////
////@RestController
////public class AuthenticationController {
////
////    @Autowired
////    private JwtUtil jwtUtil;
////
////    @GetMapping("/authenticate")
////    public ResponseEntity<?> authenticate(HttpServletRequest request) {
////        String authHeader = request.getHeader("Authorization");
////
////        if (authHeader == null || !authHeader.startsWith("Basic ")) {
////            return ResponseEntity.status(401).body("Missing or invalid Authorization header");
////        }
////
////        String base64Credentials = authHeader.substring("Basic ".length());
////        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
////        String credentials = new String(credDecoded);
////        String[] values = credentials.split(":", 2);
////
////        String username = values[0];
////        String password = values[1];
////
////        if ("user".equals(username) && "pwd".equals(password)) {
////            String token = jwtUtil.generateToken(username);
////            return ResponseEntity.ok("{\"token\":\"" + token + "\"}");
////        } else {
////            return ResponseEntity.status(401).body("Invalid credentials");
////        }
////    }
////}
////package com.cognizant.spring_learn.controller;
////
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.Base64;
////import java.util.HashMap;
////import java.util.Map;
////import jakarta.servlet.http.HttpServletRequest;
////
////
////@RestController
////public class AuthenticationController {
////
////    @GetMapping("/authenticate")
////    public ResponseEntity<Map<String, String>> authenticate(@RequestHeader(value = "Authorization", required = false) String authHeader) {
////        if (authHeader == null || !authHeader.startsWith("Basic ")) {
////            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
////                    .body(Map.of("error", "Missing or invalid Authorization header"));
////        }
////
////        // Decode Base64 part of header
////        String base64Credentials = authHeader.substring("Basic ".length());
////        String credentials = new String(Base64.getDecoder().decode(base64Credentials));
////        String[] values = credentials.split(":", 2);
////
////        if (values.length != 2) {
////            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
////                    .body(Map.of("error", "Invalid basic auth format"));
////        }
////
////        String username = values[0];
////        String password = values[1];
////
////        // Dummy check - replace with real logic
////        if (username.equals("user") && password.equals("pwd")) {
////            String dummyJwt = "eyJhbGciOiJIUzI1NiJ9.dummy.payload.signature";
////            Map<String, String> response = new HashMap<>();
////            response.put("token", dummyJwt);
////            return ResponseEntity.ok(response);
////        } else {
////            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
////                    .body(Map.of("error", "Invalid credentials"));
////        }
////    }
////}
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Base64;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//public class AuthenticationController {
//
//    @GetMapping("/authenticate")
//    public ResponseEntity<?> authenticate(@RequestHeader(value = "Authorization", required = false) String authHeader) {
//        if (authHeader == null || !authHeader.startsWith("Basic ")) {
//            return ResponseEntity.status(401).body(Map.of("error", "Missing or invalid Authorization header"));
//        }
//
//        // Decode base64 credentials
//        String base64Credentials = authHeader.substring("Basic ".length());
//        String credentials = new String(Base64.getDecoder().decode(base64Credentials));
//        String[] values = credentials.split(":", 2);
//
//        if (values.length != 2) {
//            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials format"));
//        }
//
//        String username = values[0];
//        String password = values[1];
//
//        // Dummy validation logic
//        if ("user".equals(username) && "pwd".equals(password)) {
//            String dummyToken = "eyJhbGciOiJIUzI1NiJ9.dummy.payload.signature";
//            return ResponseEntity.ok(Map.of("token", dummyToken));
//        } else {
//            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
//        }
//    }
//}

package com.cognizant.spring_learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognizant.spring_learn.util.JwtUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        String token = jwtUtil.generateToken(username);
        return ResponseEntity.ok().body(java.util.Map.of("token", token));
    }
}

