package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.nio.file.attribute.UserDefinedFileAttributeView;

public class TestSettingsInBrowser {

    public WebDriver driver;

    @BeforeClass
    void setup() throws InterruptedException {

        // set up environment and login
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
    void getToSettings() throws InterruptedException {

        // click settings cog
        WebElement getSettingsCog = driver.findElement(By.xpath("//*[@id=\"nav-settings\"]"));
        getSettingsCog.click();
        Thread.sleep(2000);

        // click settings tab
        WebElement getSettingsTab = driver.findElement(By.xpath("//*[@id=\"settings-popover-menu\"]/li[1]/a"));
        getSettingsTab.click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    void accountInfo() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");

        Thread.sleep(2000);

        // select gender, female then male
        WebElement femaleGender = driver.findElement(By.xpath("//*[@id=\"gender-selector\"]/div/button[2]/div"));
        femaleGender.click();
        Thread.sleep(2000);


        WebElement maleGender = driver.findElement(By.xpath("//*[@id=\"gender-selector\"]/div/button[1]/div"));
        maleGender.click();
        Thread.sleep(2000);


        // change theme
        WebElement themeDropBox = driver.findElement(By.xpath("//*[@id=\"theme-dropdown\"]/div/select"));
        themeDropBox.click();
        Thread.sleep(2000);


        WebElement darkMode = driver.findElement(By.xpath("//*[@id=\"theme-dropdown\"]/div/select/option[2]"));
        darkMode.click();
        Thread.sleep(2000);

    }

    @Test(priority = 3)
    void privacy_Settings() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-700)");

        // get to privacy tab
        WebElement privacyTab = driver.findElement(By.id("privacy"));
        privacyTab.click();
        Thread.sleep(2000);

        // click on communication drop down
        WebElement communicationDrop = driver.findElement(By.xpath("//*[@id=\"communication-privacy-master-setting\"]/div/select"));
        communicationDrop.click();
        Thread.sleep(2000);

        // custom
        WebElement customCommunication = driver.findElement(By.xpath("//*[@id=\"communication-privacy-master-setting\"]/div/select/option[2]"));
        customCommunication.click();
        Thread.sleep(2000);

        // default
        WebElement defaultCommunication = driver.findElement(By.xpath("//*[@id=\"communication-privacy-master-setting\"]/div/select/option[1]"));
        defaultCommunication.click();
        Thread.sleep(2000);
    }

    @AfterClass
    void closeScreen(){
        driver.close();
    }

}
