package com.jiang.day1;

import com.sun.org.apache.bcel.internal.ExceptionConstants;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class HomeWork_D2 {
    WebDriver driver;

    @BeforeTest
    public void Before() {
        driver = new FirefoxDriver();
        driver.get("http://10.8.203.72:8888/mms/login.html");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("zmH8kfNd");
        driver.findElement(By.id("login_submit")).click();
    }

    @Test
    //进入发表新帖
    public void test_01() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[text()='博客blogs']")));
        driver.findElement(By.xpath(".//*[text()='博客blogs']")).click();
        driver.findElement(By.xpath(".//*[text()='发表新帖']")).click();
        Thread.sleep(3000);
    }

//    @Test
//    //输入标题，验证50个字符的提示
//    public void test_02() throws InterruptedException {
//        //WebDriverWait wait = new WebDriverWait(driver,10);
//        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/div[1]/div/div/section/div/div[2]/div/div/div/div[3]/div/input")));
//        driver.findElement(By.id("searchBtn")).click();
//        Thread.sleep(3000);
////        //点击添加项目
////        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/section/div/div[2]/div/div/div/div[3]/div/input")).click();
////        Thread.sleep(1000);
////        //点击关闭项目
////        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/section/div/div[2]/div/div/div/div[12]/div/div/div[3]/button[2]")).click();
//        String warn = driver.findElement(By.xpath("//*[@id=\"blog_title_prompt\"]")).getText();
//        Assert.assertEquals(warn, "标题不能为空");
//    }
//
//    @Test
//    //使用isDisplayed 验证是否显示
//    public void test_03() {
//        boolean A = driver.findElement(By.xpath("//*[@id=\"blog_title_prompt\"]")).isDisplayed();
//        Assert.assertTrue(A);
//    }
//
//    @Test
//    //选择select下拉栏中的元素
//    public void test_04() throws InterruptedException {
//        WebElement el1 = driver.findElement(By.id("blog_type"));
//        Select select = new Select(el1);
//        select.selectByVisibleText("其他");
//        String text = el1.getAttribute("value");
//        Assert.assertEquals("04", text);
//    }
//
//    //    @Test
////    //存储一个所属项目,并判断是否存储成功
////    public void test_05() throws InterruptedException {
////        //
////        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/section/div/div[2]/div/div/div/div[3]/div/input")).click();
////        driver.findElement(By.id("add_package")).sendKeys("君龙人寿");
////        driver.findElement(By.id("add_introduce")).sendKeys("服务保险公司");
////        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/section/div/div[2]/div/div/div/div[12]/div/div/div[3]/button[1]")).click();
////        Thread.sleep(1000);
////        String text = driver.findElement(By.id("select2-modelVersion-container")).getText();
////        Assert.assertEquals("君龙人寿", text);
////    }
//    @Test
//    //模拟鼠标拖拽
//    public void test_05() throws InterruptedException {
//        WebElement el1 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/section/div/div[2]/div/div/div/div[5]/div/img"));
//        Actions action = new Actions(driver);
//        action.moveToElement(el1).perform();
//        Thread.sleep(3000);
//    }
//
//    @Test
//    //上传一个图片
//    public void test_06() throws InterruptedException {
//        driver.findElement(By.id("input-b1"))
//                .sendKeys("C:\\Users\\Actionj\\Desktop\\picture\\电子档案库技术逻辑架构图.png");
//        Thread.sleep(2000);
//    }

    @Test
    //Attribute方法联系，
    // 点击下拉框，
    // 选择一个元素，
    // 并通过Attribute进行判断
//    public void test_07() throws InterruptedException, AWTException {
//        WebElement el2 = driver.findElement(By.id("select2-modelVersion-container"));
//        el2.click();
//        WebElement el3 = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
//        el3.sendKeys("君龙人寿");
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        String title = el2.getAttribute("title");
//        Assert.assertEquals("君龙人寿", title);
//        Thread.sleep(2000);
//        //driver 控制权， 转交给alert
//        //Alert alert = driver.switchTo().alert();
//        //将控制权转回去
//        //handle
//        //JS 修改属性值
//        //driver.switchTo().defaultContent();


    @AfterTest
    public void After() {
        driver.quit();
    }
}
