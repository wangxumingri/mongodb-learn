package com.wxss.mongodblearn;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.wxss.mongodblearn.utils.MongoUtils;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbLearnApplicationTests {
    MongoDatabase db = MongoUtils.getMongoDatabase("test");

    @Test
    public void testGet() {
        MongoCollection<Document> goodsCol = db.getCollection("goods");

        List<Document> documents = new ArrayList<>();
        Document document = new Document();
        document.append("name", "ccc");
        document.append("price", 123);
        document.append("status", false);
        documents.add(document);
        // 插入一个
//        goodsCol.insertOne(document);
        // 插入多个
        document = new Document();
        document.append("name", "bbb");
        document.append("price", 321);
        document.append("status", false);
        documents.add(document);

        document = new Document();
        document.append("name", "bbb");
        document.append("price", 321);
        document.append("status", false);
        documents.add(document);
        goodsCol.insertMany(documents);
        // 查询
        FindIterable<Document> findIterable = goodsCol.find();
        for (Document value : findIterable) {
            System.out.println(value);
        }
    }

    @Test
    public void update(){
        MongoCollection<Document> goodsCol = db.getCollection("goods");
        Bson filters = Filters.eq("name", "ccc");
        Document document = new Document();
        document.append("name", "ddd");
        // 没有的field会自动创建
        document.append("count", 666);
        Document newValue = new Document("$set",document);
        // 只会匹配第一个
        goodsCol.updateOne(filters, newValue);

        // 查询
        FindIterable<Document> findIterable = goodsCol.find();
        for (Document value : findIterable) {
            System.out.println(value);
        }
    }
    @Test
    public void deleteOne(){
        MongoCollection<Document> users = db.getCollection("users");
        FindIterable<Document> findIterable = users.find();
        System.out.println("删除前...");
        for (Document document : findIterable) {
            System.out.println(document);
        }
        // 删除
        Bson filter = Filters.eq("age", 23);
        users.deleteOne(filter);

        findIterable = users.find();
        System.out.println("删除后...");
        for (Document document : findIterable) {
            System.out.println(document);
        }
    }

    @Test
    public void deleteAll(){
        MongoCollection<Document> users = db.getCollection("users");
        FindIterable<Document> findIterable = users.find();
        System.out.println("删除前...");
        for (Document document : findIterable) {
            System.out.println(document);
        }
        // 删除
        findIterable = users.find();
        System.out.println("删除后...");
        for (Document document : findIterable) {
            System.out.println(document);
        }
    }
}
