package utils;

import java.util.*;
import java.io.*;
public class ReadProperties
{

    /***
     * This method is created to read value from properties file.
     * @param key parameter whose value user want to read.
     * @param filepath  location of properties file from which data need to be read
     * @return returns value present in properties file as a string
     * @throws Exception throws exception on failure.
     */
    public static String getData(String key,String filepath)throws Exception
    {
            FileInputStream fileInputStream=new FileInputStream(filepath);
            Properties properties=new Properties();
            properties.load(fileInputStream);
            return properties.getProperty(key);
        }
}
