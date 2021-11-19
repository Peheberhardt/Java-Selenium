package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.AgentesPage;
import Pages.LoginPage;

public class AgentesPenitenciarios {
	private WebDriver driver;
	private LoginPage loginpage;
	private AgentesPage agentespage;
		
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		loginpage.LogarComDadosVŠlidos();
		agentespage = new AgentesPage(driver);
	}
	@Test
	public void PreencherFormularioAgentes() throws InterruptedException {
		agentespage.PreencherFormularioAgentesComDadosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatoriosAgentes() {
		agentespage.ValidarCamposAgentes();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
