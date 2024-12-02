
package com.mydbs.insurance.insurance_management.controller;

import com.mydbs.insurance.insurance_management.model.User;
import com.mydbs.insurance.insurance_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/service-providers")
    public ResponseEntity<List<User>> getServiceProviders() {
        return ResponseEntity.ok(userService.getActiveServiceProviders());
    }

    @GetMapping("/all-service-providers")
    public ResponseEntity<List<User>> getAllServiceProviders() {
        return ResponseEntity.ok(userService.getAllServiceProviders());
    }


 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/current")
    public ResponseEntity<User> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }


}
