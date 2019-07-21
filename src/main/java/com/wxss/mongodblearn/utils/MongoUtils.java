package com.wxss.mongodblearn.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

/**
 * Author:Created by wx on 2019/7/15
 * Desc:
 */
public class MongoUtils {
    private static final MongoClient CLIENT_WITHOUT_AUTH;
    private static final MongoClient CLIENT_WITH_AUTH;

    static {

        CLIENT_WITHOUT_AUTH = new MongoClient("localhost", 27017);

        ServerAddress serverAddress = new ServerAddress("localhost",27017);
        MongoCredential credential =  MongoCredential.createCredential("root","admin","admin13579".toCharArray());
        CLIENT_WITH_AUTH = new MongoClient(serverAddress, Arrays.asList(credential));
    }

    public static MongoDatabase getMongoDatabaseWithoutAuth(String dbName){
        return CLIENT_WITHOUT_AUTH.getDatabase(dbName);
    }
    public static MongoDatabase getMongoDatabaseWithAuth(String dbName){
        return CLIENT_WITH_AUTH.getDatabase(dbName);
    }
}
