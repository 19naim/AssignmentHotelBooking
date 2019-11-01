package com.company;

import java.io.Serializable;

public class Hotel extends RoomType implements Serializable {

    private String city;
    private String hotelName;

    private int numberOfRoom;
    private double price;

    private double ratingPoint = 5.0;



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(double ratingPoint) {
        this.ratingPoint = ratingPoint;
    }



}
