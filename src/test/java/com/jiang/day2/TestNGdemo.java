package com.jiang.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestNGdemo {
    //信任能力 实例化
    WebDriver driver;
    //    @BeforeTest
//    public void Before() {
//        driver = new FirefoxDriver();
//        driver.get("http://10.8.203.72:8888/mms/login.html");
//        driver.findElement(By.name("username")).sendKeys("admin");
//        driver.findElement(By.name("password")).sendKeys("zmH8kfNd");
//        driver.findElement(By.id("login_submit")).click();
//    }

    @DataProvider(name = "data")
    public Object[][] test() {
        return new Object[][]{
                {"firefox","http://10.251.4.192:5555"},
                {"chrome","http://10.251.4.192:6666"}
        };
    }

    @Test(dataProvider = "data")
    public void test_01(String browserType, String Url) throws MalformedURLException {
        if (browserType.contentEquals("firefox")) {
            //选择浏览器类型
            DesiredCapabilities dc = DesiredCapabilities.firefox();
            //建立远程连接
            driver = new RemoteWebDriver(new URL(Url + "/wd/hub"), dc);
            test_02(driver);
        } else if (browserType.contentEquals("chrome")) {
            DesiredCapabilities dc = DesiredCapabilities.chrome();
            driver = new RemoteWebDriver(new URL(Url + "/wd/hub"), dc);
            test_02(driver);
        } else {
            System.out.println("error");
        }
    }

    public void test_02(WebDriver driver) {
        driver.get("http://10.8.203.72:8888/mms/login.html");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("zmH8kfNd");
        driver.findElement(By.id("login_submit")).click();
        driver.quit();
    }
//    @AfterTest
//    public void After(){
//        driver.quit();
//    }
}
