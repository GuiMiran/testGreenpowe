package automatizacion.greenpower.test;

import org.testng.annotations.Test;

import automatizacion.pages.HomePage;

public class LoginTests extends BaseTest {

@Test(priority = 0)
public void invalidLoginTest_InvalidUserNameInvalidPassword()
			throws InterruptedException {
	//*************PAGE METHODS WITH JAVA GENERICS********************
    //Open N11 HomePage
    page.GetInstance(HomePage.class).goToN11();

    //Method Chaining (Go to Login Page and then LoginToN11)
    page.GetInstance(HomePage.class).goToLoginPage().loginToN11("guido.bart@gmail.com","Mejora19");

//		// *************ASSERTIONS***********************
//		// Thread.sleep(500); //It is better to use explicit wait here.
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By
//				.xpath("//*[text()='E-posta adresiniz veya şifreniz hatalı']")));
//		page.GetInstance(LoginPage.class).verifyLoginPassword(
//				("E-posta adresiniz veya şifreniz hatalı"));
	}

	@Test(priority = 1)
	public void invalidLoginTest_EmptyUserEmptyPassword()
			throws InterruptedException {
		// *************PAGE METHODS WITH JAVA GENERICS********************
		// Open N11 HomePage
		page.GetInstance(HomePage.class).goToN11();

		// Method Chaining (Go to Login Page and then LoginToN11)
		page.GetInstance(HomePage.class).goToLoginPage().loginToN11("", "");

//		// *************ASSERTIONS***********************
//		// Thread.sleep(500); //It is better to use explicit wait here.
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By
//				.xpath("//*[text()='Lütfen e-posta adresinizi girin.']")));
//		page.GetInstance(LoginPage.class).verifyLoginUserName(
//				"Lütfen e-posta adresinizi girin.");
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By
//				.xpath("//*[text()='Bu alanın doldurulması zorunludur.']")));
//		page.GetInstance(LoginPage.class).verifyLoginPassword(
//				"Bu alanın doldurulması zorunludur.");
	}
}
