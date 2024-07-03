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

public class falseSignIn extends BasePage {
    public falseSignIn() throws IOException {
        super();
    }
    public WebDriver driver;
    @Before
    public void setUp() throws IOException {
        driver = getDriver();


    }

    @Given("User goes to login page")
    public void user_goes_to_login_page() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        driver.get(getUrl());


    }
    @When("User uses bad login credentials")
    public void user_uses_bad_login_credentials() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("#text")).sendKeys("dshgsd");
        driver.findElement(By.cssSelector("#password")).sendKeys("fghghhfg");
    }
    @And("User clicks login")
    public void user_clicks_login() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("#login-button")).click();
    }
    @Then("User should see popup box")
    public void user_should_see_popup_box() {
        // Write code here that turns the phrase above into concrete actions
        // Wait for the alert to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // Get the text from the alert
        String alertText = alert.getText();
        System.out.println("Alert text is: " + alertText);

        // Verify the alert text
        Assert.assertEquals(alertText, "validation failed");

        // Accept the alert
        alert.accept();
        System.out.println("Alert accepted.");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
