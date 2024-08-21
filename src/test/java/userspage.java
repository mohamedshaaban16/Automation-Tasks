import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class userspage {
    WebDriver driver;

    @BeforeMethod
    public void repeat() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://back.00b.io/ar/dashboard/login");
        WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']"));

        // Valid login case
        emailField.sendKeys("project-managament@bio.com");
        passwordField.sendKeys("123123123");
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='تسجيل الدخول']"));
        loginButton.click();
        Thread.sleep(3000);
        driver.navigate().to("https://back.00b.io/ar/dashboard/users");

    }
    @Test( priority = 1)
    public void testValidSearch() {
        // Find the search field using CSS Selectors
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));

        // Assert that the search field is displayed
        Assert.assertTrue(searchField.isDisplayed(), "Search field is not displayed");

        // Valid search case
        searchField.sendKeys("mona");

    }
    
}
