package p03_IteratorTest;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] ELEMENTS = {"element1","element2"};

    @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionIfElementsIsNull() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

   @Before
    public void initListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(ELEMENTS);
   }

   @Test
   public void shouldMoveIndex(){
        boolean move = this.listIterator.move();
        Assert.assertTrue(move);
   }

   @Test
   public void shouldReturnFalseWhenMovingMoreTimesThanThereAreItems(){
        this.listIterator.move();
        this.listIterator.move();
        boolean move = this.listIterator.move();
        Assert.assertFalse(move);
   }

   @Test
    public void shouldReturnTrueWhenTheCurrentElementIsNotTheLastOne(){
        boolean hasNext = this.listIterator.hasNext();
        Assert.assertTrue(hasNext);
   }

   @Test
    public void shouldReturnFalseWhenIndexIsAtTheLastElement(){
        this.listIterator.move();
        boolean hasNext = this.listIterator.hasNext();
        Assert.assertFalse(hasNext);
   }

   @Test
    public void shouldPrintTheElementAtFirstIndex(){
        String currentElement = this.listIterator.print();
        Assert.assertEquals(ELEMENTS[0],currentElement);
   }

   @Test (expected = IllegalStateException.class)
    public void shouldThrowExceptionIfPrintOnEmptyList() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();
        this.listIterator.print();
   }

}