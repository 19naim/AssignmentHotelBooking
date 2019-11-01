package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandling extends DataManagement implements Serializable{

    @Override
    public void saveHotelDataInFile(List<Hotel> hotels)throws FileNotFoundException{
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream("FileHotel.txt", false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hotels);
            objectOutputStream.close();

            System.out.println("Hotel Data saved");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



    @Override
    public void saveCustomerDataInFile(List<Customer> customers) throws FileNotFoundException{
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream("CustomerFile.txt", false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(customers);
            objectOutputStream.close();

            System.out.println("Customer Data saved");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}
