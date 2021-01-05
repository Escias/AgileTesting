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

public class EnemyTest {

    Enemy enemy;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Avant le démarrage ENEMY");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Après tous les tests ENEMY");
    }

    @Before
    public void setUp() throws Exception {
        enemy = new Enemy("Mob", 1);
        System.out.println("Avant un test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Après un test");
    }

    @Test
    public void testEnemyProperties() throws Exception {
        assertThat(enemy, hasProperty("name"));
        assertThat(enemy, hasProperty("name", is("Mob")));
    }

    @Test
    public void testEnemyHp() throws Exception {
        assertThat(enemy.getHp(), equalTo(15*enemy.getLevel()));
    }

    @Test
    public void testEnemyDmg() throws Exception {
        enemy.takeDamage(3);
        assertThat(enemy.getHp(), allOf(lessThan(15*enemy.getLevel()), equalTo(15*enemy.getLevel()-3)));
    }

    @Test
    public void testEnemyAtk() throws Exception {
        Hero hero = new Hero("Jaina Portvaillant");
        enemy.attack(hero);
        assertThat(enemy.getHp(), lessThan(20));
    }
}