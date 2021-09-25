package TestiniumGittigidiyorProject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;


import java.util.List;


public class TestCase extends BaseTest {

    private static Logger logger = Logger.getLogger(TestCase.class);

    @Test

    public void test() {
        PropertyConfigurator.configure("log4j.properties");
        BasePage basePage = new BasePage(driver);

        basePage.wait(2);
        String title = driver.getTitle();
        System.out.println(title);
        if (title.equals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi"))
            logger.info("Home page title found");
        else
            logger.info("Home page title not found");

        basePage.click(Element.cookies);

        /*basePage.mouseaction(Element.login);
        basePage.wait(3);
        basePage.click(Element.loginLoginButton);
        basePage.write(Element.usernameOrEmail, "keremskurnaz@gmail.com");
        basePage.write(Element.password, "123456abc");
        basePage.click(Element.submit);*/

        basePage.write(Element.searchBox, "Bilgisayar");
        basePage.click(Element.findButton);

        WebElement scrollDown = driver.findElement(By.xpath("//a[@aria-label='2. sayfa']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", scrollDown);

        basePage.click(Element.secondPage);
        basePage.wait(3);

        String url = driver.getCurrentUrl();
        System.out.println(url);
        if (url.equals("https://www.gittigidiyor.com/arama/?k=Bilgisayar&sf=2"))
            logger.info("Second page's url found");
        else
            logger.info("Second page's url not found");


        List<WebElement> productList=basePage.ElementList(Element.randomProduct);
        int randomNumber= basePage.RandomNumber(productList.size());
        productList.get(randomNumber).click();
        basePage.wait(3);

        WebElement productPrice = driver.findElement(By.id("sp-price-lowPrice"));
        String productPriceText = productPrice.getText();
        System.out.println(productPriceText);

        js.executeScript("window.scrollBy(0,500)");
        basePage.wait(1);
        basePage.click(Element.addToBasket);


        basePage.wait(2);
        js.executeScript("window.scrollBy(0,-500)");
        basePage.mouseaction(Element.myBasket);
        basePage.wait(2);
        basePage.click(Element.goToMyBasket);

        WebElement totalAmount = driver.findElement(By.xpath("//p[@class='new-price']"));
        String totalAmountText = totalAmount.getText();
        System.out.println(totalAmountText);
        if (totalAmountText.equals(productPriceText))
            logger.info("The product price is equals the basket price.");
        else
            logger.info("The product price is not equals the basket price.");

        basePage.select(Element.productNumber, "2");
        basePage.wait(2);

        WebElement productTotal = driver.findElement(By.xpath("//div[@class='gg-d-16 gg-m-14 detail-text']"));
        String productTotalText = productTotal.getText();
        System.out.println(productTotalText);
        if (productTotalText.equals("Ürün Toplamı (2 Adet)"))
            logger.info("Total product is 2 items");
        else
            logger.info("Total product isn't 2 items.");

        basePage.click(Element.deleteProduct);
        basePage.wait(10);

        WebElement myBasket = driver.findElement(By.xpath("//h2[1]"));
        String myBasketText = myBasket.getText();
        System.out.println(myBasketText);
        if (myBasketText.equals("Sepetinizde ürün bulunmamaktadır."))
            logger.info("There is no product in your basket.");
        else
            logger.info("There is product in your basket.");


    }
}