package com.datadawgs.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    com.datadawgs.springboot.repository.AppRepository appRepository;


    @GetMapping(path="/qqq")
    public List<String> getVolQQQ (){
        return appRepository.getVolQQQ();
    }

    @GetMapping("/spy")
    public List<String> getVolSPY() {
        return appRepository.getVolSPY();
    }

    @GetMapping("/vti")
    public List<String> getVolVTI() {
        return appRepository.getVolVTI();
    }

    @GetMapping("/iwm")
    public List<String> getVolIMW() {
        return appRepository.getVolIWM();
    }

}
