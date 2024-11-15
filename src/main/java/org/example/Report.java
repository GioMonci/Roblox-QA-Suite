package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Report {
    public WebDriver driver;
    // a method used to make the code less redundant
    @BeforeClass
    void setup() throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("https://www.roblox.com/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.id("login-username")).sendKeys("[UserName]");
        Thread.sleep(2500);

        driver.findElement(By.id("login-password")).sendKeys("[Password]");
        Thread.sleep(3000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(11000);
    }
    @Test
    void reportPlayer() throws InterruptedException {

        driver.findElement(By.id("navbar-search-input")).sendKeys("[UserName]");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text() = 'in People']")).click();
        Thread.sleep(4000);

        //test
        driver.findElement(By.xpath("//*[@id=\"player-search-page\"]/div/div/ul/li/div/div")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"about\"]/div[1]/div[3]/div[2]/a/span")).click();
        Thread.sleep(2000);

        WebElement dropDown = driver.findElement(By.id("ReportCategory"));
        Select reportDropDown = new Select(dropDown);

        reportDropDown.selectByIndex(1);
        Thread.sleep(2000);

        reportDropDown.selectByIndex(2);
        Thread.sleep(2000);

        reportDropDown.selectByIndex(3);
        Thread.sleep(2000);

        reportDropDown.selectByIndex(4);
        Thread.sleep(2000);

        reportDropDown.selectByIndex(5);
        Thread.sleep(2000);

        reportDropDown.selectByIndex(6);
        Thread.sleep(2000);

        reportDropDown.selectByIndex(7);
        Thread.sleep(2000);

        reportDropDown.selectByIndex(8);
        Thread.sleep(2000);

        reportDropDown.selectByIndex(9);
        Thread.sleep(2000);

        reportDropDown.selectByIndex(10);
        Thread.sleep(2000);

        driver.findElement(By.id("Comment")).sendKeys("A-B-C is easy as 1-2-3");
        Thread.sleep(4000);

    }
    @AfterClass
    void driverQuit(){driver.quit();}

}
