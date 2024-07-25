package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test
        public void TC_01_Id(){
        driver.findElement(By.id("FirstName")).sendKeys("Nhung");

    }
    @Test
        public void TC_02_Class(){
        driver.findElement(By.className("header-logo"));
        }
    @Test
        public void TC_03_Name(){
        driver.findElement(By.name("DateOfBirthDay"));
    }
    @Test
    public void TC_04_TagName(){
        driver.findElements(By.tagName("input"));
    }
    @Test
    public void TC_05_LinkText(){
    driver.findElement(By.linkText("Shipping & returns"));
    }
    @Test
    public void TC_06_Partial_LinkText(){
    driver.findElement(By.partialLinkText("vendor account"));
    }
    @Test
    public void TC_07_Css(){
        //css with ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));
        // css with class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));
        //css with name
        driver.findElement(By.cssSelector("input[name='FirstName']"));
        //css with tagName
        driver.findElement((By.cssSelector("input")));
        //css with link
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));
        //css with partial link
        driver.findElement(By.cssSelector("a[href^='/customer/addresses']"));
        //driver.findElement(By.cssSelector("a[href*='addresses']"));
        //driver.findElement(By.cssSelector("a[href$='addresses']"));

    }
    @Test
    public void TC_08_Xpath(){

    }

//    @AfterClass
//    public void afterClass() {
//        driver.quit();
//    }


}
