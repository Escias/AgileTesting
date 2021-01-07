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
import org.openqa.selenium.*;

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

	// Homepage
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

	// Configurateur
	@Given("^je suis sur la page modelS$")
	public void je_suis_sur_la_page_modelS() throws Throwable {
		driver.get("https://www.tesla.com/fr_fr/models/");
	}

	@Then("^j'appuie sur Commander$")
	public void j_appuie_sur_Commander() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Commander']")).click();
		Thread.sleep(3000);
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}
	}

	@Then("^l'url de la page doit être \"([^\"]*)\"$")
	public void l_url_de_la_page_doit_être(String arg1) throws Throwable {
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}
		assertEquals(driver.getCurrentUrl(), arg1);
	}

	@Then("^Le prix du LOA doit être de \"([^\"]*)\"$")
	public void le_prix_du_LOA_doit_être_de(String arg1) throws Throwable {
		String loa = driver.findElement(By.cssSelector(".finance-item--price")).getAttribute("innerHTML");
		boolean check = loa.contains(arg1);
		assertThat(check, is(true));
	}

	@Then("^j'appuie sur \"([^\"]*)\"$")
	public void j_appuie_sur(String arg1) throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".tds-menu-header-main--cross_hatch")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(), \"" + arg1 + "\")]")).click();
	}

	@Given("^je suis sur la page event$")
	public void je_suis_sur_la_page_event() throws Throwable {
		driver.get("https://www.tesla.com/fr_FR/events");
	}

	@Then("^la page doit contenir \"([^\"]*)\" evenements$")
	public void la_page_doit_contenir_evenements(String arg1) throws Throwable {
		String count = Integer.toString(driver.findElements(By.xpath("//a[text()=\"Informations\"]")).size());
		assertEquals(count, arg1);
	}

	@Then("^appuyer sur \"([^\"]*)\"$")
	public void appuyer_sur(String arg1) throws Throwable {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[contains(text(), \"" + arg1 + "\")]")).click();
		Thread.sleep(10000);
	}


	@Then("^la page doit contenir plus de \"([^\"]*)\" evenements$")
	public void la_page_doit_contenir_plus_de_evenements(String arg1) throws Throwable {
		String count = Integer.toString(driver.findElements(By.xpath("//a[text()=\"Informations\"]")).size());
		assertThat(count, greaterThan(arg1));
	}

	@Then("^je saisis le prénom \"([^\"]*)\"$")
	public void je_saisis_le_prénom(String arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@id=\"edit-firstname-td\"]")).sendKeys(arg1);
	}

	@Then("^je saisis le nom \"([^\"]*)\"$")
	public void je_saisis_le_nom(String arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@id=\"edit-lastname-td\"]")).sendKeys(arg1);
	}

	@Then("^je saisis le mail \"([^\"]*)\"$")
	public void je_saisis_le_mail(String arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@id=\"edit-usermail-td\"]")).sendKeys(arg1);
	}

	@Then("^je saisis le téléphone \"([^\"]*)\"$")
	public void je_saisis_le_téléphone(String arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@id=\"edit-phonenumber-td\"]")).sendKeys(arg1);
	}

	@Then("^je sélectionne la région \"([^\"]*)\"$")
	public void je_sélectionne_la_région(String arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@id=\"edit-countries-td\"]")).click();
		driver.findElement(By.xpath("//option[contains(text(), \"" + arg1 + "\")]")).click();
	}

	@Then("^je saisis le code postal \"([^\"]*)\"$")
	public void je_saisis_le_code_postal(String arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@id=\"edit-zipcode-td\"]")).sendKeys(arg1);
	}

	@Then("^appuyer sur le bouton \"([^\"]*)\"$")
	public void appuyer_sur_le_bouton(String arg1) throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(), \"" + arg1 + "\")]")).click();
		Thread.sleep(2000);
	}


	@After
	public void afterScenario() {
		driver.quit();
	}

}
