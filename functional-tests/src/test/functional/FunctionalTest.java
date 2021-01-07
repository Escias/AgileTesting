package test.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;

public class FunctionalTest {

	private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		driver = new ChromeDriver();
        driver.get("https://www.tesla.com/fr_FR/");
	    	// Seems no more working in last Chrome versions
		// driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }

    // Test de la Story #1-homepage (https://trello.com/c/WKTneu9o/1-homepage)
	@Test
    public void testHomepage() throws Exception {
		assertEquals(driver.getTitle(), "Voitures électriques, énergie solaire et propre | Tesla France");
		// TODO
		// To Be Completed By Coders From Coding Factory
    }

    @Test
    public void testDescription() throws Exception {
        assertEquals(driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content"), "Tesla accélère la transition mondiale vers une énergie durable en proposant des véhicules électriques, des panneaux solaires et des solutions intégrées d'énergie renouvelable pour les particuliers et les entreprises.");
    }

    @Test
    public void testH1() throws Exception {
        List<String> listPunches = Arrays.asList("Model 3", "Model S", "Model X", "Model Y", "Systèmes d'énergie solaire et Powerwalls");
        for(String h1 : listPunches) {
            assertEquals(driver.findElement(By.xpath("//h1[contains(., \"" + h1 + "\")]")).getAttribute("innerHTML"), h1);
        }
    }

    @Test
    public void testPunchlines() throws Exception {
        Boolean title1 = driver.findElements(By.xpath("//h1[contains(text(), 'Model 3')]")).size() > 0;
        assertThat(title1, is(true));
        Boolean title2 = driver.findElements(By.xpath("//h1[contains(text(), 'Model S')]")).size() > 0;
        assertThat(title2, is(true));
        Boolean title3 = driver.findElements(By.xpath("//h1[contains(text(), 'Model X')]")).size() > 0;
        assertThat(title3, is(true));
        Boolean title4 = driver.findElements(By.xpath("//h1[contains(text(), 'Model Y')]")).size() > 0;
        assertThat(title4, is(true));
        Boolean title5 = driver.findElements(By.xpath("//h1[contains(text(), \"Systèmes d"+"'"+"énergie solaire et Powerwalls\")]")).size() > 0;
        assertThat(title5, is(true));
    }

    @Test
    public void testMenu() throws Exception {
        String lien1 = driver.findElement(By.xpath("//a[text() = 'Model S']")).getAttribute("href");
        assertThat(lien1, is("https://www.tesla.com/fr_fr/models"));
        String lien2 = driver.findElement(By.xpath("//a[text() = 'Model 3']")).getAttribute("href");
        assertThat(lien2, is("https://www.tesla.com/fr_fr/model3"));
        String lien3 = driver.findElement(By.xpath("//a[text() = 'Model X']")).getAttribute("href");
        assertThat(lien3, is("https://www.tesla.com/fr_fr/modelx"));
        String lien4 = driver.findElement(By.xpath("//a[text() = 'Cybertruck']")).getAttribute("href");
        assertThat(lien4, is("https://www.tesla.com/fr_fr/cybertruck"));
        String lien5 = driver.findElement(By.xpath("//a[text() = 'Roadster']")).getAttribute("href");
        assertThat(lien5, is("https://www.tesla.com/fr_fr/roadster"));
        String lien6 = driver.findElement(By.xpath("//a[text() = 'Recharger']")).getAttribute("href");
        assertThat(lien6, is("https://www.tesla.com/fr_fr/charging"));
    }



    @Test
    public void testBurgerMenu() throws Exception {
        String Burger1 = driver.findElement(By.xpath("//"))
    }

    // Test de la Story n ...
    // TODO
    // To Be Completed By Coders From Coding Factory

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
