package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import Pages.PrescricoesPage;

public class PrescricoesMedicas {
	private WebDriver driver;
	private LoginPage loginpage;
	private PrescricoesPage prescricoespage;
	
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		loginpage.LogarComDadosVálidos();
		prescricoespage = new PrescricoesPage(driver);
	}
	
	@Test
	public void CriarNovaPrescricao() throws InterruptedException {
		prescricoespage.CriarNovaPrescricao(); 
	}
	
	@Test
	public void ValidarCamposObrigatorios() {
		prescricoespage.ValidarCamposObrigatorios();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
