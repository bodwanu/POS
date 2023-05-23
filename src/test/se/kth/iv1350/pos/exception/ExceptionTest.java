package test.se.kth.iv1350.pos.exception;

import main.se.kth.iv1350.pos.exception.DatabaseConnectionException;
import main.se.kth.iv1350.pos.exception.ItemNotFoundException;
import org.junit.Test;

public class ExceptionTest {

    @Test(expected = ItemNotFoundException.class)
    public void testItemNotFoundException() throws ItemNotFoundException {
        throw new ItemNotFoundException("Item not found");
    }

    @Test(expected = DatabaseConnectionException.class)
    public void testDatabaseConnectionException() throws DatabaseConnectionException {
        throw new DatabaseConnectionException("Database error");
    }
}