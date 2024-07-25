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
    //các câu lệnh để thao tác với trình duyêt: driver.
    WebDriver driver;
    //các câu lệnh để thao tác với element: element.
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
        public void TC_01_(){
            // mở ra 1 url
            driver.get("https://facebook.com/");
            //đóng tab của trình duyệt
            driver.close();
            //đóng trình duyệt
            driver.quit();
            //đi tìm WebElement theo loại By nào


    }
    @Test
        public void TC_02_(){

        }
    @Test
        public void TC_03_(){

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
