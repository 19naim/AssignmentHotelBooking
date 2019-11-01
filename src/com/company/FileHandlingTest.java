package com.company;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FileHandlingTest {
    File file = new File("FileHotel.txt");
    @Test
    public void saveHotelDataInFile() {
        assertTrue("true",file.exists());
    }
}