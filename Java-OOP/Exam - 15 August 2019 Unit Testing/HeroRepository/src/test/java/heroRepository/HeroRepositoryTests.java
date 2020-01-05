package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class HeroRepositoryTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS HeroRepository
    private HeroRepository heroRepository;
    private Hero hero;
    private static final String DEFAULT_HERO_NAME = "Pesho";
    private static final int DEFAULT_HERO_LEVEL = 1;


    @Before
    public void createRepositoryAndHero(){
        this.heroRepository = new HeroRepository();
        this.hero = new Hero(DEFAULT_HERO_NAME,DEFAULT_HERO_LEVEL);
    }

    @Test
    public void getCountShouldReturnZeroOnEmptyRepository(){
        HeroRepository heroRepository = new HeroRepository();
        int count = heroRepository.getCount();
        assertEquals(0,count);
    }

    @Test
    public void getCountShouldReturnTheAmountOfHeroesInTheRepository(){
        this.heroRepository.create(hero);
        int count = this.heroRepository.getCount();
        assertEquals(1,count);
    }

    @Test (expected = NullPointerException.class)
    public void createShouldThrowExceptionWhenNullHeroIsCreated(){
        this.heroRepository.create(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void createShouldThrowExceptionWhenAddingTheSameHero(){
        this.heroRepository.create(this.hero);
        this.heroRepository.create(this.hero);
    }

    @Test
    public void createShouldAddHeroToTheRepository(){
        String created = this.heroRepository.create(this.hero);
        String expected = String.format("Successfully added hero %s with level %d", DEFAULT_HERO_NAME, DEFAULT_HERO_LEVEL);
        assertEquals(expected,created);
    }



    @Test (expected = NullPointerException.class)
    public void removeShouldThrowExceptionWhenHeroNameIsNull(){
        this.heroRepository.remove(null );
    }

    @Test (expected = NullPointerException.class)
    public void removeShouldThrowExceptionWhenHeroNameIsEmpty(){
        this.heroRepository.remove("" );
    }

    @Test
    public void removeShouldReturnTrueWhenHeroIsRemoved(){
        this.heroRepository.create(this.hero);
        boolean isRemoved = this.heroRepository.remove(DEFAULT_HERO_NAME);
        assertTrue(isRemoved);
    }

    @Test
    public void removeShouldReturnFalseWhenHeroIsNotPresented(){
        this.heroRepository.create(this.hero);
        boolean isRemove = this.heroRepository.remove("Gosho");
        assertFalse(isRemove);
    }

    @Test
    public void getHeroWithHighestLevelShouldReturnNullIfRepositoryIsEmpty(){
        Hero heroWithHighestLevel = this.heroRepository.getHeroWithHighestLevel();
        assertNull(heroWithHighestLevel);
    }

    @Test
    public void getHeroWithHighestLevelShouldReturnTheHeroWithBiggerLevel(){
        heroRepository.create(hero);
        Hero highestHero = new Hero("Gosho",2);
        heroRepository.create(highestHero);
        Hero heroWithHighestLevel = heroRepository.getHeroWithHighestLevel();
        assertEquals(highestHero,heroWithHighestLevel);
    }

    @Test
    public void getHeroShouldReturnNullWhenRepositoryIsEmpty(){
        Hero hero = heroRepository.getHero(DEFAULT_HERO_NAME);
        assertNull(hero);
    }

    @Test
    public void getHeroShouldReturnNullWhenHeroWithGivenNameIsNotPresented(){
        heroRepository.create(hero);
        Hero getHero = heroRepository.getHero("Gosho");
        assertNull(getHero);
    }

    @Test
    public void getHeroShouldReturnHeroWithGivenName(){
        heroRepository.create(hero);
        Hero getHero = heroRepository.getHero(DEFAULT_HERO_NAME);
        assertEquals(this.hero,getHero);

    }

    @Test
    public void getHeroesShouldReturnEmptyCollectionWhenRepositoryIsEmpty(){
        Collection<Hero> heroes = heroRepository.getHeroes();
        assertTrue(heroes.isEmpty());
    }

    @Test
    public void getHeroesShouldReturnCollectionWithAllHeroes(){
        Hero newHero = new Hero("Gosho",2);
        List<String> heroList = new LinkedList<>();
        heroList.add(this.hero.getName());
        heroList.add(newHero.getName());

        heroRepository.create(this.hero);
        heroRepository.create(newHero);
        Collection<Hero> heroes = heroRepository.getHeroes();
        List<String> heroesNames = new LinkedList<>();
        for (Hero currentHero : heroes) {
            heroesNames.add(currentHero.getName());
        }
        assertEquals(heroList,heroesNames);
    }
}
