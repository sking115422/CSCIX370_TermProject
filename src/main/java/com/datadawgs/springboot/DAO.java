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

@Repository
@Transactional
public class DAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Stock> list(String db) {
        String sql = "SELECT * FROM mydb."+db+" LIMIT 50";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

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

    public List<Stock> highestOpen(String db) {
        String sql = "SELECT * FROM mydb."+db+" WHERE OPEN = (SELECT MAX(OPEN) FROM mydb."+db+") LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    public List<Stock> highestOpen(String db, Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormat.format(startDate);
        String end = dateFormat.format(endDate);
        String sql = "SELECT * FROM mydb."+db+" WHERE OPEN = (SELECT MAX(OPEN) FROM mydb."+db+" WHERE date >= '" + start + "' AND date <= '" + end + "') LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    public List<Stock> highestClose(String db) {
        String sql = "SELECT * FROM mydb."+db+" WHERE CLOSE = (SELECT MAX(CLOSE) FROM mydb."+db+") LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    public List<Stock> highestClose(String db, Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormat.format(startDate);
        String end = dateFormat.format(endDate);
        String sql = "SELECT * FROM mydb."+db+" WHERE CLOSE = (SELECT MAX(CLOSE) FROM mydb."+db+" WHERE date >= '" + start + "' AND date <= '" + end + "') LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    public List<Stock> highestVol(String db, Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormat.format(startDate);
        String end = dateFormat.format(endDate);
        String sql = "SELECT * FROM mydb."+db+" WHERE VOLUME = (SELECT MAX(VOLUME) FROM mydb."+db+" WHERE date >= '" + start + "' AND date <= '" + end + "') LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    public List<Stock> highestVol(String db) {
        String sql = "SELECT * FROM mydb."+db+" WHERE VOLUME = (SELECT MAX(VOLUME) FROM mydb."+db+") LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    public List<Stock> biggestIncrease(String db) {
        String sql = "SELECT * FROM mydb."+db+" WHERE CLOSE-OPEN = (SELECT MAX(CLOSE-OPEN) FROM mydb."+db+") LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    public List<Stock> biggestIncrease(String db, Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormat.format(startDate);
        String end = dateFormat.format(endDate);
        String sql = "SELECT * FROM mydb."+db+" WHERE CLOSE-OPEN = (SELECT MAX(CLOSE-OPEN) FROM mydb."+db+" WHERE date >= '" + start + "' AND date <= '" + end + "') LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    public List<Stock> biggestDecrease(String db) {
        String sql = "SELECT * FROM mydb."+db+" WHERE CLOSE-OPEN = (SELECT MIN(CLOSE-OPEN) FROM mydb."+db+") LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    public List<Stock> biggestDecrease(String db, Date startDate, Date endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormat.format(startDate);
        String end = dateFormat.format(endDate);
        String sql = "SELECT * FROM mydb."+db+" WHERE CLOSE-OPEN = (SELECT MIN(CLOSE-OPEN) FROM mydb."+db+" WHERE date >= '" + start + "' AND date <= '" + end + "') LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    public List<StockInfo> getStockInfo(String ticker) {
        String sql = "SELECT * FROM mydb.stockinfo WHERE stockTicker = '" + ticker + "'";
        List<StockInfo> stockName = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(StockInfo.class));
        return stockName;
    }


    public Stock get(String db, Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String start = dateFormat.format(date);
        String sql = "SELECT * FROM mydb."+db+" WHERE date='" + start +"'";
        List<Stock> stock = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Stock.class));
        return stock.get(0);
    }



}
