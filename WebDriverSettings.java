package com.rztk;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;


public class WebDriverSettings {

    public ChromeDriver driver;
    public WebDriverWait wait;
    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/Users/Home/IdeaProjects/First_Task/src/main/resources/drivers/chromedriver91.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        // Map<String, Object> prefs = new HashMap<String, Object>();
       // prefs.put("profile.default_content_setting_values.notifications", 2);
        // ChromeOptions options = new ChromeOptions();
       // options.setExperimentalOption("prefs", prefs);
       // driver = new ChromeDriver(options);
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-notifications");
        //driver = new ChromeDriver(options);


    }
    @After
    public void closePage() {

        driver.quit();
    }
}
