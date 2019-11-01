package com.company;

import java.util.ArrayList;

public class AvgRatingPoint {
    private String hotelName;
    private String cityName;
    private int numberOfGuest = 0;
    private double pointSum = 0;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getNumberOfGuest() {
        return numberOfGuest;
    }

    public void setNumberOfGuest(int numberOfGuest) {
        this.numberOfGuest = numberOfGuest;
    }

    public double getPointSum() {
        return pointSum;
    }

    public void setPointSum(double pointSum) {
        this.pointSum = pointSum;
    }

}
