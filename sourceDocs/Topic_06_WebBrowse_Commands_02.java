package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowse_Commands_01 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
        public void TC_01_Page_Url(){

    }
    @Test
    public void TC_02_Page_Title(){

    }
    @Test
    public void TC_03_Page_Navigation(){

    }
    @Test
    public void TC_04_Page_Source(){

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
