package com.wxss.mongodblearn.dao;

import com.wxss.mongodblearn.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

/**
 * Author:Created by wx on 2019/7/15
 * Desc:
 *     1.可使用父类的方法查询
 *     2.也可自己定义符合命名规则的方法查询
 *     3.还可使用@Query注解+MongoDB Json Query String查询
 */
public interface MongoRepo extends MongoRepository<User,String>{

    /**
     * @Query("{'key':?n}")
     * key:文档中的字段
     * ？：表示占位符
     * n :参数索引，匹配方法的入参（n>=0,且为整数）
     * @param name
     * @return
     */
    @Query("{'name':?0}")
    List<User> findList(String name);


    @Query("{'age':{$gt:?0,$lt:?1}}")
    List<User> findList(int gt,int lt);
}
