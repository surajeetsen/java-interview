package com.feecalculator;

import com.feecalculator.common.TxnFeeTemplateImpl;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.io.File;
import java.util.Iterator;

public class FeeCalculatorApp {

    public static void main(String[] args) {
        /*File file = new File("resources/sampleData.xlsx");
        TxnFeeTemplateImpl template = new TxnFeeTemplateImpl();
        template.feeCalculatorTemplate(file);*/

        //MongoClient mongoClient = new MongoClient("localhost", 27017);
        /*System.out.println("Database connection successful");

        MongoDatabase db = mongoClient.getDatabase("test");
        MongoCollection collection = db.getCollection("emps");

        *//*FindIterable iter = collection.find();

        Iterator it = iter.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }*//*

        collection.find().forEach(System.out::println);*/

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));



    }

}