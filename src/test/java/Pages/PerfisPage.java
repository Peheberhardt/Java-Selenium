package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Codigos.CodigosUteis;
import DSL.DslClass;

public class PerfisPage {
	private DslClass dsl;
	private CodigosUteis uteis;
	private AdmPage admpage;
	
	public PerfisPage(WebDriver driver) {
		super();
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
		admpage = new AdmPage (driver);
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
	}
	
	public void ValidarPerfilUsuarioADM() throws InterruptedException {
		admpage.PreencherFormularioADMComDadosValidos();
		dsl.Clicar(By.xpath("//a[text()='Administradores']"));
		dsl.Preencher(By.id("input-pesquisa"), "Teste");
		Thread.sleep(1000);
		String nome = dsl.WaitForElement(By.xpath("(//tr//td)[1]")).getText();
		String cpf = dsl.WaitForElement(By.xpath("(//tr//td)[2]")).getText();
		dsl.Clicar(By.xpath("//a[text()='Perfis']"));
		dsl.Clicar(By.xpath("//a[text()='Usuário']"));
		dsl.Clicar(By.xpath("//div[text()='Selecione o tipo de usuário']"));
		Thread.sleep(2000);
		dsl.Clicar(By.xpath("//*[text()='Médico']"));
		dsl.Preencher(By.id("cpf"), cpf);
		dsl.Clicar(By.xpath("//button[text()='Pesquisar']"));
		Thread.sleep(1000);
		Assert.assertEquals(dsl.Assert(By.xpath("//div//h4")), nome);
	}
}
