package tests;

import base.BaseClass;
import org.testng.annotations.Test;
import page_object_model.loginPage.LoginPage;

public class Login extends BaseClass {

    @Test
    public void login_test() throws InterruptedException {
        Thread.sleep(3000);
        LoginPage _login = new LoginPage(driver);
        _login.set_your_username("Admin");
        Thread.sleep(2000);
        _login.set_your_password("admin123");
        Thread.sleep(2000);
        _login.click_on_submitBtn();
        Thread.sleep(5000);

    }

}
