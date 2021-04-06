package utils;

import java.util.*;
import java.io.*;
public class ReadProperties {

        public static String readDataFromPropertiesFile(String key,String filepath)throws Exception{
            FileReader reader=new FileReader(filepath);
            Properties properties=new Properties();
            properties.load(reader);
            return properties.getProperty(key);
        }

}
