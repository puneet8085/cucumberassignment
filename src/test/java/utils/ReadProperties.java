package utils;

import java.util.*;
import java.io.*;
public class ReadProperties
{
    public static String getData(String key,String filepath)throws Exception
    {
            FileInputStream fileInputStream=new FileInputStream(filepath);
            Properties properties=new Properties();
            properties.load(fileInputStream);
            return properties.getProperty(key);
        }
}
