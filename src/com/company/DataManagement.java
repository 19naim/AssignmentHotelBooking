package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a abstract class for handling data from and to file
 * There two abstract methods for writing data to file
 * and two regular methods to retrieve saved data when program starts
 *
 * Retrieve data methods are protected with error handling if somehow existing files are
 * unavailable.
 *
 */
public abstract class DataManagement implements Serializable {

    public abstract void saveHotelDataInFile(List<Hotel> hotels) throws FileNotFoundException;

    public abstract void saveCustomerDataInFile(List<Customer> customers) throws FileNotFoundException;


    public List<Hotel> rtvHotelData(String fileName){
        ObjectInputStream objectinputstream = null;
        List<Hotel> hotels = null;
        File file = new File(fileName);
        if(file.exists()){
            try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            hotels = (List<Hotel>) objectinputstream.readObject();
            objectinputstream .close();
            System.out.println("Data extracted from Hotel file...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        }else{
            hotels = new ArrayList<>();
        }
        return hotels;
    }

    public List<Customer>rtvCustomerData(String fileName){

        ObjectInputStream objectinputstream = null;
        List<Customer> customers = null;
        File file = new File(fileName);
        if(file.exists()) {
            try {
                FileInputStream streamIn = new FileInputStream(fileName);
                objectinputstream = new ObjectInputStream(streamIn);
                customers = (List<Customer>) objectinputstream.readObject();
                objectinputstream.close();
                System.out.println("Data Extracted from Customer File....");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            customers = new ArrayList<>();
        }
        return customers;

    }
}
