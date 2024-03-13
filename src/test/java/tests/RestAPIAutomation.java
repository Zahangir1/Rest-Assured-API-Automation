package tests;

import base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_object_model.loginPage.LoginPage;

import static org.hamcrest.Matchers.equalTo;

public class RestAPIAutomation extends BaseClass {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in"; // Set the base URI
    }

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

    @Test (priority = 1)
    public void valid_signup () {
        JSONObject request = new JSONObject();

        request.put("email", "eve.holt@reqres.in");
        request.put("password", "pistol");

        RestAssured.
        given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("/api/register").
        then().
                statusCode(200).
                body("token", equalTo("QpwL5tke4Pnpja7X4")).
                body("id", equalTo(4));
        System.out.println("Sign up access successfully");

    }

    @Test (priority = 2)
    public void wrong_credential () {
        JSONObject request = new JSONObject();

        request.put("email", "ash.holt@reqres.in");
        request.put("password", "pistol");

        RestAssured.
        given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("/api/register").
        then().
                statusCode(400).
                body("error", equalTo("Note: Only defined users succeed registration"));
        System.out.println("Validate wrong credentials");

    }

    @Test (priority = 3)
    public void signup_onlyEmail () {
        JSONObject request = new JSONObject();

        request.put("email", "eve.holt@reqres.in");

        RestAssured.
        given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("/api/register").
        then().
                statusCode(400).
                body("error", equalTo("Missing password"));
        System.out.println("Sign up with only email");

    }

    @Test (priority = 4)
    public void signup_onlyPassword () {
        JSONObject request = new JSONObject();

        request.put("password", "pistol");

        RestAssured.
        given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                body(request.toJSONString()).

        when().
                post("/api/register").
        then().
                statusCode(400).
                body("error", equalTo("Missing email or username"));
        System.out.println("Sign up with validate password");
    }

    /*@AfterClass
    public void afterTest() {
        //Reset Values
        RestAssured.reset();
    }*/
}
