package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SearchUser {
    public WebDriver driver;
    // a method used to make the code less redundant
    @BeforeClass
    void setup() throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("https://www.roblox.com/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.findElement(By.id("login-username")).sendKeys("[UserName]");
        Thread.sleep(2000);

        driver.findElement(By.id("login-password")).sendKeys("[Password]");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(11000);
    }
    @Test
    void correctUsername() throws InterruptedException {

        driver.findElement(By.id("navbar-search-input")).sendKeys("[UserName]");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text() = 'in People']")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 1)
    void incorrectUsername() throws InterruptedException {

        driver.findElement(By.id("navbar-search-input")).sendKeys("[RandomString]");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text() = 'in People']")).click();
        Thread.sleep(5000);

    }
    @AfterClass
    void driverQuit(){driver.quit();}
}
