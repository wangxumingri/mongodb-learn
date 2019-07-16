package com.wxss.mongodblearn;

import com.mongodb.client.MongoDatabase;
import com.wxss.mongodblearn.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Author:Created by wx on 2019/7/15
 * Desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void testSave() {
        User user = new User();
        // 实体类没有id属性，且没有显示声明哪个属性是主键时，MongoDB会增加一个_id字段，并设其值为ObjectId(...)
//        user.setUid("没有id属性");  //
//        user.setName("且没有使用@Id注解");
        // 实体类有id属性，且没有声明哪个属性是主键时，MongoDB默认将id属性映射为_id字段，如果id属性有值，就以其值为_id的值，否则自动生成ObjectId(...)为值
//        user.setId("id值");

//                user.setUid("没有id属性");  //

        user.setName("id为null,使用@Id注解");

        user.setPassword("222");
//        List<User> userList = new ArrayList<>();
//        userList.add(user);

//        mongoTemplate.insert(userList, "user");// 保存多个
        User insert = mongoTemplate.insert(user);// 保存一个对象
        System.out.println(insert);
//        mongoTemplate.save(userList,"user"); // 保存一个对象

    }

    @Test
    public void testFind() {
        User user = new User();
        user.setName("insert保存多个数据");
        user.setPassword("6666");
        System.out.println(user.getName());
        MongoDatabase db = mongoTemplate.getDb();
        System.out.println(db.getName());

        Set<String> collectionNames = mongoTemplate.getCollectionNames();

        for (String collectionName : collectionNames) {
            System.out.println(collectionName);
        }

        Query query = new Query(Criteria.where("userName").is(user.getName()));
        User one = mongoTemplate.findOne(query, User.class, "user");

        System.out.println(one);
    }

    @Test
    public void testFindAll() {
        List<User> userList = mongoTemplate.findAll(User.class, "user");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindWithQuery() {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("insert保存").and("_id").is("5d2c48bccdb187113c9136d3"));
        List<User> userList = mongoTemplate.find(query, User.class, "user");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 根据正则表达式查询
     */
    @Test
    public void testFindByRegex(){
        Query query = new Query(Criteria.where("name").regex("^模板"));
        List<User> userList = mongoTemplate.find(query, User.class);
        System.out.println(userList);
    }

    /**
     * 比较运算符查询
     */
    @Test
    public void testLtAndGt(){
        Query query = new Query(Criteria.where("age").lt(20).gt(11).ne(12));
        List<User> userList = mongoTemplate.find(query, User.class,"users");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 排序查询
     */
    @Test
    public void testSort(){
        Query query = new Query();
        // 根据age字段降序查询
        query.with(new Sort(Sort.Direction.DESC,"age"));
        List<User> userList = mongoTemplate.find(query, User.class,"users");
        for (User user : userList) {
            System.out.println(user);
        }
    }
    /**
     * 分页查询
     */
    @Test
    public void testPage(){
        Query query = new Query();
        Pageable pageable = PageRequest.of(0, 2);
        query.with(pageable);
        List<User> userList = mongoTemplate.find(query, User.class,"user");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate(){
//        mongoTemplate.upsert()
    }
}
