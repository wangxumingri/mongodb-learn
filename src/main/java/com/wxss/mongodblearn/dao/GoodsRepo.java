package com.wxss.mongodblearn.dao;

import com.wxss.mongodblearn.entity.Goods;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Author:Created by wx on 2019/7/16
 * Desc:,
 */
public interface GoodsRepo extends MongoRepository<Goods,String>,QuerydslPredicateExecutor<Goods> {
}
