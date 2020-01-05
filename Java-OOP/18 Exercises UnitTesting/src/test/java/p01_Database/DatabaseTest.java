package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import javax.xml.crypto.Data;
import java.util.concurrent.ThreadLocalRandom;

public class DatabaseTest {

    private Database database;
    private Integer[] numbers;

    @Before
    public void initDatabase() throws OperationNotSupportedException {
        this.numbers = initNumbers(6);
        this.database = new Database(numbers);
    }

    private Integer[] initNumbers(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt();
        }
        return arr;
    }

    @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionIfMoreThanSixteenIntegers() throws OperationNotSupportedException {
       Database database = new Database(new Integer[17]);
   }

   @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWithNullParameters() throws OperationNotSupportedException {
       Database database = new Database();
   }

   @Test
    public void shouldCreateObjectWithValidParameters(){
        Integer[] elements = this.database.getElements();
        Assert.assertEquals(numbers.length,elements.length);
   }

   @Test
    public void shouldSetElementsInCorrectOrder(){
        Integer[] elements = this.database.getElements();
        Assert.assertArrayEquals(numbers,elements);
   }

   @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenAddingNull() throws OperationNotSupportedException {
        this.database.add(null);
   }

   @Test
    public void shouldAddElementToFirstEmptySpace() throws OperationNotSupportedException {
        Integer element = 5;
        this.database.add(element);
        Integer[] elements = this.database.getElements();
       Assert.assertEquals(element,elements[elements.length-1]);
   }

   @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenRemovingFromEmptyDatabase() throws OperationNotSupportedException {
        Database database = new Database(1);
        database.remove();
        database.remove();
   }

   @Test
    public void shouldRemoveElementFromLastPosition() throws OperationNotSupportedException {
        this.database.remove();

        Integer[] elements = this.database.getElements();
        Integer lastElement = elements[elements.length-1];
        Assert.assertEquals(this.numbers[this.numbers.length-2],lastElement);
   }



}
