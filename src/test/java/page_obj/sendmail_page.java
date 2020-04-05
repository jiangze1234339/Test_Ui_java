package page_obj;

import org.openqa.selenium.By;

public class sendmail_page {
    //点击写信
    public static By button_write = By.cssSelector("li.js-component-component.ra0.mD0");
    //收件人输入框
    public static By input_receive = By.className("nui-editableAddr-ipt");
    //主题输入栏
    public static By input_zhuti = By.xpath(".//*[@class='qa0']/div[2]/div[1]/div[1]/div[1]/input");
    //附件输入栏
    public static By input_fujian = By.xpath(".//*[@class='fv0']/div[2]/input");
    //内容frame
    public static By content_frame = By.className("APP-editor-iframe");
    //输入内容
    public static By input_content = By.xpath("/html/body");
    //发送按钮
    public static By botton_send = By.xpath(".//*[@class='jp0']/div[1]/span[2]");
    //显示等待
    public static By send_ok = By.xpath(".//*[text()='发送成功']");

}
