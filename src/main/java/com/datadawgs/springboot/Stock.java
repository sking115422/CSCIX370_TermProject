package com.datadawgs.springboot;

/**
 * POJO object for storing stockData
 */
public class Stock {
    private String date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;

    /**
     * empty constructor
     */
    protected Stock() {
    }

    /**
     * @param date date
     * @param open opening value of the Stock
     * @param close closing value of the stock
     * @param high highest value of the day
     * @param low lowest value of the day
     * @param volume total volume of the stock
     */
    protected Stock(String date, double open, double close, double high, double low, double volume) {
        this.date = date;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
    }

    /**
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date date of the stock
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return opening value of the stock
     */
    public double getOpen() {
        return open;
    }

    /**
     * @param open opening value of the stock
     */
    public void setOpen(double open) {
        this.open = open;
    }

    /**
     * @return highest value of the day
     */
    public double getHigh() {
        return high;
    }

    /**
     * @param high highest value of the day
     */
    public void setHigh(double high) {
        this.high = high;
    }

    /**
     * @return lowest value of the day
     */
    public double getLow() { return low; }

    /**
     * @param low lowest value of the day
     */
    public void setLow(double low) {
        this.low = low;
    }

    /**
     * @return closing value of the day
     */
    public double getClose() {
        return close;
    }

    /**
     * @param close closing value of the day
     */
    public void setClose(double close) {
        this.close = close;
    }

    /**
     * @return total volume of the day
     */
    public double getVolume() {
        return volume;
    }

    /**
     * @param volume total volume of the day
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

}
