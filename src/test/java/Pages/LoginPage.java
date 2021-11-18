package Pages;

import org.openqa.selenium.By;
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
		dsl.Preencher(By.id("email"), "adm01@testingcompany.com.br");
		dsl.Preencher(By.id("password"), "testing@123@");
		dsl.Clicar(By.xpath("//button[@class = 'btn btn-login shadow-2 mb-4 btn btn-primary']"));
	}
	
		
}
