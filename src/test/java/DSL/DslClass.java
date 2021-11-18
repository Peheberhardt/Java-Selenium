package DSL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DslClass {
	
	private WebDriver driver;
	public DslClass(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	public void PreencherId(String id, String texto) {
		driver.findElement(By.id(id)).sendKeys(texto);
	}
	public void ClicarXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();;
	}
	
	public void ClicarId(String id) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
	}


	public void PreencherIdFormulario(String id, String gerarNomes) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).sendKeys(gerarNomes);
	}
	
	public String AssertById(String id) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).getText();
		
	}
	
}
