package main.se.kth.iv1350.pos.exception;

public class DatabaseConnectionException extends Exception {

    private final String database;

    public DatabaseConnectionException(String database) {
        super("There is no connection with the database: " + database);
        this.database = database;
    }

    public String getDatabaseName() {
        return this.database;
    }
}
