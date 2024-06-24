package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class JoinGroup {
    public WebDriver driver;
    @BeforeClass
    void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.roblox.com/home");
        driver.manage().window().maximize();
        driver.findElement(By.id("login-username")).sendKeys("STestingCharacter2");
        Thread.sleep(2500);
        driver.findElement(By.id("login-password")).sendKeys("Softwaretestingclassproject2024");
        Thread.sleep(4000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(11000);
    }
    @Test(priority = 1)
    void searchforgroup() throws InterruptedException
    {
        // Resolution
        //driver.findElement(By.xpath("//*[@id=\"header-menu-icon\"]/button[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("nav-group")).click();
        driver.findElement(By.id("GroupSearchField")).sendKeys("Team Blue Monkey");
        driver.findElement(By.id("GroupSearchButton"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"group-search-container\"]/div/div[3]/ul/group-result-card[1]/li/a/div/div[1]/div[1]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"group-join-button\"]")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    void make_primary() throws  InterruptedException
    {
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"group-container\"]/div/div/div[2]/div/div[1]/div[2]/div[3]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"make-primary\"]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"make-primary-button\"]")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 3)
    void leave_group() throws  InterruptedException
    {
        driver.findElement(By.xpath("//*[@id=\"group-container\"]/div/div/div[2]/div/div[1]/div[2]/div[3]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"leave-group\"]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"leave-group-button\"]")).click();
        Thread.sleep(3000);
    }

    @AfterClass
    void closeScreen(){
        driver.close();
    }

}
