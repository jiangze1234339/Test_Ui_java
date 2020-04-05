package page_obj;

import org.openqa.selenium.By;

public class login_page {
    public static By select_send = By.id("switchAccountLogin");
    public static By iframe_login = By.xpath(".//*[@id='loginDiv']/iframe");
    public static By send_user =  By.xpath(".//*[@id='account-box']/div[2]/input");
    public static By send_pwd =  By.cssSelector("input.j-inputtext.dlpwd");
    public static By click_login = By.linkText("登  录");
}
