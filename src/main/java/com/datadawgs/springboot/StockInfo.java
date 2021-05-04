package com.datadawgs.springboot;

/**
 * this class is POJO object for storing stockInfo
 */
public class StockInfo {
    private String stockTicker;
    private String stockName;
    private String stockDesc;

    /**
     * @param stockTicker short name
     * @param stockName full name
     * @param stockDesc description
     */
    protected StockInfo(String stockTicker, String stockName, String stockDesc) {
        this.stockTicker = stockTicker;
        this.stockName = stockName;
        this.stockDesc = stockDesc;
    }

    /**
     *
     */
    protected StockInfo() {
    }

    /**
     * @return short name of stock
     */
    public String getStockTicker() {
        return stockTicker;
    }

    /**
     * @param stockTicker short name of stock
     */
    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    /**
     * @return full name of stock
     */
    public String getStockName() {
        return stockName;
    }

    /**
     * @param stockName full name of stock
     */
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    /**
     * @return description of the stock
     */
    public String getStockDesc() {
        return stockDesc;
    }

    /**
     * @param stockDesc description of the stock
     */
    public void setStockDesc(String stockDesc) {
        this.stockDesc = stockDesc;
    }
}
