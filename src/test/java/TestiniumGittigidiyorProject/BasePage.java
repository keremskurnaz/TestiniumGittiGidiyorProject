package TestiniumGittigidiyorProject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



import java.util.List;
import java.util.Random;

public class BasePage {

    private static Logger logger = Logger.getLogger(BasePage.class);

    public WebDriver driver;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void click(By by) {

            WebElement element = driver.findElement(by);
            element.click();
            logger.info(by + " clicked element");

    }

    public void write(By by, String word) {

        WebElement element = driver.findElement(by);
        element.sendKeys(word);
        logger.info(word + " wrote value." + by + "element");
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
            logger.info("Given " + seconds + " seconds time waited.");

        } catch (Exception e) {
            logger.error("Given" + seconds + " seconds time didn't wait.");
        }
    }

    public void mouseaction(By by) {

        try {
            Actions actions = new Actions(driver);
            WebElement target = driver.findElement(by);
            actions.moveToElement(target).perform();
            logger.info(by + "Mouse hovered over element");
        } catch (Exception e) {
            logger.error(by + "Mouse didn't hover over element");
        }

    }

    public List<WebElement> ElementList(By by) {

        List<WebElement> elementList = driver.findElements(by);
        return elementList;
    }

    public int RandomNumber(int limit) {
        Random random = new Random();
        int randomNumber = random.nextInt(limit);
        return randomNumber;
    }

    public void select(By by, String option) {

        try {
            Select select = new Select(driver.findElement(by));
            select.selectByVisibleText(option);
            select.selectByValue(option);
            logger.info(by + "selected element clicked.");
        } catch (Exception e) {
            logger.error(by + "selected element didn't click.");
        }

    }
}