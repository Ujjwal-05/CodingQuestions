package SystemDesign.Patterns.Factory;

/*
========================================================================================
ABSTRACT FACTORY DESIGN PATTERN - DATABASE EXAMPLE
========================================================================================
Why Abstract Factory?
- Factory Method creates only ONE product (ex: createQuery()).
- But in real DB systems, choosing a DB means we need a FAMILY of related objects:
  ✅ Query
  ✅ Transaction
  ✅ Updater (Update/Insert/Delete)
- All these objects must be compatible with each other (MySQL family with MySQL family).

Solution:
- Create an Abstract Factory: DatabaseFactory
- Concrete Factories: MySQLFactory, MongoFactory
- Each factory creates a full set of related objects.
========================================================================================
*/


/*
========================================================================================
PRODUCT FAMILY 1: Query
========================================================================================
*/
//interface Query {
//    void execute();
//}

class MySQLQuery implements Query {
    @Override
    public void execute() {
        System.out.println("Executing SQL Query on MySQL...");
    }
}

class MongoQuery implements Query {
    @Override
    public void execute() {
        System.out.println("Executing NoSQL Query on MongoDB...");
    }
}


/*
========================================================================================
PRODUCT FAMILY 2: Transaction
========================================================================================
*/
interface Transaction {
    void begin();
    void commit();
}

class MySQLTransaction implements Transaction {
    @Override
    public void begin() {
        System.out.println("MySQL Transaction BEGIN");
    }

    @Override
    public void commit() {
        System.out.println("MySQL Transaction COMMIT");
    }
}

class MongoTransaction implements Transaction {
    @Override
    public void begin() {
        System.out.println("MongoDB Transaction BEGIN");
    }

    @Override
    public void commit() {
        System.out.println("MongoDB Transaction COMMIT");
    }
}


/*
========================================================================================
PRODUCT FAMILY 3: Updater
========================================================================================
*/
interface Updater {
    void update(String data);
}

class MySQLUpdater implements Updater {
    @Override
    public void update(String data) {
        System.out.println("Updating MySQL table with data: " + data);
    }
}

class MongoUpdater implements Updater {
    @Override
    public void update(String data) {
        System.out.println("Updating MongoDB collection with data: " + data);
    }
}


/*
========================================================================================
ABSTRACT FACTORY
========================================================================================
- Creates a family of related objects
========================================================================================
*/
interface DatabaseFactory {
    Query createQuery();
    Transaction createTransaction();
    Updater createUpdater();
}


/*
========================================================================================
CONCRETE FACTORIES
========================================================================================
*/
class MySQLFactory implements DatabaseFactory {

    @Override
    public Query createQuery() {
        return new MySQLQuery();
    }

    @Override
    public Transaction createTransaction() {
        return new MySQLTransaction();
    }

    @Override
    public Updater createUpdater() {
        return new MySQLUpdater();
    }
}

class MongoFactory implements DatabaseFactory {

    @Override
    public Query createQuery() {
        return new MongoQuery();
    }

    @Override
    public Transaction createTransaction() {
        return new MongoTransaction();
    }

    @Override
    public Updater createUpdater() {
        return new MongoUpdater();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {

        // Choose factory at runtime (example: MySQL)
        DatabaseFactory factory = new MySQLFactory();

        Query query = factory.createQuery();
        Transaction tx = factory.createTransaction();
        Updater updater = factory.createUpdater();

        tx.begin();
        query.execute();
        updater.update("name='Ujjwal'");
        tx.commit();


        System.out.println("------------------------------------------------");

        // Choose factory at runtime (example: MongoDB)
        DatabaseFactory factory2 = new MongoFactory();

        Query query2 = factory2.createQuery();
        Transaction tx2 = factory2.createTransaction();
        Updater updater2 = factory2.createUpdater();

        tx2.begin();
        query2.execute();
        updater2.update("{name:'Ujjwal'}");
        tx2.commit();
    }
}

