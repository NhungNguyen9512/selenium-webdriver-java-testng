package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_08_Textbox_TextArea {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
        public void Login_01_Empty_Email_Password(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title = 'My Account']")).click();
        sleepInSecond(3);
        driver.findElement(By.xpath("//button[@title='Login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),"This is a required field.");
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),"This is a required field.");
    }
    @Test
    public void Login_02_Invalid_Email() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title = 'My Account']")).click();
        sleepInSecond(3);
        driver.findElement(By.xpath("//ul[@class='form-list']//input[@type='email']")).sendKeys("1234@1234");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");
        driver.findElement(By.xpath("//div[@class='buttons-set']/button[@type='submit']")).click();

        }
    @Test
        public void Login_03_Invalid_Password(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title = 'My Account']")).click();
        sleepInSecond(3);
        driver.findElement(By.xpath("//ul[@class='form-list']//input[@type='email']")).sendKeys("abcd@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123");
        driver.findElement(By.xpath("//div[@class='buttons-set']/button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(),"Please enter 6 or more characters without leading or trailing spaces.");
    }
    @Test
    public void Login_04_Invalid_Email_Or_Password(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title = 'My Account']")).click();
        sleepInSecond(3);
        driver.findElement(By.xpath("//ul[@class='form-list']//input[@type='email']")).sendKeys("abcd@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//div[@class='buttons-set']/button[@type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText(),"Invalid login or password.");
    }
    @Test
    public void Login_05_Success(){
        //register
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title = 'My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSecond(2);

        String firstName = "Nhung", lastName = "test", pass = "123456"

        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys();
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys();
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys();
        driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys();
        driver.findElement(By.xpath("//button[@title='Register']")).click();
        sleepInSecond(3);
        //login

        //verify acc

    }
    public void sleepInSecond(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
