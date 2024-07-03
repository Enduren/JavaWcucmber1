package StepDefinitions;

import createDrivers.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class correctSignIn extends BasePage {

    public correctSignIn() throws IOException {
        super();
    }
    public WebDriver driver;
    @Before
    public void setUp() throws IOException {
        driver = getDriver();


    }


    @Given("User goes to signin page")
    public void user_goes_to_signin_page() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        driver.get(getUrl());
    }
    @When("User uses good login credentials")
    public void user_uses_good_login_credentials() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("#text")).sendKeys("webdriver");
        driver.findElement(By.cssSelector("#password")).sendKeys("webdriver123");
    }
    @And("User clicks login button")
    public void user_clicks_login_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("#login-button")).click();
    }
    @Then("User sees popup box")
    public void user_sees_popup_box() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Get the text from the alert
        String alertText = alert.getText();
        System.out.println("Alert text is: " + alertText);

        // Verify the alert text
        Assert.assertEquals(alertText, "validation succeeded");

        // Accept the alert
        alert.accept();
        System.out.println("Alert accepted.");
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
