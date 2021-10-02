package com.ay.mortgage_server_app;

import com.ay.mortgage_server_app.db.repositories.MortgageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mortgage")
public class MainController {
    @Autowired
    MortgageRepository repository;

    @GetMapping
    public void dosome() {
        repository.findAll();
    }
}
