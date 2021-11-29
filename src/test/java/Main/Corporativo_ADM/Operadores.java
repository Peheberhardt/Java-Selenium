package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import Pages.OperadoresPage;

public class Operadores {

	private LoginPage loginpage;
	private WebDriver driver;
	private OperadoresPage operadorespage;
	
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		loginpage.LogarComDadosVálidos();
		operadorespage = new OperadoresPage(driver);
	}
	
	@Test
	public void PreencherFormularioOperadoresComDadosValidos() throws InterruptedException {
		operadorespage.PreencherFormularioOperadoresComDadosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatorios() throws InterruptedException {
		operadorespage.ValidarCamposObrigatorios();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
	
}
