package com.swagLab.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    /*
• Reading one time is good but we need to create a re-usable utility method so we can read from our .properties file whenever we want.
1. Create a new class: ConfigurationReader.java
2. Copy/paste our .properties file reading logic
3. Edit if needed
4. Create a new utility method to re-use our logic
5. Method should accept “key” as a String, and return “value” as String
 */



    //1- Create the Properties object (create object)
    //make it "private" so we are limiting access to the object
    //"static" is to make sure its created and loaded before everything else.
    private static Properties properties=new Properties();

    static {

        try{
            //2- Open file using FileInputStream (open file)
            FileInputStream file = new FileInputStream("configuration.properties");//helping us to open this file
            //3- Load the "properties" object with "file" (load properties)
            properties.load(file);

            //close the file in memory
            file.close();

        }catch (IOException e){
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            e.printStackTrace();
        }


    }

    //create a utility method to use the object to read
    //4- Use "properties" object to read from the file (read properties)


    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }








}
