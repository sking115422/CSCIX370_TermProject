package com.datadawgs.springboot.controller;


import com.datadawgs.springboot.DAO;
import com.datadawgs.springboot.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private DAO dao;

    @GetMapping("/")
    public String homePage(Model model){
        return "home";
    }

    @RequestMapping("/iwm")
    public String iwmPage(Model model) {
        List<Stock> stocks = dao.list("iwm");
        List<Stock> highestOpen = dao.highestOpen("iwm");
        List<Stock> highestVol = dao.highestVol("iwm");
        List<Stock> highestClose = dao.highestClose("iwm");
        List<Stock> biggestIncrease = dao.biggestIncrease("iwm");
        List<Stock> biggestDecrease = dao.biggestDecrease("iwm");
        model.addAttribute("stocks", stocks);
        model.addAttribute("highestOpen", highestOpen);
        model.addAttribute("highestVol", highestVol);
        model.addAttribute("highestClose", highestClose);
        model.addAttribute("biggestIncrease", biggestIncrease);
        model.addAttribute("biggestDecrease", biggestDecrease);
        return "iwm";
    }

}
