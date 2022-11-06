package com.example.demo.controller;

import com.example.demo.model.ItemVO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class DemoController {

    // Todo: Add proper API Path
    @PostMapping(path = "/api/item")
    public ResponseEntity<?> validateItem(@Valid @RequestBody ItemVO item) {
        return ResponseEntity.ok(null);
    }
}
