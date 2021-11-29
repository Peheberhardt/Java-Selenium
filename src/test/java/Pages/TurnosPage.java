package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Codigos.CodigosUteis;
import DSL.DslClass;

public class TurnosPage {

	private DslClass dsl;
	private CodigosUteis uteis;
	
	public TurnosPage(WebDriver driver) {
		super();
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
	}
	
	public void PreencherFormularioTurnosComDadosValidos() throws InterruptedException {
		String nome = uteis.gerarNomes();
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Turnos']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Preencher(By.id("nome"), nome);
		dsl.Clicar(By.id("dataHoraIni"));
		dsl.Clicar(By.xpath("//li[text()='14:00']"));
		dsl.Clicar(By.id("dataHoraFim"));
		dsl.Clicar(By.xpath("//li[text()='15:00']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Erro ao atualizar turno", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		dsl.Clicar(By.xpath("//button[text()='Cancelar']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Preencher(By.id("nome"), nome);
		dsl.Clicar(By.id("dataHoraIni"));
		dsl.Clicar(By.xpath("//li[text()='14:00']"));
		dsl.Clicar(By.id("dataHoraFim"));
		dsl.Clicar(By.xpath("//li[text()='15:00']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Turno cadastrado com sucesso!", dsl.Assert(By.id("swal2-title")));
		String element = dsl.WaitForElement(By.id("swal2-title")).getText().toString();
		if(element.equals("Turno cadastrado com sucesso!")) {
			dsl.Clicar(By.xpath("//button[text()='OK']"));
			Thread.sleep(2000);
			dsl.Preencher(By.name("input-pesquisa"), nome);
			Thread.sleep(2000);
			dsl.Clicar(By.xpath("//p[text()='"+nome+"']/../..//span[@class = 'MuiIconButton-label']"));
			dsl.Clicar(By.xpath("//button[text()='Desativar!']"));
			Thread.sleep(2000);
			Assert.assertEquals("Inativo", dsl.Assert(By.xpath("//b[text()='Inativo']")));
		}
	}
	
	public void ValidarCamposObrigatorios() {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Turnos']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		Assert.assertEquals("O campo nome deve ter pelo menos 5 caracteres", dsl.Assert(By.xpath("//div[text()='O campo nome deve ter pelo menos 5 caracteres']")));
		Assert.assertEquals("Campo de Data de Nascimento é obrigatório", dsl.Assert(By.xpath("//div[text()='Campo de Data de Nascimento é obrigatório']")));
		Assert.assertEquals("Campo de Data de Nascimento é obrigatório", dsl.Assert(By.xpath("//div[text()='Campo de Data de Nascimento é obrigatório']")));

	}
}
