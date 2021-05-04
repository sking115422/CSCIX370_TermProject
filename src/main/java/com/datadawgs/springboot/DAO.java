package com.datadawgs.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * this class helps to interact with database
 */
@Repository
@Transactional
public class DAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * this method helps to get all the stock data as POJO object
     * @param db name of the stock table
     * @return all the daily stock data that is available
     */
    public List<Stock> list(String db) {
        String sql = "SELECT * FROM mydb."+db+" LIMIT 50";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    /**
     * this method helps to get all the stock data as POJO object on time period
     * @param db name of the table in database
     * @param startDate date of the investing stock
     * @param endDate last date of the investing stock
     * @return all the daily stock data between startDate and endDate
     */
    public List<Stock> list(String db, Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormat.format(startDate);
        String end = dateFormat.format(endDate);
        String sql = "SELECT * FROM mydb."+db+" WHERE date >= '" + start + "' AND date <= '" + end + "'";
        System.out.println(sql);
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    /**
     * this method helps to get the stock data when opening value is highest as POJO object
     * @param db name of the stock table
     * @return stock data when opening value is highest
     */
    public List<Stock> highestOpen(String db) {
        String sql = "SELECT * FROM mydb."+db+" WHERE OPEN = (SELECT MAX(OPEN) FROM mydb."+db+") LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    /**
     * this method helps to get the stock data when opening value is highest as POJO object in time period
     * @param db name of the table in database
     * @param startDate date of the investing stock
     * @param endDate last date of the investing stock
     * @return stock data when opening value is highest between startDate and endDate
     */
    public List<Stock> highestOpen(String db, Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormat.format(startDate);
        String end = dateFormat.format(endDate);
        String sql = "SELECT * FROM mydb."+db+" WHERE OPEN = (SELECT MAX(OPEN) FROM mydb."+db+" WHERE date >= '" + start + "' AND date <= '" + end + "') LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    /**
     * this method helps to get the stock data when closing value is highest as POJO object
     * @param db name of the stock table
     * @return stock data when closinging value is highest
     */
    public List<Stock> highestClose(String db) {
        String sql = "SELECT * FROM mydb."+db+" WHERE CLOSE = (SELECT MAX(CLOSE) FROM mydb."+db+") LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    /**
     * this method helps to get the stock data when closing value is highest as POJO object in time period
     * @param db name of the table in database
     * @param startDate date of the investing stock
     * @param endDate last date of the investing stock
     * @return stock data when closing value is highest between startDate and endDate
     */
    public List<Stock> highestClose(String db, Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormat.format(startDate);
        String end = dateFormat.format(endDate);
        String sql = "SELECT * FROM mydb."+db+" WHERE CLOSE = (SELECT MAX(CLOSE) FROM mydb."+db+" " +
                "WHERE date >= '" + start + "' AND date <= '" + end + "') LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    /**
     * this method helps to get the stock data when total volume is highest as POJO object in time period
     * @param db name of the table in database
     * @param startDate date of the investing stock
     * @param endDate last date of the investing stock
     * @return stock data when volume is highest between startDate and endDate
     */
    public List<Stock> highestVol(String db, Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormat.format(startDate);
        String end = dateFormat.format(endDate);
        String sql = "SELECT * FROM mydb."+db+" WHERE VOLUME = (SELECT MAX(VOLUME) FROM mydb."+db+" " +
                "WHERE date >= '" + start + "' AND date <= '" + end + "') LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    /**
     * this method helps to get the stock data when total volume is highest as POJO object
     * @param db name of the stock table
     * @return stock data when volume is highest
     */
    public List<Stock> highestVol(String db) {
        String sql = "SELECT * FROM mydb."+db+" WHERE VOLUME = (SELECT MAX(VOLUME) FROM mydb."+db+") LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    /**
     * this method helps to get the stock data when biggest increase in value happened as POJO object
     * @param db name of the stock table
     * @return stock data when biggest increase in value happened
     */
    public List<Stock> biggestIncrease(String db) {
        String sql = "SELECT * FROM mydb."+db+" WHERE CLOSE-OPEN = (SELECT MAX(CLOSE-OPEN) FROM mydb."+db+") LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    /**
     * this method helps to get the stock data when biggest increase in value happened as POJO object in time period
     * @param db name of the table in database
     * @param startDate date of the investing stock
     * @param endDate last date of the investing stock
     * @return stock data when biggest increase in value happened between startDate and endDate
     */
    public List<Stock> biggestIncrease(String db, Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormat.format(startDate);
        String end = dateFormat.format(endDate);
        String sql = "SELECT * FROM mydb."+db+" WHERE CLOSE-OPEN = (SELECT MAX(CLOSE-OPEN) FROM mydb."+db+" " +
                "WHERE date >= '" + start + "' AND date <= '" + end + "') LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    /**
     * this method helps to get the stock data when biggest decrease in value happened as POJO object
     * @param db name of the stock table
     * @return stock data when biggest decrease in value happened
     */
    public List<Stock> biggestDecrease(String db) {
        String sql = "SELECT * FROM mydb."+db+" WHERE CLOSE-OPEN = (SELECT MIN(CLOSE-OPEN) FROM mydb."+db+") LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    /**
     * this method helps to get the stock data when biggest decrease in value happened as POJO object in time period
     * @param db name of the table in database
     * @param startDate date of the investing stock
     * @param endDate last date of the investing stock
     * @return stock data when biggest decrease in value happened between startDate and endDate
     */
    public List<Stock> biggestDecrease(String db, Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormat.format(startDate);
        String end = dateFormat.format(endDate);
        String sql = "SELECT * FROM mydb."+db+" WHERE CLOSE-OPEN = (SELECT MIN(CLOSE-OPEN) FROM mydb."+db+" " +
                "WHERE date >= '" + start + "' AND date <= '" + end + "') LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }


    /**
     * this method help to get stock information as POJO object
     * @param ticker name of the stock
     * @return return stock information as POJO object
     */
    public List<StockInfo> getStockInfo(String ticker) {
        String sql = "SELECT * FROM mydb.stockinfo WHERE stockTicker = '" + ticker + "'";
        List<StockInfo> stockName = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(StockInfo.class));
        return stockName;
    }


    /**
     * this method helps to get stockData of the particular day
     * @param db name of the stock
     * @param date date that you want to pull stockdata
     * @return return stockData as POJO object of this stock of that date
     */
    public Stock get(String db, Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormat.format(date);
        String sql = "SELECT * FROM mydb."+db+" WHERE date='" + start +"'";
        List<Stock> stock = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Stock.class));
        return stock.get(0);
    }



}
