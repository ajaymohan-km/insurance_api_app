package com.mydbs.insurance.insurance_management.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    // private final AccountService accountService;

    // @GetMapping("/accounts")
    // public ResponseEntity<List<Account>> getAccounts() {
    //     return ResponseEntity.ok(accountService.getCurrentUserAccounts());
    // }

    // @PostMapping("/transfer")
    // public ResponseEntity<Transaction> transfer(@RequestBody TransferRequest request) {
    //     return ResponseEntity.ok(accountService.transfer(request));
    // }
}