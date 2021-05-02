package com.datadawgs.springboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<String> getVolQQQ() {
        List<String> qqqVolData = new ArrayList <> ();
        qqqVolData.addAll(jdbcTemplate.queryForList("SELECT volume FROM mydb.qqq LIMIT 10;", String.class));

        return qqqVolData;

    }

    public List<String> getCloseQQQ() {
        List<String> qqqCloseData = new ArrayList <> ();
        qqqCloseData.addAll(jdbcTemplate.queryForList("SELECT close FROM mydb.qqq LIMIT 10;", String.class));

        return qqqCloseData;

    }


    public List<String> getVolSPY() {
        List<String> spyVolData = new ArrayList <> ();
        spyVolData.addAll(jdbcTemplate.queryForList("SELECT volume FROM mydb.spy LIMIT 10;", String.class));

        return spyVolData;

    }

    public List<String> getVolVTI() {
        List<String> vtiVolData = new ArrayList<>();
        vtiVolData.addAll(jdbcTemplate.queryForList("SELECT volume FROM mydb.spy LIMIT 10;", String.class));

        return vtiVolData;
    }

    public List<String> getVolIWM() {
        List<String> iwmVolData = new ArrayList<>();
        iwmVolData.addAll(jdbcTemplate.queryForList("SELECT volume FROM mydb.spy LIMIT 10;", String.class));

        return iwmVolData;
    }

}
