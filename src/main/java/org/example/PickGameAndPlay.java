package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PickGameAndPlay {

    public static WebDriver driver;

    // sets up driver and logs into Roblox
    @BeforeClass
    void setup() throws InterruptedException {

        // Specify the path to your Chrome profile directory
        String profilePath = "[user-data-path]";
        // Set ChromeOptions to use the existing profile
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + profilePath);

        driver = new ChromeDriver(options);
        driver.get("https://www.roblox.com/home");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    void searchForGame() throws InterruptedException{

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

        //play game
        WebElement playGame = driver.findElement(By.cssSelector("button.btn-common-play-game-lg"));
        playGame.click();

        Thread.sleep(8000); // 20 seconds change later
    }

    @Test(priority = 2)
    void getInGame() throws InterruptedException, AWTException {
        // Get the coordinates where you want to move the mouse
        int targetX = 900;
        int targetY = 900;
        int targetX2 = 1261;
        int targetY2 = 1078;
        int targetX3 = 1271;
        int targetY3 = 1075;

        // Create an instance of Robot class
            Robot robotMouse = new Robot();

            Thread.sleep(1000);
            robotMouse.keyPress(KeyEvent.VK_F11);
            Thread.sleep(100);
            robotMouse.keyRelease(KeyEvent.VK_F11);

            // Move the mouse cursor to the target coordinates
            robotMouse.mouseMove(targetX, targetY);
            Thread.sleep(2000);

            // Simulate a mouse click at the target coordinates
            robotMouse.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Press left mouse button
            Thread.sleep(100);
            robotMouse.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Release left mouse button

            Thread.sleep(2000);

            // Move the mouse cursor to the target coordinates
            robotMouse.mouseMove(targetX2, targetY2);
            Thread.sleep(2000);

            // Simulate a mouse click at the target coordinates
            robotMouse.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Press left mouse button
            Thread.sleep(100);
            robotMouse.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Release left mouse button

            // Move the mouse cursor to the target coordinates
            robotMouse.mouseMove(targetX3, targetY3);
            Thread.sleep(2000);

            // Simulate a mouse click at the target coordinates
            robotMouse.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Press left mouse button
            Thread.sleep(100);
            robotMouse.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Release left mouse button
            robotMouse.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Press left mouse button
            Thread.sleep(100);
            robotMouse.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Release left mouse button
            robotMouse.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Press left mouse button
            Thread.sleep(100);
            robotMouse.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Release left mouse button

            // Print a message indicating the mouse has been moved
            System.out.println("Mouse moved to: X = " + targetX2 + ", Y = " + targetY2);
    }

    @Test(priority = 3)
    void playingGame() throws InterruptedException, AWTException {

        Thread.sleep(5000);

        Robot robot = new Robot();

        // move camera
        robot.keyPress(KeyEvent.VK_RIGHT);
        Thread.sleep(3000);
        robot.keyRelease(KeyEvent.VK_RIGHT);

        // walk around
        robot.keyPress(KeyEvent.VK_UP);
        Thread.sleep(3000);
        robot.keyRelease(KeyEvent.VK_UP);

        // get out of full screen
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_F11);
        Thread.sleep(100);
        robot.keyRelease(KeyEvent.VK_F11);

        // hit X button
        int targetX = 2534;
        int targetY = 8;

        // Move the mouse cursor to the target coordinates
        robot.mouseMove(targetX, targetY);
        Thread.sleep(2000);

        // Simulate a mouse click at the target coordinates
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // Press left mouse button
        Thread.sleep(100);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // Release left mouse button

    }

    @AfterClass
    void closeScreen(){
        driver.close();
    }
}
