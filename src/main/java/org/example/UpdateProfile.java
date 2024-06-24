package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class UpdateProfile {
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
    void updateProfile() throws InterruptedException {

        driver.findElement(By.id("login-username")).sendKeys("dissolvd");
        Thread.sleep(2000);

        driver.findElement(By.id("login-password")).sendKeys("cheesecat123");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(11000);

        driver.findElement(By.xpath("//*[@id=\"nav-profile\"]/span")).click();
        Thread.sleep(7000);

        // clicks edit
        WebElement edit = driver.findElement(By.xpath("//*[@id=\"about\"]/div[1]/profile-description/div/div[1]/div/button/span"));
        edit.click();
        Thread.sleep(2000);

        // find textbox
        WebElement textbox = driver.findElement(By.xpath("//*[@id=\"descriptionTextBox\"]"));
        textbox.clear();
        Thread.sleep(2000);
        textbox.sendKeys("Software Testing");

        driver.findElement(By.xpath("//*[@id=\"SaveInfoSettings\"]")).click();
        Thread.sleep(2000);

    }
    @AfterClass
    void driverQuit(){driver.quit();}
}
