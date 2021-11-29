package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Codigos.CodigosUteis;
import DSL.DslClass;

public class HipotesesPage {

	private WebDriver driver;
	private DslClass dsl;
	private CodigosUteis uteis;
	
	public HipotesesPage(WebDriver driver) {
		super();
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
		this.driver = driver;
	}
	
	public void PreencherCamposHipotesesComDadosValidos() throws InterruptedException {
		String nome = uteis.gerarNomes();
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Hipóteses diagnósticas']"));
		driver.navigate().refresh();
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Preencher(By.id("nome"), nome);
		dsl.Preencher(By.id("codigoCID"), "ASDASD");
		dsl.Preencher(By.id("descricao"), "TESTETESTE");
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Erro ao atualizar hipótese diagnóstica", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		dsl.Clicar(By.xpath("//button[text()='Cancelar']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Preencher(By.id("nome"), nome);
		dsl.Preencher(By.id("codigoCID"), "ASDASD");
		dsl.Preencher(By.id("descricao"), "TESTETESTE");
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Hipótese diagnóstica cadastrada com sucesso!", dsl.Assert(By.id("swal2-title")));
		String element = dsl.WaitForElement(By.id("swal2-title")).getText().toString();
		if(element.equals("Hipótese diagnóstica cadastrada com sucesso!")) {
			dsl.Clicar(By.xpath("//button[text()='OK']"));
			Thread.sleep(2000);
			dsl.Preencher(By.name("input-pesquisa"), nome);
			Thread.sleep(3000);
			dsl.Clicar(By.xpath("//p[text()='"+nome+"']/../..//span[@class = 'MuiIconButton-label']"));
			dsl.Clicar(By.xpath("//button[text()='Desativar!']"));
			Thread.sleep(3000);
			Assert.assertEquals("Inativo", dsl.Assert(By.xpath("//b[text()='Inativo']")));
		}
	}
	
	public void ValidarCamposObrigatorios() {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Hipóteses diagnósticas']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Preencha todos os campos corretamente!", dsl.Assert(By.id("swal2-title")));
		dsl.Clicar(By.xpath("//button[text()='OK']"));
		Assert.assertEquals("O campo nome deve ter pelo menos 5 caracteres",dsl.Assert(By.xpath("//div[text()='O campo nome deve ter pelo menos 5 caracteres']")));
		Assert.assertEquals("Campo CID deve conter no mínimo 6 caracteres",dsl.Assert(By.xpath("//div[text()='Campo CID deve conter no mínimo 6 caracteres']")));
		Assert.assertEquals("O campo descrição deve conter no mínimo 5 caracteres!",dsl.Assert(By.xpath("//div[text()='O campo descrição deve conter no mínimo 5 caracteres!']")));
	}
}
