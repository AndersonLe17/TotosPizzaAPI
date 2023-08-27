package com.totospizza.api.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @PreAuthorize("hasRole('CLIENT')")
    @GetMapping("/demo")
    public String demo() {
        return "Hola mundo";
    }

}
