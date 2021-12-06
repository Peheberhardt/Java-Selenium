package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Codigos.CodigosUteis;
import DSL.DslClass;

public class PerfisPage {
	
	private DslClass dsl;
	private CodigosUteis uteis;
	private AdmPage admpage;
	private MedicosPage medicospage;
	private EnfermeirosPage enfermeirospages;
	private OperadoresPage operadorespage;
	private TecEnfermagemPages tecnicoenfermagempage;
	private AgentesPage agentespage;
	
	public PerfisPage(WebDriver driver) {
		super();
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
		admpage = new AdmPage (driver);
		medicospage = new MedicosPage(driver);
		enfermeirospages = new EnfermeirosPage(driver);
		operadorespage = new OperadoresPage(driver);
		tecnicoenfermagempage = new TecEnfermagemPages(driver);
		agentespage = new AgentesPage(driver);
	}
	
	public void CriarNovoPerfil() throws InterruptedException {
		String nome = uteis.gerarNomes();
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Perfis']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		dsl.Preencher(By.id("nome_do_perfil"), nome);
		dsl.Clicar(By.xpath("//p[text()='AtendimentosVideoCall']/../..//span[@class = 'MuiIconButton-label']"));
		dsl.Clicar(By.xpath("//p[text()='CadAdministradores']/../..//span[@class = 'MuiIconButton-label']"));
		dsl.Clicar(By.xpath("//p[text()='CadAgendamentoConsultaListar']/../..//span[@class = 'MuiIconButton-label']"));
		dsl.Clicar(By.xpath("//p[text()='CadAdministradoresListar']/../..//span[@class = 'MuiIconButton-label']"));
		dsl.Clicar(By.xpath("//button[text()='Salvar']"));
		Thread.sleep(1500);
		dsl.Preencher(By.id("input-pesquisa"), nome);
		Assert.assertEquals(nome, dsl.Assert(By.xpath("//td[@id='"+nome+"']")));
	}
	
	
	//Fazer quando eles consertarem o bug
	public void ValidarCamposObrigatorios() {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Perfis']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		dsl.Clicar(By.xpath("//button[text()='Salvar']"));
		Assert.assertEquals("O Campo título deve ter pelo menos 5 caracteres", dsl.Assert(By.xpath("//div[text()='O Campo título deve ter pelo menos 5 caracteres']")));
	}
	
	public void ValidarPerfilUsuarioADM() throws InterruptedException {
		dsl.Clicar(By.xpath("//a[text()='Administradores']"));
		dsl.Preencher(By.id("input-pesquisa"), "Teste");
		Thread.sleep(1000);
		String nome = dsl.WaitForElement(By.xpath("(//tr//td)[1]")).getText();
		String cpf = dsl.WaitForElement(By.xpath("(//tr//td)[2]")).getText();
		dsl.Clicar(By.xpath("//a[text()='Perfis']"));
		dsl.Clicar(By.xpath("//a[text()='Usuário']"));
		dsl.Clicar(By.xpath("//div[text()='Selecione o tipo de usuário']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//div[@class = 'css-1pcexqc-container basic-select dark-theme']//div[text()='Administrador']"));
		dsl.Preencher(By.id("cpf"), cpf);
		dsl.Clicar(By.xpath("//button[text()='Pesquisar']"));
		Thread.sleep(1000);
		Assert.assertEquals(nome,dsl.Assert(By.xpath("//div//h4")));
	}
	
	public void ValidarPerfilUsuarioMedico() throws InterruptedException {
		dsl.Clicar(By.xpath("//a[text()='Médicos']"));
		dsl.Preencher(By.id("input-pesquisa"), "Teste");
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("(//tr//td//i)[2]"));
		Thread.sleep(1000);
		WebElement element = dsl.WaitForElement(By.id("nome"));
		String nome = element.getAttribute("value");
		WebElement element1 = dsl.WaitForElement(By.id("cpf"));
		String cpf = element1.getAttribute("value");
		dsl.Clicar(By.xpath("//a[text()='Perfis']"));
		dsl.Clicar(By.xpath("//a[text()='Usuário']"));
		dsl.Clicar(By.xpath("//div[text()='Selecione o tipo de usuário']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//div[@class = 'css-1pcexqc-container basic-select dark-theme']//div[text()='Médico']"));
		dsl.Preencher(By.id("cpf"), cpf);
		dsl.Clicar(By.xpath("//button[text()='Pesquisar']"));
		Thread.sleep(1000);
		Assert.assertEquals(nome,dsl.Assert(By.xpath("//div//h4")));
	}
	
	public void ValidarPerfilUsuarioEnfermeiro() throws InterruptedException {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Enfermeiros']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("(//tr//td//i)[2]"));
		Thread.sleep(1000);
		WebElement element = dsl.WaitForElement(By.id("nome"));
		String nome = element.getAttribute("value");
		WebElement element1 = dsl.WaitForElement(By.id("cpf"));
		String cpf = element1.getAttribute("value");
		dsl.Clicar(By.xpath("//a[text()='Perfis']"));
		dsl.Clicar(By.xpath("//a[text()='Usuário']"));
		dsl.Clicar(By.xpath("//div[text()='Selecione o tipo de usuário']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//div[@class = 'css-1pcexqc-container basic-select dark-theme']//div[text()='Enfermeiro']"));
		dsl.Preencher(By.id("cpf"), cpf);
		dsl.Clicar(By.xpath("//button[text()='Pesquisar']"));
		Thread.sleep(1000);
		Assert.assertEquals(nome,dsl.Assert(By.xpath("//div//h4")));
	}
	
	public void ValidarPerfilUsuarioOperador() throws InterruptedException {
		//dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Operadores']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("(//tr//td//i)[1]"));
		Thread.sleep(1000);
		WebElement element = dsl.WaitForElement(By.id("nome_completo"));
		String nome = element.getAttribute("value");
		WebElement element1 = dsl.WaitForElement(By.id("cpf"));
		String cpf = element1.getAttribute("value");
		dsl.Clicar(By.xpath("//a[text()='Perfis']"));
		dsl.Clicar(By.xpath("//a[text()='Usuário']"));
		dsl.Clicar(By.xpath("//div[text()='Selecione o tipo de usuário']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//div[@class = 'css-1pcexqc-container basic-select dark-theme']//div[text()='Operador']"));
		dsl.Preencher(By.id("cpf"), cpf);
		dsl.Clicar(By.xpath("//button[text()='Pesquisar']"));
		Thread.sleep(1000);
		Assert.assertEquals(nome,dsl.Assert(By.xpath("//div//h4")));
	}
	
	public void ValidarPerfilUsuarioTecnicoEnfermagem() throws InterruptedException {
		//dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Técnicos em Enfermagem']"));
		dsl.Clicar(By.xpath("(//tr//td//i)[1]"));
		WebElement element = dsl.WaitForElement(By.id("nome"));
		String nome = element.getAttribute("value");
		WebElement element1 = dsl.WaitForElement(By.id("cpf"));
		String cpf = element1.getAttribute("value");
		dsl.Clicar(By.xpath("//a[text()='Perfis']"));
		dsl.Clicar(By.xpath("//a[text()='Usuário']"));
		dsl.Clicar(By.xpath("//div[text()='Selecione o tipo de usuário']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//div[@class = 'css-1pcexqc-container basic-select dark-theme']//div[text()='Técnico de enfermagem']"));
		dsl.Preencher(By.id("cpf"), cpf);
		dsl.Clicar(By.xpath("//button[text()='Pesquisar']"));
		Thread.sleep(1000);
		Assert.assertEquals(nome,dsl.Assert(By.xpath("//div//h4")));
	}
	
	public void ValidarPerfilUsuarioAgentePenitenciario() throws InterruptedException {
		//dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Agentes penitenciários']"));
		dsl.Clicar(By.xpath("(//tr//td//i)[1]"));
		WebElement element = dsl.WaitForElement(By.id("nome"));
		String nome = element.getAttribute("value");
		WebElement element1 = dsl.WaitForElement(By.id("cpf"));
		String cpf = element1.getAttribute("value");
		dsl.Clicar(By.xpath("//a[text()='Perfis']"));
		dsl.Clicar(By.xpath("//a[text()='Usuário']"));
		dsl.Clicar(By.xpath("//div[text()='Selecione o tipo de usuário']"));
		Thread.sleep(1000);
		dsl.Clicar(By.xpath("//div[@class = 'css-1pcexqc-container basic-select dark-theme']//div[text()='Agente penitenciário']"));
		dsl.Preencher(By.id("cpf"), cpf);
		dsl.Clicar(By.xpath("//button[text()='Pesquisar']"));
		Thread.sleep(1000);
		Assert.assertEquals(nome,dsl.Assert(By.xpath("//div//h4")));
	}
}
