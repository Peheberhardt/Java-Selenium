package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Codigos.CodigosUteis;
import DSL.DslClass;


public class AntecedentesPage {
	
	
	private DslClass dsl;
	private CodigosUteis uteis;
	
	public AntecedentesPage(WebDriver driver) {
		super();
		dsl = new DslClass(driver);
		uteis = new CodigosUteis();
	}
	
	public void PreencherFormularioAntecedentes() {
		dsl.Clicar(By.xpath("//span[text()='Cadastros']"));
		dsl.Clicar(By.xpath("//a[text()='Antecedentes']"));
		dsl.Clicar(By.xpath("//a[text()='Cadastrar']"));
		dsl.Preencher(By.id("antecedente"), uteis.gerarNomes());
		dsl.Clicar(By.xpath("//button[text()='Cadastrar']"));
		Assert.assertEquals("Antecedente cadastrado com sucesso!", dsl.Assert(By.id("swal2-title")));
	}
}
