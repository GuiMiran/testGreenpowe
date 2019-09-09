package automatizacion.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements by using Page Factory*********
    @FindBy(how = How.CSS, using = "input#userNameInput")
    public WebElement username;

    @FindBy(how = How.CSS, using = "input#passwordInput")
    public WebElement password;

    @FindBy(how = How.CSS, using = "span#submitButton")
    public WebElement loginButton;

    @FindBy(how = How.CSS, using = "label#errorText")
    public WebElement errorMessageUsername;
    
    @FindBy(how = How.CSS, using = "nav.vui-header-last > a.vui-header-link.text.desktop.bordered")
    public List<WebElement> menuVeracity;

    @FindBy(how = How.XPATH, using = "//*[@id=\"loginForm\"]/div[2]/div/div")
    public WebElement errorMessagePassword;


    //*********Page Methods*********
    public void loginToN11 (String pusername, String ppassword){
        //Enter Username(Email)
        writeText(username,pusername);
        //Enter Password
        writeText(password, ppassword);
        //Click Login Button
        click(loginButton);
    }

    //Verify Username Condition
    public void verifyLoginUserName (String expectedText) {
    	System.out.println("valor del mensaje error=> "+readText(errorMessageUsername));
        Assert.assertEquals(readText(errorMessageUsername), expectedText);
    }

    //Verify Password Condition
    public void verifyLoginPassword (String expectedText) {
    	System.out.println("valor del mensaje error=> "+readText(errorMessagePassword));
        Assert.assertEquals(readText(errorMessagePassword), expectedText);
    }

	public void verifyLoadLoginPage(List<String> valoresAcomprobar) {
		
		List<Boolean> valoresCorrecto= new ArrayList<Boolean>();
		List<WebElement> lisNavMenu = menuVeracity;
		for (WebElement webElementNav : lisNavMenu) {
			System.out.println(webElementNav.getText());
			valoresCorrecto.add(valoresAcomprobar.contains(webElementNav.getText()));
			Assert.assertTrue(valoresAcomprobar.contains(webElementNav.getText()));
		}
		System.out.println("validaciones"+ valoresCorrecto);
//		Assert.assertEquals(readText(menuVeracity), valoresAcomprobar);
		
	}

	

}
