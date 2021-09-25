package TestiniumGittigidiyorProject;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {
    public WebDriver driver;
    private static Logger logger = Logger.getLogger(BaseTest.class);

    @Before
    public void setup()
    {
        PropertyConfigurator.configure("log4j.properties");
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.gittigidiyor.com/");
        logger.info("Test is starting.");
    }

    @After
    public void quit()
    {
        if(driver != null){
            driver.quit();
            logger.info("Test finished.");
        }
    }
}

