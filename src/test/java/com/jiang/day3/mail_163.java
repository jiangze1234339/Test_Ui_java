package com.jiang.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.rmi.Remote;
import java.util.concurrent.TimeUnit;

//注册失败
public class mail_163 {
    long time = System.currentTimeMillis();
    String phone_number = ("" + time).substring(0, 11);


    WebDriver driver = new FirefoxDriver();

    @BeforeTest
    public void before() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //打开163邮箱网址
        driver.get("https://mail.163.com/");
        //定位 使用账号密码登录
        driver.findElement(By.id("switchAccountLogin")).click();
    }

        @Test
    //登录成功
    public void Login_success(){
        //输入账号  登录框在iframe中，所以先切换到iframe
        //定位iframe
        WebElement ele_login = driver.findElement(By.xpath(".//*[@id='loginDiv']/iframe"));
        driver.switchTo().frame(ele_login);
        //输入账号
        driver.findElement(By.xpath(".//*[@id='account-box']/div[2]/input")).sendKeys("jiangzhe5578");
        //输入密码
        driver.findElement(By.cssSelector("input.j-inputtext.dlpwd")).sendKeys("woaiwojia1");
        driver.findElement(By.linkText("登  录")).click();
        //把driver控制权从iframe转交回去
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("退出")));
        //在登录成功的页面中定位 "退出"元素 存在 返回True
        boolean exit = driver.findElement(By.linkText("退出")).isEnabled();
        Assert.assertTrue(exit);
    }
    //发送邮件
    @Test
    public void Send_mail() throws InterruptedException, AWTException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("li.js-component-component.ra0.mD0")).click();
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("1045037872@qq.com");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
//        Thread.sleep(2000);
        //没定位到
//        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("11111111111");
        driver.findElement(By.xpath(".//*[@class='qa0']/div[2]/div[1]/div[1]/div[1]/input")).sendKeys("1111111111111");
        driver.findElement(By.xpath(".//*[@class='fv0']/div[2]/input")).sendKeys("C:\\Users\\Actionj\\Desktop\\新建文本文档.txt");
        Thread.sleep(2000);
        WebElement ele_frame = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(ele_frame);
        driver.findElement(By.xpath("/html/body")).sendKeys("123");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath(".//*[@class='jp0']/div[1]/span[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[text()='发送成功']")));
        Boolean bool = driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(bool);
    }
//    @Test
//    //登录失败
//    public void Login_failed() {
//        //输入账号  登录框在iframe中，所以先切换到iframe
//        //定位iframe
//        WebElement ele_login = driver.findElement(By.xpath(".//*[@id='loginDiv']/iframe"));
//        driver.switchTo().frame(ele_login);
//        //输入账号
//        driver.findElement(By.xpath(".//*[@id='account-box']/div[2]/input")).sendKeys("jiangzhe5578");
//        //输入密码
//        driver.findElement(By.cssSelector("input.j-inputtext.dlpwd")).sendKeys("666666");
//        driver.findElement(By.linkText("登  录")).click();
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ferrorhead")));
//        String text = driver.findElement(By.className("ferrorhead")).getText();
//        Assert.assertEquals(text, "帐号或密码错误");
//    }

//    //注册失败
//    @Test
//    public void regist_failed() throws InterruptedException {
//        //定位iframe
//        WebElement ele_login = driver.findElement(By.xpath(".//*[@id='loginDiv']/iframe"));
//        driver.switchTo().frame(ele_login);
//        driver.findElement(By.id("changepage")).click();
//        Thread.sleep(2000);
////        driver.switchTo().defaultContent();
//        String handle = driver.getWindowHandle();
//        for (String handles : driver.getWindowHandles()) {
//            if (handles.contentEquals(handle)) {
//                continue;
//            } else {
//                driver.switchTo().window(handles);
//            }
//        }
////        WebDriverWait wait = new WebDriverWait(driver,30);
////        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/div/div/div[1]/h2")));
////        driver.findElement(By.xpath(".//*[@class='m-body']/div[1]/input")).sendKeys("jiangzhe45786");
//        driver.findElement(By.xpath(".//*[@class='m-body']/div[2]/input")).sendKeys("woaiwojia1");
//        driver.findElement(By.xpath(".//*[@class='m-body']/div[3]/input")).sendKeys(phone_number);
//        driver.findElement(By.xpath(".//*[@class='m-body']/div[4]/span")).click();
//        driver.findElement(By.className("j-register")).click();
//        WebDriverWait wait2 = new WebDriverWait(driver, 5);
//        wait2.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@class='m-body']/div[3]/div[2]")));
////        String text = driver.findElement(By.xpath(".//*[@class='m-body']/div[3]/div[2]")).getText();
//        String text = driver.findElement(By.xpath(".//*[@class='m-body']/div[1]/div[2]")).getText();
//        Assert.assertEquals(text,"邮箱地址不能为空");
//        Thread.sleep(3000);
//    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}
