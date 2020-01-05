package heroRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    private final static String HERO_NAME = "Aladin";
    private final static int HERO_LEVEL = 1;
    private final static int ITEM_STRENGTH = 10;
    private final static int ITEM_AGILITY = 10;
    private final static int ITEM_INTELLIGENCE = 10;

    private Hero hero;
    private Item item;
    private HeroRepository heroRepository;

    @Before
    public void createRepository() {
        this.item = new Item(ITEM_STRENGTH, ITEM_AGILITY, ITEM_INTELLIGENCE);
        this.hero = new Hero(HERO_NAME, HERO_LEVEL, this.item);
        this.heroRepository = new HeroRepository();
    }


    @Test
    public void getCountShouldReturnZeroWhenCollectionIsEmpty(){
        int count = this.heroRepository.getCount();
        assertEquals(0,count);
    }

    @Test
    public void getCountShouldReturnTheSizeOfTheRepository(){
        this.heroRepository.add(hero);
        this.heroRepository.add(new Hero("Gosho",10,new Item(1,1,1)));
        int count = this.heroRepository.getCount();
        assertEquals(2,count);

    }

    @Test
    public void constructorShouldCreateNewCollection() {
        HeroRepository heroRepository = new HeroRepository();
        int count = heroRepository.getCount();
        assertEquals(0, count);
    }

    @Test
    public void addShouldAddHeroToRepository() {
        this.heroRepository.add(this.hero);
        int count = this.heroRepository.getCount();
        assertEquals(1, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldThrowExceptionWhenAddingRepositoryAlreadyContainsHero() {
        this.heroRepository.add(hero);
        this.heroRepository.add(hero);
    }

    @Test
    public void addShouldReturnCorrectMessageWhenAddingSameHeroTwice() {
        String message = "";
        this.heroRepository.add(hero);
        try {
            this.heroRepository.add(hero);
        } catch (IllegalArgumentException e) {
            message = e.getMessage();
        }
        assertEquals("Duplicate heroes!", message);
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowWhenRepositoryIsEmpty() {
        this.heroRepository.remove(HERO_NAME);
    }

    @Test
    public void removeShouldRemoveHeroFromRepository() {
        this.heroRepository.add(hero);
        this.heroRepository.remove(HERO_NAME);
        int count = this.heroRepository.getCount();
        assertEquals(0, count);
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowExceptionWhenHeroIsNotPresentedInRepository() {
        this.heroRepository.add(hero);
        this.heroRepository.remove("Gosho");
    }

    @Test
    public void removeShouldReturnCorrectMessageWhenRemovingFromEmptyRepository() {
        String message = "";
        try {
            this.heroRepository.remove(HERO_NAME);
        } catch (NullPointerException e) {
            message = e.getMessage();
        }
        assertEquals("Hero doesn't exist", message);
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthShouldThrowWhenRepositoryIsEmpty() {
        this.heroRepository.getHeroWithHighestStrength();
    }

    @Test
    public void getHeroWithHighestStrengthShouldReturnTheHeroWithHighestStrength() {
        this.heroRepository.add(this.hero);
        this.heroRepository.add(new Hero("Gosho",10,new Item(1,1,1)));
        Hero heroWithHighestStrength = this.heroRepository.getHeroWithHighestStrength();
        assertEquals(this.hero, heroWithHighestStrength);
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityShouldThrowWhenRepositoryIsEmpty() {
        this.heroRepository.getHeroWithHighestAgility();
    }

    @Test
    public void getHeroWithHighestAgilityShouldReturnTheHeroWithHighestAgility() {
        this.heroRepository.add(this.hero);
        this.heroRepository.add(new Hero("Gosho",10,new Item(1,1,1)));
        Hero heroWithHighestAgility = this.heroRepository.getHeroWithHighestAgility();
        assertEquals(this.hero, heroWithHighestAgility);
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceShouldThrowWhenRepositoryIsEmpty() {
        this.heroRepository.getHeroWithHighestIntelligence();
    }

    @Test
    public void getHeroWithHighestIntelligenceShouldReturnTheHeroWithHighestIntelligence() {
        this.heroRepository.add(this.hero);
        this.heroRepository.add(new Hero("Gosho",10,new Item(1,1,1)));
        Hero heroWithHighestIntelligence = this.heroRepository.getHeroWithHighestIntelligence();
        assertEquals(this.hero, heroWithHighestIntelligence);
    }

    @Test
    public void toStringShouldReturnEmptyStringOnEmptyRepository() {
        String string = this.heroRepository.toString();
        assertEquals("", string);
    }

    @Test
    public void toStringShouldReturnCorrectString() {
        this.heroRepository.add(hero);
        String string = this.heroRepository.toString();
        String expected = String.format("Hero: %s – %d%n" +
                        "  *  Strength: %d%n" +
                        "  *  Agility: %d%n" +
                        "  *  Intelligence: %d%n", hero.getName(), hero.getLevel(),
                hero.getItem().getStrength(),
                hero.getItem().getAgility(),
                hero.getItem().getIntelligence());
        assertEquals(expected, string);
    }
}