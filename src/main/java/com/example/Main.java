package com.example;

import java.io.IOException;
import com.example.Admin.LoginPage;
import com.example.Admin.User;
import com.example.Framework.Frame;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class Main {

    static LoginPage first = new LoginPage();
    public static Frame iPad = new Frame(first);
    public static User user;
    public static int numPhoto = 0;
    public static void main( String[] args ) throws IOException {
        MongoClient client = MongoClients.create("mongodb+srv://artistrymp4:artistrymp4project@artistry.zi4lf5v.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("artistry");
        MongoCollection<Document> col = db.getCollection("photos");
        numPhoto = (int) col.countDocuments();
        client.close();

        iPad.initComponents(new LoginPage());
        iPad.setVisible(true);
    }
}
