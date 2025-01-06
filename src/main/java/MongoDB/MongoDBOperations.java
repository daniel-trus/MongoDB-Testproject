package MongoDB;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class MongoDBOperations {
    private final MongoDatabase database;

    public MongoDBOperations(MongoDatabase database) {
        this.database = database;
    }

    public void insertDocument(String collectionName, Document document) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            collection.insertOne(document);
            System.out.println("Dodano dokument: " + document.toJson());
        } catch (Exception e) {
            System.out.println("Błąd podczas dodawania dokumentu " + e.getMessage());
        }
    }

    public void findDocuments(String collectionName) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            try (MongoCursor<Document> cursor = collection.find().iterator()) {
                while (cursor.hasNext()) {
                    System.out.println("Pobrano dokument: " + cursor.next().toJson());
                }
            }
        } catch (Exception e) {
            System.out.println("Nie znaleziono dokumentu: " + e.getMessage());
        }
    }


    public void updateDocument(String collectionName, String key, Object valueToFind, Document updatedDocument) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            collection.updateOne(Filters.eq(key, valueToFind), new Document("$set", updatedDocument));
            System.out.println("Zaktualizowano dokument o " + key + ": " + valueToFind + " na " + updatedDocument.toJson());
        } catch (Exception e) {
            System.out.println("Błąd podczas aktualizowania dokumentu: " + e.getMessage());
        }
    }

    public void deleteDocument(String collectionName, String key, Object value) {
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            Document filter = new Document(key, value);
            collection.deleteOne(filter);
            System.out.println("Dokument usunięty: " + filter.toJson());
        } catch (Exception e) {
            System.out.println("Błąd podczas usuwania dokumentu: " + e.getMessage());
        }
    }
}
