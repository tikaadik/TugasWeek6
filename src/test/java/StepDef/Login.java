package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User open link website")
    public void user_open_link_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @Then("User input registered username")
    public void user_input_registered_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("User input registered password")
    public void user_input_registered_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("User tap login button")
    public void user_tap_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User input wrong username")
    public void user_input_wrong_username() {
        driver.findElement(By.id("user-name")).sendKeys("tika_user");
    }

    @And("User input wrong password")
    public void user_input_wrong_password() {
        driver.findElement(By.id("password")).sendKeys("tika123");
    }

    @Then("User in on dashboard page")
    public void user_in_on_dashboard_page() {
        Boolean isDisplayed = driver.findElement(By.id("shopping_cart_container")).isDisplayed();
        Assert.assertEquals(isDisplayed, true);
        driver.quit();
    }

    @Then("User get error message")
    public void user_get_error_message() {
        Boolean errorLogin = driver.findElement(By.className("error-message-container")).isDisplayed();
        Assert.assertEquals(errorLogin, true);
        driver.quit();
    }
}
