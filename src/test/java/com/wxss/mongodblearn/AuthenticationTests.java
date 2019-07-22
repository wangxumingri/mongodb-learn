package com.wxss.mongodblearn;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.wxss.mongodblearn.entity.Goods;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:Created by wx on 2019/7/18
 * Desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationTests {

    @Test
    public void testAuth(){
        //服务器地址 和 端口
        ServerAddress serverAddress = new ServerAddress("localhost",27017);
        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
        addrs.add(serverAddress);
        //用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createScramSha1Credential("test", "test", "admin13579".toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);
        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(addrs,credentials);
        //连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        // 获取集合
        MongoCollection<Document> goods = mongoDatabase.getCollection("goods");
        // 查询
        FindIterable<Document> findIterable = goods.find();
        for (Document document : findIterable) {
            System.out.println(document);
        }
        System.out.println("Connect to database successfully");
    }

//
//    @Autowired
//    private MongoTemplate mongoTemplate;

    @Test
    public void springBootAuth(){
//        List<Goods> goods = mongoTemplate.findAll(Goods.class);
//        for (Goods good : goods) {
//            System.out.println(good);
//        }
    }



    @Test
    public void testSpringAuth(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mongodb.xml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        MongoClient mongo = applicationContext.getBean("mongoClient", MongoClient.class);
        MongoDatabase local = mongo.getDatabase("local");
        MongoCollection<Document> startup_log = local.getCollection("startup_log");
        FindIterable<Document> findIterable = startup_log.find();

        for (Document document : findIterable) {
            System.out.println(document);
        }

        System.out.println("*************************");
        MongoDbFactory mongoDbFactory = applicationContext.getBean("mongoDbFactory", MongoDbFactory.class);

        MongoDatabase db = mongoDbFactory.getDb();
        String name = db.getName();
        System.out.println(name);
        MongoTemplate MongoTemplate = applicationContext.getBean("anotherMongoTemplate", MongoTemplate.class);
        MongoDatabase db1 = MongoTemplate.getDb();

        System.out.println(MongoTemplate);
        System.out.println(db1.getName());
        List<Goods> all = MongoTemplate.findAll(Goods.class);
        System.out.println(all);
//        MongoDatabase db = mongo.getDatabase("test");
//        MongoCollection<Document> c = db.getCollection("goods");
//        FindIterable<Document> findIterable = c.find();
//        for (Document document : findIterable) {
//            System.out.println(document);
//        }
    }
}
