package org.example;

import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
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
    void correctCrendentials() throws InterruptedException {

        driver.findElement(By.id("login-username")).sendKeys("[UserName]");
        Thread.sleep(2000);

        driver.findElement(By.id("login-password")).sendKeys("[Password]");
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
    @Test (priority = 1)
    void wrongCrendentials() throws InterruptedException {

        driver.findElement(By.id("login-username")).sendKeys("someonesusername");
        Thread.sleep(2000);

        driver.findElement(By.id("login-password")).sendKeys("arandompassword");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

    }
    @Test (priority = 2)
    void correctPassword() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.findElement(By.id("login-username")).sendKeys("someonesusername");
        Thread.sleep(2000);

        driver.findElement(By.id("login-password")).sendKeys("[Password]");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

    }
    @Test (priority = 3)
    void correctUsername() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.findElement(By.id("login-username")).sendKeys("[UserName]");
        Thread.sleep(2000);

        driver.findElement(By.id("login-password")).sendKeys("arandompassword");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

    }
    @Test (priority = 4)
    void blankCrendentials() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

    }
    @Test (priority = 5)
    void blankPassword() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.findElement(By.id("login-username")).sendKeys("[UserName]");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

    }
    @Test (priority = 5)
    void blankUsername() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.findElement(By.id("login-password")).sendKeys("[Password]");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(3000);

    }
    @AfterClass
    void driverQuit(){driver.quit();}

}
