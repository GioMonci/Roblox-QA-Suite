package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Logout {
    public WebDriver driver;
    // a method used to make the code less redundant
    @BeforeClass
    void setup() throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("https://www.roblox.com/login");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    @Test
    void logOut() throws InterruptedException {

        driver.findElement(By.id("login-username")).sendKeys("dissolvd");
        Thread.sleep(2000);

        driver.findElement(By.id("login-password")).sendKeys("cheesecat123");
        Thread.sleep(3000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(11000);

        driver.findElement(By.id("nav-settings")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"settings-popover-menu\"]/li[5]/a")).click();
        Thread.sleep(4000);

        // only occurs when the account lacks an email
        driver.findElement(By.xpath("//*[@id=\"rbx-body\"]/div[18]/div[2]/div/div/div[3]/div/button[2]")).click();
        Thread.sleep(3000);

    }
    @AfterClass
    void driverQuit(){driver.quit();}
}
