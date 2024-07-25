
package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Xpath_Css {
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
        driver.manage().window().maximize();
    }

    @Test
    public void Register_01_Empty_Data(){
        //open web link
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //action
        driver.findElement(By.id("txtFirstname")).clear();
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();

        //verify
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");

    }
    @Test
    public void Register_02_Invalid_Email_Address(){
        //action
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen van A");
        driver.findElement(By.id("txtEmail")).sendKeys("123");
        driver.findElement(By.id("txtCEmail")).sendKeys("123");
        driver.findElement(By.id("txtPassword")).sendKeys("Abcd@1234");
        driver.findElement(By.id("txtCPassword")).sendKeys("Abcd@1234");
        driver.findElement(By.id("txtPhone")).sendKeys("0987878787");
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email hợp lệ");

    }
    @Test
    public void Register_03_Incorrect_Confirm_Email(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //action
        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen Van A");
        driver.findElement(By.id("txtEmail")).sendKeys(("abc123@gmail.com"));
        driver.findElement(By.id("txtCEmail")).sendKeys(("abc"));
        driver.findElement(By.id("txtPassword")).sendKeys("Abcd@1234");
        driver.findElement(By.id("txtCPassword")).sendKeys(("Abcd@1234"));
        driver.findElement(By.id("txtPhone")).sendKeys("0987878787");
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText(),"Email nhập lại không đúng");

    }

    @Test
    public void Register_04_Invalid_Password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //action
        driver.findElement(By.xpath("//input[@id='txtFirstname']")).sendKeys("Nguyen van A");
        driver.findElement(By.xpath("//input[@id='txtEmail']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtCEmail']")).sendKeys("abc123@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@id='txtCPassword']")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@id='txtPhone']")).sendKeys("0987878787");
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();
        //Verify
        Assert.assertEquals(driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");

    }
    @Test
    public void Register_05_Incorrect_Confirm_Password(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //action
        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen van A");
        driver.findElement(By.id("txtEmail")).sendKeys("abc123@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("abc123@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("abcd@1234");
        driver.findElement(By.id("txtCPassword")).sendKeys("abd@123");
        driver.findElement(By.id("txtPhone")).sendKeys("0987878787");
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();
        //verify
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");

    }
    @Test
    public void Register_06_Incorrect_Phone_Number(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //phone number is less than 10 characters
        //action
        driver.findElement(By.id("txtFirstname")).sendKeys("Nguyen van A");
        driver.findElement(By.id("txtEmail")).sendKeys("abc123@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("abc123@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("abcd@1234");
        driver.findElement(By.id("txtCPassword")).sendKeys("abd@123");
        driver.findElement(By.id("txtPhone")).sendKeys("0987878");
        driver.findElement(By.xpath("//button[@type='submit' and text()='ĐĂNG KÝ']")).click();
        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");

        //phone number is more than 10 characters
        //action
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("09898989898989899");
        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");
        //start os phone number is invalid
        //action
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("1234567890");
        //verify
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
