package com.wxss.mongodblearn.utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Author:Created by wx on 2019/7/15
 * Desc:
 */
public class MongoUtils {
    private static final MongoClient CLIENT;

    static {
        CLIENT = new MongoClient("localhost", 27017);
    }

    public static MongoDatabase getMongoDatabase(String dbName){
        return CLIENT.getDatabase(dbName);
    }
}
