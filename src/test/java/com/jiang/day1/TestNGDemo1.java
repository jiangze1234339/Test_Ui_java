package com.jiang.day1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
public class TestNGDemo1 {
    WebDriver driver;
    @Test
    public void test_01() throws AWTException, InterruptedException {
        driver = new FirefoxDriver();
        driver.get("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=2&pn=0&spn=0&di=8030&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=1035415831%2C1465727770&os=2036467054%2C2328224179&simid=4030878874%2C470441821&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=%E5%9B%BE%E7%89%87&objurl=http%3A%2F%2Fa3.att.hudong.com%2F68%2F61%2F300000839764127060614318218_950.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3F4_z%26e3B6zan0c_z%26e3Bv54AzdH3FkkfAzdH3Fp5rtv_z%26e3Bwfrx%3Ft1%3Dd8ln08c&gsm=1&islist=&querylist=");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("span.bar-btn.btn-download")));
        driver.findElement(By.cssSelector("span.bar-btn.btn-download")).click();
        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);


        }
    @AfterTest
    public void After(){
        driver.quit();
    }
}
