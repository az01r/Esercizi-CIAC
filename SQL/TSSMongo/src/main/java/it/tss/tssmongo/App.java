package it.tss.tssmongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Paolo
 */
public class App {
    public static void main(String[] args) {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase db = client.getDatabase("demo"); // prendo un db
        MongoCollection collection = db.getCollection("animals"); // prendo una collection, ovvero una tabella
        Animal giraffa = new Animal("giraffa", "mammifero");
        addAnimal(collection, giraffa);
        
    }

    private static void addAnimal(MongoCollection collection, Animal animal) {
        Document document = new Document("_id",new ObjectId()); // creo un documento, ovvero un record
        document.append("name", animal.getName()).append("type", animal.getType()); // appendo gli attributi
        List<Document> figli = new ArrayList<>();
        figli.add(new Document().append("nome", "figlio 1"));
        figli.add(new Document().append("nome", "figlio 2"));
        figli.add(new Document().append("nome", "figlio 3"));
      
        document.append("figli", figli); // appendo una lista
        collection.insertOne(document);
    }
}
