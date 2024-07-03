package createDrivers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    private String url;
    protected Properties prop;

    public BasePage() throws IOException {
        prop = new Properties();///Users/dextertennison/eclipse-workspace/CucumberTest/src/main/java/resources
        String configPath = System.getProperty("user.dir") + "/src/main/java/resources/config.properties";
        File configFile = new File(configPath);

        if (!configFile.exists()) {
            throw new FileNotFoundException("Configuration file not found at: " + configPath);
        }

        try (FileInputStream data = new FileInputStream(configFile)) {
            prop.load(data);
        }
    }

    public WebDriver getDriver() throws IOException {
        String browser = prop.getProperty("browser");

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Please choose from: chrome, firefox, or safari");
            System.exit(0);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getUrl() throws IOException {
        url = prop.getProperty("url");
        return url;
    }



    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}
