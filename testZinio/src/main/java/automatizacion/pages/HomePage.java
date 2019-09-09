package automatizacion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import automatizacion.reports.ExtentReport;
import automatizacion.reports.ExtentReport.*;


public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "https://www.dnvgl.com/";

    String directLoginURL = "https://www.veracity.com/auth/login";

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.CSS, using = "section.the-header__content > a")
    public WebElement signInButton;

    //*********Page Methods*********
    //Go to Homepage
    public void goToN11 (){
//		ExtentReport.logger = ExtentReport.extent.createTest("Inicializando la pagina: "+baseURL);

        driver.get(baseURL);
    }

    //Go to LoginPage
    public LoginPage goToLoginPage (){
        click(signInButton);
        //I want to chain LoginPage's methods so I return LoginPage by initializing its elements
        return new PageFactory().initElements(driver,LoginPage.class);
    }
}