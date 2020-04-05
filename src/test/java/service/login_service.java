package service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page_obj.first_page;
import page_obj.login_page;

public class login_service {

    public static void login(WebDriver driver,String username,String password ){
        //输入账号  登录框在iframe中，所以先切换到iframe
        //定位iframe
        WebElement ele_login = driver.findElement(By.xpath(".//*[@id='loginDiv']/iframe"));
        driver.switchTo().frame(ele_login);
        //输入账号
        driver.findElement(login_page.send_user).sendKeys(username);
        //输入密码
        driver.findElement(login_page.send_pwd).sendKeys(password);
        driver.findElement(login_page.click_login).click();
        //把driver控制权从iframe转交回去
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(first_page.botton_exit));
        //在登录成功的页面中定位 "退出"元素 存在 返回True
//        boolean exit = driver.findElement(first_page.botton_exit).isEnabled();
//        Assert.assertTrue(exit);
    }
}
