package tests;

import java.util.Arrays;

import org.testng.annotations.Test;

import automatizacion.greenpower.test.BaseTest;
import automatizacion.pages.HomePage;
import automatizacion.pages.LoginPage;

public class LoginTests extends BaseTest {

	  @Test (priority = 0)
	    public void validLoginTest_validUserNameAndValidPassword () throws InterruptedException {
	        //*************PAGE METHODS WITH JAVA GENERICS********************
	        //Open N11 HomePage
	        //Initialize elements by using PageFactory
	        page.GetInstance(HomePage.class).goToN11();

	        //Chain of Invocation (Go to Login Page and then LoginToN11)
	        page.GetInstance(HomePage.class).
	        		goToLoginPage().loginToN11("guido.bart@gmail.com", "Mejora19");

	        //*************ASSERTIONS***********************
	        Thread.sleep(500); //It is better to use explicit wait here.
	        
//	        page.GetInstance(LoginPage.class).verifyLoadLoginPage(Arrays.asList("Marketplace","My services","My data", "Support"));
	    }
	@Test (priority = 0)
    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws InterruptedException {
        //*************PAGE METHODS WITH JAVA GENERICS********************
        //Open N11 HomePage
        //Initialize elements by using PageFactory
        page.GetInstance(HomePage.class).goToN11();

        //Chain of Invocation (Go to Login Page and then LoginToN11)
        page.GetInstance(HomePage.class).           
        		goToLoginPage().loginToN11("usuarioincorrecto@gmail.com", "passwordincorrecto");

        //*************ASSERTIONS***********************
        Thread.sleep(500); 
//        page.GetInstance(LoginPage.class).verifyLoginPassword(("Enter your email address in the format \\\"user@domain\\\"."));
    }

    @Test (priority = 1)
    public void invalidLoginTest_EmptyUserEmptyPassword () throws InterruptedException {
        //*************PAGE METHODS WITH JAVA GENERICS********************
        //Open N11 HomePage
        page.GetInstance(HomePage.class).goToN11();

        //Method Chaining (Go to Login Page and then LoginToN11)
        page.GetInstance(HomePage.class).goToLoginPage().loginToN11("","");

        //*************ASSERTIONS***********************
        Thread.sleep(500); //It is better to use explicit wait here.
        page.GetInstance(LoginPage.class).verifyLoginUserName("Enter your email address in the format \"user@domain\".");
       // page.GetInstance(LoginPage.class).verifyLoginPassword("error de ");
    }

}
