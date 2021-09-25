package TestiniumGittigidiyorProject;

import org.openqa.selenium.By;


public class Element {

    public static By login = By.xpath("//div[@data-cy='header-user-menu']");
    public static By loginLoginButton = By.xpath("//header[@id='main-header']/div[3]/div/div/div/div[3]/div/div/div[2]/div/div/div/a/span");
    public static By cookies = By.xpath("//a[@class='tyj39b-5 lfsBU']");
    public static By usernameOrEmail = By.id("L-UserNameField");
    public static By password = By.id("L-PasswordField");
    public static By submit = By.id("gg-login-enter");
    public static By searchBox = By.cssSelector("input[data-cy='header-search-input']");
    public static By findButton = By.xpath("//button[@class='qjixn8-0 sc-1bydi5r-0 gaMakD']");
    public static By secondPage = By.xpath("//a[@aria-label='2. sayfa']");
    public static By randomProduct = By.xpath("//header[@class='sc-1n49x8z-2 eIQPKN']");
    public static By addToBasket = By.id("add-to-basket");
    public static By myBasket = By.xpath("//span[@class='basket-title']");
    public static By goToMyBasket = By.xpath("//a[@class='gg-ui-btn-default padding-none']");
    public static By productNumber = By.xpath("//select[@class='amount']");
    public static By deleteProduct = By.xpath("//i[@class='gg-icon gg-icon-bin-medium'][1]");
}