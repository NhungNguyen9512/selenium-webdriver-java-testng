package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_WebElement_Commands_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Display() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if(driver.findElement(By.xpath("//input[@id ='email']")).isDisplayed()){
            driver.findElement(By.xpath("//input[@id ='email']")).sendKeys("Automation testing");
            System.out.println("Email text box is displayed");
        } else {
            System.out.println("Email text box is not displayed");

        }

        if(driver.findElement(By.xpath("//input[@id='over_18']")).isDisplayed()){
            driver.findElement(By.xpath("//input[@id='over_18']")).click();
            System.out.println("Over 18 radio button is displayed");
        }else{
            System.out.println("Over 18 radio button is NOT displayed");
        }

        if(driver.findElement(By.xpath("//textarea[@id='edu']")).isDisplayed()){
            driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("Automation testing");
            System.out.println("Education is displayed");
        }else {
            System.out.println("Education is not displayed");
        }

        if(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()){
            System.out.println("User h5 is displayed");
        }else{
            System.out.println("User h5 is NOT displayed");
        }
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id ='email']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='over_18']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//textarea[@id='edu']")).isDisplayed());

        Assert.assertFalse(driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed());
    }
    @Test
    public void TC_02_Enable(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id ='email']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='over_18']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//textarea[@id='edu']")).isEnabled());


        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='job1']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='job2']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Development']")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='slider-1']")).isEnabled());

       Assert.assertTrue(driver.findElement(By.xpath("//input[@id='password']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='radio-disabled']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//textarea[@id='bio']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//select[@id='job3']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='check-disbaled']")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='slider-2']")).isEnabled());




    }
    @Test
    public void TC_03_Display(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//input[@id='under_18']")).click();
        driver.findElement(By.xpath("//input[@id='java']")).click();
        if(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected()){
            System.out.println("Có: Element is selected");

        }else {
            System.out.println("Không: Element is de-selected");
        }
        if(driver.findElement(By.xpath("//input[@id='java']")).isSelected()){
            System.out.println("Có: Element is selected");
        }else{
            System.out.println("Không: Element is de-selected");
        }

    }
    @Test
    public void TC_04_Display(){
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abcd@gmail.com");
        //password = number
        driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("123");
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//li[@class='username-check completed']")).isDisplayed());
//        password = lowercase
//        driver.findElement(By.xpath("//input[@id='email']")).clear();
//        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc");
//        //verrify....
    }

    public void sleepInSecond(int timeInSecond){
        try {
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }


}
