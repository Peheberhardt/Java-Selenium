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
	
	public PerfisPage(WebDriver driver) {
		super();
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
	}
	
	public void CriarNovoPerfil() throws InterruptedException {
		String nome = uteis.gerarNomes();
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Perfis']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		dsl.Preencher(By.id("perfilNome"), nome);
		dsl.Clicar(By.xpath("//p[text()='AtendimentosVideoCall']/../..//span[@class = 'MuiIconButton-label']"));
		dsl.Clicar(By.xpath("//p[text()='CadAdministradores']/../..//span[@class = 'MuiIconButton-label']"));
		dsl.Clicar(By.xpath("//p[text()='CadAgendamentoConsultaListar']/../..//span[@class = 'MuiIconButton-label']"));
		dsl.Clicar(By.xpath("//p[text()='CadAdministradoresListar']/../..//span[@class = 'MuiIconButton-label']"));
		dsl.Clicar(By.xpath("//button[text()='Salvar']"));
		Thread.sleep(1500);
		dsl.Preencher(By.id("input-pesquisa"), nome);
		WebElement element = dsl.WaitForElement(By.xpath("//td[@id='"+nome+"']"));
		Assert.assertEquals(nome, element.getText());
	}
	
	
	//Fazer quando eles consertarem o bug
	public void ValidarCamposObrigatorios() {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Perfis']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
	}
}
