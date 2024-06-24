package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;


public class RegisterUser {
    public WebDriver cdriver;
    @BeforeClass
    void setup() throws InterruptedException{
        cdriver = new ChromeDriver();
        cdriver.get("https://www.roblox.com/home");
        cdriver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement hyperLinkTest = cdriver.findElement(By.linkText("Sign Up"));
        hyperLinkTest.click();
    }

    @Test(priority = 1)
    //@Ignore
    void invalid_dob() throws InterruptedException{
        //cdriver = new ChromeDriver();
        //cdriver.get("https://www.roblox.com/home");
        //cdriver.manage().window().maximize();
        Thread.sleep(2000);
        //INVALID BIRTHDAY
        WebElement dropElement1 = cdriver.findElement(By.id("MonthDropdown"));
        Select monthDropDown = new Select(dropElement1);
        monthDropDown.selectByIndex(2);
        Thread.sleep(2000);
        WebElement dropElement2 = cdriver.findElement(By.id("DayDropdown"));
        Select dayDropDown = new Select(dropElement2);
        dayDropDown.selectByIndex(31);
        Thread.sleep(2000);
        WebElement dropElement3 = cdriver.findElement(By.id("YearDropdown"));
        Select yearDropDown = new Select(dropElement3);
        yearDropDown.selectByIndex(20);
        Thread.sleep(2000);
        //cdriver.close();

    }
    @Test(priority = 2)
    //@Ignore
    void taken_username() throws InterruptedException{
        //cdriver = new ChromeDriver();
        //cdriver.get("https://www.roblox.com");
        //cdriver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement dropElement1 = cdriver.findElement(By.id("MonthDropdown"));
        Select monthDropDown = new Select(dropElement1);
        monthDropDown.selectByIndex(2);
        //Thread.sleep(2000);
        WebElement dropElement2 = cdriver.findElement(By.id("DayDropdown"));
        Select dayDropDown = new Select(dropElement2);
        dayDropDown.selectByIndex(28);
        //Thread.sleep(2000);
        WebElement dropElement3 = cdriver.findElement(By.id("YearDropdown"));
        Select yearDropDown = new Select(dropElement3);
        yearDropDown.selectByIndex(20);
        //Thread.sleep(2000);
        cdriver.findElement(By.id("signup-username")).sendKeys("Roblox");
        //cdriver.close();


    }
    @Test(priority = 3)
    void invalid_password_creation() throws InterruptedException{
        //cdriver = new ChromeDriver();
        //cdriver.get("https://www.roblox.com");
        //cdriver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement dropElement1 = cdriver.findElement(By.id("MonthDropdown"));
        Select monthDropDown = new Select(dropElement1);
        monthDropDown.selectByIndex(2);
        //Thread.sleep(2000);
        WebElement dropElement2 = cdriver.findElement(By.id("DayDropdown"));
        Select dayDropDown = new Select(dropElement2);
        dayDropDown.selectByIndex(28);
        //Thread.sleep(2000);
        WebElement dropElement3 = cdriver.findElement(By.id("YearDropdown"));
        Select yearDropDown = new Select(dropElement3);
        yearDropDown.selectByIndex(20);
        //Thread.sleep(2000);
        cdriver.findElement(By.id("signup-username")).clear();
        cdriver.findElement(By.id("signup-username")).sendKeys("StestingCharacter1");
        cdriver.findElement(By.id("signup-password")).sendKeys("hello");
        WebElement show_password_button = cdriver.findElement(By.xpath("//*[@id=\"signup\"]/div/div/div/div[3]/div"));
        show_password_button.click();
        Thread.sleep(2000);
        //cdriver.close();

    }
    @Test(priority = 4)
    //@Ignore
    void registercorrectuser() throws InterruptedException {
        //cdriver = new ChromeDriver();
        //cdriver.get("https://www.roblox.com");
        //cdriver.manage().window().maximize();
        Thread.sleep(2000);
        //BIRTHDATE
        WebElement dropElement1 = cdriver.findElement(By.id("MonthDropdown"));
        Select monthDropDown = new Select(dropElement1);
        monthDropDown.selectByIndex(4);
        //Thread.sleep(2000);
        WebElement dropElement2 = cdriver.findElement(By.id("DayDropdown"));
        Select dayDropDown = new Select(dropElement2);
        dayDropDown.selectByIndex(11);
        //Thread.sleep(2000);
        WebElement dropElement3 = cdriver.findElement(By.id("YearDropdown"));
        Select yearDropDown = new Select(dropElement3);
        yearDropDown.selectByIndex(20);
        //Thread.sleep(2000);
        //GENDER
        WebElement genderButton1 = cdriver.findElement(By.id("FemaleButton"));
        genderButton1.click();
        Thread.sleep(2000);
        WebElement genderButton2 = cdriver.findElement(By.id("MaleButton"));
        genderButton2.click();
        Thread.sleep(2000);
        //USERNAME and password
        cdriver.findElement(By.id("signup-username")).clear();
        cdriver.findElement(By.id("signup-username")).sendKeys("STestingCharacter10");
        cdriver.findElement(By.id("signup-password")).clear();
        cdriver.findElement(By.id("signup-password")).sendKeys("Softwaretestingclassproject2024");
        Thread.sleep(2000);
        WebElement sign_up_button = cdriver.findElement(By.id("signup-button"));
        sign_up_button.click();
        Thread.sleep(11000);
    }
    @AfterClass
    void close_screen() throws InterruptedException
    {
        cdriver.close();
    }
}

