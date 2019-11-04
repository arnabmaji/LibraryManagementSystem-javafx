package io.github.arnabmaji19.model;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Database {
    //Singleton class

    private static final Database instance = new Database();
    private static final String DATABASE_NAME = "LibraryDatabase";
    private MongoDatabase database;

    private Database(){
        //Setting Up MongoDatabase for POJOs
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();
        MongoClient client = MongoClients.create(settings);
        database = client.getDatabase(DATABASE_NAME);
    }


    public static Database getInstance() {
        return instance;
    }

    public MongoCollection<Librarian> getLibrarianCollection(){ return database.getCollection("Librarian", Librarian.class); }

    public MongoCollection<Book> getBookCollection(){
        return database.getCollection("Book", Book.class);
    }

    public MongoCollection<IssueDetail> getIssueDetailCollection() { return database.getCollection("IssueDetails", IssueDetail.class); }
}
