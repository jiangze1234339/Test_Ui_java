package com.jiang.day1;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class Testdriver {
    WebDriver driver;

    @BeforeTest
    public void Before() {
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
    }

    //    @Test
//    public void driver_open() {
//        //WebDriver Chrom_driver = new ChromeDriver();
//        //WebDriver Fire_driver = new FirefoxDriver();
//        driver.get("https://www.baidu.com");
//        String bd_url = driver.getCurrentUrl();
//        System.out.println("获取到的URL" + bd_url);
//        Assert.assertEquals(bd_url, "https://www.baidu.com/");
//    }
    @Test
    public void test_01() throws InterruptedException {
        //八种定位方式
        //1.id
        String input = "kw";
        driver.findElement(By.id(input)).sendKeys("selenium");
        Thread.sleep(3000);

    }

    //    @Test
//    //2.name
//    public void elements_by_name() throws InterruptedException {
//        driver.findElement(By.name("wd")).clear();
//        Thread.sleep(3000);
//    }
    @Test
    //3.class name  因为button元素中的class含有空格，所以用css代替class
    // 原<input id = 'su' class = "bg s_btn"> 用css:input.bg.s_btn替换 用.来替换空格
    public void test_02() throws InterruptedException {
        driver.findElement(By.cssSelector("input.bg.s_btn")).click();
        Thread.sleep(3000);
    }

    @Test
    //4.tagname
    public void test_03() throws InterruptedException {
        driver.findElement(By.linkText("图片")).click();
        Thread.sleep(3000);
    }

    @Test
    //截屏方法
    public void test_04()

    {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat df = new SimpleDateFormat("MM-dd_HH.mm");
        String data_name = df.format(new Date());
        System.out.print(data_name);
        try {
            FileUtils.copyFile(file, new File("picture/" + data_name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //5.xpath
    public void test_05() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/a[1]")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void After() {
        driver.quit();
    }
}
