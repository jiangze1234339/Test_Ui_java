package com.jiang.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test_grid {
    @Test
    public void testChrome() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        WebDriver driver = new RemoteWebDriver(new URL("http://10.251.4.192:4444/wd/hub"), dc);
        driver.get("https://www.baidu.com");
        driver.quit();
    }


}
