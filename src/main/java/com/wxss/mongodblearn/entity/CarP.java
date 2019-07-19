package com.wxss.mongodblearn.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

/**
 * Author:Created by wx on 2019/7/18
 * Desc:
 */
@Data
public class Car2 {
    private long cid;
    @Field("car_name")
    private String carName;
    private BigDecimal price;
}
