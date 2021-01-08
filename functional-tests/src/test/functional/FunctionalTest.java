package test.functional;

import java.util.concurrent.TimeUnit;
import java.util.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class FunctionalTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
        driver = new ChromeDriver();
        // Seems no more working in last Chrome versions
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.tesla.com/fr_FR/");
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
    public void testMenu() throws Exception {
        List<String> listMenu = Arrays.asList("/fr_fr/models", "/fr_fr/model3", "/fr_fr/modelx", "/fr_fr/modely", "/fr_fr/powerwall", "/fr_fr/charging");
        for(String menu : listMenu) {
            String url = "https://www.tesla.com"+menu;
            assertEquals(driver.findElement(By.xpath("//a[contains(@href, \"" + menu + "\")]")).getAttribute("href"), url);
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
