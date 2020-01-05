package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTests {

    private Dummy dummy;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;


    public void createAliveDummy(){
        this.dummy = new Dummy(DUMMY_HEALTH,DUMMY_EXPERIENCE);
    }

    public void createDeadDummy(){
        this.dummy = new Dummy(-DUMMY_HEALTH,DUMMY_EXPERIENCE);
    }

    @Test
    public void dummyShouldLoseHealthAfterAttacked(){
        createAliveDummy();
        this.dummy.takeAttack(DUMMY_HEALTH);
        Assert.assertEquals("Wrong health",0,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyShouldThrowExceptionIfAttacked(){
        createDeadDummy();
        dummy.takeAttack(1);
    }

    @Test
    public void deadDummyShouldGiveXP(){
        createDeadDummy();
        Assert.assertEquals("Wrong experience",DUMMY_EXPERIENCE,dummy.giveExperience());
    }

    @Test (expected = IllegalStateException.class)
    public void aliveDummyShouldNotGiveXP(){
        createAliveDummy();
        this.dummy.giveExperience();

    }
}
