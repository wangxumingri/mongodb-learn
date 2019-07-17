package com.wxss.mongodblearn;

import com.wxss.mongodblearn.dao.CityMongoRepository;
import com.wxss.mongodblearn.entity.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author:Created by wx on 2019/7/17
 * Desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CityTests {
    @Autowired
    private CityMongoRepository cityMongoRepository;
    @Test
    public void testSave(){
        City city = new City();

        city.setCid(12346L);
        city.setArea(22122.1);
        city.setName("港港");
        city.setPeopleCount(31333L);

        cityMongoRepository.save(city);
    }
}