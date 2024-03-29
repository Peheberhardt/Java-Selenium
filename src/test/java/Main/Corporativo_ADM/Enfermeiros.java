package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.EnfermeirosPage;
import Pages.LoginPage;

public class Enfermeiros {
	
	private WebDriver driver;
	private LoginPage loginpage;
	private EnfermeirosPage enfermeirospage;
	
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		enfermeirospage = new EnfermeirosPage(driver);
	}
	
	@Test
	public void PreencherFormularioEnfermeirosComDadosValidos() throws InterruptedException {
		loginpage.LogarComDadosVŠlidos();
		enfermeirospage.PreencherFormularioEnfermeirosComDadosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatoriosEnfermeiros() throws InterruptedException {
		loginpage.LogarComDadosVŠlidos();
		enfermeirospage.ValidarCamposObrigatoriosEnfermeiros();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
