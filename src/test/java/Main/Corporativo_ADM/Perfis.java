package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
	
	@Test
	public void ValidarCamposObrigatorios() {
		perfispage.ValidarCamposObrigatorios();
	}
	
	@Test
	public void ValidarPerfilUsuarioADM() throws InterruptedException {
		perfispage.ValidarPerfilUsuarioADM();
	}
	
	@Test
	public void ValidarPerfilUsuarioMedico() throws InterruptedException {
		perfispage.ValidarPerfilUsuarioMedico();
	}
	
	@Test
	public void ValidarPerfilUsuarioEnfermeiro() throws InterruptedException {
		perfispage.ValidarPerfilUsuarioEnfermeiro();
	}
	
	@Test
	public void ValidarPerfilUsuarioOperador() throws InterruptedException {
		perfispage.ValidarPerfilUsuarioOperador();
	}
	
	@Test
	public void ValidarPerfilUsuarioTecnicoEnfermagem() throws InterruptedException {
		perfispage.ValidarPerfilUsuarioTecnicoEnfermagem();
	}
	
	@Test
	public void ValidarPerfilUsuarioAgentePenitenciario() throws InterruptedException {
		perfispage.ValidarPerfilUsuarioAgentePenitenciario();
	}
	
	
	@After
	public void Ending() {
		driver.quit();
	}
}
