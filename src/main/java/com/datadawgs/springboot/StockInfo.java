package com.datadawgs.springboot;

public class StockInfo {
    private String stockTicker;
    private String stockName;
    private String stockDesc;

    protected StockInfo(String stockTicker, String stockName, String stockDesc) {
        this.stockTicker = stockTicker;
        this.stockName = stockName;
        this.stockDesc = stockDesc;
    }

    protected StockInfo() {
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockDesc() {
        return stockDesc;
    }

    public void setStockDesc(String stockDesc) {
        this.stockDesc = stockDesc;
    }
}
