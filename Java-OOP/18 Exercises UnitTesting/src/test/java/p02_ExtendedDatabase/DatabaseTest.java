package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private Person person;
    private static final int ID = 1;
    private static final String NAME = "Pesho";

    @Before
    public void initDatabase() throws OperationNotSupportedException {
        this.person = new Person(ID,NAME);
        this.database = new Database(person);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionIfEmptyDatabaseIsInit() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionIfTooBigDatabaseIsInit() throws OperationNotSupportedException{
        Database database = new Database(new Person[17]);
    }
    @Test
    public void shouldAddPersonToDatabase() throws OperationNotSupportedException {
        this.database.add(new Person(2,"Gosho"));
        Assert.assertEquals("Adding person was not successful",2,this.database.getElements().length);
    }


    @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionIfNullIDIsPresent() throws OperationNotSupportedException {
       this.database.add(null);
    }

    @Test
    public void databaseShouldBeEmptyAfterRemovingTheOnlyPerson() throws OperationNotSupportedException {
        this.database.remove();
        Assert.assertEquals("Database is not empty",0,database.getElements().length);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenRemovingFromEmptyDatabase() throws OperationNotSupportedException {
        this.database.remove();
        this.database.remove();
    }

    @Test
    public void shouldFindPersonByUsername() throws OperationNotSupportedException{
        Person foundPerson = this.database.findByUsername(NAME);
        Assert.assertEquals(person,foundPerson);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenFindingPersonByNotPresentedUsername() throws OperationNotSupportedException {
        this.database.findByUsername("Gosho");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenFindingPersonByNullUsername() throws OperationNotSupportedException{
        this.database.findByUsername(null);
    }

    @Test
    public void shouldFindPersonByID() throws OperationNotSupportedException{
        Person foundPerson = this.database.findById(ID);
        Assert.assertEquals(person,foundPerson);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void shouldThrowExceptionWhenFindingPersonByNotPresentedID() throws OperationNotSupportedException{
        this.database.findById(2);
    }


}
