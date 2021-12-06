package Main.Corporativo_ADM;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.AdmPage;
import Pages.AgentesPage;
import Pages.EnfermeirosPage;
import Pages.LoginPage;
import Pages.MedicosPage;
import Pages.OperadoresPage;
import Pages.PerfisPage;
import Pages.TecEnfermagemPages;

public class Perfis {
	
	private LoginPage loginpage;
	private WebDriver driver;
	private PerfisPage perfispage;
	private AdmPage admpage;
	private MedicosPage medicospage;
	private EnfermeirosPage enfermeirospages;
	private OperadoresPage operadorespage;
	private TecEnfermagemPages tecnicoenfermagempage;
	private AgentesPage agentespage;
	
	@Before
	public void Inicializar() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\autodrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corporativosrcolamedtest.web.app/login");
		driver.manage().window().maximize();
		loginpage = new LoginPage(driver);
		perfispage = new PerfisPage(driver);
		admpage = new AdmPage (driver);
		medicospage = new MedicosPage(driver);
		enfermeirospages = new EnfermeirosPage(driver);
		operadorespage = new OperadoresPage(driver);
		tecnicoenfermagempage = new TecEnfermagemPages(driver);
		agentespage = new AgentesPage(driver);
	}
	
	@Test
	public void CriarNovoPerfil() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		perfispage.CriarNovoPerfil();
	}
	
	@Test
	public void ValidarCamposObrigatorios() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		perfispage.ValidarCamposObrigatorios();
	}
	
	@Test
	public void ValidarPerfilUsuarioADM() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		admpage.PreencherFormularioADMComDadosValidos();
		perfispage.ValidarPerfilUsuarioADM();
	}
	
	@Test
	public void ValidarPerfilUsuarioMedico() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		medicospage.PreencherFormularioMedicoComDadosValidos();
		perfispage.ValidarPerfilUsuarioMedico();
	}
	
	@Test
	public void ValidarPerfilUsuarioEnfermeiro() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		enfermeirospages.PreencherFormularioEnfermeirosComDadosValidos();
		perfispage.ValidarPerfilUsuarioEnfermeiro();
	}
	
	@Test
	public void ValidarPerfilUsuarioOperador() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		operadorespage.PreencherFormularioOperadoresComDadosValidos();
		perfispage.ValidarPerfilUsuarioOperador();
	}
	
	@Test
	public void ValidarPerfilUsuarioTecnicoEnfermagem() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		tecnicoenfermagempage.PreencherFormularioTecEnfermagemComDadaosValidos();
		perfispage.ValidarPerfilUsuarioTecnicoEnfermagem();
	}
	
	@Test
	public void ValidarPerfilUsuarioAgentePenitenciario() throws InterruptedException {
		loginpage.LogarComDadosVálidos();
		agentespage.PreencherFormularioAgentesComDadosValidos();
		perfispage.ValidarPerfilUsuarioAgentePenitenciario();
	}
	
	
	@After
	public void Ending() {
		driver.quit();
	}
}
