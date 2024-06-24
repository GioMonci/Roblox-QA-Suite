package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Main {

    // This is just a test to make sure Webdriver and TestNG can run on your pc
    public WebDriver driver;

    @Test(priority = 1)
    void test1() throws InterruptedException{

        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.close();
    }


}

