package automatizacion.greenpower.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import automatizacion.pages.PageGenerator;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;

    @BeforeMethod
    public void setup () {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mirian\\Downloads\\drivers\\vers76\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		
		 
		driver = new ChromeDriver(options);

    	//Create a Chrome driver. All test classes use this.
//        driver = new ChromeDriver();

        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,15);

        //Maximize Window
        driver.manage().window().maximize();

        //Instantiate the Page Class
        page = new PageGenerator(driver);
    }

    @AfterMethod
    public void teardown () {
        driver.quit();
    }
}
