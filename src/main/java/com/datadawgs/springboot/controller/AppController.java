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

        List<Stock> stockName = dao.getName("iwm");
        List<Stock> stockDesc = dao.getDescription("iwm");
        model.addAttribute("stockName", stockName);
        model.addAttribute("stockDesc", stockDesc);

        System.out.println(stockName.get(0));
        System.out.println(stockDesc.get(0));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(startdate);
        Date endDate = format.parse(enddate);
        List<Stock> stocks = dao.list("iwm",startDate, endDate);

        Stock[] stockArray = stocks.toArray(new Stock[stocks.size()]);
        System.out.println(stockArray.length);
        System.out.println(stocks.size());
        String[] dates = stocks.stream().map(t -> t.getDate()).toArray(String[]::new);
        Double[] closing = stocks.stream().map(t -> t.getClose()).toArray(Double[]::new);
        System.out.println(dates.length);
        System.out.println(closing.length);
        model.addAttribute("stock", stockArray);
        model.addAttribute("dates", dates);
        model.addAttribute("closing", closing);


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
    public String getVolQQQ (Model model, @RequestParam("qqqStartdate") String startdate, @RequestParam("qqqEnddate") String  enddate, @RequestParam("amount") String amount) throws ParseException {
        double value = Double.parseDouble(amount);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(startdate);
        Date endDate = format.parse(enddate);
        List<Stock> stocks = dao.list("qqq",startDate, endDate);

        Stock[] stockArray = stocks.toArray(new Stock[stocks.size()]);
        System.out.println(stockArray.length);
        System.out.println(stocks.size());
        Stock firstday = dao.get("qqq", startDate);
        double numberOfStock = value/firstday.getClose();
        String[] dates = stocks.stream().map(t -> t.getDate()).toArray(String[]::new);
        Double[] closing = stocks.stream().map(t -> t.getClose() * numberOfStock).toArray(Double[]::new);
        List<Stock> highestOpen = dao.highestOpen("qqq", startDate, endDate);
        List<Stock> highestVol = dao.highestVol("qqq", startDate, endDate);
        List<Stock> highestClose = dao.highestClose("qqq", startDate, endDate);
        List<Stock> biggestIncrease = dao.biggestIncrease("qqq", startDate, endDate);
        List<Stock> biggestDecrease = dao.biggestDecrease("qqq", startDate, endDate);
        System.out.println(dates.length);
        System.out.println(closing.length);
        model.addAttribute("dates", dates);
        model.addAttribute("closing", closing);
        model.addAttribute("stocks", stocks);
        model.addAttribute("highestOpen", highestOpen);
        model.addAttribute("highestVol", highestVol);
        model.addAttribute("highestClose", highestClose);
        model.addAttribute("biggestIncrease", biggestIncrease);
        model.addAttribute("biggestDecrease", biggestDecrease);

        return "qqq";

    }


}