package com.datadawgs.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Stock> highestOpen(String db) {
        String sql = "SELECT * FROM mydb."+db+" WHERE OPEN = (SELECT MAX(OPEN) FROM mydb."+db+") LIMIT 1";
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

    public List<Stock> biggestDecrease(String db) {
        String sql = "SELECT * FROM mydb."+db+" WHERE CLOSE-OPEN = (SELECT MIN(CLOSE-OPEN) FROM mydb."+db+") LIMIT 1";
        List<Stock> stocks = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Stock.class));
        return stocks;
    }

    public Stock get(String date) {
        return null;
    }
}
