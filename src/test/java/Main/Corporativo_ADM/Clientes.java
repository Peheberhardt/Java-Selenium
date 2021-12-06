package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.ClientesPage;
import Pages.LoginPage;

public class Clientes {

	private WebDriver driver;
	private LoginPage loginpage;
	private ClientesPage clientespage;
	
	@Before
	public void Inicializar() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		clientespage = new ClientesPage(driver);
	}
	
	@Test
	public void PreencherFormularioClientes() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		clientespage.PreencherFormularioClienteComDadosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatoriosClientes() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		clientespage.ValidarCamposObrigatorios();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
