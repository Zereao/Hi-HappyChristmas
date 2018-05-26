package com.hyl.love.cx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonUtil {

    private static Properties prop = new Properties();

    public static Properties loadProperties() {
        File propertiesFile = new File("src/main/resources/properties/mailInfo.properties");
        try {
            prop.load(new FileInputStream(propertiesFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
