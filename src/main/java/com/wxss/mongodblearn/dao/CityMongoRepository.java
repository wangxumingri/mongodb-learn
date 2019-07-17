package com.wxss.mongodblearn.dao;

import com.wxss.mongodblearn.entity.City;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Author:Created by wx on 2019/7/17
 * Desc:
 */
public interface CityMongoRepository extends MongoRepository<City,String> {
}
