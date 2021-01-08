package test;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import codingfactory.rpgconsole.hero.Hero;
import codingfactory.rpgconsole.enemy.Enemy;

public class HeroTest {

	Hero hero;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Avant le démarrage HERO");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Après tous les tests HERO");
	}

	@Before
	public void setUp() throws Exception {
		hero = new Hero("Jaina Portvaillant");
		System.out.println("Avant un test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Après un test");
	}

	@Test
	public void testHeroProperties() throws Exception {
		assertThat(hero, hasProperty("name"));
		assertThat(hero, hasProperty("name", is("Jaina Portvaillant")));
	}

	@Test
	public void testHeroHp() throws Exception {
		assertThat(hero.getHp(), equalTo(20));
	}

	@Test
	public void testHeroLevel(){
		assertThat(hero.getLevel(), equalTo(1));
	}

	@Test
	public void testHeroAtk(){
		assertThat(hero.getAtk(), equalTo(2));
	}

	@Test
	public void testHeroDmg() throws Exception {
		hero.takeDamage(3);
		assertThat(hero.getHp(), allOf(lessThan(20), equalTo(17)));
	}

	@Test
	public void testHeroAttack() throws Exception {
		Enemy enemy = new Enemy("Mob", 1);
		hero.attack(enemy);
		assertThat(enemy.getHp(), lessThan(15));
	}

	@Test
	public void testHeroLevelUp() throws Exception {
		hero.levelUp();
		assertThat(hero.getLevel(), is(2));
	}
}
