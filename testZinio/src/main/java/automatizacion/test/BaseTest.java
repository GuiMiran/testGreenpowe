package automatizacion.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import automatizacion.pages.PageGenerator;

//import pages.PageGenerator;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;
 
    @BeforeClass
    public void classLevelSetup() {
    	
    	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mirian\\Downloads\\drivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		
		WebDriver driver = new ChromeDriver(options);

        //Create a Chrome driver. All test classes use this.
//        driver = new ChromeDriver();
 
        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,15);
 
        //Maximize Window
        driver.manage().window().maximize();
    }
 
    @BeforeMethod
    public void methodLevelSetup () {
        //Instantiate the Page Class
        page = new PageGenerator(driver);
    }
 
    @AfterClass
    public void teardown () {
        driver.quit();
    }
}