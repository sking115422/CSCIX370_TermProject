package com.datadawgs.springboot.controller;


import com.datadawgs.springboot.DAO;
import com.datadawgs.springboot.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class AppController {

    @Autowired
    private DAO dao;

    @GetMapping("/")
    public String homePage(Model model){
        return "home";
    }

    @RequestMapping("/iwm")
    public String iwmPage(Model model, @RequestParam("startdate") String startdate, @RequestParam("enddate") String  enddate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(startdate);
        Date endDate = format.parse(enddate);
        List<Stock> stocks = dao.list("iwm", startDate, endDate);
        List<Stock> highestOpen = dao.highestOpen("iwm", startDate, endDate);
        List<Stock> highestVol = dao.highestVol("iwm", startDate, endDate);
        List<Stock> highestClose = dao.highestClose("iwm", startDate, endDate);
        List<Stock> biggestIncrease = dao.biggestIncrease("iwm", startDate, endDate);
        List<Stock> biggestDecrease = dao.biggestDecrease("iwm", startDate, endDate);
        model.addAttribute("stocks", stocks);
        model.addAttribute("highestOpen", highestOpen);
        model.addAttribute("highestVol", highestVol);
        model.addAttribute("highestClose", highestClose);
        model.addAttribute("biggestIncrease", biggestIncrease);
        model.addAttribute("biggestDecrease", biggestDecrease);
        return "iwm";
    }

    @GetMapping(path="/qqq")
    public String getVolQQQ (Model model){

        Date startDate = new Date(2005, 01, 03);
        Date endDate = new Date(2006,01,03);
        List<Stock> stocks = dao.list("qqq",startDate, endDate);

        Date[] dates = stocks.stream().map(t -> t.getDate()).toArray(Date[]::new);
        Double[] price = stocks.stream().map(t -> t.getClose()).toArray(Double[]::new);

        model.addAttribute("dates", dates);
        model.addAttribute("closing", price);
        return "qqq";

    }

}
