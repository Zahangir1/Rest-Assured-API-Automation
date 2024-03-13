package page_object_model.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver = null;

    public LoginPage(WebDriver driver){
        this.driver =driver;
    }

    By username = By.xpath("(//input)[2]");
    By password = By.xpath("(//input)[3]");
    By submitBtn = By.xpath("(//button)[1]");

    public void set_your_username(String uname){
        driver.findElement(username).sendKeys(uname);
    }

    public void set_your_password(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void click_on_submitBtn(){
        driver.findElement(submitBtn).click();
    }

}
