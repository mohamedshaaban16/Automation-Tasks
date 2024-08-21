import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Addrecourd {

        String carNumber = "155";
        String fuelinLiters = "15";
        String fuelCost = "500";
        String fuelTyp = "solar";
        String customerCompanyID="20";
        // String value="2023-10-26T17:12";
        public WebDriver driver;
        @BeforeMethod
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://hiring.petroapp.com/test2.html");


        }
        public By carNumberField = new By.ByCssSelector("input[name=\"carNumber\"]");
    public By fuelinLitersField = new By.ByCssSelector("input[name=\"fuelInLiters\"]");
    public By fuelCostField= new By.ByCssSelector("input[name=\"fuelCost\"]");
    public By fuelTypeField = new By.ByCssSelector("input[name=\"fuelType\"]");
    public By dateandTime = new By.ByXPath("/html/body/div[1]/div/form/div[5]/input");
        //   private By dateandTimeValue = new By.ByCssSelector("input[value=\"2023-10-26T16:54\"]");

        public By customerCompanyIDfield= new By.ByCssSelector("input[name=\"companyId\"]");
        public By addButton = new By.ByCssSelector("button[type=\"submit\"]");

        @Test(priority = 1)
        public void insertcarNumber() {
            driver.findElement(carNumberField).sendKeys("155");
        }
        @Test(priority = 2)

        public void insertfuelinLiters() {
            driver.findElement(fuelinLitersField).sendKeys("15");
        }
        @Test(priority = 3)
        public void insertfuelCost() {
            driver.findElement(fuelCostField).sendKeys("500");
        }
        @Test(priority = 4)
        public void insertfullType() {
            driver.findElement(fuelTypeField).sendKeys("solar");
        }
        @Test(priority = 5)
        public void setDateandTime() throws InterruptedException {
            driver.findElement(dateandTime).click();
            Thread.sleep(2000);
        }
        //    @Test(priority = 6)
//    public void setDateandTimeValue() {
//        driver.findElement(dateandTimeValue).sendKeys(value);
//    }
        @Test(priority = 7)
        public void insertID() {
            driver.findElement(customerCompanyIDfield).sendKeys("20");
        }
        @Test(priority = 8)
        public void setAddButton() {
            driver.findElement(addButton).click();
        }
    }

