package com.example.examenmongo;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

public class ConexionMongo {

    ConnectionString connectionString = new ConnectionString("mongodb+srv://DiegoJC:1234" +
            "@cluster0.eq2v3bi.mongodb.net/?retryWrites=true&w=majority");
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase("Musica");
    public boolean insertar(Cancion c){
        MongoCollection<Document> collection=database.getCollection("cancion");
        Document document=new Document("idCancion", c.getIdCancion())
                .append("nombre", c.getNombre())
                .append("artista", c.getArtista())
                .append("año", c.getAño())
                .append("genero", c.getGenero());
        collection.insertOne(document);
        return true;
    }
    public boolean actualizar(Cancion cancionAnterior, Cancion cancionNueva){
        MongoCollection<Document> collection = database.getCollection("cancion");
        Bson filter = Filters.eq("idCancion", cancionAnterior.getIdCancion());
        Document document=new Document("idCancion", cancionNueva.getIdCancion())
                .append("nombre", cancionNueva.getNombre())
                .append("artista", cancionNueva.getArtista())
                .append("año", cancionNueva.getAño())
                .append("genero", cancionNueva.getGenero());
        Bson update = new Document("$set", document);
        UpdateResult result = collection.updateOne(filter, update);
        System.out.println(result.getModifiedCount() + " documentos modificados");
        return true;
    }

    public boolean mostrar() {
        try {
            MongoCollection<Document> collection = database.getCollection("cancion");
            FindIterable<Document> documents = collection.find();
            for (Document document : documents) {
                System.out.println(document.toJson());
            }
            return true;
        } catch (Exception e) {
            System.out.println("Hubo un error");
            return false;
        }
    }
    public boolean eliminar(int idCancion){
        MongoCollection<Document> collection = database.getCollection("cancion");
        Bson filter = Filters.eq("idCancion", idCancion);
        DeleteResult result = collection.deleteOne(filter);
        System.out.println(result.getDeletedCount() + " documentos eliminados");
        return true;
    }


}
