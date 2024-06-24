package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class PurchaseItems {
    public WebDriver driver;
    @BeforeClass
    void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.roblox.com/home");
        driver.manage().window().maximize();
        driver.findElement(By.id("login-username")).sendKeys("STestingCharacter9");
        Thread.sleep(2000);
        driver.findElement(By.id("login-password")).sendKeys("Softwaretestingclassproject2024");
        Thread.sleep(3000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(11000);
        driver.findElement(By.linkText("Marketplace")).click();
        Thread.sleep(2000);
        //Free Items
        WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"search-options\"]/form/div/div[2]/div/div[8]/ul/li[3]/label"));
        ((JavascriptExecutor) driver).executeScript(("arguments[0].scrollIntoView(true);"), targetElement);
        Thread.sleep(1000);
        targetElement.click();
        Thread.sleep(5000);
    }
    @Test(priority = 3)
    void purchase_knight_of_redcliff() throws InterruptedException{

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@title='Knights of Redcliff: Paladin']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-btn-entry\"]/div[2]/button/div/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-btn-entry\"]/div[2]/div/div/div[3]/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"rbx-body\"]/div[18]/div[2]/div/div/div[3]/div[2]/button[1]"));
        driver.navigate().back();
        Thread.sleep(5000);

    }
    @Test(priority = 1)
    void add_to_cart() throws InterruptedException
    {
        Actions actions = new Actions(driver);
        WebElement test = driver.findElement(By.xpath("//*[@id=\"results\"]/ul/li[2]/a/div[1]/div"));
        actions.moveToElement(test).moveToElement(driver.findElement(By.xpath("//*[@id=\"results\"]/ul/li[2]/a/div[1]/div/div/button[1]"))).click().build().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-btn-entry\"]/div[2]/button/div/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-btn-entry\"]/div[2]/div/div/div[3]/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"rbx-body\"]/div[18]/div[2]/div/div/div[3]/div[2]/button[1]")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    void remove_from_cart() throws InterruptedException
    {
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement test = driver.findElement(By.xpath("//*[@id=\"results\"]/ul/li[2]/a/div[1]/div"));
        actions.moveToElement(test).moveToElement(driver.findElement(By.xpath("//*[@id=\"results\"]/ul/li[2]/a/div[1]/div/div/button[1]"))).click().build().perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-btn-entry\"]/div[2]/button/div/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-btn-entry\"]/div[2]/div/div/div[2]/div[1]/div[2]/div/div/div/div/div/div[2]/button")).click();
        Thread.sleep(3000);
    }
    @AfterClass
    void close_screen() throws InterruptedException
    {
        driver.close();
    }
}
