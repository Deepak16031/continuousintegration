package com.deepak.continuousintegration.controller;

import com.deepak.continuousintegration.model.Goal;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/goal")
public class GoalController {

    @PostMapping("/")
    public ResponseEntity<Goal> addGoal(@RequestBody @Valid Goal goal) {
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }
}
