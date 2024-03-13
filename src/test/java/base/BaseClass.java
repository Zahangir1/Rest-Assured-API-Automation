package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public static WebDriver driver;
    public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        System.out.println("Title: " + driver.getTitle());
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
        System.out.println("Browser open Successfully!");
    }

}
