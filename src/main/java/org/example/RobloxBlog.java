package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class RobloxBlog {

    public WebDriver driver;

    @BeforeClass
    void setup() throws InterruptedException {

        // set up environment and login
        driver = new ChromeDriver();
        driver.get("https://www.roblox.com/home");
        driver.manage().window().maximize();

        driver.findElement(By.id("login-username")).sendKeys("dissolvd");
        Thread.sleep(2000);

        driver.findElement(By.id("login-password")).sendKeys("cheesecat123");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(11000);
    }

    @Test(priority = 1)
    void getToBlog() throws InterruptedException {

        // Click on Blog Tab
        WebElement blogTab = driver.findElement(By.xpath("//*[@id=\"nav-blog\"]"));
        blogTab.click();
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);

    }

    @Test(priority = 2)
    void filterByCommunity()throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //filter articles by community
        WebElement filter = driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div[1]/div/fieldset[1]/div/button"));
        filter.click();

        WebElement community = driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div[1]/div/fieldset[1]/div/ul/li[3]/a"));
        community.click();
        Thread.sleep(2000);

        // click an article
        WebElement clickArticle = driver.findElement(By.xpath("//*[@id=\"post-209762\"]/a/div[1]/div"));
        clickArticle.click();
        Thread.sleep(2000);

        // scroll down
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(4000);

        // go back
        driver.navigate().back();
        Thread.sleep(2000);

    }

    @Test(priority = 3)
    void filterByCreators() throws InterruptedException{

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //filter articles by creators

        WebElement filter = driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div[1]/div/fieldset[1]/div/button"));
        filter.click();

        WebElement creator = driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div[1]/div/fieldset[1]/div/ul/li[4]/a"));
        creator.click();

        // click an article
        WebElement clickArticle = driver.findElement(By.xpath("//*[@id=\"post-209710\"]/a/div[1]/div"));
        clickArticle.click();
        Thread.sleep(2000);


        // scroll down
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(4000);

        // go back
        driver.navigate().back();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    void manualSearch() throws InterruptedException{

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // click on search bar
        WebElement search = driver.findElement(By.xpath("//*[@id=\"s\"]"));
        search.sendKeys("Future");
        Thread.sleep(2000);

        // Hit Enter Key with Robot
        try{
            Robot robot = new Robot();
            // Press the Enter key
            robot.keyPress(KeyEvent.VK_ENTER);
            // Release the Enter key
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e){
            e.printStackTrace();
        }
        Thread.sleep(8000);

        // click an article
        WebElement clickArticle = driver.findElement(By.xpath("//*[@id=\"post-43620\"]/a/div[1]/div"));
        clickArticle.click();
        Thread.sleep(2000);

        // scroll down
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(4000);
    }

    @AfterClass
    void closeScreen(){
        driver.quit();
    }
}
