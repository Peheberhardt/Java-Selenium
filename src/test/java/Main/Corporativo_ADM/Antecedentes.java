package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.AntecedentesPage;
import Pages.LoginPage;

public class Antecedentes {
	
	private WebDriver driver;
	private LoginPage loginpage;
	private AntecedentesPage antecedentespage;

	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		antecedentespage = new AntecedentesPage(driver);
	}
	
	@Test
	public void PreencherFormularioAntecedentes() throws InterruptedException {
		loginpage.LogarComDadosV�lidos();
		antecedentespage.PreencherFormularioAntecedentes();
	}
	
	@Test 
	public void ValidarCamposAntecedentes() throws InterruptedException {
		loginpage.LogarComDadosV�lidos();
		antecedentespage.ValidarCamposAntecedentes();
	}
	@After
	public void Ending() {
		driver.quit();
	}
	
}
