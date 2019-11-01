package com.company;

import java.io.Serializable;


public class Customer extends RoomType implements Serializable {
    private String hotelName;
    private String city;

    private String nameOfCustomer;
    private int idNo;
    private int numOfRoom;
    private double price;

   // private double ratingPoint;

    public String getHotelName() { return hotelName; }

    public void setHotelName(String hotelName) { this.hotelName = hotelName; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getNameOfCustomer() { return nameOfCustomer; }

    public void setNameOfCustomer(String nameOfCustomer) { this.nameOfCustomer = nameOfCustomer; }

    public int getIdNo() { return idNo; }

    public void setIdNo(int idNo) { this.idNo = idNo; }

    public int getNumOfRoom() { return numOfRoom; }

    public void setNumOfRoom(int numOfRoom) { this.numOfRoom = numOfRoom; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
/*
    public double getRatingPoint() {
        return ratingPoint;
    }

    public void setRatingPoint(double ratingPoint) {
        this.ratingPoint = ratingPoint;
    }
*/




}
