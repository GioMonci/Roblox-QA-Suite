package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class RateGame {

    public WebDriver driver;

    // set up environment and login
    @BeforeClass
    void setup() throws InterruptedException {

        // Specify the path to your Chrome profile directory
        String profilePath = "[user-data-path]";
        // Set ChromeOptions to use the existing profile
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + profilePath);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.get("https://www.roblox.com/home");
        Thread.sleep(4000);
    }

    @Test(priority = 1)
    void findGameAndRateOne()throws InterruptedException {

        // find first game on home page
        WebElement findGame = driver.findElement(By.xpath("//*[@id=\"4055984814\"]"));
        findGame.click();
        Thread.sleep(2000);

        // Up Vote
        WebElement upVote = driver.findElement(By.xpath("//*[@id=\"voting-section\"]/div[2]/div/div/div[1]/span"));
        upVote.click();
        Thread.sleep(2000);

        // Refresh changes and go back
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    void findGameAndRateTwo() throws InterruptedException {


        //find second game on home page
        WebElement findGame2 = driver.findElement(By.xpath("//*[@id=\"5316906701\"]"));
        findGame2.click();
        Thread.sleep(2000);

        // Down Vote
        WebElement downVote = driver.findElement(By.xpath("//*[@id=\"voting-section\"]/div[2]/div/div/div[3]/span"));
        downVote.click();
        Thread.sleep(2000);
        // undue
        downVote.click();
        Thread.sleep(2000);

        // Refresh changes and go back
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);

    }

    @Test(priority = 3)
    void findGameAndRateThree() throws InterruptedException {

        //find third game on home page
        WebElement findGame3 = driver.findElement(By.xpath("//*[@id=\"4520164804\"]"));
        findGame3.click();
        Thread.sleep(2000);

        // up vote
        WebElement upVote = driver.findElement(By.xpath("//*[@id=\"voting-section\"]/div[2]/div/div/div[1]/span"));
        upVote.click();
        Thread.sleep(2000);

        // down vote
        WebElement downVote = driver.findElement(By.xpath("//*[@id=\"voting-section\"]/div[2]/div/div/div[3]/span"));
        downVote.click();
        Thread.sleep(2000);

        // undue
        downVote.click();
        Thread.sleep(2000);

        // Refresh changes and go back
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);

    }
    @AfterClass
    void closeScreen(){
        driver.close();
    }
}
