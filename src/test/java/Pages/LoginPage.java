package Pages;

import org.openqa.selenium.WebDriver;

import DSL.DslClass;

public class LoginPage {

	static WebDriver driver;
	private DslClass dsl;
	public LoginPage(WebDriver driver) {
		super();
		dsl = new DslClass(driver);
	}
	
	public void LogarComDadosVálidos() throws InterruptedException {
		dsl.PreencherId("email", "adm01@testingcompany.com.br");
		dsl.PreencherId("password", "testing@123@");
		dsl.ClicarXpath(("//button[@class = 'btn btn-login shadow-2 mb-4 btn btn-primary']"));
	}
	
		
}
