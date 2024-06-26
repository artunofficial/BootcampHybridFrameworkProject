package com.tutorialsNinja.TestBase;

import com.TutorialsNinja.Utilities.Util;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {
    WebDriver driver;
    public ChromeOptions options;
    public Properties prop;
    public FileInputStream ip;

    public Properties dataProp;

    public FileInputStream ip1;


    public TestBase() throws Exception {
        prop = new Properties();
        ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\com\\TutorialsNinja\\Config\\config.properties");
        prop.load(ip);

        dataProp = new Properties();
        ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\com\\tutorialsNinja\\TestData\\testData.properties");
        dataProp.load(ip);
    }

    public WebDriver initializeBrowserAndOpenApplication(String browserName) {
        if (browserName.equals("chrome")) {
            options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
            driver = new ChromeDriver(options);
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGELOAD_TIME_WAIT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME_WAIT));
        driver.get(prop.getProperty("url"));

        return driver;
    }
}
