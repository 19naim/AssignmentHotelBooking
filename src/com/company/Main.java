package com.company;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Hotel> hotels;
    public static List<Customer> customers;



    public static void main(String[] args) {
        //load data from File to List ................

        FileHandling fhd = new FileHandling();
        hotels = fhd.rtvHotelData("FileHotel.txt");
        customers = fhd.rtvCustomerData("CustomerFile.txt");


        int input = 0;

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\nSelect from following menu:" +
                    "\n 1. AdminPerson." +
                    "\n 2. Customer" +
                    "\n 3. exit");
            input = in.nextInt();
            switch(input){
                case 1:{
                    adminPerson();
                    break;
                }
                case 2:{
                    customer();
                    break;
                }
                case 3:{
                   System.exit(0);
                }
            }




           /* if (input == 1) {
                adminPerson();

            } else if (input == 2) {
                customer();
            }
*/
        }
    }


    /**
     * principle method to execute all the administration work
     * Like
     * Check available hotel with available rooms
     * Create new Hotel and rooms
     * delete Hotel one by one
     * delete all the hotels at a time
     * delete customers one by one
     */
    public static void adminPerson() {
        Scanner inp = new Scanner(System.in);
        Scanner inpS = new Scanner(System.in);
        int inpt = 0;

        while (inpt != 8) {
            System.out.println("Select from following menu:" +
                    "\n 1. Insert Hotel." +
                    "\n 2. Check ArrayList." +
                    "\n 3. show all hotel." +
                    "\n 4. Show All Customers." +
                    "\n 5. Delete one Customer." +
                    "\n 6. Delete One Hotel." +
                    "\n 7. Delete All Hotels." +
                    "\n 8. Exit.");
            try {
                inpt = inp.nextInt();
            } catch (Exception e) {
                System.out.println("Integer Expected !!!" +
                        "\nTry again");
                inpt = inp.nextInt();
            }


            if (inpt == 1) {
                Hotel hotel = new Hotel();
                String city;
                String hotelNm;
                int numsOfRoom;
                double price;


                System.out.println("1. City:");
                city = inpS.next();
                hotel.setCity(city);

                System.out.println("2. Hotel Name:");
                hotelNm = inpS.next();
                hotel.setHotelName(hotelNm);

                System.out.println("3. Amount of Room:");
                numsOfRoom = inpS.nextInt();
                hotel.setNumberOfRoom(numsOfRoom);

                System.out.println("4. Price:");
                price = inpS.nextDouble();
                hotel.setPrice(price);

                hotels.add(hotel);
                FileHandling fh = new FileHandling();

                //Transferring Data to File...
                try {
                    fh.saveHotelDataInFile(hotels);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (inpt == 2) {
                System.out.println(hotels.isEmpty());
            } else if (inpt == 3) {
                for (int i = 0; i < hotels.size(); i++) {
                    System.out.println("\nName of City: " + hotels.get(i).getCity());
                    System.out.println("Name of Hotel: " + hotels.get(i).getHotelName());
                    System.out.println("Number of Room: " + hotels.get(i).getNumberOfRoom());
                    System.out.println("Price per Room: " + hotels.get(i).getPrice());
                    System.out.println("Average Rating Point: " + hotels.get(i).getRatingPoint());
                }
            } else if (inpt == 4) {
                for (int i = 0; i < customers.size(); i++) {

                    System.out.println("\nHotel Name: " + customers.get(i).getHotelName());
                    System.out.println("City Name:" + customers.get(i).getCity());
                    System.out.println("Customer Name:" + customers.get(i).getNameOfCustomer());
                    System.out.println("Customer ID Number:" + customers.get(i).getIdNo());
                    System.out.println("Number of Room Booked:" + customers.get(i).getNumOfRoom());
                    System.out.println("Price : " + customers.get(i).getPrice() + "SEK");
                    //System.out.println("Rating:" +hotels.get(i).getRatingPoint());
                }
            } else if (inpt == 5) {
                FileHandling fh = new FileHandling();
                String name;
                String htlName;
                System.out.println("Please Enter Name of Customer:");
                name = inpS.next();
                System.out.println("Please Enter Name of Hotel:");
                htlName = inpS.next();

                for (int i = 0; i < customers.size(); i++) {
                    if ((customers.get(i).getNameOfCustomer().equals(name)) && (customers.get(i).getHotelName().equals(htlName))) {

                        hotels.get(i).setNumberOfRoom(hotels.get(i).getNumberOfRoom() + customers.get(i).getNumOfRoom());
                        customers.remove(i);

                        //updating Customer file

                        try {
                            fh.saveCustomerDataInFile(customers);
                            fh.saveHotelDataInFile(hotels);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }


                    }
                }

            } else if (inpt == 6) {
                FileHandling fh = new FileHandling();
                String hotelName;
                System.out.println("Please Enter Name of the Hotel:");
                hotelName = inpS.next();
                for (int i = 0; i < hotels.size(); i++) {
                    if ((hotels.get(i).getHotelName().equals(hotelName))) {
                        for (int j = 0; j < customers.size(); j++) {
                            if (customers.get(j).getHotelName().equals(hotelName)){
                                customers.remove(j);
                            }
                        }
                        hotels.remove(i);


                        // Updating File.....
                        try {
                            fh.saveCustomerDataInFile(customers);
                            fh.saveHotelDataInFile(hotels);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }


            } else if (inpt == 7) {
                FileHandling fh = new FileHandling();
                hotels.clear();
                customers.clear();
                try {
                    fh.saveHotelDataInFile(hotels);
                    fh.saveCustomerDataInFile(customers);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }


        }

    }

//====================================CUSTOMER METHOD STARTS=================================

    /**
     * Principle method to handle customer
     * customer can check available hotel
     * book one or more room of same hotel at a time
     * cancel booking
     * check booked rooms
     */
    public static void customer() {

        Scanner inp = new Scanner(System.in);
        Scanner inpS = new Scanner(System.in);
        int inpt = 0;

        while (inpt != 6) {
            System.out.println("\nSelect from following menu:" +
                    "\n 1. Check Available Hotel." +
                    "\n 2. Book a room." +
                    "\n 3. See booking details." +
                    "\n 4. Cancel your booking." +
                    "\n 5. rate your booking." +
                    "\n 6. Exit");
            inpt = inp.nextInt();

            if (inpt == 1) {
                for (int i = 0; i < hotels.size(); i++) {
                    System.out.println("\nName of City: " + hotels.get(i).getCity());
                    System.out.println("Name of Hotel: " + hotels.get(i).getHotelName());
                    System.out.println("Number of available Rooms: " + hotels.get(i).getNumberOfRoom());
                    System.out.println("Price per Room: " + hotels.get(i).getPrice() + "SEK");
                    System.out.println("Rating Point Average: " + hotels.get(i).getRatingPoint());
                }

            } else if (inpt == 2) {

                Customer cust = new Customer();

                String htlName;
                String cityName;

                String custName;
                int custId;
                int amountOfRoom;
                double price;
                double ratingPoint;

                System.out.println("Enter Hotel Name:");
                htlName = inpS.next();
                cust.setHotelName(htlName);


                System.out.println("Enter City:");
                cityName = inpS.next();
                cust.setCity(cityName);


                System.out.println("Enter your Name:");
                custName = inpS.next();
                cust.setNameOfCustomer(custName);
                System.out.println("Enter you ID No.");
                custId = inpS.nextInt();
                cust.setIdNo(custId);
                System.out.println("Enter amount of Room:");
                amountOfRoom = inpS.nextInt();
                cust.setNumOfRoom(amountOfRoom);

                // Extracting price from Hotel ArrayList
                System.out.println("Setting price .........");
                for (int i = 0; i < hotels.size(); i++) {
                    if (hotels.get(i).getHotelName().equals(htlName)) {
                        double priceIncr = hotels.get(i).getPrice();
                        price = priceIncr * amountOfRoom;
                        //Setting price
                        cust.setPrice(price);
                    }
                }

                //Defining rating ...
                System.out.println("Enter rating(1.....5): ");

                double inpRating = inpS.nextDouble();


                for (int i = 0; i < hotels.size(); i++) {
                    if (hotels.get(i).getHotelName().equals(htlName)) {

                      hotels.get(i).setRatingPoint((hotels.get(i).getRatingPoint()+inpRating)/2);
                    }
                }


                customers.add(cust);

                // Deduct room number

                for (int i = 0; i < hotels.size(); i++) {
                    if (hotels.get(i).getHotelName().equals(htlName)) {
                        hotels.get(i).setNumberOfRoom(hotels.get(i).getNumberOfRoom() - amountOfRoom);
                    }

                }
// Transferring data to file
                FileHandling fg = new FileHandling();

                try {
                    fg.saveCustomerDataInFile(customers);
                    fg.saveHotelDataInFile(hotels);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }


            } else if (inpt == 3) {
                Scanner it = new Scanner(System.in);

                System.out.println("Please enter your name:");
                System.out.println(customers.isEmpty());
                String name = it.nextLine();

                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).getNameOfCustomer().equals(name)) {
                        System.out.println("\nHotel Name: " + customers.get(i).getHotelName());
                        System.out.println("City Name:" + customers.get(i).getCity());
                        System.out.println("Customer Name:" + customers.get(i).getNameOfCustomer());
                        System.out.println("Customer ID Number:" + customers.get(i).getIdNo());
                        System.out.println("Number of Room Booked:" + customers.get(i).getNumOfRoom());
                        System.out.println("Price : " + customers.get(i).getPrice() + "SEK");
                        System.out.println("Rating:" + hotels.get(i).getRatingPoint());
                    }
                }
            } else if (inpt == 4) {
                Scanner it = new Scanner(System.in);
                FileHandling fh = new FileHandling();
                System.out.println("Please enter your name:");
                System.out.println(customers.isEmpty());
                String name = it.nextLine();
                System.out.println("Please Enter Hotel Name:");
                String htlName = it.nextLine();
                for (int i = 0; i < customers.size(); i++) {
                    if ((customers.get(i).getNameOfCustomer().equals(name)) && (customers.get(i).getHotelName().equals(htlName))) {
                        hotels.get(i).setNumberOfRoom(hotels.get(i).getNumberOfRoom() + customers.get(i).getNumOfRoom());
                        customers.remove(i);
                        //Updating File

                        try {
                            fh.saveHotelDataInFile(hotels);
                            fh.saveCustomerDataInFile(customers);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }


        }


    }
}
