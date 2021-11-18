package DSL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DslClass {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	
	public DslClass(WebDriver driver) {
		super();
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 30);
		this.js = (JavascriptExecutor)this.driver;
	}
	
	
	public void Preencher(By by, String texto) {
		WebElement elementFound = this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
		elementFound.sendKeys(texto);
		
		if (this.js.executeScript("return arguments[0].innerText", elementFound).toString() != texto || elementFound.getText() != texto) {
			this.js.executeScript("arguments[0].value = arguments[1]", elementFound, texto);
		}
	}
	
	public void Clicar(By by) {
		
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}
	
	public String Assert(By by) {
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
	}
	
}
