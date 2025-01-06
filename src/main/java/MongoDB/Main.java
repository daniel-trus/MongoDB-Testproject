package MongoDB;

import Basic.Fields;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        MongoDBConnector connector = new MongoDBConnector();
        MongoDBOperations operations = new MongoDBOperations(connector.getDatabase());

        Fields fields = new Fields(1,"Daniel","Trus","dan-test@test.com");

        Document document = fields.toDocument();

        operations.insertDocument("MyCollection",document);

        // Zamknięcie połączenia
        connector.closeConnection();
    }
}
