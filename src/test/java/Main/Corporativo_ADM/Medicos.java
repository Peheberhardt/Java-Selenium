package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import Pages.MedicosPage;

public class Medicos {

	private WebDriver driver;
	private MedicosPage medicospage;
	private LoginPage loginpage;
	
	@Before
	public void Iniciaizar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		loginpage.LogarComDadosVálidos();
		medicospage = new MedicosPage(driver);
	}
	
	
	@Test
	public void PreencherFormularioMedicoComDadosValidos() throws InterruptedException {
		medicospage.PreencherFormularioMedicoComDadosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatorios() throws InterruptedException {
		medicospage.ValidarCamposObrigatorios();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
