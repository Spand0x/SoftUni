package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {

    private CustomLinkedList<String> list;
    private static final String ELEMENT_ONE = "Element 1";
    private static final String ELEMENT_TWO = "Element 2";

    @Before
    public void initList(){
        this.list = new CustomLinkedList<>();
    }



    @Test (expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWhenGettingElementFromEmptyListWithZeroIndex(){
        this.list.get(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWhenGettingElementFromEmptyListWithNegativeIndex(){
        this.list.get(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldReturnExceptionWhenGettingElementFromEmptyListWithPositiveIndex(){
        this.list.get(1);
    }

    @Test
    public void shouldReturnElementFromFirstPosition(){
        this.list.add(ELEMENT_ONE);
        String element = this.list.get(0);
        Assert.assertEquals("Did not return element from first position",ELEMENT_ONE,element);
    }

    @Test
    public void shouldReturnElementFromLastPosition(){
        this.list.add(ELEMENT_ONE);
        this.list.add(ELEMENT_TWO);
        String element = this.list.get(1);
        Assert.assertEquals("Did not return element from last position",ELEMENT_TWO,element);
    }

    @Test
    public void shouldReturnFalseWhenListIsEmptyAndDoesNotContainElement(){
        Assert.assertFalse(this.list.contains(ELEMENT_ONE));
    }

    @Test
    public void shouldReturnFalseWhenListDoesNotContainElement(){
        this.list.add(ELEMENT_ONE);
        Assert.assertFalse(this.list.contains(ELEMENT_TWO));
    }

    @Test
    public void shouldReturnTrueWhenListContainsElement(){
        this.list.add(ELEMENT_ONE);
        Assert.assertTrue(this.list.contains(ELEMENT_ONE));
    }

    @Test
    public void shouldAddNewItemToEmptyList(){
        this.list.add(ELEMENT_ONE);
        Assert.assertTrue(this.list.contains(ELEMENT_ONE));
    }

    @Test
    public void shouldAddNewItemAtLastPosition(){
        this.list.add(ELEMENT_ONE);
        this.list.add(ELEMENT_TWO);
        Assert.assertEquals("Element was not added at last position", 1,this.list.indexOf(ELEMENT_TWO));
    }



}