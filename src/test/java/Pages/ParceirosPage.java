package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Codigos.CodigosUteis;
import DSL.DslClass;

public class ParceirosPage {

	private CodigosUteis uteis;
	private DslClass dsl;
	
	public ParceirosPage(WebDriver driver) {
		super();
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
	}
	
	public void PreencherFormularioParceirosComDadosValidos() throws InterruptedException {
		String nome = uteis.gerarNomes();
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Parceiros']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Preencher(By.id("cnpj"), "" );
		dsl.Preencher(By.id("nome"), nome);
		dsl.Preencher(By.id("email"), uteis.gerarEmail());
		dsl.Preencher(By.id("telefone"), uteis.gerarTelefone());
		dsl.Preencher(By.id("cep"), "29160-752");
		dsl.Clicar(By.xpath("//button[contains(., 'Consultar')]"));
		dsl.Preencher(By.id("numero"), "29");
		Thread.sleep(200);
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Parceiro cadastrado com sucesso!", dsl.Assert(By.id("swal2-title")));
		String element = dsl.WaitForElement(By.id("swal2-title")).getText().toString();
		if(element.equals("Parceiro cadastrado com sucesso!")) {
			dsl.Clicar(By.xpath("//button[text()='OK']"));
			Thread.sleep(2000);
			dsl.Preencher(By.name("input-pesquisa"), nome);
			Thread.sleep(3000);
			dsl.Clicar(By.xpath("//td[text()='"+nome+"']/..//span[@class = 'MuiIconButton-label']"));
			dsl.Clicar(By.xpath("//button[text()='Desativar!']"));
			Thread.sleep(3000);
			Assert.assertEquals("Inativo", dsl.Assert(By.xpath("//b[text()='Inativo']")));
		}
	}
}
