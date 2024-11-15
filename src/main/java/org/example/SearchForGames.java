package org.example;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;


public class SearchForGames {

    public WebDriver driver;

    @BeforeClass
    // sets up driver and logs into Roblox
    void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.roblox.com/home");
        driver.manage().window().maximize();

        driver.findElement(By.id("login-username")).sendKeys("[UserName]");
        Thread.sleep(2000);

        driver.findElement(By.id("login-password")).sendKeys("[Password]");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(11000);
    }
    @Test(priority = 1)
    void noGameResult()throws InterruptedException{

        // finds searchbar and puts in a string that will lead to no game being found
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"navbar-search-input\"]"));
        Thread.sleep(2000);
        searchBar.sendKeys("tfvhiwdz");
        Thread.sleep(3000);

        // clicks the experiences option in the search drop down
        WebElement experienceOption = driver.findElement(By.xpath("//*[@id=\"right-navigation-header\"]/div[1]/ul/li[1]/a/span[3]"));
        experienceOption.click();
        Thread.sleep(3000);
        WebElement searchBar1 = driver.findElement(By.xpath("//*[@id=\"navbar-search-input\"]"));
        Thread.sleep(2000);

        // click xButton
        WebElement xButton = driver.findElement(By.xpath("//*[@id=\"right-navigation-header\"]/div[1]/div/form/div/span"));
        xButton.click();
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    // searches for a game using random letters, selects first option and gives it a down vote.
    void searchGameRandom() throws InterruptedException{

        // finds search bar and puts random string in it
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"navbar-search-input\"]"));
        Thread.sleep(2000);
        searchBar.clear();
        // gets random 8 letter long string
        String randomLetters = generateRandomString();
        Thread.sleep(2000);
        searchBar.sendKeys(randomLetters);

        // clicks the experiences option in the search drop down
         WebElement experienceOption = driver.findElement(By.xpath("//*[@id=\"right-navigation-header\"]/div[1]/ul/li[1]/a/span[3]"));
         experienceOption.click();

         Thread.sleep(3000); //SHLUMP MODE

        // finds the first option and clicks on it
        WebElement firstGameOption = driver.findElement(By.cssSelector(".grid-item-container.game-card-container:nth-of-type(1)"));
        firstGameOption.click();

        Thread.sleep(3000);

        // goes back to search page
        driver.navigate().back();

        Thread.sleep(3000);

        // finds the second option and clicks on it
        WebElement secondGameOption = driver.findElement(By.cssSelector(".grid-item-container.game-card-container:nth-of-type(2)"));
        secondGameOption.click();

        Thread.sleep(3000);

        // goes back to search page
        driver.navigate().back();

        Thread.sleep(3000);

        // click xButton
        WebElement xButton = driver.findElement(By.xpath("//*[@id=\"right-navigation-header\"]/div[1]/div/form/div/span"));
        xButton.click();
        Thread.sleep(3000);

    }

     @Test(priority = 3)
    void searchWantedGame() throws InterruptedException{
        // finds searchbar and puts in Monkey Tycoon Game
        WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"navbar-search-input\"]"));
        searchBar.clear();
        Thread.sleep(2000);
        searchBar.sendKeys("Monkey Tycoon");
        Thread.sleep(3000);

        // clicks the experiences option in the search drop down
        WebElement experienceOption = driver.findElement(By.xpath("//*[@id=\"right-navigation-header\"]/div[1]/ul/li[1]/a/span[3]"));
        experienceOption.click();

        Thread.sleep(5500);

        // finds Monkey Tycoon and clicks on it
        WebElement firstGameOption = driver.findElement(By.xpath("//*[@id=\"4055984814\"]"));
        firstGameOption.click();

        Thread.sleep(4000);
    }

    @AfterClass
    void closeScreen(){
        driver.close();
    }

    public String generateRandomString(){
        int length = 4;
        String letters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++){
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }
        return sb.toString();
    }
}
