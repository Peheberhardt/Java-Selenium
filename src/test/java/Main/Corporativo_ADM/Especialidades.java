package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.EspecialidadesPage;
import Pages.LoginPage;

public class Especialidades {

	private WebDriver driver;
	private LoginPage loginpage;
	private EspecialidadesPage especialidadespage;
	
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		loginpage.LogarComDadosV�lidos();
		especialidadespage = new EspecialidadesPage(driver);
	}
	
	@Test
	public void PreencherFormularioEspecialidadesComDadosValidos() throws InterruptedException {
		especialidadespage.PreencherFormularioEspecialidadesComDadosValidos();
	}
	
	@Test
	public void ValidarCamposObrigatorios() {
		especialidadespage.ValidarCamposObrigatorios();
	}
	
	@After
	public void Ending() {
		driver.quit();
	}
}
