package org.example;
import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomizeAvatar {

    public WebDriver driver;
    @BeforeClass
    void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.roblox.com/home");
        driver.manage().window().maximize();
        driver.findElement(By.id("login-username")).sendKeys("[UserName]");
        Thread.sleep(2200);
        driver.findElement(By.id("login-password")).sendKeys("[Password]");
        Thread.sleep(3500);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(11000);
    }
    @Test(priority = 1)
    void character_customization() throws InterruptedException{
        // resolution size - uncomment if small screen
        //driver.findElement(By.xpath("//*[@id=\"header-menu-icon\"]/button[2]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"nav-character\"]/span")).click();
        Thread.sleep(2200);
        //driver.findElement(By.xpath("//*[@id=\"recent-items-container\"]/div[1]/ul/li[24]/div/div/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@data-item-name='True Blue Hair']")).click();
        Thread.sleep(6000);
    }
    @Test(priority = 2)
    void change_skin_tone() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id=\"head-&-body-dropdown\"]/span")).click();
        Thread.sleep(2400);
        driver.findElement(By.xpath("//*[@id=\"avatar-container\"]/div/div/div[7]/div[1]/div/div/div[2]/div/ul/li[2]")).click();
        Thread.sleep(2100);
        driver.findElement(By.xpath("//*[@id=\"bodyColors\"]/div/div/div[21]")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 3)
    void equip_knight() throws InterruptedException
    {
        driver.findElement(By.xpath("//*[@id=\"characters-dropdown\"]/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"avatar-container\"]/div/div/div[7]/div[1]/div/div/div[2]/div/ul/li[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"costumes\"]/div[2]/div[1]/ul/li[1]/div/div/div[1]/a")).click();
        Thread.sleep(5000);
    }

    @AfterClass
    void close_screen(){

        driver.close();
    }
}



