
package MongoDB;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;

public class MongoDBConnector {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "FirstSerwer";
    private MongoClient client;
    @Getter
    private MongoDatabase database;

    public MongoDBConnector() {
        try {
            client = MongoClients.create(CONNECTION_STRING);
            database = client.getDatabase(DATABASE_NAME);
            System.out.println("Połączono z bazą MongoDB: " + database.getName());
        } catch (Exception e) {
            System.out.println("Błąd połączenia: " + e.getMessage());
        }
    }

    public void closeConnection() {
        if (client != null) {
            client.close();
            System.out.println("Zamknięto połączenie z bazą MongoDB.");
        }
    }
}
