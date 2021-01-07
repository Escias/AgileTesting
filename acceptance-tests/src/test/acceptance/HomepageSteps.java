package test.acceptance;

import java.util.concurrent.TimeUnit;

import java.lang.*;

import org.junit.Test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class HomepageSteps {

	public static WebDriver driver;

	@Before
	public void beforeScenario() {
		System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		driver = new ChromeDriver();
		// Seems no more working in last Chrome versions
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Page d'accueil
	@Given("^je suis sur la homepage$")
	public void je_suis_sur_la_homepage() throws Throwable {
		driver.get("https://www.tesla.com/fr_fr/");
	}

	@Then("^le titre doit être \"([^\"]*)\"$")
	public void le_titre_doit_être(String arg1) throws Throwable {
	    assertEquals(driver.getTitle(), arg1);
	}

	@Then("^la description contient \"([^\"]*)\"$")
	public void la_description_doit_être(String arg1) throws Throwable {
		// By CSS Selector
		assertTrue(driver.findElement(By.cssSelector("meta[name='description']")).getAttribute("content").contains(arg1));
		// By XPATH, si vous préférez...
	    // assertEquals(driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content"), arg1);
	}

	@Then("^j'indique l'élément et le contenu \"([^\"]*)\" \"([^\"]*)\"$")
	public void j_indique_l_élément_et_le_contenu(String arg1, String arg2) throws Throwable {
		boolean check = arg2.contains("/fr_fr/");
		String content;
		if (check == true){
			content = "https://www.tesla.com"+arg2;
			assertEquals(driver.findElement(By.xpath("//"+arg1+"[contains(@href, \"" + arg2 + "\")]")).getAttribute("href"), content);
		}else{
			content = arg2;
			assertEquals(driver.findElement(By.xpath("//"+arg1+"[contains(., \"" + arg2 + "\")]")).getAttribute("innerHTML"), content);
		}
	}

	@Then("^je choisi un element du menu-burger \"([^\"]*)\"$")
	public void je_choisi_un_element_du_menu_burger(String arg1) throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".tds-menu-header-main--cross_hatch")).click();
		Thread.sleep(1000);
		assertEquals(driver.findElement(By.xpath("//a[contains(text(), \"" + arg1 + "\")]")).getAttribute("innerHTML"), arg1);
	}


	@After
	public void afterScenario() {
		driver.quit();
	}

}
