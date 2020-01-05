package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class HeroTests {
    private static final int TARGET_XP = 10;

    @Test
    public void doesHeroGetsXPWhenTargetDies(){
        Target fakeTarget = Mockito.mock(Target.class);
        Weapon fakeWeapon = Mockito.mock(Weapon.class);
        Mockito.when(fakeTarget.isDead()).thenReturn(true);
        Mockito.when(fakeTarget.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero("hero",fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals("Wrong experience",TARGET_XP,hero.getExperience());
    }
}
