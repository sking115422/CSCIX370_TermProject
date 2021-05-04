package com.datadawgs.springboot.controller;


import com.datadawgs.springboot.DAO;
import com.datadawgs.springboot.Stock;
import com.datadawgs.springboot.StockInfo;
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

/**
 * This class is a controller and control all the HTML request.
 */
@Controller
public class AppController {

    @Autowired
    private DAO dao;

    @GetMapping("/")
    public String homePage(Model model){
        return "home";
    }

    /**
     * handles /iwm request
     * @param model carries data to view
     * @param startdate is start date of investing stock
     * @param enddate is end date of the investing stock
     * @param amount is total amount invested
     * @return navigates to template web page
     * @throws ParseException throws when failed to parse string
     */
    @RequestMapping("/iwm")
    public String iwmPage(Model model, @RequestParam("startdate") String startdate, @RequestParam("enddate") String  enddate, @RequestParam("amount") String amount) throws ParseException {
        double value = Double.parseDouble(amount);
        List<StockInfo> stockInfo = dao.getStockInfo("iwm");
        model.addAttribute("stockInfo", stockInfo.get(0));


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(startdate);
        Date endDate = format.parse(enddate);
        List<Stock> stocks = dao.list("iwm",startDate, endDate);

        Stock firstday = dao.get("iwm", startDate);
        double numberOfStock = value/firstday.getClose();

        Stock[] stockArray = stocks.toArray(new Stock[stocks.size()]);
        System.out.println(stockArray.length);
        System.out.println(stocks.size());
        String[] dates = stocks.stream().map(t -> t.getDate()).toArray(String[]::new);
        Double[] closing = stocks.stream().map(t -> t.getClose()).toArray(Double[]::new);
        Double[] money = stocks.stream().map(t -> t.getClose() * numberOfStock).toArray(Double[]::new);
        System.out.println(dates.length);
        System.out.println(closing.length);
        model.addAttribute("stock", stockArray);
        model.addAttribute("money", money);
        model.addAttribute("dates", dates);
        model.addAttribute("closing", closing);
        model.addAttribute("numberOfStock", numberOfStock);


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


    /**
     * handles /qqq request
     * @param model carries data to view
     * @param startdate is start date of investing stock
     * @param enddate is end date of the investing stock
     * @param amount is total amount invested
     * @return navigates to template web page
     * @throws ParseException throws when failed to parse string
     */
    @GetMapping(path="/qqq")
    public String getVolQQQ (Model model, @RequestParam("startdate") String startdate, @RequestParam("enddate") String  enddate, @RequestParam("amount") String amount) throws ParseException {
        double value = Double.parseDouble(amount);
        List<StockInfo> stockInfo = dao.getStockInfo("qqq");
        model.addAttribute("stockInfo", stockInfo.get(0));


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(startdate);
        Date endDate = format.parse(enddate);
        List<Stock> stocks = dao.list("qqq",startDate, endDate);

        Stock firstday = dao.get("qqq", startDate);
        double numberOfStock = value/firstday.getClose();

        Stock[] stockArray = stocks.toArray(new Stock[stocks.size()]);
        System.out.println(stockArray.length);
        System.out.println(stocks.size());
        String[] dates = stocks.stream().map(t -> t.getDate()).toArray(String[]::new);
        Double[] closing = stocks.stream().map(t -> t.getClose()).toArray(Double[]::new);
        Double[] money = stocks.stream().map(t -> t.getClose() * numberOfStock).toArray(Double[]::new);
        System.out.println(dates.length);
        System.out.println(closing.length);
        model.addAttribute("stock", stockArray);
        model.addAttribute("money", money);
        model.addAttribute("dates", dates);
        model.addAttribute("closing", closing);
        model.addAttribute("numberOfStock", numberOfStock);


        List<Stock> highestOpen = dao.highestOpen("qqq", startDate, endDate);
        List<Stock> highestVol = dao.highestVol("qqq", startDate, endDate);
        List<Stock> highestClose = dao.highestClose("qqq", startDate, endDate);
        List<Stock> biggestIncrease = dao.biggestIncrease("qqq", startDate, endDate);
        List<Stock> biggestDecrease = dao.biggestDecrease("qqq", startDate, endDate);
        model.addAttribute("stocks", stocks);
        model.addAttribute("highestOpen", highestOpen);
        model.addAttribute("highestVol", highestVol);
        model.addAttribute("highestClose", highestClose);
        model.addAttribute("biggestIncrease", biggestIncrease);
        model.addAttribute("biggestDecrease", biggestDecrease);


        return "iwm";

    }

    /**
     * handles /spy request
     * @param model carries data to view
     * @param startdate is start date of investing stock
     * @param enddate is end date of the investing stock
     * @param amount is total amount invested
     * @return navigates to template web page
     * @throws ParseException throws when failed to parse string
     */
    @GetMapping(path="/spy")
    public String getVolSPY (Model model, @RequestParam("startdate") String startdate, @RequestParam("enddate") String  enddate, @RequestParam("amount") String amount) throws ParseException {
        double value = Double.parseDouble(amount);
        List<StockInfo> stockInfo = dao.getStockInfo("spy");
        model.addAttribute("stockInfo", stockInfo.get(0));


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(startdate);
        Date endDate = format.parse(enddate);
        List<Stock> stocks = dao.list("spy",startDate, endDate);

        Stock firstday = dao.get("spy", startDate);
        double numberOfStock = value/firstday.getClose();

        Stock[] stockArray = stocks.toArray(new Stock[stocks.size()]);
        System.out.println(stockArray.length);
        System.out.println(stocks.size());
        String[] dates = stocks.stream().map(t -> t.getDate()).toArray(String[]::new);
        Double[] closing = stocks.stream().map(t -> t.getClose()).toArray(Double[]::new);
        Double[] money = stocks.stream().map(t -> t.getClose() * numberOfStock).toArray(Double[]::new);
        System.out.println(dates.length);
        System.out.println(closing.length);
        model.addAttribute("stock", stockArray);
        model.addAttribute("money", money);
        model.addAttribute("dates", dates);
        model.addAttribute("closing", closing);
        model.addAttribute("numberOfStock", numberOfStock);


        List<Stock> highestOpen = dao.highestOpen("spy", startDate, endDate);
        List<Stock> highestVol = dao.highestVol("spy", startDate, endDate);
        List<Stock> highestClose = dao.highestClose("spy", startDate, endDate);
        List<Stock> biggestIncrease = dao.biggestIncrease("spy", startDate, endDate);
        List<Stock> biggestDecrease = dao.biggestDecrease("spy", startDate, endDate);
        model.addAttribute("stocks", stocks);
        model.addAttribute("highestOpen", highestOpen);
        model.addAttribute("highestVol", highestVol);
        model.addAttribute("highestClose", highestClose);
        model.addAttribute("biggestIncrease", biggestIncrease);
        model.addAttribute("biggestDecrease", biggestDecrease);


        return "iwm";

    }

    /**
     * handles /vti request
     * @param model carries data to view
     * @param startdate is start date of investing stock
     * @param enddate is end date of the investing stock
     * @param amount is total amount invested
     * @return navigates to template web page
     * @throws ParseException throws when failed to parse string
     */
    @GetMapping(path="/vti")
    public String getVolVTI (Model model, @RequestParam("startdate") String startdate, @RequestParam("enddate") String  enddate, @RequestParam("amount") String amount) throws ParseException {
        double value = Double.parseDouble(amount);
        List<StockInfo> stockInfo = dao.getStockInfo("vti");
        model.addAttribute("stockInfo", stockInfo.get(0));


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(startdate);
        Date endDate = format.parse(enddate);
        List<Stock> stocks = dao.list("vti",startDate, endDate);

        Stock firstday = dao.get("vti", startDate);
        double numberOfStock = value/firstday.getClose();

        Stock[] stockArray = stocks.toArray(new Stock[stocks.size()]);
        System.out.println(stockArray.length);
        System.out.println(stocks.size());
        String[] dates = stocks.stream().map(t -> t.getDate()).toArray(String[]::new);
        Double[] closing = stocks.stream().map(t -> t.getClose()).toArray(Double[]::new);
        Double[] money = stocks.stream().map(t -> t.getClose() * numberOfStock).toArray(Double[]::new);
        System.out.println(dates.length);
        System.out.println(closing.length);
        model.addAttribute("stock", stockArray);
        model.addAttribute("money", money);
        model.addAttribute("dates", dates);
        model.addAttribute("closing", closing);
        model.addAttribute("numberOfStock", numberOfStock);


        List<Stock> highestOpen = dao.highestOpen("vti", startDate, endDate);
        List<Stock> highestVol = dao.highestVol("vti", startDate, endDate);
        List<Stock> highestClose = dao.highestClose("vti", startDate, endDate);
        List<Stock> biggestIncrease = dao.biggestIncrease("vti", startDate, endDate);
        List<Stock> biggestDecrease = dao.biggestDecrease("vti", startDate, endDate);
        model.addAttribute("stocks", stocks);
        model.addAttribute("highestOpen", highestOpen);
        model.addAttribute("highestVol", highestVol);
        model.addAttribute("highestClose", highestClose);
        model.addAttribute("biggestIncrease", biggestIncrease);
        model.addAttribute("biggestDecrease", biggestDecrease);


        return "iwm";

    }




}