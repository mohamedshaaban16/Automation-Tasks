import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
    WebDriver driver;

    @BeforeMethod
    public void repeat() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://back.00b.io/ar/dashboard/login");
    }
    @Test(priority = 1)
    public void testValidLogin() throws InterruptedException {
        WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']"));

        // Assert that the elements are displayed
        Assert.assertTrue(emailField.isDisplayed(), "Email field is not displayed");
        Assert.assertTrue(passwordField.isDisplayed(), "Password field is not displayed");

        // Valid login case
        emailField.sendKeys("project-managament@bio.com");
        passwordField.sendKeys("123123123");
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='تسجيل الدخول']"));
        loginButton.click();

            Thread.sleep(3000); // Adjust time as needed

    }
    @Test(priority = 2)
    public void testInvalidLogin() {
        // Find the email and password fields using CSS Selectors
        WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']"));

        // Clear the fields
        emailField.clear();
        passwordField.clear();

        // Invalid login case with empty fields
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='تسجيل الدخول']"));
        loginButton.click();

        // Add a wait to allow time for the validation messages to appear
        try {
            Thread.sleep(3000); // Adjust time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
