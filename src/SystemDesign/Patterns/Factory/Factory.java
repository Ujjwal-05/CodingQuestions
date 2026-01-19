package SystemDesign.Patterns.Factory;

/*
========================================================================================
FACTORY METHOD DESIGN PATTERN - DATABASE QUERY EXAMPLE
========================================================================================
Example from diagram:
- We have a Database abstraction which has a factory method: createQuery()
- Based on the DB type (MySQL / MongoDB), it returns different Query objects.
- Client code does not use "new SQLQuery()" or "new NoSQLQuery()" directly.

Flow:
Database db = new MySQLDatabase();   OR   new MongoDatabase();
Query q = db.createQuery();          <-- Factory Method
q.execute();

Benefits:
✅ OCP: Adding new DB type doesn't require changing client code
✅ SRP: Client doesn't handle object creation logic
========================================================================================
*/


interface Query {
    void execute();
}

class SQLQuery implements Query {
    @Override
    public void execute() {
        System.out.println("Executing SQL Query on MySQL Database...");
    }
}

class NoSQLQuery implements Query {
    @Override
    public void execute() {
        System.out.println("Executing NoSQL Query on MongoDB Database...");
    }
}

abstract class Database {
    abstract Query createQuery(); // Factory Method
}

class MySQLDatabase extends Database {
    @Override
    Query createQuery() {
        return new SQLQuery();
    }
}

class MongoDatabase extends Database {
    @Override
    Query createQuery() {
        return new NoSQLQuery();
    }
}

public class Factory {
    public static void main(String[] args) {

        // Example 1: MySQL
        Database db1 = new MySQLDatabase();
        Query q1 = db1.createQuery();   // Factory Method call
        q1.execute();

        // Example 2: MongoDB
        Database db2 = new MongoDatabase();
        Query q2 = db2.createQuery();   // Factory Method call
        q2.execute();
    }
}


