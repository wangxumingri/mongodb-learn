package com.wxss.mongodblearn.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Author:Created by wx on 2019/7/17
 * Desc:
 */
@Document
@Data
public class City {
    @Id
    private String id;
//    @Indexed(unique = true)
    private long cid;
    private String name;
    private double area;
    @Field("people_count")
    private long peopleCount;
}
