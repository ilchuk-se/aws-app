package com.awsbasics.simpleapp.controller;

import com.awsbasics.simpleapp.service.LambdaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consistency")
@RequiredArgsConstructor
public class ConsistencyController {

    private final LambdaService lambdaService;

    @GetMapping
    public ResponseEntity<?> triggerDataConsistencyFunction() {
        return lambdaService.triggerDataConsistencyFunction();
    }
}
