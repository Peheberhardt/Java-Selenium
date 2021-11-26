package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import Pages.PerfisPage;

public class Perfis {
	
	private LoginPage loginpage;
	private WebDriver driver;
	private PerfisPage perfispage;
	
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		loginpage.LogarComDadosVálidos();
		perfispage = new PerfisPage(driver);
	}
	
	@Test
	public void CriarNovoPerfil() throws InterruptedException {
		perfispage.CriarNovoPerfil();
	}
	
	
	@After
	public void Ending() {
		driver.quit();
	}
}
