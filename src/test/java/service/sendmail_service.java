package service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_obj.sendmail_page;

import java.awt.*;
import java.awt.event.KeyEvent;

public class sendmail_service {
    public static void sssend(WebDriver driver,String receive_user) throws InterruptedException, AWTException {
        Thread.sleep(2000);
        //点击写信
        driver.findElement(sendmail_page.button_write).click();
        //收件人输入框
        driver.findElement(sendmail_page.input_receive).sendKeys(receive_user);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
//        Thread.sleep(2000);
        //没定位到
//        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("11111111111");
        //主题输入栏
        driver.findElement(sendmail_page.input_zhuti).sendKeys("1111111111111");
        //附件输入栏
        driver.findElement(sendmail_page.input_fujian).sendKeys("C:\\Users\\Actionj\\Desktop\\新建文本文档.txt");
        Thread.sleep(2000);
        //定位输入内容体的iframe
        WebElement ele_frame = driver.findElement(sendmail_page.content_frame);
        //切换到iframe
        driver.switchTo().frame(ele_frame);
        //输入内容
        driver.findElement(sendmail_page.input_content).sendKeys("123");
        //切换回来
        driver.switchTo().defaultContent();
        //点击发送
        driver.findElement(sendmail_page.botton_send).click();
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(sendmail_page.send_ok));
    }
}
