package com.jabatalks.qa.testBase;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static Properties prop;
    public static WebDriver driver;
    static Logger log = Logger.getLogger(BaseClass.class);
    static String localDir = System.getProperty("user.dir");


    public BaseClass() throws IOException {
        log.info("*********BaseClass Constructor Initialization Start*********");
        log.info("*********Properties file Initialization Start*********");
        prop = new Properties();
        FileInputStream ip = new FileInputStream(localDir +
                "/src/main/java/com/jabatalks/qa/config/config.properties");
        prop.load(ip);
        log.info("*********Properties file Initialization End*********");
        log.info("*********BaseClass Constructor Initialization End*********");
    }

    public static void initialization() {
        log.info("*********Driver Initialization Start*********");
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome") || browserName.equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", localDir + prop.getProperty("chromeDriverPath"));
            driver = new ChromeDriver();
        }
        log.info("*********Driver Initialization End*********");

        log.info("*********Browser Basic Setup Start*********");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("pageloadtimeout")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("implicitwait")), TimeUnit.SECONDS);
        log.info("*********Browser Basic Setup End*********");
        driver.get(prop.getProperty("url"));
        log.info("Navigating to base url");

    }
}
